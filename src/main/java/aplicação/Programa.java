package aplicação;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//Programa com objetivo de inserir pessoas no BD
		
		//id nulo porque o próprio banco de dados incrementará automaticamente os Ids
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");//nome da persisitence unit é o apelido que está no persistence.xml
		EntityManager em = emf.createEntityManager();//com essa instanciação já tenho uma conexão com banco de dados e toda a questão de persistência implementada
		
		//quando o JPA não faz apenas uma leitura do BD, é preciso fazer uma transação com o BD
		em.getTransaction().begin();
		
		//inserindo as pessoas no BD
		em.persist(p1);//pega o objeto e insere no BD
		em.persist(p2);
		em.persist(p3);
		
		em.getTransaction().commit();
		
		System.out.println("Pronto");
		
		em.close();
		emf.close();
		
		

	}

}
