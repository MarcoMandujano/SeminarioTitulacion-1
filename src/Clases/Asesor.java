package Clases;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Parker
 */
public class Asesor {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cubiculo;
    private String email;
    private Time hrInicioAsesoria;
    private Time hrFinAsesoria;

    public Asesor(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
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
