package by.pvt.zkh.command;

import javax.servlet.http.HttpServletRequest;

import by.pvt.zkh.resource.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
}
