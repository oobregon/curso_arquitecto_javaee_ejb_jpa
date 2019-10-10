package mensajeria;

import javax.ejb.Local;

import model.Venta;

@Local
public interface ProcesaCompra {	
	void procesarCompra(Venta venta);
}
