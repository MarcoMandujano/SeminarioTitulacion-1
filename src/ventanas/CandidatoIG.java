package ventanas;

import base.CandidatoDBHelper;
import base.GrupoDBHelper;
import clase.Asesor;
import clase.Candidato;
import clase.Grupo;
import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Parker
 */
public class CandidatoIG extends javax.swing.JPanel {
    /**
    * se utiliza para poder mostrar su información en la Panel.
    */
    private Candidato candidato;

    /**
    * se utiliza para poder asignar lo a un candidato
    * asi como para distinguir quien ve el Panel.
    */
    private Asesor asesor;

    /**
     * Creates new form Candidato.
     */
    public CandidatoIG() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbFoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLbNombre = new javax.swing.JLabel();
        jLbApellidos = new javax.swing.JLabel();
        jLbCreditos = new javax.swing.JLabel();
        jLbCarrera = new javax.swing.JLabel();
        jLbTemaTesis = new javax.swing.JLabel();
        jBtCartaCompromiso = new javax.swing.JButton();
        jBtCartaMotivos = new javax.swing.JButton();
        jBtAceptar = new javax.swing.JButton();
        jBtEnEspera = new javax.swing.JButton();
        jLabelAsesor = new javax.swing.JLabel();
        jLbAsesor = new javax.swing.JLabel();
        jLabelDirTesis = new javax.swing.JLabel();
        jLbDirTesis = new javax.swing.JLabel();

        jLbFoto.setText("jLbFoto");

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Creditos");

        jLabel4.setText("Carrera");

        jLabel5.setText("Tema de Tesis");

        jLbNombre.setText("jLbNombre");

        jLbApellidos.setText("jLbApPaterno");

        jLbCreditos.setText("jLbApMaterno");

        jLbCarrera.setText("jLbCarrera");

        jLbTemaTesis.setText("jLbTemaTesis");

