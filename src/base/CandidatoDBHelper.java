package base;

import clase.Asesor;
import clase.Candidato;
import clase.Grupo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Parker
 */
public class CandidatoDBHelper {
    /**
    * variable que se utuliza para hacer conexión con la base de datos.
    */
    static DBConexion conexion = null;
    
    /**
    * Constructos de AsesorDBHelper.
    */
    public CandidatoDBHelper(){
        conexion = new DBConexion();
    }
    
    /**
    * Registra un candidato en la base de datos.
    * 
    * @param    candidato   se guardara en la base de datos.
    * @return               un boolean, true si se guardo en la base de datos,
    *                       false si ocurrio un error.
    */
    public final boolean registrar(final Candidato candidato) {
        boolean transaccion = true;
        
        try {
            Statement sentencia = conexion.getStatement();
                                                
            String query = "INSERT INTO CANDIDATO VALUES ("
                        + "(SELECT COUNT(*) FROM CANDIDATO) + 1, "
                        + "'', '', '', '" 
                        + candidato.getNombre() + "', '" 
                        + candidato.getApellidoPaterno() + "', '" 
                        + candidato.getApellidoMaterno() + "', '" 
                        + candidato.getContrasena() + "', '" 
                        + candidato.getMatricula() + "', '" 
                        + candidato.getEmail() + "', " 
                        + candidato.getCelular() + ", '" 
                        + candidato.getCarrera() + "', " 
                        + candidato.getCreditos() + ", '" 
                        + candidato.getTemaTesis() + "', '" 
                        + candidato.getDirectorTesis() + "', '" 
                        + candidato.getLugarTrabajo() + "', '" 
                        + candidato.getHorarioTrabajo() 
                        + "', EMPTY_BLOB(), EMPTY_BLOB())";            
            
            sentencia.execute(query);
            confirmar();
            
            setFoto(candidato);
            setCartaCompromiso(candidato);
            setCartaMotivos(candidato);
        } catch (SQLException ex) {
            System.out.println(ex);
            transaccion = false;
        }

        return transaccion;
    }

    /**
    * Actualiza la carta exposición de motivos de un candidato por medio de su contraseña.
    * 
    * @param    candidato   se extrae su File cartaCompromiso y su contraseña.
    * @return               un boolean, true si se guardo en la base de datos,
    *                       false si ocurrio un error.
    */
    public final boolean setCartaCompromiso(final Candidato candidato) {
        boolean transaccion = true;
        
        try {            
            File blobFile = candidato.getCartaCompromiso();
            InputStream blobInput = new FileInputStream(blobFile);
            
            PreparedStatement ops;
            String query = "UPDATE CANDIDATO SET CARTACOMPROMISO = ? "
                        + "WHERE CONTRASENA = ?";                       
            ops = conexion.getConexion().prepareStatement(query);
            
            ops.setBinaryStream(1, blobInput, (int)blobFile.length());
            ops.setString(2, candidato.getContrasena());
            ops.executeUpdate();
            confirmar();            
        } catch (FileNotFoundException | SQLException ex) {
            System.out.println("BaseDatos.CandidatoDBHelper"
                            + ".SetCartaCompromiso() " + ex);
            transaccion = false;
        }
        
        return transaccion;
    }
    
    /**
    * Actualiza la carta exposición de motivos de un candidato por medio de su id.
    * 
    * @param    candidato   se extrae su File cartaExpoMotivos y su id.
    * @return               un boolean, true si se guardo en la base de datos,
    *                       false si ocurrio un error.
    */
    public final boolean setCartaMotivos(final Candidato candidato) {
        boolean transaccion = true;
        
        try {            
            File blobFile = candidato.getCartaExpoMotivos();
            InputStream blobInput = new FileInputStream(blobFile);
            
            PreparedStatement ops;
            String query = "UPDATE CANDIDATO SET CARTAEXPOMOTIVOS = ? "
                        + "WHERE CONTRASENA = ?";                       
            ops = conexion.getConexion().prepareStatement(query);
            
            ops.setBinaryStream(1, blobInput, (int)blobFile.length());
            ops.setString(2, candidato.getContrasena());
            ops.executeUpdate();
            confirmar();
        } catch (FileNotFoundException | SQLException ex) {
            System.out.println("BaseDatos.CandidatoDBHelper.SetCartaMotivos() " 
                                + ex);
            transaccion = false;
        }

        return transaccion;
    }
    
