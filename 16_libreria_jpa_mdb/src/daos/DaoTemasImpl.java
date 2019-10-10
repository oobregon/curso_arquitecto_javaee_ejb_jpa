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

import model.Tema;

/**
 *
 * @author Profesortarde
 */
@Stateless
 public class DaoTemasImpl implements DaoTemas {
	@PersistenceContext(unitName = "libreriaventasUP")
	EntityManager em;
	 
    @Override
	public List<Tema> obtenerTemas() {
    	/* También se podría usar la namedQuery
    	 * Query q = em.createNamedQuery("Tema.findAll");
    	 */
    	
    	String jpql = "select t from Tema t";
    	Query q = em.createQuery(jpql);
    	return (List<Tema>)q.getResultList();    	
    }

	@Override
	public Tema obtenerLibro(String titulo) {
		String jpql = "select t from Tema t join t.libros l where l.titulo = ?1";
		Query q = em.createQuery(jpql);
		q.setParameter(1,titulo);
		
		// No olvidemos que si no hay objetos que satisfagan la jpql, entonces, getSingleResult genera una excepción (NonUniqueResultException).
		// así que lo correcto es incluir la llamada al metodo en un try/catch 
		return (Tema)q.getSingleResult();
	}
}
