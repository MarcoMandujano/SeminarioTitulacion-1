package Clases;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Parker
 */
public class Candidato {
    private int id;    
    private ImageIcon Foto; 
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasena;
    private int matricula;
    private String email;
    private int celular;
    private String carrera;
    private int creditos;
    private String temaTesis;
    private String directorTesis;
    private String lugarTrabajo;
    private String horarioTrabajo;
    private File cartaCompromiso;
    private File cartaExpoMotivos; 
    private Asesor asesor;

    public Candidato(ImageIcon Foto, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, String carrera, String temaTesis, File cartaCompromiso, File cartaExpoMotivos) {
        this.Foto = Foto;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.carrera = carrera;
        this.temaTesis = temaTesis;
        this.cartaCompromiso = cartaCompromiso;
        this.cartaExpoMotivos = cartaExpoMotivos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageIcon getFoto() {
        return Foto;
    }

    public void setFoto(ImageIcon Foto) {
        this.Foto = Foto;
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getTemaTesis() {
        return temaTesis;
    }

    public void setTemaTesis(String temaTesis) {
        this.temaTesis = temaTesis;
    }

    public String getDirectorTesis() {
        return directorTesis;
    }

    public void setDirectorTesis(String directorTesis) {
        this.directorTesis = directorTesis;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(String horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

    public File getCartaCompromiso() {
        return cartaCompromiso;
    }

    public void setCartaCompromiso(File cartaCompromiso) {
        this.cartaCompromiso = cartaCompromiso;
    }

    public File getCartaExpoMotivos() {
        return cartaExpoMotivos;
    }

    public void setCartaExpoMotivos(File cartaExpoMotivos) {
        this.cartaExpoMotivos = cartaExpoMotivos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }
}
