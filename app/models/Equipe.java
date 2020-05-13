package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import controllers.Alunos;
import play.db.jpa.Blob;
import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Equipe extends Model {

	public String nome;
	public Blob foto;
	public float pontuacao;
	public String codigo;
	public String senha;
	
	public void setSenha(String senha) {
		this.senha = Crypto.passwordHash(senha);
	}
}
