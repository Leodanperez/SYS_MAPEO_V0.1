package Dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    static String bd = "XE";
    static String login = "SYS_MAPEO";
    static String password = "SYS_MAPEO";
    static String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
    // jdbc:oracle:thin:@<HOST>:1521:<SID>

    Connection conn = null;

    /**
     * Constructor de la clase. Se llama constructor porque tiene el mismo
     * nombre que la clase y cuando se crea un nuevo objeto de esta clase es
     * como se va a inicializar al crear un nuevo objeto de este tipo.
     *
     */
    public DbConnection() {

        try {
            //obtenemos el driver para mysql
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //obtenemos una conexion con los parametros especificados anteriormente 
            conn = DriverManager.getConnection(url, login, password);
            // Si conn no es nulo, significa que podimos conectarnos
            if (conn != null) {
                System.out.println("Connecting database [" + conn + "] OK");
            }
        } catch (SQLException e) // Excepcion ocurrida por la conexion 
        {
            System.out.println("Excepcion conexion: " + e.getMessage());
        } catch (ClassNotFoundException e) // Excepcion ocurrida por no encontrar el driver
        {
            System.out.println("Excepcion driver: " + e.getMessage());
        }

    }

    public Connection getConnection() {
        return conn;
    }

    // Quitamos de memoria la conexion
    public void disconnect() {
        System.out.println("Closing database: [" + conn + "] OK");
        if (conn != null) {
            try {
                // System.out.println("Desconectado de " + bd + " OK");
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

}
