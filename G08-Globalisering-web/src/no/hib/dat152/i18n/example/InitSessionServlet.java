package no.hib.dat152.i18n.example;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet implementation class InitSessionServlet.
 */
@WebServlet("/index.html")
public final class InitSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new InitSessionServlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public InitSessionServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			String localeValue = locale.getLanguage() + "_" + locale.getCountry();

			Config.set(request.getSession(), Config.FMT_LOCALE, localeValue);

			Cookie localeCookie = new Cookie("locale", localeValue);
			localeCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds
			response.addCookie(localeCookie);
			// Cookie with locale sent to client
		}
		response.sendRedirect("index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