    /**
    * Actualiza la foto de un candidato por medio de su contraseña.
    * 
    * @param    candidato   se extrae su ImageIcon y su contraseña.
    * @return               un boolean, true si se guardo en la base de datos,
    *                       false si ocurrio un error.
    */
    public final boolean setFoto(final Candidato candidato) {
        boolean transaccion = true;
        
        try {            
            File blobFile = new File(candidato.getFoto().getDescription());
            InputStream blobInput = new FileInputStream(blobFile);
            
            PreparedStatement ops;
            String query = "UPDATE CANDIDATO SET FOTO = ? WHERE CONTRASENA = ?";                       
            ops = conexion.getConexion().prepareStatement(query);
            
            ops.setBinaryStream(1, blobInput, (int)blobFile.length());
            ops.setString(2, candidato.getContrasena());
            ops.executeUpdate();
            confirmar();
        } catch (FileNotFoundException | SQLException ex) {
            System.out.println("BaseDatos.CandidatoDBHelper.SetFoto() " + ex);
            transaccion = false;
        }

        return transaccion;
    }

    /**
    * Se asigna grupo y asesor al candidato.
    * 
    * @param    asesor      se extrae su id.
    * @param    grupo       se extrae su id.
    * @param    candidato   se extrae su id.
    * @return               un boolean, true si se guardo en la base de datos,
    *                       false si ocurrio un error.
    */
    public final boolean setGrupoYAsesor(final Asesor asesor, final Grupo grupo,
                                        final Candidato candidato) {
        boolean transaccion = true;
        
        try {
            Statement sentencia = conexion.getStatement();
                                  
            String query = "UPDATE CANDIDATO "
                            + "SET IDASESOR = " + asesor.getId()
                            + ", IDGRUPO = " + grupo.getId()
                            + " WHERE IDCANDIDATO = " + candidato.getId();            
            
            sentencia.execute(query);
            confirmar();
        } catch (SQLException ex) {
            System.out.println(ex);
            transaccion = false;
        }

        return transaccion;
    }
    
    /**
    * Se obtienen todos los candidatos sin grupo de la base de datos.
    * 
    * @return       un ArrayList de Candidato, los candidatos solo tendran id,
    *               foto, nombre, apellido paterno, apellido materno, carrera,
    *               creditos, tema de tesis, carta compromiso y
    *               Carta exposición de motivos.
    */
    public final ArrayList < Candidato > getSinGrupoIG() {
        ArrayList < Candidato > candidatos = new ArrayList<>();
        
        try{
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT * FROM CANDIDATO "
                            + "WHERE IDGRUPO IS NULL";            
            ResultSet resultado = sentencia.executeQuery(query);
            
            while (resultado.next()) {
                int idCandidato = resultado.getInt("IDCANDIDATO");
                Blob fotoBlob = resultado.getBlob("FOTO");
                String nombre = resultado.getString("NOMBRE");
                String apPaterno = resultado.getString("APELLIDOPATERNO");
                String apMaterno = resultado.getString("APELLIDOMATERNO");
                String carrera = resultado.getString("CARRERA");
                int creditos = resultado.getInt("CREDITOS");
                String temaTesis = resultado.getString("TEMADETESIS");
                
                
                ImageIcon foto = new ImageIcon(
                                fotoBlob.getBytes(1, (int)fotoBlob.length()));
                
                Candidato candidato = new Candidato(nombre, apPaterno,
                                            apMaterno, "", carrera, temaTesis);                
                candidato.setId(idCandidato);
                candidato.setFoto(foto);
                candidato.setCreditos(creditos);
                candidatos.add(candidato);
            }
        } catch (SQLException ex) {
            System.out.println("BaseDatos.CandidatoDBHelper.getSinGrupoIG() "
                                + ex);
        }

        return candidatos;
    }
    
