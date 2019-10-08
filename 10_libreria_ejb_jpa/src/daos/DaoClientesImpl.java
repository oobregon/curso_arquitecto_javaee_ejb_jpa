package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import model.Cliente;

@Stateless
public class DaoClientesImpl implements DaoClientes {
	@PersistenceContext(unitName = "libreriaUP")
	EntityManager em;
	
	@Override
	public boolean autenticar(String user, String pass) {
		String jpql = "select c from Cliente c where c.usuario = ?1 and c.password = ?2";
		Query q = em.createQuery(jpql);
		q.setParameter(1,user);
		q.setParameter(2,pass);
		return q.getResultList().size()>0;
	}
	
	@Override
	public Cliente obtenerCliente(String user, String pass) {
		String jpql = "select c from Client c where c.usuario = ?1 and c.password = ?2";
		Query q = em.createQuery(jpql);
		q.setParameter(1,user);
		q.setParameter(2,pass);
		// Si no encuentra ningún cliente, retorna una excepción.
		//Cliente c = (Cliente)q.getSingleResult();
		List<Cliente> clientes = (List<Cliente>)q.getResultList();
		return clientes.size()>0?(Cliente)clientes.get(0):null;
	}

	@Override
	public void registrar(Cliente c) {
		em.persist(c);
	}

}
