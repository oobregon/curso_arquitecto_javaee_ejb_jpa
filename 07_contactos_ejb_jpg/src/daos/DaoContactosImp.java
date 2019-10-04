package daos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Contacto;

@Stateless
public class DaoContactosImp implements DaoContactos {
	@PersistenceContext(unitName = "UPagenda")
	EntityManager em;	
	
	@Override
	public void altaContacto() {
		Contacto contacto = new Contacto(0,23,"email@anonm.es","Jaimito");
		em.persist(contacto);
	}
	
	@Override
	public void eliminarContacto(int idContacto) {
		Contacto contacto = em.find(Contacto.class,idContacto);
		em.remove(contacto);
	}
	
	
	@Override
	public void altaContacto(Contacto contacto) {
		em.persist(contacto);
	}
	
	
	@Override
	public void altaContactoParametrizado(Contacto contacto) {
		em.persist(contacto);
	}
	
	@Override
	public List<Contacto> dameContactos() {
		String jpql = "select c from Contacto c";
		Query q = em.createQuery(jpql);
		return (List<Contacto>)q.getResultList();
	}	
}
