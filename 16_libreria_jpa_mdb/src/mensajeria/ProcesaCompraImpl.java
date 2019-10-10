package mensajeria;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import model.Venta;

/**
 * Session Bean implementation class ProcesaCompraImpl
 */
@Stateless
public class ProcesaCompraImpl implements ProcesaCompra {	
	@Resource(type=ConnectionFactory.class,lookup="java:/jms/VentaLibroFactoria")
	ConnectionFactory conexionCola;
	@Resource(type=Queue.class,lookup="java:/jms/COLAVENTALIBRO")
	Queue cola;
	
	@Override
	public void procesarCompra(Venta venta) {
		// abrir sesion con la cola
		try(Connection con = conexionCola.createConnection();Session sesion = con.createSession()) {						
			// Creamos un productor y le asociamos a la cola
			MessageProducer productorMensajes = sesion.createProducer(cola);
			
			// Creamos el mensaje a partir de la información que se debe enviar a la cola.
			ObjectMessage mensaje = sesion.createObjectMessage(venta);
			
			// Enviamos el mensaje a la cola
			productorMensajes.send(mensaje);
		} catch (JMSException ex) {
			ex.printStackTrace();
		}
	}	
}
