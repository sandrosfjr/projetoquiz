package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {

	@Before
	static void verificar() {
		
		if(session.contains("usuario.email") == false) {
			Login.form();
		} 
		
		
	}
	
	
}
