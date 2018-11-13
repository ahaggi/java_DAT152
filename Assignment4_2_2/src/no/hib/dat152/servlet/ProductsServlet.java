package no.hib.dat152.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import no.hib.dat152.dao.ProductDAO;
import no.hib.dat152.model.Product;
import no.hib.dat152.utility.Utility;

/**
 * Servlet implementation class Products
 */
@WebServlet("/productsServlet")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Utility.checkLang(request, response);

        String langCode = (String) Config.get(request.getSession(), Config.FMT_LOCALE);
        
		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> products = productDAO.getProducts(langCode);
		
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
	}
}
