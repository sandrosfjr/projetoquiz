package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Professor extends Model{

	public String nome;
	public String matricula;
	
	@ManyToMany
	@JoinTable(name="professores_alunos")
	public List<Aluno> alunos;
	
	
}
