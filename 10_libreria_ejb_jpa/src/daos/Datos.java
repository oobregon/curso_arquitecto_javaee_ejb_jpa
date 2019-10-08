package daos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Datos {
	
	public static DataSource obtenerDataSource(String referencia) {
		DataSource ds = null;
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/" + referencia);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
