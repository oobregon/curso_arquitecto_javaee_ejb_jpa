package mensajeria;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import daos.DaoVentas;
import model.Venta;

/**
 * Message-Driven Bean implementation class for: ProcesaVentas
 */
@MessageDriven(activationConfig = {@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
								   @ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "java:/jms/COLAVENTALIBRO")})

public class ProcesaVentas implements MessageListener {	
	@EJB
	DaoVentas daoEjb;
    public void onMessage(Message message) {
    	ObjectMessage obj = (ObjectMessage)message;
        try {
			Venta venta = (Venta)obj.getObject();
			daoEjb.altaVenta(venta);			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
