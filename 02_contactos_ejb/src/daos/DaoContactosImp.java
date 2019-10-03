package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import model.Contacto;

@Stateless
public class DaoContactosImp implements DaoContactos {
	private static final String url = "jdbc:mysql://localhost:3306/agenda2";
	private static final String user = "root";
	private static final String contra = "root";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void altaContacto() {
		try(Connection con=DriverManager.getConnection(url,user,contra)) {
			String sql = "insert into contactos (nombre,email,edad) values(";
			sql+="'jdbc','jdbc@gmail.com',34)";
			Statement sentencia = con.createStatement();
			sentencia.execute(sql);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
	
	@Override
	public void eliminarContacto(int idContacto) {
		try(Connection con=DriverManager.getConnection(url,user,contra)) {
			String sql = "delete from contactos where idContacto = ?";
			PreparedStatement sentencia = con.prepareStatement(sql);
			sentencia.setInt(1,idContacto);
			sentencia.execute();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
	
	
	@Override
	public void altaContacto(Contacto contacto) {
		try(Connection con=DriverManager.getConnection(url,user,contra)) {
			String sql = "insert into contactos (nombre,email,edad) values";
			sql+="('" + contacto.getNombre() +"','" + contacto.getEmail() + "'," + contacto.getEdad() + ")";
			System.out.println(sql);
			Statement sentencia = con.createStatement();
			sentencia.execute(sql);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
	
	
	@Override
	public void altaContactoParametrizado(Contacto contacto) {
		try(Connection con=DriverManager.getConnection(url,user,contra)) {
			String sql = "insert into contactos (nombre,email,edad) values (?,?,?)";			
			PreparedStatement sentencia = con.prepareStatement(sql);
			sentencia.setString(1,contacto.getNombre());
			sentencia.setString(2,contacto.getEmail());
			sentencia.setInt(3,contacto.getEdad());
			sentencia.execute();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
	
	@Override
	public List<Contacto> dameContactos() {
		List<Contacto> lista = new ArrayList<Contacto>();
		try(Connection con=DriverManager.getConnection(url,user,contra);
			Statement sentencia = con.createStatement();
			ResultSet rs=sentencia.executeQuery("select idContacto,nombre,email,edad from contactos");) {
			while(rs.next()) {
				Contacto contacto = new Contacto();
				contacto.setIdContacto(rs.getInt(1));
				contacto.setNombre(rs.getString(2));
				contacto.setEmail(rs.getString(3));
				contacto.setEdad(rs.getInt(4));
				lista.add(contacto);
			}			
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}	
		return lista;
	}	
}
