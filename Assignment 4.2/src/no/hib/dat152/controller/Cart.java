package no.hib.dat152.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import no.hib.dat152.dao.ProductDAO;
import no.hib.dat152.model.CartItem;
import no.hib.dat152.model.Product;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("locale")) {
                    // Set locale from cookie
                    Config.set(request.getSession(), Config.FMT_LOCALE, cookie.getValue());
                }
            }
        } else {
            Locale locale = request.getLocale();

            Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage() + "_" + locale.getCountry());
            Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE,"en-US");

            Cookie localeCookie = new Cookie("locale", locale.getLanguage() + "_" + locale.getCountry());
            localeCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds
            response.addCookie(localeCookie);
            // Cookie with locale sent to client
        }
		
        
		HttpSession session = request.getSession();
		String langCode = (String) Config.get(session, Config.FMT_LOCALE);
		HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
		
		if (cart == null) {
			cart = new HashMap<Integer, Integer>();
		}
		
		Object[] keys = cart.keySet().toArray();
		Arrays.sort(keys);
		
		ArrayList<Product> products = productDAO.getProducts(langCode);
		ArrayList<CartItem> cartList = new ArrayList<CartItem>();
		
		for (Object k : keys) {
			int i = (Integer) k;
			int amount = cart.get(i);
			Product p = products.get(i);
			cartList.add(new CartItem(p, amount));
		}
		
		double total = 0;
		for (CartItem i : cartList) {
			total += i.getTotalPrice();
		}
		
		request.setAttribute("cart", cartList);
		request.setAttribute("total", total);
		
		request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
		String productId_s = (String) request.getParameter("productId");
		
		if (cart == null) {
			cart = new HashMap<Integer, Integer>();
		}
		
		if (productId_s != null) {
			int productId;
			try {
				 productId = Integer.parseInt(productId_s);
				 
				 if (cart.containsKey(productId)) {
					 cart.put(productId, cart.get(productId) + 1);
				 } else {
					 cart.put(productId, 1);
				 }
				 
				 session.setAttribute("cart", cart);
				 
				 response.sendRedirect("cart");
			} catch (Exception e) {
				// TODO: handle error.
				response.sendRedirect("error?errorMsg=Error. Product ID not of type integer.");
			}
		} else {
			// TODO: handle error.
			response.sendRedirect("error");
		}
	}
}
