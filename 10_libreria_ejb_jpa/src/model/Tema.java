package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the temas database table.
 * 
 */
@Entity
@Table(name="temas")
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	public Tema(int idTema, String tema) {
		super();
		this.idTema = idTema;
		this.tema = tema;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTema;

	private String tema;

	//bi-directional many-to-one association to Libro
	// lazy: al recuperar el objeto principal, en este caso Tema, los objetos relacionados no se traen, no se cargan,
	// solo se recuperan si son solicitados. El valor por defecto es LAZY:
	// fetch = FetchType.LAZY
	// fetch = FetchType.EAGER: tenemos que ser conscientes de que poner esta configuración implica que nos traemos todas las instancias
	// de las Entidades relacionadas con la Entidad actual, y también nos traemos las instancias relacionadas con l
	@OneToMany(mappedBy ="tema")
	private List<Libro> libros;

	public Tema() {
	}

	public int getIdTema() {
		return this.idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Libro addLibro(Libro libro) {
		getLibros().add(libro);
		libro.setTema(this);

		return libro;
	}

	public Libro removeLibro(Libro libro) {
		getLibros().remove(libro);
		libro.setTema(null);

		return libro;
	}

}