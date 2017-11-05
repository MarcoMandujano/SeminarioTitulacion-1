package BaseDatos;

import Clases.Asesor;
import Clases.Candidato;
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
            
            //Si son valores nulos se modifica para guardarse con los parametros de oracle
            String celular = Integer.toString(candidato.getCelular());
                        
            if(candidato.getCelular() == 0){
                celular = "''";
            }
                        
            String query = "INSERT INTO CANDIDATO VALUES ((SELECT COUNT(*) FROM CANDIDATO) + 1, '', '', '', '" + candidato.getNombre() + "', '" + candidato.getApellidoPaterno() + "', '" + candidato.getApellidoMaterno() + "', '" + candidato.getContrasena() + "', '" + candidato.getBoleta() + "', '" + candidato.getEmail() + "', " + celular + ", '" + candidato.getCarrera() + "', " + candidato.getGeneración() + ", '" + candidato.getTemaTesis() + "', '" + candidato.getDirectorTesis() + "', '" + candidato.getLugarTrabajo() + "', '" + candidato.getHorarioTrabajo() + "', EMPTY_BLOB(), EMPTY_BLOB())";            
            
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
    * Se asigna asesor al candidato
    */
    public boolean setAsesor(Asesor asesor, Candidato candidato){
        boolean transaccion = true;
        
        try{
            Statement sentencia = conexion.getStatement();
                                  
            String query = "UPDATE CANDIDATO "
                            + "SET IDASESOR = " + asesor.getId()
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
    * Los candidatos solo tendran id, foto, nombre, apellido paterno, apellido materno, carrera, tema de tesis, carta compromiso y Carta exposición de motivos.
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
                String temaTesis = resultado.getString("TEMADETESIS");
                resultado.getBlob("CARTACOMPROMISO");
                resultado.getBlob("CARTAEXPOMOTIVOS");
                
                Candidato candidato = new Candidato(new ImageIcon("foto.png"), nombre, apPaterno, apMaterno, carrera, carrera, temaTesis, new File(""), new File(""));
                candidato.setId(idCandidato);
                candidatos.add(candidato);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        return candidatos;
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
