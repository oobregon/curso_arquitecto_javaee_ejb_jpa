package ejbs;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

/**
 * Session Bean implementation class TemporizadorEjb
 */
@Stateless
@LocalBean
public class TemporizadorEjb implements TemporizadorEjbLocal {
	@Resource
	SessionContext sc;
	
	
	Timer tm;
	
		@Timeout
		void imprimirMensaje(Timer t) {
			System.out.println("Imprimiendo el mensaje periódico "+t.getInfo());
		}
	
		@Override
		public void iniciarTemporizador(long periodo) {
			tm=sc.getTimerService().createTimer(3000, periodo, "mensaje de temporizador");
		}
		@Override
		public void detenerTemporizador() {
			tm.cancel();
			
		}
}
