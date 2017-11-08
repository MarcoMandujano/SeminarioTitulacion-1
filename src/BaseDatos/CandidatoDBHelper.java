package BaseDatos;

import Clases.Asesor;
import Clases.Candidato;
import Clases.Grupo;
import java.io.File;
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
        }
        catch(SQLException ex){
            System.out.println(ex);
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
                resultado.getBlob("FOTO");
                String nombre = resultado.getString("NOMBRE");
                String apPaterno = resultado.getString("APELLIDOPATERNO");
                String apMaterno = resultado.getString("APELLIDOMATERNO");
                String carrera = resultado.getString("CARRERA");
                int creditos = resultado.getInt("CREDITOS");
                String temaTesis = resultado.getString("TEMADETESIS");
                resultado.getBlob("CARTACOMPROMISO");
                resultado.getBlob("CARTAEXPOMOTIVOS");
                
                Candidato candidato = new Candidato(new ImageIcon("foto.png"), nombre, apPaterno, apMaterno, "", carrera, temaTesis, new File(""), new File(""));
                candidato.setId(idCandidato);                
                candidato.setCreditos(creditos);
                candidatos.add(candidato);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
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
                
                resultado.getBlob("FOTO");
                String nombre = resultado.getString("NOMBRE");
                String apPaterno = resultado.getString("APELLIDOPATERNO");
                String apMaterno = resultado.getString("APELLIDOMATERNO");
                String carrera = resultado.getString("CARRERA");
                int creditos = resultado.getInt("CREDITOS");
                String temaTesis = resultado.getString("TEMADETESIS");
                
                Candidato candidato = new Candidato(new ImageIcon("foto.png"), nombre, apPaterno, apMaterno, "", carrera, temaTesis, new File(""), new File(""));
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
                resultado.getBlob("CARTACOMPROMISO");
                resultado.getBlob("CARTAEXPOMOTIVOS");
                
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
        
    public boolean Confirmar(){
        boolean confirmacion = true;
        try{
            Statement sentencia = conexion.getStatement();
            
            String query = "COMMIT";            
            sentencia.execute(query);
        }
        catch(SQLException ex){
            System.out.println(ex);
            confirmacion = false;
        }
        return confirmacion;
    }
}
