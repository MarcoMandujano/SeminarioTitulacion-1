package BaseDatos;

import Clases.Asesor;
import Clases.Candidato;
import Clases.Grupo;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import oracle.jdbc.OraclePreparedStatement;
import oracle.sql.*;

/**
 *
 * @author Parker
 */
public class CandidatoDBHelper {
    static DBConexion conexion = null;
    
    public CandidatoDBHelper(){
        conexion = new DBConexion();
    }
    
    public boolean Registrar(Candidato candidato){
        boolean transaccion = true;
        
        try{
            Statement sentencia = conexion.getStatement();
                                                
            String query = "INSERT INTO CANDIDATO VALUES ((SELECT COUNT(*) FROM CANDIDATO) + 1, '', '', '', '" + candidato.getNombre() + "', '" + candidato.getApellidoPaterno() + "', '" + candidato.getApellidoMaterno() + "', '" + candidato.getContrasena() + "', '" + candidato.getMatricula() + "', '" + candidato.getEmail() + "', " + candidato.getCelular() + ", '" + candidato.getCarrera() + "', " + candidato.getCreditos() + ", '" + candidato.getTemaTesis() + "', '" + candidato.getDirectorTesis() + "', '" + candidato.getLugarTrabajo() + "', '" + candidato.getHorarioTrabajo() + "', EMPTY_BLOB(), EMPTY_BLOB())";            
            
            sentencia.execute(query);
            Confirmar();
            
            SetFoto(candidato);
            SetCartaCompromiso(candidato);
            SetCartaMotivos(candidato);
        }
        catch(SQLException ex){
            System.out.println(ex);
            transaccion = false;
        }
        
        return transaccion;
    }
    
    /*
    * Actualiza la carta exposición de motivos de un candidato por medio de su contraseña.
    */
    public boolean SetCartaCompromiso(Candidato candidato){
        boolean transaccion = true;
        
        try{            
            File blobFile = candidato.getCartaCompromiso();
            InputStream blobInput = new FileInputStream(blobFile);
            
            PreparedStatement ops;
            String query = "UPDATE CANDIDATO SET CARTACOMPROMISO = ? WHERE CONTRASENA = ?";                       
            ops = conexion.getConexion().prepareStatement(query);
            
            ops.setBinaryStream(1, blobInput, (int)blobFile.length());
            ops.setString(2, candidato.getContrasena());
            ops.executeUpdate();
            Confirmar();
        }
        catch(Exception ex){            
            System.out.println("BaseDatos.CandidatoDBHelper.SetCartaCompromiso() " + ex);
            transaccion = false;
        }
        
        return transaccion;
    }
    
    /*
    * Actualiza la carta exposición de motivos de un candidato por medio de su id.
    */
    public boolean SetCartaMotivos(Candidato candidato){
        boolean transaccion = true;
        
        try{            
            File blobFile = candidato.getCartaExpoMotivos();
            InputStream blobInput = new FileInputStream(blobFile);
            
            PreparedStatement ops;
            String query = "UPDATE CANDIDATO SET CARTAEXPOMOTIVOS = ? WHERE CONTRASENA = ?";                       
            ops = conexion.getConexion().prepareStatement(query);
            
            ops.setBinaryStream(1, blobInput, (int)blobFile.length());
            ops.setString(2, candidato.getContrasena());
            ops.executeUpdate();
            Confirmar();
        }
        catch(Exception ex){            
            System.out.println("BaseDatos.CandidatoDBHelper.SetCartaMotivos() " + ex);
            transaccion = false;
        }
        
        return transaccion;
    }
    
    /*
    * Actualiza la foto de un candidato por medio de su contraseña.
    */
    public boolean SetFoto(Candidato candidato){
        boolean transaccion = true;
        
        try{            
            File blobFile = new File(candidato.getFoto().getDescription());
            InputStream blobInput = new FileInputStream(blobFile);
            
            PreparedStatement ops;
            String query = "UPDATE CANDIDATO SET FOTO = ? WHERE CONTRASENA = ?";                       
            ops = conexion.getConexion().prepareStatement(query);
            
            ops.setBinaryStream(1, blobInput, (int)blobFile.length());
            ops.setString(2, candidato.getContrasena());
            ops.executeUpdate();
            Confirmar();
        }
        catch(Exception ex){            
            System.out.println("BaseDatos.CandidatoDBHelper.SetFoto() " + ex);
            transaccion = false;
        }
        
        return transaccion;
    }
    
