package clase;

import java.util.ArrayList;

/**
 *
 * @author Parker
 */
public class Grupo {
    /**
    * identificador único del grupo.
    */
    private int id;

    /**
    * nombre del grupo.
    */
    private String nombre;

    /**
    * candidatos que conforman el grupo.
    */
    private ArrayList < Candidato > candidatos;

    /**
    * Constructor Grupo.
    *
    * @param    nombreX  nombre del grupo.
    */
    public Grupo(final String nombreX) {
        this.nombre = nombreX;
        candidatos = new ArrayList<>();
    }

    /**
    * Obtiene el id del grupo.
    *
    * @return       un int, el id del grupo.
    */
    public final int getId() {
        return id;
    }

    /**
    * Asigna id al grupo.
    *
    * @param    idX     identificador del grupo.
    */
    public final void setId(final int idX) {
        this.id = idX;
    }

    /**
    * Obtiene el nombre del grupo.
    *
    * @return       un String, el nombre del grupo.
    */
    public final String getNombre() {
        return nombre;
    }

    /**
    * Asigna el nombre del grupo.
    *
    * @param    nombreX     nombre del grupo.
    */
    public final void setNombre(final String nombreX) {
        this.nombre = nombreX;
    }

    /**
    * Obtiene los candidatos del grupo.
    *
    * @return       un ArrayList de Objetos Candidato, los candidatos
    *               que estan en el grupo.
    */
    public final ArrayList < Candidato > getCandidatos() {
        return candidatos;
    }

    /**
    * Asigna un grupo de candidatos al grupo.
    *
    * @param    candidatosX     grupo de candidatos que quieren ser del grupo.
    */
    public final void setCandidatos(final ArrayList < Candidato > candidatosX) {
        this.candidatos = candidatosX;
    }

    /**
    * Asigna un candidato al grupo.
    *
    * @param    candidato     candidato que quieren ser del grupo.
    */
    public final void agregarCandidato(final Candidato candidato) {
        candidatos.add(candidato);
    }
}