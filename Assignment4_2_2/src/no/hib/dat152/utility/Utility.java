package no.hib.dat152.utility;

import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.*;
import javax.servlet.jsp.jstl.core.Config;

public class Utility {
	
	public static String copyright(String text, int sinceYear) {
		return "\u00a9 " + RomanNumeral.toRoman(sinceYear) + " - " +
			   RomanNumeral.toRoman(Calendar.getInstance().get(Calendar.YEAR)) +
			   " " + text;
	}
	
	public static String shortText(String text, int length) {
		if (text.length() < length) {
			return text;
		} else {
			return text.substring(0, length) + " ...";
		}
	}
	
	public static void checkLang(HttpServletRequest request , HttpServletResponse response) {
		//TODO invalidate sasjonen
		Cookie[] cookies = request.getCookies();
		
		boolean cookieFound = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
            	/**********************************/
    			System.out.println(cookie.getName());
    			System.out.println(cookie.getValue());
    			System.out.println(cookie.getPath());
            	/**********************************/
                if (cookie.getName().equals("locale")) {
                    // Set locale from cookie
                	cookieFound = true;
                    Config.set(request.getSession(), Config.FMT_LOCALE, cookie.getValue());
                    Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE,"en-US"); 
                }
            }
        }
        if ( ! cookieFound) {
            Locale locale = request.getLocale(); //TODO Enumeration preferredLocales = req.getLocales();
            Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage() + "_" + locale.getCountry());
            Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE,"en-US"); 

            Cookie localeCookie = new Cookie("locale", locale.getLanguage() + "_" + locale.getCountry());
            localeCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds
            response.addCookie(localeCookie);
            // Cookie with locale sent to client
        }

	}
}