    /**
    * Se obtienen todos los candidatos de un grupo con el id del grupo.
    * 
    * @param    grupo   se le asignan objetos Candidato.
    * @return           un Grupo, el grupo contendra objetos Candidato,
    *                   los candidatos tendran id, foto, nombre, apellido paterno,
    *                   apellido materno, carrera, creditos, tema de tesis y asesor.
    */
    public final Grupo getConGrupoIG(final Grupo grupo) {
        try {
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT * FROM CANDIDATO "
                            + "WHERE IDGRUPO = " + grupo.getId();            
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                int idCandidato = resultado.getInt("IDCANDIDATO");
                int idasesor = resultado.getInt("IDASESOR");

                AsesorDBHelper helperAsesor = new AsesorDBHelper();
                Asesor asesor = helperAsesor.getAsesor(idasesor);

                Blob fotoBlob = resultado.getBlob("FOTO");
                String nombre = resultado.getString("NOMBRE");
                String apPaterno = resultado.getString("APELLIDOPATERNO");
                String apMaterno = resultado.getString("APELLIDOMATERNO");
                String carrera = resultado.getString("CARRERA");
                int creditos = resultado.getInt("CREDITOS");
                String temaTesis = resultado.getString("TEMADETESIS");
                String dirTesis = resultado.getString("DIRECTORDETESIS");
                
                ImageIcon foto = new ImageIcon(
                                fotoBlob.getBytes(1, (int)fotoBlob.length()));

                Candidato candidato = new Candidato(nombre, apPaterno,
                                            apMaterno, "", carrera, temaTesis);
                candidato.setAsesor(asesor);
                candidato.setId(idCandidato);
                candidato.setFoto(foto);
                candidato.setCreditos(creditos);
                candidato.setDirectorTesis(dirTesis);

                grupo.agregarCandidato(candidato);
            }
        } catch (SQLException ex) {
            System.out.println("base.CandidatoDBHelper.getConGrupoIG() " + ex);
        }
        
