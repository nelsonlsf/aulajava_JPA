package aplicação;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa2 {

	public static void main(String[] args) {
	
		//programa com objetivo de buscar pessoa no BD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");//nome da persisitence unit é o apelido que está no persistence.xml
		EntityManager em = emf.createEntityManager();//com essa instanciação já tenho uma conexão com banco de dados e toda a questão de persistência implementada
		
		Pessoa p = em.find(Pessoa.class, 2);//buscar a pessoa no BD com o Id 2
		
		System.out.println(p);
		
		System.out.println("Pronto!");
		em.close();
		emf.close();

	}

}
