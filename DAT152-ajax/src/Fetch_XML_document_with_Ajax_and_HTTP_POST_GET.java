

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fetch_XML_document_with_Ajax_and_HTTP_POST
 */
@WebServlet("/Fetch_XML_document")
public class Fetch_XML_document_with_Ajax_and_HTTP_POST_GET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String data = request.getParameter("data");
	      System.out.println( data);
 
//		   if (data != null && !data.equals("") ) {
		      response.setContentType("text/xml");
		      response.setHeader("Cache-Control", "no-cache");
		      response.getWriter().write("<data>"+data+"</data>");
//		   }
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String navn = request.getParameter("navn");
//	      System.out.println("id = "+id + ", navn = "+ navn);

//		   if (data != null && !data.equals("") ) {
	      response.setContentType("text/xml");
	      response.setHeader("Cache-Control", "no-cache");
		      response.getWriter().write("<person>");
		      response.getWriter().write("<id>"+id+"</id>");
		      response.getWriter().write("<navn>"+navn+"</navn>");
 		      response.getWriter().write("</person>");
//		   }
	}

}
