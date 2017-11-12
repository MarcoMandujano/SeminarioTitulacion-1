package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Parker
 */
public class DBConexion {
    /**
    * direccion de la base de datos.
    */
    static String url;

    /**
    * usuario para conectarse a la base de datos.
    */
    static String usuario;

    /**
    * contraseña para conectarse a la base de datos.
    */
    static String contrasena;

    /**
    * Se utiliza para hacer una conexión a la base de datos.
    */
    static Connection conexion = null;

    /**
    * estado en el que se encuentra la conexión, true conectado,
    * false ocurrio un error.
    */
    static boolean estado = true;

    /**
    * Constructos de DBConexion.
    * Realiza una conexión con url, usuario y contraseña definidas.
    */
    public DBConexion() {
        DBConexion.url = "";

        try {
            DBConexion.usuario = "";
            DBConexion.contrasena = "";
            conexion = DriverManager.getConnection(
                        url, DBConexion.usuario, DBConexion.contrasena);
        } catch (Exception e) {
            System.out.println("BaseDatos.DBConexion() " + e);
            estado = false;
        }
    }

    /**
    * Constructos de DBConexion.
    * Realiza una conexión con usuario y contraseña definidas
    * por un los parametros.
    *
    * @param    usuarioX    usuario para conectarse a la base de datos.
    * @param    contrasenaX contraseña para conectarse a la base de datos.
    */
    public DBConexion(final String usuarioX, final String contrasenaX) {
        DBConexion.url = "";

        try {
            DBConexion.usuario = usuarioX;
            DBConexion.contrasena = contrasenaX;
            conexion = DriverManager.getConnection(
                    url, DBConexion.usuario, DBConexion.contrasena);
        } catch (Exception e) {
            System.out.println("BaseDatos.DBConexion() " + e);
            estado = false;
        }
    }

    /**
    * Cierra la conexión.
    */
    public final void closeConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("BaseDatos.DBConexion.closeConexion() " + e);
            estado = false;
        }
    }

    /**
    * Crea un objeto Statement.
    *
    * @return       un Statement, si la conexión sigue abierta,
    *               null si ocurre un error o la conexión esta cerrada.
    */
    public final Statement getStatement() {
        try {
            if (conexion.isClosed()) {
                return null;
            }

            return conexion.createStatement();
        } catch (Exception e) {
            System.out.println("BaseDatos.DBConexion.getStatement() " + e);
            return null;
        }
    }

    /**
    * Regresa la conexión.
    *
    * @return       un Connection, con el valor almacenado en conexion.
    */
    public final Connection getConexion() {
        return conexion;
    }
}
