/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Libro;
import model.Tema;

@Stateless
public class DaoLibrosImpl implements DaoLibros {
	@PersistenceContext(unitName = "libreriaUP")
	EntityManager em;
	
    @Override
	public List<Libro> recuperarLibros() {
    	Query q = em.createNamedQuery("Libro.findAll");
    	return (List<Libro>)q.getResultList(); 
    }
    
    
    @Override
	public List<Libro> recuperarLibros(int idTema) {
    	// Forma 1
    	//String jpql = select l from Libro l where l.tema.idTema = ?1; 
    			
    	// Forma 2	
    	// Esta segunda forma tiene el problema de
    	Tema tema = em.find(Tema.class,idTema);
    	return tema.getLibros();   	    	
    }  
}
