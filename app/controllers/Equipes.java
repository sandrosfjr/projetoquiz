package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Aluno;
import models.Equipe;
import models.Usuario;
import play.mvc.Controller;

public class Equipes extends Controller {

	public static void index() {
		render();
	}
	
	public static void responderPerguntas() {
		render();
	}
	
	public static void form() {
		List<Aluno> lista = Alunos.listar();
		render(lista);
	}

	static List listar() {
		List<Equipe> listaEquipes = Equipe.findAll();
		return listaEquipes;
	}

	public static void salvar(Equipe equipe, Usuario usuario) {
	
		equipe.save();
		Alunos.form();

		Login.form();
	}

	public static void remover(Long id) {
		Equipe equipe = Equipe.findById(id);
		equipe.delete();

	}

	public static void fotoEquipe(Long id) {
		Equipe equipe = Usuario.findById(id);
		notFoundIfNull(equipe);
		response.setContentTypeIfNotSet(equipe.foto.type());
		renderBinary(equipe.foto.get());
	}
}
