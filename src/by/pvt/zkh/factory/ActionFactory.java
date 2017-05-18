package by.pvt.zkh.factory;

import javax.servlet.http.HttpServletRequest;

import by.pvt.zkh.client.CommandEnum;
import by.pvt.zkh.command.ActionCommand;
import by.pvt.zkh.command.EmptyCommand;
import by.pvt.zkh.resource.MessageManager;

public class ActionFactory {
  public ActionCommand defineCommand(HttpServletRequest request) {
    ActionCommand current = new EmptyCommand();
    String action = request.getParameter("command");
    if (action == null || action.isEmpty()) {
      return current;
    }
    try {
      CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
      current = currentEnum.getCurrentCommand();
    } catch (IllegalArgumentException e) {
      request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
    }
    return current;
  }
}