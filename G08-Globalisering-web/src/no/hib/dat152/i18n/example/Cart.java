package no.hib.dat152.i18n.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String goods = request.getParameter("goods");
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		
		double price = 0;
		if ("shirt".equals(goods)) {
			price = 10.0;
		}else if ("pants".equals(goods)) {
			price = 20.0;
		}else if ("shoe".equals(goods)) {
			price = 30.0;
		}
		request.getSession().setAttribute("goods", goods);
		request.getSession().setAttribute("quantity", quantity);
		request.getSession().setAttribute("price", price);
		
		response.sendRedirect("Cart");
		
	}

}
