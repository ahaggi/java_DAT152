

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class Fetch_XML_document_with_Ajax_and_HTTP_POST
 */
@WebServlet("/Fetch_jason")
public class Fetch_JSON_FormatedText_with_Ajax_and_HTTP_POST_GET2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      
		String data = request.getParameter("data");

			JSONObject obj = new JSONObject();
		      obj.put("id", new Integer(1));
		      obj.put("data", data);

//		   if (data != null && !data.equals("") ) {
	      	  response.setContentType("application/json");
		      response.getWriter().print(obj);
//		   }
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String navn = request.getParameter("navn");
//	      System.out.println("id = "+id + ", navn = "+ navn);

//		   if (data != null && !data.equals("") ) {
	    	  response.setContentType("application/json");
		      response.getWriter().print("{\"id\":\""+id+"\", \"name\":\""+navn+"\"}");
//		   }
	}

}
