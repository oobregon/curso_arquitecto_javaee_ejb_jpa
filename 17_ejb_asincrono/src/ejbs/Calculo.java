package ejbs;

import java.util.concurrent.Future;

import javax.ejb.Local;

@Local
public interface Calculo {
	// Suponemos que esta es una operaci�n compleja
	Future<Integer> sumaNumeros(int n);
}
