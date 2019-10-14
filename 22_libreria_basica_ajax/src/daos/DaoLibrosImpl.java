package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Libro;
import model.Tema;

/**
 * Session Bean implementation class DaoLibrosImpl
 */
@Stateless
public class DaoLibrosImpl implements DaoLibros {
	@PersistenceContext(unitName = "librosUP")
	EntityManager em;

	@Override
	public List<Libro> obtenerLibros(int idTema) {
		Tema tema = em.find(Tema.class,idTema);
		return tema.getLibros();
	}

	@Override
	public List<Libro> obtenerLibros() {
		Query q = em.createNamedQuery("Libro.todos");
		return (List<Libro>)q.getResultList();
	}	
}
