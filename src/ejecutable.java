import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

public class Ejecutable {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        BaseDeDatos bd = new BaseDeDatos();
        // bd.borrarTablaDeLaBaseDeDatos();
        Cliente cliente = new Cliente("felipe", "valor", "felipevalor@gmail.com");

        bd.agregarALaBD(cliente.getNombre(), cliente.getApellido(), cliente.getMail());
        bd.updatecliente(0, "felipe", "valor", "felipevalorgmail.com");

    }
}