package aplicação;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa3 {

	public static void main(String[] args) {
		
		
		//programa com o objetivo de remover uma pessoa do BD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");//nome da persisitence unit é o apelido que está no persistence.xml
		EntityManager em = emf.createEntityManager();//com essa instanciação já tenho uma conexão com banco de dados e toda a questão de persistência implementada
		
		//só é possível remover, um registro que esteja MONITORADO, ou seja, um registro que acabou de ser inserido ou buscado e que não tenha sido fechado o EntityManager
		Pessoa p = em.find(Pessoa.class, 2);
		//além disso, tem que ser aberta uma transação antes de realizar a remoção
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto");
		
		em.close();
		emf.close();

	}

}
