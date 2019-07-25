package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import interfaces.Ventana;

public class Consultas {
	Ventana miVentana;
	private String url;
	public Consultas(Ventana miVentana) {
		this.miVentana = miVentana;
		this.url = "jdbc:mysql://localhost:3306/tienda?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		//this.url = "jdbc:mysql://localhost:3306/tienda";
		cargarDriver();
	}

	public void cargarDriver() {
		// this.conexion=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void registrarArticulo(String Articulo, String precio) {
		try {
			Connection conexion = DriverManager.getConnection(url, "root", "123456");
			Statement comando = conexion.createStatement();
			comando.executeUpdate("insert into articulos(articulo,precio) values ('" + Articulo + "'," + precio + ")");
			conexion.close();
			JOptionPane.showMessageDialog(null, "Registro exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void buscarArticulo(String codigo) {

		try {
			Connection conexion = DriverManager.getConnection(url, "root", "123456");
			Statement comando = conexion.createStatement();
			ResultSet registro = comando
					.executeQuery("select articulo,precio from articulos where codigo=" + codigo);
			if (registro.next() == true) {
				miVentana.getTextFieldArticulo().setText(registro.getString("articulo"));
				miVentana.getTextFieldPrecio().setText(registro.getString("precio"));
			} else {
				JOptionPane.showMessageDialog(null, "NO EXISTE EL PRODUCTO", "Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			}
			conexion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void consultarArticulo(String codigo) {
		try {
			Connection conexion = DriverManager.getConnection(url, "root", "123456");
			Statement comando = conexion.createStatement();
			ResultSet registro = comando.executeQuery("select articulo,precio from articulos where codigo=" + codigo);
			if (registro.next() == true) {
				miVentana.getTextFieldDesArticulo().setText(registro.getString("articulo"));
				miVentana.getTextFieldDesPrecio().setText(registro.getString("precio"));
			} else {
				JOptionPane.showMessageDialog(null, "NO EXISTE EL PRODUCTO", "Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			}
			conexion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarArticulo(String codigo) {
		try {
			Connection conexion = DriverManager.getConnection(url, "root", "123456");
			Statement comando = conexion.createStatement();
			int cantidad = comando.executeUpdate("delete  from articulos where codigo=" + codigo);
			if (cantidad == 1) {
				JOptionPane.showMessageDialog(null, "ARTICULO ELIMINADO", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "NO EXISTE EL PRODUCTO", "Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			}
			conexion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
			System.out.println(e1.toString());
		}
	}

	public void editarArticulo(String articulo, String precio, String codigo) {
		try {
			Connection conexion = DriverManager.getConnection(url, "root", "123456");
			Statement comando = conexion.createStatement();
			int cantidad = comando.executeUpdate(
					"update articulos set articulo='" + articulo +"',"+ "precio=" + precio + " where codigo=" + codigo);
			if (cantidad == 1) {
				JOptionPane.showMessageDialog(null, "ARTICULO MODIFICADO", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "NO EXISTE EL PRODUCTO", "Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			}
			conexion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
