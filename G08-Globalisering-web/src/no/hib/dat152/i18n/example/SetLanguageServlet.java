package no.hib.dat152.i18n.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet implementation class SetLanguageServlet.
 */
@WebServlet("/SetLanguage")
public class SetLanguageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new SetLanguageServlet.
     *
     * @see HttpServlet#HttpServlet()
     */
    public SetLanguageServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String locale = request.getParameter("locale");
        if (locale != null) {
            Config.set(request.getSession(), Config.FMT_LOCALE, locale);

            Cookie localeCookie = new Cookie("locale", locale);
            localeCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds
            response.addCookie(localeCookie);
            // Cookie with locale sent to client
        }

        String referrer = request.getHeader("referer");
        System.out.println(referrer);
        response.sendRedirect(referrer);
    }



}
