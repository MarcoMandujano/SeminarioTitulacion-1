package base;

import clase.Grupo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Parker
 */
public class GrupoDBHelper {
    /**
    * variable que se utuliza para hacer conexión con la base de datos.
    */
    static DBConexion conexion = null;

    /**
    * Constructos de GrupoDBHelper.
    */
    public GrupoDBHelper() {
        conexion = new DBConexion();
    }

    /**
    * Se Registra un grupo en la base de datos.
    *
    * @param    grupo   se guardara en la base de datos.
    * @return           un boolean, true si se guardo en la base de datos,
    *                   false si ocurrio un error.
    */
    public final boolean registrar(final Grupo grupo) {
        boolean transaccion = true;

        try {
            Statement sentencia = conexion.getStatement();

            String query = "INSERT INTO GRUPO VALUES ("
                    + "(SELECT COUNT(*) FROM GRUPO) + 1, '"
                    + grupo.getNombre() + "')";

            sentencia.execute(query);
            confirmar();
        } catch (SQLException ex) {
            System.out.println("base.GrupoDBHelper.Registrar() " + ex);
            transaccion = false;
        }

        return transaccion;
    }

    /**
    * Se Obtiene el número de candidatos que tiene el último grupo registrado,
    * la busqueda se hace por id.
    *
    * @param    grupo   se extrae su id.
    * @return           un int, 0 si ocurrio un error o no se encontro,
    *                   de lo contrario regresa el grupo.
    */
    public final int getNumCandidatos(final Grupo grupo) {
        int numCandidatos = 0;

        try {
            Statement sentencia = conexion.getStatement();

            String query = "SELECT COUNT(IDGRUPO) AS IDGRUPO FROM CANDIDATO "
                        + "WHERE IDGRUPO = " + grupo.getId();
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                numCandidatos = resultado.getInt("IDGRUPO");
            }
        } catch (SQLException ex) {
            System.out.println("base.GrupoDBHelper.getNumCandidatos() " + ex);
        }

        return numCandidatos;
    }

    /**
    * Se Obtiene el último grupo registrado en la base de datos.
    *
    * @return       un Grupo, null si ocurrio un error o no se encontro,
    *               de lo contrario regresa el grupo.
    */
    public final Grupo getUltimoGrupo() {
        Grupo grupo = null;

        try {
            Statement sentencia = conexion.getStatement();

            String query = "SELECT * FROM (SELECT ROWNUM AS RENGLON, "
                        + "IDGRUPO, NOMBRE FROM GRUPO) "
                        + "WHERE RENGLON = (SELECT MAX(ROWNUM) FROM GRUPO)";
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                int idGrupo = resultado.getInt("IDGRUPO");
                String nombre = resultado.getString("NOMBRE");

                grupo = new Grupo(nombre);
                grupo.setId(idGrupo);
            }
        } catch (SQLException ex) {
            System.out.println("base.GrupoDBHelper.getUltimoGrupo() " + ex);
        }

        return grupo;
    }

    /**
    * Se Obtiene los grupos que estan en la base de datos.
    *
    * @return       un ArrayList de Grupo, sin elementos si ocurre un error,
    *               de lo contrario regresa el ArrayList con Objetos Grupo.
    */
    public final ArrayList < Grupo > getGrupos() {
        ArrayList < Grupo > grupos = new ArrayList();

        try {
            Statement sentencia = conexion.getStatement();

            String query = "SELECT * FROM GRUPO";
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                int idGrupo = resultado.getInt("IDGRUPO");
                String nombre = resultado.getString("NOMBRE");

                Grupo grupo = new Grupo(nombre);
                grupo.setId(idGrupo);
                grupos.add(grupo);
            }
        } catch (SQLException ex) {
            System.out.println("base.GrupoDBHelper.getGrupos() " + ex);
        }

        return grupos;
    }

    /**
    * Realiza un commit en la base de datos.
    *
    * @return       un boolean, true si se realizao un commit exitosamente,
    *               false si ocurrio un error.
    */
    public final boolean confirmar() {
        boolean confirmacion = true;
        try {
            Statement sentencia = conexion.getStatement();

            String query = "COMMIT";
            sentencia.execute(query);
        } catch (SQLException ex) {
            System.out.println("base.GrupoDBHelper.Confirmar() " + ex);
            confirmacion = false;
        }
        return confirmacion;
    }
}