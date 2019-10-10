package daos;

import java.util.List;

import javax.ejb.Local;

import model.Tema;


@Local
public interface DaoTemas {
	List<Tema> obtenerTemas();
	
	// Dado el titulo de un libro, dame su Tema
	Tema obtenerLibro(String titulo);
}