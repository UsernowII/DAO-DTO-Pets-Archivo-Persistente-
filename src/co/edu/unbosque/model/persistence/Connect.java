package co.edu.unbosque.model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Acceso al Crud
/**
 * Clase encargada hacer la conexion a la Database
 * @author Jhon Erick Santos
 * @version 3.0
 */
public class Connect {
    /**Attributes*/
    private Connection connection = null;

    //Methods

    /**Metodo para crear la conexión con la base de datos
     **/
    public void openConnectDB(){
        String path = "jdbc:sqlite:Mascotas.db";
        try {
            Class.forName("org.sqlite.JDBC");//JDBC: java DataBase connectivity
            connection = DriverManager.getConnection(path);
            System.out.println("conexión exitosa");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**Metodo para cerrar la conexión con la base de datos
     **/
    public void closeConnectDB(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // GETTERS AND SETTERS
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