    /*
    * Se asigna grupo y asesor al candidato.
    */
    public boolean setGrupoYAsesor(Asesor asesor, Grupo grupo, Candidato candidato){
        boolean transaccion = true;
        
        try{
            Statement sentencia = conexion.getStatement();
                                  
            String query = "UPDATE CANDIDATO "
                            + "SET IDASESOR = " + asesor.getId()
                            + ", IDGRUPO = " + grupo.getId()
                            + " WHERE IDCANDIDATO = " + candidato.getId();            
            
            sentencia.execute(query);
            Confirmar();
        }
        catch(SQLException ex){
            System.out.println(ex);
            transaccion = false;
        }
        
        return transaccion;
    }
    
    /*
    * Se obtienen todos los candidatos sin grupo de la base de datos.
    * Los candidatos solo tendran id, foto, nombre, apellido paterno, apellido materno, carrera, creditos, tema de tesis, carta compromiso y Carta exposición de motivos.
    */
    public ArrayList<Candidato> getSinGrupoIG(){
        ArrayList<Candidato> candidatos = new ArrayList<>();
        
        try{
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT * FROM CANDIDATO "
                            + "WHERE IDGRUPO IS NULL";            
            ResultSet resultado = sentencia.executeQuery(query);
            
            while (resultado.next()){
                int idCandidato = resultado.getInt("IDCANDIDATO");
                Blob fotoBlob = resultado.getBlob("FOTO");
                String nombre = resultado.getString("NOMBRE");
                String apPaterno = resultado.getString("APELLIDOPATERNO");
                String apMaterno = resultado.getString("APELLIDOMATERNO");
                String carrera = resultado.getString("CARRERA");
                int creditos = resultado.getInt("CREDITOS");
                String temaTesis = resultado.getString("TEMADETESIS");
//                Blob CartaComprmiso = resultado.getBlob("CARTACOMPROMISO");
//                Blob CartaMotivoBlob = resultado.getBlob("CARTAEXPOMOTIVOS");
                                
                ImageIcon foto = new ImageIcon(fotoBlob.getBytes(1, (int)fotoBlob.length()));
                
                Candidato candidato = new Candidato(foto, nombre, apPaterno, apMaterno, "", carrera, temaTesis, new File(""), new File(""));
                candidato.setId(idCandidato);                
                candidato.setCreditos(creditos);
                candidatos.add(candidato);
            }
        }
        catch(SQLException ex){            
            System.out.println("BaseDatos.CandidatoDBHelper.getSinGrupoIG() " + ex);
        }
        
        return candidatos;
    }
    
