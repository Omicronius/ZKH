package by.pvt.zkh.client;

import by.pvt.zkh.command.ActionCommand;
import by.pvt.zkh.command.CreateOrderCommand;
import by.pvt.zkh.command.DeleteOrderCommand;
import by.pvt.zkh.command.ShowCreateOrderForm;
import by.pvt.zkh.command.LocaleChangeCommand;
import by.pvt.zkh.command.LoginCommand;
import by.pvt.zkh.command.LogoutCommand;
import by.pvt.zkh.command.RegisterCommand;
import by.pvt.zkh.command.ShowAllOrdersCommand;
import by.pvt.zkh.command.ShowMyOrdersCommand;
import by.pvt.zkh.command.ShowUsersCommand;

public enum CommandEnum {
	LOGIN {{this.command = new LoginCommand();}},
	LOGOUT {{this.command = new LogoutCommand();}},
	SHOW_ALL_USERS {{this.command = new ShowUsersCommand();}},
	SHOW_MY_ORDERS {{this.command = new ShowMyOrdersCommand();}},
	CHANGE_LOCALE {{this.command = new LocaleChangeCommand();}},
	REGISTER {{this.command = new RegisterCommand();}},
	SHOW_CREATE_ORDER_FORM {{this.command = new ShowCreateOrderForm();}},
	CREATE_ORDER {{this.command = new CreateOrderCommand();}},
	DELETE_ORDER {{this.command = new DeleteOrderCommand();}},
	SHOW_ALL_ORDERS {{this.command = new ShowAllOrdersCommand();}};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}