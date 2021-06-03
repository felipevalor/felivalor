import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class BaseDeDatos {

    // a java preparedstatement example
    public void agregarALaBD(String Nombre, String apellido, String mail) throws SQLException, ClassNotFoundException {
        try {
            // Creo la conexi�n a la base de datos dando como par�metro el String de
            // conexi�n y el Driver
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/abm";
            Class.forName(myDriver);
            // Doy los par�metros necesarios para la conexi�n con la BD, usuario y
            // contrase�a
            Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
            String query = " insert into cliente (nombre, apellido, mail)" + " values (?, ?, ?)";

            // insert mediante preparedStatement donde doy como par�metro el query y los
            // valores del objeto cliente
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, Nombre);
            preparedStmt.setString(2, apellido);
            preparedStmt.setString(3, mail);

            // Ejecuto el preparedStatemen, de esta manera, inserto los valores a la base de
            // datos
            preparedStmt.executeUpdate();
            // cierro la conexi�n.
            conn.close();
        } catch (SQLException se) {
            // log the exception
            throw se;
        }
    }

    public void updatecliente(int id, String Nombre, String apellido, String mail)
            throws SQLException, ClassNotFoundException {
        try {
            // Creo la conexi�n a la base de datos dando como par�metro el String de
            // conexi�n y el Driver
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/abm";
            Class.forName(myDriver);
            // Doy los par�metros necesarios para la conexi�n con la BD, usuario y
            // contrase�a
            Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
            // Query de inserci�n de datos en la tabla cliente
            String query = "UPDATE cliente SET nombre = ?, apellido = ?, mail = ?";
            // String query = "UPDATE cliente SET nombre = 'popo', apellido = 'asdf',
            // mail='fdsa' WHERE id = 31";

            // create our java preparedstatement using a sql update query
            PreparedStatement ps = conn.prepareStatement(query);

            // set the preparedstatement parameters

            ps.setString(1, Nombre);
            ps.setString(2, apellido);
            ps.setString(3, mail);

            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            // log the exception
            System.err.println("Se ha generado la siguiente excepcion:");
            System.err.println(e.getMessage());

        }
    }

    public static void borrarTablaDeLaBaseDeDatos() throws SQLException, ClassNotFoundException {
        try {
            // Creo la conexi�n a la base de datos dando como par�metro el String de
            // conexi�n y el Driver
            Statement stmt;
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/abm";
            Class.forName(myDriver);
            // Doy los par�metros necesarios para la conexi�n con la BD, usuario y
            // contrase�a
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String sql = "DELETE FROM cliente";
            PreparedStatement prest = conn.prepareStatement(sql);
            prest.executeUpdate();
            conn.close();

        } catch (SQLException s) {
            System.out.println("SQL statement is not executed!");
        }
    }

}
