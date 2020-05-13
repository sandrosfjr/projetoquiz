package models;

import java.io.File;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Blob;
import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Usuario extends Model {

	public String nome;
	public String email;
	public String senha;
	public int tipo;
	public Blob foto;
	
	public void setSenha(String senha) {
		this.senha = Crypto.passwordHash(senha);
	}
	
	@ManyToOne
	@JoinColumn(name="idequipe")
	public Equipe equipe;
	
	
}
