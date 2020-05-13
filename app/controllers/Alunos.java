package controllers;

import java.util.List;

import models.Aluno;
import models.Equipe;
import play.mvc.Controller;

public class Alunos extends Controller{

	public static void form() {
		List<Equipe> listaDeEquipes = Equipe.findAll();
		List<Aluno> listaAlunos = Aluno.findAll();
		render(listaDeEquipes, listaAlunos);
	}
	
	public static void editar(long id) {
		Aluno aluno = Aluno.findById(id);
		renderTemplate("Alunos/form.html", aluno);
	}
	
	public static void remover(long id) {
		Aluno aluno = Aluno.findById(id);
		aluno.delete();
		listar();
	}
	static List listar() {
		List<Aluno> listaAlunos = Aluno.findAll();
		return listaAlunos;
	}
	
	public static void salvar(Aluno aluno) {
		aluno.save();
		form();
	}
	

}
