package model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the matriculas database table.
 * 
 */
@Entity
@Table(name="matriculas")
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatriculaPK id;

	private double nota;

	public Matricula() {
	}

	public Matricula(MatriculaPK id, double nota) {
		super();
		this.id = id;
		this.nota = nota;
	}

	public MatriculaPK getId() {
		return this.id;
	}

	public void setId(MatriculaPK id) {
		this.id = id;
	}

	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

}