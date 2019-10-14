package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Tema;

/**
 * Session Bean implementation class DaoTemasImpl
 */
@Stateless
public class DaoTemasImpl implements DaoTemas {
	@PersistenceContext (unitName = "librosUP")
	EntityManager em;
	
	@Override
	public List<Tema> obtenerTemas() {
		Query q = em.createNamedQuery("Tema.todos");
		return (List<Tema>)q.getResultList();
	}
}
