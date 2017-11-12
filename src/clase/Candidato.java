package clase;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Parker
 */
public class Candidato {
    /**
    * Identificador único del candidato.
    */
    private int id;

    /**
    * foto del candidato.
    */
    private ImageIcon foto;

    /**
    * Nombre del candidato.
    */
    private String nombre;

    /**
    * Apellido paterno del candidato.
    */
    private String apellidoPaterno;

    /**
    * Apellido materno del candidato.
    */
    private String apellidoMaterno;

    /**
    * Contraseña del candidato.
    */
    private String contrasena;

    /**
    * Matrícula del candidato.
    */
    private int matricula;

    /**
    * Correo electrónico del candidato.
    */
    private String email;

    /**
    * Teléfono celular del candidato.
    */
    private int celular;

    /**
    * Carrera del candidato.
    */
    private String carrera;

    /**
    * Porcentaje de creditos del candidato.
    */
    private int creditos;

    /**
    * Tema de tesis del candidato.
    */
    private String temaTesis;

    /**
    * Director de tesis del candidato.
    */
    private String directorTesis;

    /**
    * Dirección de el trabajo del candidato.
    */
    private String lugarTrabajo;

    /**
    * Horiario de trabjao del candidato.
    */
    private String horarioTrabajo;

    /**
    * Carta compromiso del candidato.
    */
    private File cartaCompromiso;

    /**
    * Carta exposición de motivos del candidato.
    */
    private File cartaExpoMotivos;

    /**
    * Asesor del candidato.
    */
    private Asesor asesor;

    /**
     * Constructor Candidato.
     *
     * @param nombreX           nombre del candidato.
     * @param apellidoPaternoX  apellido paterno del candidato.
     * @param apellidoMaternoX  apellido materno del candidato.
     * @param contrasenaX       contraseña del candidato.
     * @param carreraX          carrera del candidato.
     * @param temaTesisX        tema de tesis del candidato.
     */
    public Candidato(final String nombreX, final String apellidoPaternoX,
            final String apellidoMaternoX, final String contrasenaX,
            final String carreraX, final String temaTesisX) {
        this.nombre = nombreX;
        this.apellidoPaterno = apellidoPaternoX;
        this.apellidoMaterno = apellidoMaternoX;
        this.contrasena = contrasenaX;
        this.carrera = carreraX;
        this.temaTesis = temaTesisX;
    }

    /**
    * Obtiene el id del candidato.
    *
    * @return       un int, el id del candidato.
    */
    public final int getId() {
        return id;
    }

    /**
    * Asigna id al candidato.
    *
    * @param    idX     identificador del candidato.
    */
    public final void setId(final int idX) {
        this.id = idX;
    }

    /**
    * Obtiene la foto del candidato.
    *
    * @return       un ImageIcon, la foto del candidato.
    */
    public final ImageIcon getFoto() {
        return foto;
    }

    /**
    * Asigna la foto al candidato.
    *
    * @param    fotoX   foto del candidato.
    */
    public final void setFoto(final ImageIcon fotoX) {
        this.foto = fotoX;
    }

    /**
    * Obtiene el nombre del candidato.
    *
    * @return       un String, el nombre del candidato.
    */
    public final String getNombre() {
        return nombre;
    }

    /**
    * Asigna el nombre al candidato.
    *
    * @param    nombreX     nombre del candidato.
    */
    public final void setNombre(final String nombreX) {
        this.nombre = nombreX;
    }

    /**
    * Obtiene el apellido paterno del candidato.
    *
    * @return       un String, el apellido paterno del candidato.
    */
    public final String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
    * Asigna apellido paterno al candidato.
    *
    * @param    apellidoPaternoX    apellido paterno del candidato.
    */
    public final void setApellidoPaterno(final String apellidoPaternoX) {
        this.apellidoPaterno = apellidoPaternoX;
    }

    /**
    * Obtiene el apellido materno del candidato.
    *
    * @return       un String, el apellido materno del candidato.
    */
    public final String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
    * Asigna apellido materno al candidato.
    *
    * @param    apellidoMaternoX    apellido materno del candidato.
    */
    public final void setApellidoMaterno(final String apellidoMaternoX) {
        this.apellidoMaterno = apellidoMaternoX;
    }

    /**
    * Obtiene la matrícula del candidato.
    *
    * @return       un int, la matrícula del candidato.
    */
    public final int getMatricula() {
        return matricula;
    }

    /**
    * Asigna matrícula al candidato.
    *
    * @param    matriculaX    matrícula del candidato.
    */
    public final void setMatricula(final int matriculaX) {
        this.matricula = matriculaX;
    }

    /**
    * Obtiene el correo electrónico del candidato.
    *
    * @return       un String, el correo electrónico del candidato.
    */
    public final String getEmail() {
        return email;
    }

    /**
    * Asigna correo electrónico al candidato.
    *
    * @param    emailX    correo electrónico del candidato.
    */
    public final void setEmail(final String emailX) {
        this.email = emailX;
    }

