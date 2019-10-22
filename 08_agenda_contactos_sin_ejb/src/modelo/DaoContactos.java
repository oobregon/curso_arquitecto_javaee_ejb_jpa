package modelo;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Contacto;

public class DaoContactos {
	static EntityManager em;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("13_contactos_jpa");
		em=factory.createEntityManager();
	}
	
	
	public void guardarContacto(String nombre, String email, int edad) {	
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Contacto con=new Contacto(0,edad,email,nombre);
		em.persist(con);
		tx.commit();
	}
	public void eliminarContacto(String nombre) {	
		
		String jpql ="Select c From Contacto c where c.nombre='"+nombre+"'";
		TypedQuery<Contacto> tq=em.createQuery(jpql,Contacto.class);
		Contacto con=tq.getSingleResult();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(con);
		tx.commit();
	}
	public void eliminarContactoPorId(int id) {			
		Contacto con=em.find(Contacto.class, id);
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		if(con!=null) {
			em.remove(con);
		}
		tx.commit();
	}
	public List<Contacto>  recuperarContactos() {
		
		
		String jpql="Select c From Contacto c";
		TypedQuery<Contacto> tq=em.createQuery(jpql,Contacto.class);
		return tq.getResultList();
	}


}
