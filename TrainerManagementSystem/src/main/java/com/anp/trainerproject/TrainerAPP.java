package com.anp.trainerproject;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TrainerAPP {   // TrainerAPP class

public static void main(String[] args) {
		
EntityManagerFactory factory = null;
		
		
try { // connecting to the database using the persistence unit  
	// Creating an EntityManagerFactory using the persistence unit named "cs"		
	factory  = Persistence.createEntityManagerFactory("cs");
	EntityManager em = factory.createEntityManager();
						
	System.out.println("------WELCOME TO TRAINER MANAGEMENT SYSTEM ------");
// Creating Trainer objects		
Trainer t1 = new Trainer(1, "Navya", "Sree", 50000,"navya@email.com",  "Female");
Trainer t2 = new Trainer(2, "Raju", "Sagar",  80000,"raj@email.com",  "Male");
Trainer t3 = new Trainer(3, "Sravan", "Patel", 60000,"sravan@email.com", "Male");
Trainer t4 = new Trainer(4, "Yamini", "Yala", 45000,"yamini@email.com", "Female");
Trainer t5 = new Trainer(5, "Bhavani", "Varahalu", 90000,"bhavani@email.com", "Female");				
TrainerDAO tDAO = new TrainerDAO(em);
//Saving Trainer objects to the database
tDAO.save(t1);
tDAO.save(t2);
tDAO.save(t3);
tDAO.save(t4);
tDAO.save(t5);
			
System.out.println("Data added successfully");

System.out.println("--------------------------");
//Retrieving Trainer details based on ID		
System.out.println(" Trainer  details based on the id :");
Optional<Trainer> TrainerById = tDAO.findById(1);
System.out.println(TrainerById);
			 
System.out.println("--------------------------");
//Retrieving all Trainer details		
System.out.println(" All Details of Trainer ");	 
List<Trainer> alltr = tDAO.findAll();
System.out.println(alltr);
			
System.out.println("------------------");
//Updating Trainer details
int  newid = 3;
String newfirstName ="Laxmi" ;
String newLastName = "Gunti" ;
int salary =  50000 ;
String newemail = "laxmi@gmail.com";
String newgender  ="Female";
tDAO.updateTrainer(newid, newfirstName, newLastName,salary, newemail, newgender);
System.out.println("Data updated sucessfully");		
System.out.println("------------------"); 
// Removing a Trainer based on ID
System.out.println("Removeing based on the id :");
tDAO.remove(3);
System.out.println("3rd record is removed");
			
			
		}
		catch (HibernateException e) {
			 e.printStackTrace();
		}
		catch (Exception e) {
		 e.printStackTrace();
		}

	}


	}


