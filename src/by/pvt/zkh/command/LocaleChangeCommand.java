package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocaleChangeCommand implements ActionCommand {
	private final String ENGLISH = "locale_en_US";
	private final String RUSSIAN = "locale_ru_RU";

	@Override
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loc = (String) session.getAttribute("locale");
		if (loc == null || loc == "locale_ru_RU") {
			session.setAttribute("locale", ENGLISH);
		} else {
			session.setAttribute("locale", RUSSIAN);
		}
		return (String) session.getAttribute("currenPage");
	}
}