    /*
    * Se obtienen todos los candidatos de un grupo con el id del grupo.
    * El grupo tendra candidatos con id, foto, nombre, apellido paterno, apellido materno, carrera, creditos, tema de tesis y asesor.
    */
    public Grupo getConGrupoIG(Grupo grupo){
        try{
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT * FROM CANDIDATO "
                            + "WHERE IDGRUPO = " + grupo.getId();            
            ResultSet resultado = sentencia.executeQuery(query);
            
            while (resultado.next()){
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
                
                ImageIcon foto = new ImageIcon(fotoBlob.getBytes(1, (int)fotoBlob.length()));
                
                Candidato candidato = new Candidato(foto, nombre, apPaterno, apMaterno, "", carrera, temaTesis, new File(""), new File(""));
                candidato.setAsesor(asesor);
                candidato.setId(idCandidato);
                candidato.setCreditos(creditos);
                
                grupo.AgregarCandidato(candidato);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        return grupo;
    }
    
    /*
    * Se obtiene un candidato por medio de su contraseña.    
    */
    public Candidato getCandidato(String contrasena){
        Candidato candidato = null;
        
        try{
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT * FROM CANDIDATO "
                            + "WHERE CONTRASENA = '" + contrasena + "'";            
            ResultSet resultado = sentencia.executeQuery(query);
            
            while (resultado.next()){
                int idCandidato = resultado.getInt("IDCANDIDATO");
                int idasesor = resultado.getInt("IDASESOR");
                int idgrupo = resultado.getInt("IDGRUPO");
                resultado.getBlob("FOTO");
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
//                resultado.getBlob("CARTACOMPROMISO");
//                resultado.getBlob("CARTAEXPOMOTIVOS");
                
                candidato = new Candidato(new ImageIcon("foto.png"), nombre, apPaterno, apMaterno, contrasena, carrera, temaTesis, new File(""), new File(""));
                candidato.setId(idCandidato);
                candidato.setMatricula(matricula);
                candidato.setEmail(email);
                candidato.setCelular(celular);
                candidato.setCreditos(creditos);
                candidato.setDirectorTesis(directorTesis);
                candidato.setLugarTrabajo(lugarTrabajo);
                candidato.setHorarioTrabajo(hrTrabajo);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        return candidato;
    }
    
    /*
    * Se obtiene la carta compromiso de un candidato por su contraseña.    
    */
    public File getCartaCompromiso(Candidato candidato){
        File archivo = null;
        Blob blob = null;
        
        try{
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT CARTACOMPROMISO FROM CANDIDATO "
                            + "WHERE IDCANDIDATO = '" + candidato.getId() + "'";            
            ResultSet resultado = sentencia.executeQuery(query);
            
            while (resultado.next()){
                blob = resultado.getBlob("CARTACOMPROMISO");
            }
            
            //Se crea el pdf con los datos obtenidos de la base de datos.
            String pathname = "CartaCompromiso.pdf";
            archivo = new File(pathname);
            FileOutputStream output = new FileOutputStream(archivo);
            InputStream inStream = blob.getBinaryStream();
            int length = -1;
            int size = (int)blob.length();
            byte[] buffer = new byte[size];
            
            while ((length = inStream.read(buffer)) > -1) {
                output.write(buffer, 0, length);
            }
            output.close();
            inStream.close();
        }
        catch(SQLException | IOException e){
            System.out.println("BaseDatos.CandidatoDBHelper.getCartaCompromiso() " + e);
        }
        
        return archivo;
    }
    
    /*
    * Se obtiene la carta exposición de motivos de un candidato por su contraseña.    
    */
    public File getCartaMotivos(Candidato candidato){
        File archivo = null;
        Blob blob = null;
        
        try{
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT CARTAEXPOMOTIVOS FROM CANDIDATO "
                            + "WHERE IDCANDIDATO = '" + candidato.getId() + "'";            
            ResultSet resultado = sentencia.executeQuery(query);
            
            while (resultado.next()){
                blob = resultado.getBlob("CARTAEXPOMOTIVOS");
            }
            
            //Se crea el pdf con los datos obtenidos de la base de datos.
            String pathname = "CartaMotivos.pdf";
            archivo = new File(pathname);
            FileOutputStream output = new FileOutputStream(archivo);
            InputStream inStream = blob.getBinaryStream();
            int length = -1;
            int size = (int)blob.length();
            byte[] buffer = new byte[size];
            
            while ((length = inStream.read(buffer)) > -1) {
                output.write(buffer, 0, length);
            }
            output.close();
            inStream.close();
        }
        catch(SQLException | IOException e){
            System.out.println("BaseDatos.CandidatoDBHelper.getCartaMotivos() " + e);
        }
        
        return archivo;
    }
    
    /*
    * Se obtiene el nombre del grupo al que pertenece el candidato. 
    * La busqueda se realiza por medio del id del candidato.    
    */
    public String getNombreGrupo(Candidato candidato){
        String nombre = "";
        
        try{
            Statement sentencia = conexion.getStatement();            
            String query = "SELECT NOMBRE FROM GRUPO "
                            + "WHERE IDGRUPO = ("
                                + "SELECT IDGRUPO FROM CANDIDATO "
                                    + "WHERE IDCANDIDATO = " + candidato.getId() + ")";            
            ResultSet resultado = sentencia.executeQuery(query);
            
            while (resultado.next()){
                nombre = resultado.getString("NOMBRE");
            }
        }
        catch(SQLException ex){
            System.out.println("BaseDatos.CandidatoDBHelper.getNombreGrupo() " + ex);
        }
        
        return nombre;
    }
    
    public boolean Confirmar(){
        boolean confirmacion = true;
        try{
            Statement sentencia = conexion.getStatement();
            
            String query = "COMMIT";            
            sentencia.execute(query);
        }
        catch(SQLException ex){
            System.out.println("BaseDatos.CandidatoDBHelper.Confirmar() " + ex);
            confirmacion = false;
        }
        return confirmacion;
    }    
}
