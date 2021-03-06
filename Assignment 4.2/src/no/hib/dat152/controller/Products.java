package no.hib.dat152.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.commons.lang.LocaleUtils;

import no.hib.dat152.dao.ProductDAO;
import no.hib.dat152.model.Product;

/**
 * Servlet implementation class Products
 */
@WebServlet("/products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
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
        
        String langCode = (String) Config.get(request.getSession(), Config.FMT_LOCALE);
		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> products = productDAO.getProducts(langCode);
		
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
	}
}