    /**
    * Obtiene el teléfono celular del candidato.
    *
    * @return       un int, el teléfono celular del candidato.
    */
    public final int getCelular() {
        return celular;
    }

    /**
    * Asigna el teléfono celular al candidato.
    *
    * @param    celularX    teléfono celular del candidato.
    */
    public final void setCelular(final int celularX) {
        this.celular = celularX;
    }

    /**
    * Obtiene la carrera del candidato.
    *
    * @return       un String, la carrera del candidato.
    */
    public final String getCarrera() {
        return carrera;
    }

    /**
    * Asigna carrera al candidato.
    *
    * @param    carreraX    carrera del candidato.
    */
    public final void setCarrera(final String carreraX) {
        this.carrera = carreraX;
    }

    /**
    * Obtiene el porcentaje de creditos del candidato.
    *
    * @return       un int, el porcentaje de creditos del candidato.
    */
    public final int getCreditos() {
        return creditos;
    }

    /**
    * Asigna procentaje de creditos al candidato.
    *
    * @param    creditosX    porcentaje de creditos del candidato.
    */
    public final void setCreditos(final int creditosX) {
        this.creditos = creditosX;
    }

    /**
    * Obtiene el tema de tesis del candidato.
    *
    * @return       un String, el tema de tesis del candidato.
    */
    public final String getTemaTesis() {
        return temaTesis;
    }

    /**
    * Asigna tema de tesis al candidato.
    *
    * @param    temaTesisX    tema de tesis del candidato.
    */
    public final void setTemaTesis(final String temaTesisX) {
        this.temaTesis = temaTesisX;
    }

    /**
    * Obtiene el director de tesis del candidato.
    *
    * @return       un String, el director de tesis del candidato.
    */
    public final String getDirectorTesis() {
        return directorTesis;
    }

    /**
    * Asigna director de tesis al candidato.
    *
    * @param    directorTesisX    director de tesis del candidato.
    */
    public final void setDirectorTesis(final String directorTesisX) {
        this.directorTesis = directorTesisX;
    }

    /**
    * Obtiene la dirección de trabajo del candidato.
    *
    * @return       un String, la dirección del trabajo del candidato.
    */
    public final String getLugarTrabajo() {
        return lugarTrabajo;
    }

    /**
    * Asigna dirección de trabajo al candidato.
    *
    * @param    lugarTrabajoX   dirección de trabajo del candidato.
    */
    public final void setLugarTrabajo(final String lugarTrabajoX) {
        this.lugarTrabajo = lugarTrabajoX;
    }

    /**
    * Obtiene el horario de trabajo del candidato.
    *
    * @return       un String, horario de trabajo del candidato.
    */
    public final String getHorarioTrabajo() {
        return horarioTrabajo;
    }

    /**
    * Asigna horario de trabajo al candidato.
    *
    * @param    horarioTrabajoX    horario de trabajo del candidato.
    */
    public final void setHorarioTrabajo(final String horarioTrabajoX) {
        this.horarioTrabajo = horarioTrabajoX;
    }

    /**
    * Obtiene la carta compromiso del candidato.
    *
    * @return       un File, la carta compromiso del candidato.
    */
    public final File getCartaCompromiso() {
        return cartaCompromiso;
    }

    /**
    * Asigna carta compromiso al candidato.
    *
    * @param    cartaCompromisoX    carta compromiso del candidato.
    */
    public final void setCartaCompromiso(final File cartaCompromisoX) {
        this.cartaCompromiso = cartaCompromisoX;
    }

    /**
    * Obtiene la carta exposición de motivos del candidato.
    *
    * @return       un File, la carta exposición de motivos del candidato.
    */
    public final File getCartaExpoMotivos() {
        return cartaExpoMotivos;
    }

    /**
    * Asigna carta exposición de motivos al candidato.
    *
    * @param    cartaExpoMotivosX    carta exposición de motivos del candidato.
    */
    public final void setCartaExpoMotivos(final File cartaExpoMotivosX) {
        this.cartaExpoMotivos = cartaExpoMotivosX;
    }

    /**
    * Obtiene la contraseña del candidato.
    *
    * @return       un String, la contraseña del candidato.
    */
    public final String getContrasena() {
        return contrasena;
    }

    /**
    * Asigna contraseña al candidato.
    *
    * @param    contrasenaX    contraseña del candidato.
    */
    public final void setContrasena(final String contrasenaX) {
        this.contrasena = contrasenaX;
    }

    /**
    * Obtiene el asesor del candidato.
    *
    * @return       un Asesor, asesor del candidato.
    */
    public final Asesor getAsesor() {
        return asesor;
    }

    /**
    * Asigna asesor al candidato.
    *
    * @param    asesorX    asesor del candidato.
    */
    public final void setAsesor(final Asesor asesorX) {
        this.asesor = asesorX;
    }
}
