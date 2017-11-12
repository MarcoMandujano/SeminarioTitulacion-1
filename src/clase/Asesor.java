package clase;

import java.sql.Time;

/**
 *
 * @author Parker
 */
public class Asesor {
    /**
    * Identificador único de un asesor.
    */
    private int id;

    /**
    * Nombre de un asesor.
    */
    private String nombre;

    /**
    * Apellido paterno de un asesor.
    */
    private String apellidoPaterno;

    /**
    * Apellido materno de un asesor.
    */
    private String apellidoMaterno;

    /**
    * Contraseña de un asesor.
    */
    private String contrasena;

    /**
    * Cubículo de un asesor.
    */
    private String cubiculo;

    /**
    * Correo electrónico de un asesor.
    */
    private String email;

    /**
    * Hora de inicio de asesoria de un asesor.
    */
    private Time hrInicioAsesoria;

    /**
    * Hora de fin de asesoria de un asesor.
    */
    private Time hrFinAsesoria;

    /**
    * Constructor de Asesor.
    *
    * @param nombreX            nombre del asesor.
    * @param apellidoPaternoX   apellido paterno del asesor.
    * @param apellidoMaternoX   apellido materno del asesor.
    * @param contrasenaX        contraseña del asesor.
    */
    public Asesor(final String nombreX, final String apellidoPaternoX,
            final String apellidoMaternoX, final String contrasenaX) {
        this.nombre = nombreX;
        this.apellidoPaterno = apellidoPaternoX;
        this.apellidoMaterno = apellidoMaternoX;
        this.contrasena = contrasenaX;
    }

    /**
    * Obtiene el id del asesor.
    *
    * @return       un int, el id del asesor.
    */
    public final int getId() {
        return id;
    }

    /**
    * Asigna id al asesor.
    *
    * @param    idX     se asigna al asesor.
    */
    public final void setId(final int idX) {
        this.id = idX;
    }

    /**
    * Obtiene el nombre del asesor.
    *
    * @return       un String, el nombre del asesor.
    */
    public final String getNombre() {
        return nombre;
    }

    /**
    * Asigna nombre al asesor.
    *
    * @param    nombreX     nombre del asesor.
    */
    public final void setNombre(final String nombreX) {
        this.nombre = nombreX;
    }

    /**
    * Obtiene el apellido paterno del asesor.
    *
    * @return       un String, el apellido paterno del asesor.
    */
    public final String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
    * Asigna apellido paterno al asesor.
    *
    * @param    apellidoPaternoX    apellido paterno del asesor.
    */
    public final void setApellidoPaterno(final String apellidoPaternoX) {
        this.apellidoPaterno = apellidoPaternoX;
    }

    /**
    * Obtiene el apellido materno del asesor.
    *
    * @return       un String, el apellido materno del asesor.
    */
    public final String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
    * Asigna apellido materno al asesor.
    *
    * @param    apellidoMaternoX    apellido materno del asesor.
    */
    public final void setApellidoMaterno(final String apellidoMaternoX) {
        this.apellidoMaterno = apellidoMaternoX;
    }

    /**
    * Obtiene la contraseña del asesor.
    *
    * @return       un String, la contraseña del asesor.
    */
    public final String getContrasena() {
        return contrasena;
    }

    /**
    * Asigna contraseña al asesor.
    *
    * @param    contrasenaX    contraseña del asesor.
    */
    public final void setContrasena(final String contrasenaX) {
        this.contrasena = contrasenaX;
    }

    /**
    * Obtiene el cubículo del asesor.
    *
    * @return       un String, el cubículo del asesor.
    */
    public final String getCubiculo() {
        return cubiculo;
    }

    /**
    * Asigna cubículo al asesor.
    *
    * @param    cubiculoX   cubículo del asesor.
    */
    public final void setCubiculo(final String cubiculoX) {
        this.cubiculo = cubiculoX;
    }

    /**
    * Obtiene el correo electrónico del asesor.
    *
    * @return       un String, el correo electrónico del asesor.
    */
    public final String getEmail() {
        return email;
    }

    /**
    * Asigna correo electrónico al asesor.
    *
    * @param    emailX    correo electrónico del asesor.
    */
    public final void setEmail(final String emailX) {
        this.email = emailX;
    }

    /**
    * Obtiene la hora de inicio de asesoria del asesor.
    *
    * @return       un Time, la hora de inicio de la asesoria del asesor.
    */
    public final Time getHrInicioAsesoria() {
        return hrInicioAsesoria;
    }

    /**
    * Asigna la hora de inicio de asesoria del asesor.
    *
    * @param    hrInicioAsesoriaX   hora de inicio de asesoria del asesor.
    */
    public final void setHrInicioAsesoria(final Time hrInicioAsesoriaX) {
        this.hrInicioAsesoria = hrInicioAsesoriaX;
    }

    /**
    * Obtiene la hora de fin de asesoria del asesor.
    *
    * @return       un Time, la hora de fin de la asesoria del asesor.
    */
    public final Time getHrFinAsesoria() {
        return hrFinAsesoria;
    }

    /**
    * Asigna la hora de fin de asesoria del asesor.
    *
    * @param    hrFinAsesoriaX   hora de fin de asesoria del asesor.
    */
    public final void setHrFinAsesoria(final Time hrFinAsesoriaX) {
        this.hrFinAsesoria = hrFinAsesoriaX;
    }
}
