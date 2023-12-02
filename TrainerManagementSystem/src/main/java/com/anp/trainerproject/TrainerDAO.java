package com.anp.trainerproject;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class TrainerDAO {   // TrainerDAO class 
private EntityManager em;
//Constructor to initialize TrainerDAO with an EntityManager
public TrainerDAO(final EntityManager em) {
		this.em = em;
}
//Method to save a Trainer entity to the database
public void save(final Trainer trainer) {
EntityTransaction tx = null;
 try {   
	tx = em.getTransaction(); 

	if (!tx.isActive()) 
	  {
		tx.begin();
	}
	// Merge the Trainer object with the persistence context
 Trainer mergedTrainer = em.merge(trainer);
	tx.commit();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
//Method to find a Trainer by its ID
	public Optional<Trainer> findById(int id) {

		Trainer t = em.find(Trainer.class, id);

		if (t != null) {
			return Optional.of(t);
		} else {
			return Optional.empty();
		}
	}
	// Method to retrieve all Trainers from the database
	public List<Trainer> findAll() {

		List<Trainer> t1 = em.createQuery("from Trainer", Trainer.class).getResultList();

		return t1;

	}
// Method to update Trainer details based on ID
public void updateTrainer( int id, String newfirstName, String newLastName, int newsalary,String newemail, String newgender) {
EntityTransaction tx = null; 
	try {
	tx = em.getTransaction(); 

	if (!tx.isActive()) 
	{
	 tx.begin();
	}
	Trainer trainer = em.find(Trainer.class, id) ;
	if(trainer!=null) {
	trainer.setFirstName(newfirstName);
	trainer.setLastName(newLastName);
	trainer.setSalary(newsalary);
    trainer.setEmail(newemail);
    trainer.setGender(newgender);
				
				em.merge(trainer); // Merge the changes to the persistence context
				tx.commit(); 
			}	
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
			
	}
//Method to remove a Trainer entity from the database by ID
public void remove(int id) {  
		EntityTransaction tx = null; 
		
		Trainer t = em.find(Trainer.class, id);  
		
		try {
			tx = em.getTransaction(); 

			if (!tx.isActive()) 
			{
				tx.begin();
			}
 // Remove the Trainer entity from the database
			em.remove(t);
			tx.commit();
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
			
	}	
}

