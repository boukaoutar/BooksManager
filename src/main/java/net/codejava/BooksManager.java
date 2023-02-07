package net.codejava;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BooksManager {
	public static void main(String[] args)
	{
		// 1: Ouverture unite de travail JPA
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		// 2: Ouverture transaction
		// le fait de faire une cnx entre la base et le code
		entityManager.getTransaction().begin();
		
		// 3: Instanciation Objet metier
		Book newBook = new Book();
		newBook.setTitle("Clean Code");
		newBook.setAuthor("Ahmed");
		newBook.setPrice(60);

		
		// 4: Persistance Objet/Relationnel : creation d'un enregistrement en base
		// enregister dans la BD : CREATE + INSERT 
		entityManager.persist(newBook);
		
		// 5: Fermeture transaction
		entityManager.getTransaction().commit();
		
		// 6: Fermeture unite de travail JPA
		entityManager.close();
		factory.close();
	}
}
