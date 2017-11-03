package Clases;

import javax.swing.ImageIcon;

/**
 *
 * @author Parker
 */
public class Candidato {
    private ImageIcon Foto; 
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String Boleta;
    private String email;
    private int celular;
    private String carrera;
    private int Generación;
    private String temaTesis;
    private String directorTesis;
    private String lugarTrabajo;
    private String horarioTrabajo;
    private String cartaCompromiso;
    private String cartaExpoMotivos;

    public Candidato(ImageIcon Foto, String nombre, String apellidoPaterno, String apellidoMaterno, String carrera, String temaTesis, String cartaCompromiso, String cartaExpoMotivos) {
        this.Foto = Foto;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.carrera = carrera;
        this.temaTesis = temaTesis;
        this.cartaCompromiso = cartaCompromiso;
        this.cartaExpoMotivos = cartaExpoMotivos;
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

    public String getBoleta() {
        return Boleta;
    }

    public void setBoleta(String Boleta) {
        this.Boleta = Boleta;
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

    public int getGeneración() {
        return Generación;
    }

    public void setGeneración(int Generación) {
        this.Generación = Generación;
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

    public String getCartaCompromiso() {
        return cartaCompromiso;
    }

    public void setCartaCompromiso(String cartaCompromiso) {
        this.cartaCompromiso = cartaCompromiso;
    }

    public String getCartaExpoMotivos() {
        return cartaExpoMotivos;
    }

    public void setCartaExpoMotivos(String cartaExpoMotivos) {
        this.cartaExpoMotivos = cartaExpoMotivos;
    }
    
    public Asesor MiAsesor(){
        Asesor asesor = new Asesor(nombre, apellidoPaterno, apellidoMaterno);
        return asesor;                
    }
}
