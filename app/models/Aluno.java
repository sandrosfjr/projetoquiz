package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Aluno extends Model{
	
	public String nome;
	public String matricula;
	
	@ManyToOne
	@JoinColumn(name="idequipe")
	public Equipe equipe;
	
	@ManyToMany
	@JoinTable(name="professores_alunos")
	public List<Professor> professores;
	
}