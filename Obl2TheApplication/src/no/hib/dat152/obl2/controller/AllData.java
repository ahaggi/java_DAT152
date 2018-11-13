package no.hib.dat152.obl2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.obl2.database.SearchItem;
import no.hib.dat152.obl2.database.SearchItemDAO;
import no.hib.dat152.obl2.database.AppUser;
import no.hib.dat152.obl2.database.AppUserDAO;

@WebServlet("/alldata")
public class AllData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		AppUserDAO userDAO = new AppUserDAO();
		List<AppUser> allUsers = userDAO.getAllUsers();
		
		for (AppUser appUser : allUsers) {
			System.out.println(appUser.getFirstname());
		}

	
		SearchItemDAO searchItemDAO = new SearchItemDAO();
		List<SearchItem> myhistory = searchItemDAO.getAllSearchItemList();

		request.setAttribute("myhistory", myhistory);


			request.setAttribute("allUsers", allUsers);

			request.getRequestDispatcher("alldata.jsp").forward(request, response);
		
	}
}
