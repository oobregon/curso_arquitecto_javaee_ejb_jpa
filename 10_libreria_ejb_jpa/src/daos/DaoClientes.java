package daos;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface DaoClientes {

	boolean autenticar(String user, String pass);
	
	Cliente obtenerCliente(String user, String pass);

	void registrar(Cliente c);

}