        jBtCartaCompromiso.setText("Carta compromiso");
        jBtCartaCompromiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCartaCompromisoActionPerformed(evt);
            }
        });

        jBtCartaMotivos.setText("Carta exposición de motivos");
        jBtCartaMotivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCartaMotivosActionPerformed(evt);
            }
        });

        jBtAceptar.setText("Aceptar");
        jBtAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAceptarActionPerformed(evt);
            }
        });

        jBtEnEspera.setText("En espera");
        jBtEnEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnEsperaActionPerformed(evt);
            }
        });

        jLabelAsesor.setText("Asesor");

        jLbAsesor.setText("jLbAsesor");

        jLabelDirTesis.setText("Director Tesis");

        jLbDirTesis.setText("jLbAsesor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabelAsesor)
                            .addComponent(jLabelDirTesis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbApellidos)
                            .addComponent(jLbNombre)
                            .addComponent(jLbCarrera)
                            .addComponent(jLbCreditos)
                            .addComponent(jLbTemaTesis)
                            .addComponent(jLbAsesor)
                            .addComponent(jLbDirTesis))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtEnEspera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtCartaCompromiso, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtCartaMotivos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtEnEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLbNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLbApellidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLbCreditos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLbCarrera))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLbTemaTesis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAsesor)
                            .addComponent(jLbAsesor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDirTesis)
                            .addComponent(jLbDirTesis))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtCartaCompromiso)
                    .addComponent(jBtCartaMotivos))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAceptarActionPerformed
        // Se obtiene el último grupo registrado.
        GrupoDBHelper helperGrupo = new GrupoDBHelper();
        Grupo grupo = helperGrupo.getUltimoGrupo();

        final int limiteDeCandidatos = 25;

        /*
        * Si el número limite de candidatos en un grupo es menor se registra
        * el acnadidato en el grupo.
        */
        if (helperGrupo.getNumCandidatos(grupo) < limiteDeCandidatos) {
            registrarCandidato(grupo, asesor, candidato);
            return;
        }

        /*
        * De lo contrario se crea un nuevo grupo y se registra el candidato
        * en este nuevo grupo.
        */
        int id = grupo.getId();
        id++;
        grupo = new Grupo(String.valueOf(id));

        // Se asigna id manualmente para evitar otra consulta.
        grupo.setId(id);
        helperGrupo.registrar(grupo);
        registrarCandidato(grupo, asesor, candidato);
    }//GEN-LAST:event_jBtAceptarActionPerformed

    private void jBtCartaMotivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCartaMotivosActionPerformed
        CandidatoDBHelper helper = new CandidatoDBHelper();

        /*
        * Abre una venta de Adobe Acrobat Reader DC con
        * la carta exposición de motivos del candidato.
        * Esta carta se encuentra en la base de datos.
        */
        try {
            Desktop.getDesktop().open(helper.getCartaMotivos(candidato));
        } catch (IOException ex) {
            System.out.println("Interfaz.CandidatoIG"
                            + ".jBtCartaMotivosActionPerformed() " + ex);
        }
    }//GEN-LAST:event_jBtCartaMotivosActionPerformed

    private void jBtCartaCompromisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCartaCompromisoActionPerformed
        CandidatoDBHelper helper = new CandidatoDBHelper();

        /*
        * Abre una venta de Adobe Acrobat Reader DC con
        * la carta compromiso del candidato.
        * Esta carta se encuentra en la base de datos.
        */
        try {
            Desktop.getDesktop().open(helper.getCartaCompromiso(candidato));
        } catch (IOException ex) {
            System.out.println("Interfaz.CandidatoIG"
                            + ".jBtCartaMotivosActionPerformed() " + ex);
        }
    }//GEN-LAST:event_jBtCartaCompromisoActionPerformed

    private void jBtEnEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnEsperaActionPerformed
        /*
        * Se abre una ventana emergente para que el asesor aclare
        * por que pone en espera al candidato.
        */
        String respuesta = JOptionPane.showInputDialog(this,
                                "Describa el por que", "Aclaración",
                                JOptionPane.QUESTION_MESSAGE);

        if (respuesta != null && !respuesta.isEmpty()) {
            jBtEnEspera.setEnabled(false);
            jBtCartaCompromiso.setEnabled(false);
            jBtCartaMotivos.setEnabled(false);
            jBtAceptar.setVisible(false);
        }
    }//GEN-LAST:event_jBtEnEsperaActionPerformed

    /**
    * Le asigna grupo y asesor a un candidato.
    *
    * @param    grupo       en el que se asignara el candidato.
    * @param    asesorX      el que se asignara al candidato.
    * @param    candidatoX   al que se le resgistrara en un grupo y un asesor.
    * @return               un boolena, true si se asigna corectamene
    *                       el grupo y asesor al candidato,
    *                       false si ocurre un error.
    */
    public final boolean registrarCandidato(final Grupo grupo,
                            final Asesor asesorX, final Candidato candidatoX) {
        boolean resultado = false;

        // Se evita errores de mal uso de la función.
        if (asesorX == null || candidatoX == null || grupo == null) {
            return resultado;
        }

        CandidatoDBHelper helperCandidato = new CandidatoDBHelper();

        /*
        * Si se asigno correctamente un asesor al candidato
        * se muestra mensaje y se asegura que no se pueda asignar a otro.
        */
        if (helperCandidato.setGrupoYAsesor(asesorX, grupo, candidatoX)) {
            JOptionPane.showMessageDialog(this,
                    "El candidato se registro en el Grupo " + grupo.getNombre(),
                    "Candidato aceptado", JOptionPane.INFORMATION_MESSAGE);
            jBtAceptar.setEnabled(false);
            jBtAceptar.setText("Aceptado");
            jBtEnEspera.setVisible(false);
            resultado = true;
            return resultado;
        }

        JOptionPane.showMessageDialog(this,
                "No se pudo asignar un grupo al candidato",
                "Error en el sistema", JOptionPane.ERROR_MESSAGE);
        return resultado;
    }

    /**
    * Obtiene al candidato.
    *
    * @return   un Candidato, el candidato que esta viendo la ventana.
    */
    public final Candidato getCandidato() {
        return candidato;
    }

    /**
    * Asigna un candidato a la ventana.
    *
    * @param   candidatoX  es quien abrira la ventana.
    */
    public final void setCandidato(final Candidato candidatoX) {
        this.candidato = candidatoX;
        vistaAsesor(true);
    }

    /**
    * Obtiene al asesor.
    *
    * @return   un Asesor, el asesor que esta viendo la ventana.
    */
    public final Asesor getAsesor() {
        return asesor;
    }

    /**
    * Asigna un asesor a la ventana.
    *
    * @param   asesorX  es quien abrira la ventana.
    */
    public final void setAsesor(final Asesor asesorX) {
        this.asesor = asesorX;
        mostrarAsesor();
    }

    /**
    * Mostrar la información del candidato en el panel.
    *
    * @param    visbles  establecera la visibilidad de JLabel dedicadas
    *                   para un asesor.
    */
    public final void vistaAsesor(final boolean visbles) {
        // Se pone escala la foto del candidato.
        final int ancho = 100;
        final int alto = 100;
        Image imagen = candidato.getFoto().getImage();
        imagen = imagen.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
        Icon icono = new ImageIcon(imagen);
        jLbFoto.setIcon(icono);
        jLbNombre.setText(candidato.getNombre());

        // Se muestra las iniciales de los apellidos.
        String apellidos = candidato.getApellidoPaterno().charAt(0) + " "
                        + candidato.getApellidoMaterno().charAt(0);
        jLbApellidos.setText(apellidos);

        jLbCreditos.setText(candidato.getCreditos() + " %");
        jLbCarrera.setText(candidato.getCarrera());
        jLbTemaTesis.setText(candidato.getTemaTesis());
        jLbDirTesis.setText(candidato.getDirectorTesis());

        // Se asigna la visibilidad dependiendo en que ventana se mostraria.
        jBtAceptar.setVisible(visbles);
        jBtEnEspera.setVisible(visbles);
        jBtCartaCompromiso.setVisible(visbles);
        jBtCartaMotivos.setVisible(visbles);
        jLabelAsesor.setVisible(!visbles);
        jLbAsesor.setVisible(!visbles);
        jLabelDirTesis.setVisible(!visbles);
        jLbDirTesis.setVisible(!visbles);
    }

    /**
    * Mostrar la información del asesor en el panel.
    */
    public final void mostrarAsesor() {
        jLbAsesor.setText(asesor.getNombre() + " "
                        + asesor.getApellidoPaterno());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAceptar;
    private javax.swing.JButton jBtCartaCompromiso;
    private javax.swing.JButton jBtCartaMotivos;
    private javax.swing.JButton jBtEnEspera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAsesor;
    private javax.swing.JLabel jLabelDirTesis;
    private javax.swing.JLabel jLbApellidos;
    private javax.swing.JLabel jLbAsesor;
    private javax.swing.JLabel jLbCarrera;
    private javax.swing.JLabel jLbCreditos;
    private javax.swing.JLabel jLbDirTesis;
    private javax.swing.JLabel jLbFoto;
    private javax.swing.JLabel jLbNombre;
    private javax.swing.JLabel jLbTemaTesis;
    // End of variables declaration//GEN-END:variables
}