        return grupo;
    }
    
    /**
    * Se obtiene un candidato por medio de su contraseña.
    * 
    * @param    contrasena  String con el que se realizara la busqueda en la base de datos.
    * @return               un Candidato, null si ocurre un error o no se encontro,
    *                       de lo contrario regresa al canddato.
    */
    public final Candidato getCandidato(final String contrasena) {
        Candidato candidato = null;
        
        try {
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT * FROM CANDIDATO "
                            + "WHERE CONTRASENA = '" + contrasena + "'";            
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                int idCandidato = resultado.getInt("IDCANDIDATO");
                Blob fotoBlob = resultado.getBlob("FOTO");
                String nombre = resultado.getString("NOMBRE");
                String apPaterno = resultado.getString("APELLIDOPATERNO");
                String apMaterno = resultado.getString("APELLIDOMATERNO");
                int matricula = resultado.getInt("MATRICULA");
                String email = resultado.getString("EMAIL");
                int celular = resultado.getInt("CELULAR");
                String carrera = resultado.getString("CARRERA");
                int creditos = resultado.getInt("CREDITOS");
                String temaTesis = resultado.getString("TEMADETESIS");
                String directorTesis = resultado.getString("DIRECTORDETESIS");
                String lugarTrabajo = resultado.getString("LUGARTRABAJO");
                String hrTrabajo = resultado.getString("HORARIOTRABAJO");
                                
                ImageIcon foto = new ImageIcon(
                                fotoBlob.getBytes(1, (int)fotoBlob.length()));

                candidato = new Candidato(nombre, apPaterno, apMaterno,
                                        contrasena, carrera, temaTesis);
                candidato.setId(idCandidato);
                candidato.setFoto(foto);
                candidato.setMatricula(matricula);
                candidato.setEmail(email);
                candidato.setCelular(celular);
                candidato.setCreditos(creditos);
                candidato.setDirectorTesis(directorTesis);
                candidato.setLugarTrabajo(lugarTrabajo);
                candidato.setHorarioTrabajo(hrTrabajo);
            }
        } catch (SQLException ex) {
            System.out.println("base.CandidatoDBHelper.getCandidato() " + ex);
        }

        return candidato;
    }
    
    /**
    * Se obtiene la carta compromiso de un candidato por su id.
    *
    * @param    candidato   se extrae su id.
    * @return               un File, null si ocurre un error o no tiene 
    *                       cartaCompromiso el candidato, de lo contrario 
    *                       regresa la cartaCompromiso.
    */
    public final File getCartaCompromiso(final Candidato candidato) {
        File archivo = null;
        Blob blob = null;

        try {
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT CARTACOMPROMISO FROM CANDIDATO "
                            + "WHERE IDCANDIDATO = '" + candidato.getId() + "'";            
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                blob = resultado.getBlob("CARTACOMPROMISO");
            }

            //Se crea el pdf con los datos obtenidos de la base de datos.
            String pathname = "CartaCompromiso.pdf";
            archivo = new File(pathname);
            FileOutputStream output = new FileOutputStream(archivo);
            InputStream inStream = blob.getBinaryStream();
            int length;
            int size = (int)blob.length();
            byte[] buffer = new byte[size];

            while ((length = inStream.read(buffer)) > -1) {
                output.write(buffer, 0, length);
            }
            output.close();
            inStream.close();
        } catch (SQLException | IOException e) {
            System.out.println("BaseDatos.CandidatoDBHelper"
                                + ".getCartaCompromiso() " + e);
        }

        return archivo;
    }
    
    /**
    * Se obtiene la carta exposición de motivos de un candidato por su id.
    * 
    * @param    candidato   se extrae su id.
    * @return               un File, null si ocurre un error o no tiene 
    *                       cartaMotivos el candidato, de lo contrario regresa
    *                       la cartaMotivos.
    */
    public final File getCartaMotivos(final Candidato candidato) {
        File archivo = null;
        Blob blob = null;

        try {
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT CARTAEXPOMOTIVOS FROM CANDIDATO "
                            + "WHERE IDCANDIDATO = '" + candidato.getId() + "'";            
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                blob = resultado.getBlob("CARTAEXPOMOTIVOS");
            }

            //Se crea el pdf con los datos obtenidos de la base de datos.
            String pathname = "CartaMotivos.pdf";
            archivo = new File(pathname);
            FileOutputStream output = new FileOutputStream(archivo);
            InputStream inStream = blob.getBinaryStream();
            int length;
            int size = (int)blob.length();
            byte[] buffer = new byte[size];

            while ((length = inStream.read(buffer)) > -1) {
                output.write(buffer, 0, length);
            }
            output.close();
            inStream.close();
        } catch (SQLException | IOException e) {
            System.out.println("BaseDatos.CandidatoDBHelper.getCartaMotivos() "
                                + e);
        }

        return archivo;
    }
    
    /**
    * Se obtiene el nombre del grupo al que pertenece el candidato.
    * 
    * @param    candidato   se extrae su id para realizar la busqueda en
    *                       la base de datos.
    * @return               un String, vacio si ocurre un error o no tiene
    *                       grupo el candidato, de lo contrario regresa el
    *                       nombre del grupo.
    */
    public final String getNombreGrupo(final Candidato candidato) {
        String nombre = "";

        try {
            Statement sentencia = conexion.getStatement();
            String query = "SELECT NOMBRE FROM GRUPO "
                        + "WHERE IDGRUPO = ("
                            + "SELECT IDGRUPO FROM CANDIDATO "
                            + "WHERE IDCANDIDATO = " + candidato.getId() + ")";
            ResultSet resultado = sentencia.executeQuery(query);
            
            while (resultado.next()) {
                nombre = resultado.getString("NOMBRE");
            }
        } catch (SQLException ex) {
            System.out.println("BaseDatos.CandidatoDBHelper.getNombreGrupo() "
                                + ex);
        }

        return nombre;
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
            System.out.println("BaseDatos.CandidatoDBHelper.Confirmar() " + ex);
            confirmacion = false;
        }
        return confirmacion;
    }
}