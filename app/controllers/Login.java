package controllers;

import models.Equipe;
import models.Usuario;
import play.libs.Crypto;
import play.mvc.Controller;

public class Login extends Controller {

	public static void form() {
		render();
	}
	
	public static void loginEquipe() {
		render();
	}
	
	public static void logarEquipe(String codigo, String senha) {
		Equipe equipe = Equipe.find("codigo = ?1 and senha = ?2 ", codigo, Crypto.passwordHash(senha)).first();
		
		if(equipe == null) {
			loginEquipe();
		} else {
			session.put("equipe.nome", equipe.nome);
			session.put("equipe.codigo", equipe.codigo);
			Equipes.index();
			
		}
		
	}
	
	
	public static void formCadastro() {
		render();
	}

	public static void logar(String email, String senha) {
		Usuario usuario = Usuario.find("email = ?1 and senha = ?2 ", email, Crypto.passwordHash(senha)).first();

		if (usuario == null) {
			form();
		} else {
			session.put("usuario.email", usuario.email);
			session.put("usuario.nome", usuario.nome);

			if (usuario.tipo == 2) {
				formCadastro();
			} else {
				Usuarios.index();
			}

		}

	}

	public static void sair() {
		session.clear();
		form();
	}
}
