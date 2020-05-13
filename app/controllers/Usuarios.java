package controllers;

import java.io.File;
import java.util.List;

import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Usuarios extends Controller{

	public static void index() {
		render();
	}
	
	
	public static void salvar(Usuario usuario, String senha) {
		
		if(senha.equals("") == false) {
			usuario.senha = senha;
		}
		
		usuario.save();
		Login.formCadastro();
	}
	
	public static void editar(long id) {
		Usuario usu = Usuario.findById(id);
		renderTemplate("Login/formCadastro.html", usu);
	}
	
	public static void listar() {
		List<Usuario> lista = Usuario.findAll();
		render(lista);
	}
	
	public static void remover(long id) {
		Usuario usu = Usuario.findById(id);
		usu.delete();
		listar();
	}
	
	public static void fotoUsuario(Long id) {
		Usuario usuario = Usuario.findById(id);
		notFoundIfNull(usuario);
		response.setContentTypeIfNotSet(usuario.foto.type());
		renderBinary(usuario.foto.get());
	}
}
