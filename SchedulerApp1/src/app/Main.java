package app;

import core.Controller;
import controllers.HomeController;


/**
 * Main class. Responsible for running the application.
 */
public class Main 
{
	public static void main(String[] args) 
	{
              System.out.println("Bienvenido al Gestor de Eventos");
		Controller c = new HomeController();
		c.run();
	}
}
