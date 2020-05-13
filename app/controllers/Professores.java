package controllers;

import java.util.List;

import models.Professor;
import play.mvc.Controller;

public class Professores extends Controller {
	
	public static void cadastroPergunta() {
		render();
	}

	public static void form() {
		render();
	}
	
	
	public static void salvar(Professor professor) {
		professor.save();
		form();
	}
	
	public static void listar() {
		List<Professor> professores = Professor.findAll();
		render(professores);
	}
	
	public static void editar(long id) {
		Professor professor = Professor.findById(id);
		renderTemplate("Professores/form.html", professor);
	}
	
	public static void remover(long id) {
		Professor professor = Professor.findById(id);
		professor.delete();
		listar();
	}
}
