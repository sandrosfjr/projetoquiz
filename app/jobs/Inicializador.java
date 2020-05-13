package jobs;

import models.Aluno;
import models.Equipe;
import models.Professor;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	public void doJob() throws Exception {
		if (Usuario.count() == 0) {
			Usuario u = new Usuario();
			u.nome = "Admin";
			u.email = "admin@admin.com";
			u.senha = "12345678";
			u.tipo = 2;
			u.save();
		}
		
		if(Professor.count() == 0) {
			Professor professor1 = new Professor();
			professor1.nome = "Danilo Soares";
			professor1.matricula = "12023032";
			professor1.save();
			
			Professor professor2 = new Professor();
			professor2.nome = "João Helis";
			professor2.matricula = "59459542";
			professor2.save(); 
			
			Professor professor3 = new Professor();
			professor3.nome = "Walter Lopes";
			professor3.matricula = "39844349";
			professor3.save();
			
		}

		if(Aluno.count() == 0) {
			Aluno aluno1 = new Aluno();
			aluno1.nome = "Sandro Junior";
			aluno1.matricula = "20171074010011";
			aluno1.save();
			
			Aluno aluno2 = new Aluno();
			aluno2.nome = "José Roldão";
			aluno2.matricula = "20171074010027";
			aluno2.save();
			
		}
		
		if(Equipe.count() == 0) {
			Equipe equipeTeste = new Equipe();
			equipeTeste.codigo = "12345678";
			equipeTeste.nome = "EquipeTeste";
		}
		
	};
}
