package Clases;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Parker
 */
public class Asesor {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasena;
    private String cubiculo;
    private String email;
    private Time hrInicioAsesoria;
    private Time hrFinAsesoria;

    public Asesor(String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Time getHrInicioAsesoria() {
        return hrInicioAsesoria;
    }

    public void setHrInicioAsesoria(Time hrInicioAsesoria) {
        this.hrInicioAsesoria = hrInicioAsesoria;
    }

    public Time getHrFinAsesoria() {
        return hrFinAsesoria;
    }

    public void setHrFinAsesoria(Time hrFinAsesoria) {
        this.hrFinAsesoria = hrFinAsesoria;
    }
    
    public ArrayList<Candidato> CandidatosAsesorados(){
        ArrayList<Candidato> candidatos = new ArrayList<>();
        return candidatos;
    }
}
