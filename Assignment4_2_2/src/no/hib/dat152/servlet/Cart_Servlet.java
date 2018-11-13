package no.hib.dat152.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import no.hib.dat152.dao.ProductDAO;
import no.hib.dat152.model.Cart;
import no.hib.dat152.model.Product;
import no.hib.dat152.utility.Utility;
 
@WebServlet("/cartServlet")
public class Cart_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();

	  
	public Cart_Servlet() {
		super();
	}

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utility.checkLang(request, response);

		HttpSession session = request.getSession();

		String langCode = (String) Config.get(session, Config.FMT_LOCALE);
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
 		ArrayList<Product> products = new ArrayList<Product>(); 

		for ( Product p : productDAO.getProducts(langCode)) {
			if (cart.getCartItems().containsKey(p.getId())) 
				products.add(p);

		}

		request.setAttribute("products", products);

		request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		String productId_s = (String) request.getParameter("productId");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		if (productId_s != null) {
			int productId;
			try {
				productId = Integer.parseInt(productId_s);
				cart.addItem(productId);
 
				session.setAttribute("cart", cart);

				response.sendRedirect("cartServlet");
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
