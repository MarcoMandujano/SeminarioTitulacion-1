/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BaseDatos.CandidatoDBHelper;
import Clases.Asesor;
import Clases.Candidato;
import javax.swing.JOptionPane;

/**
 *
 * @author vos
 */
public class CandidatoIG extends javax.swing.JPanel {
    Candidato candidato;
    Asesor asesor;
    
    /**
     * Creates new form Candidato
     */
    public CandidatoIG() {
        initComponents();
//        Inicio();
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
        jLbApPaterno = new javax.swing.JLabel();
        jLbApMaterno = new javax.swing.JLabel();
        jLbCarrera = new javax.swing.JLabel();
        jLbTemaTesis = new javax.swing.JLabel();
        jBtCartaCompromiso = new javax.swing.JButton();
        jBtCartaMotivos = new javax.swing.JButton();
        jBtAceptar = new javax.swing.JButton();
        jBtEnEspera = new javax.swing.JButton();

        jLbFoto.setText("jLbFoto");

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido Paterno");

        jLabel3.setText("Apellido Materno");

        jLabel4.setText("Carrera");

        jLabel5.setText("Tema de Tesis");

        jLbNombre.setText("jLbNombre");

        jLbApPaterno.setText("jLbApPaterno");

        jLbApMaterno.setText("jLbApMaterno");

        jLbCarrera.setText("jLbCarrera");

        jLbTemaTesis.setText("jLbTemaTesis");

        jBtCartaCompromiso.setText("Carta compromiso");

        jBtCartaMotivos.setText("Carta exposición de motivos");

        jBtAceptar.setText("Aceptar");
        jBtAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAceptarActionPerformed(evt);
            }
        });

        jBtEnEspera.setText("En espera");

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
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbApPaterno)
                            .addComponent(jLbNombre)
                            .addComponent(jLbCarrera)
                            .addComponent(jLbApMaterno)
                            .addComponent(jLbTemaTesis))
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
                            .addComponent(jLbApPaterno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLbApMaterno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLbCarrera))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLbTemaTesis))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtCartaCompromiso)
                    .addComponent(jBtCartaMotivos))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAceptarActionPerformed
        CandidatoDBHelper helperCandidato = new CandidatoDBHelper();
        
        //Si se asigno correctamente un asesor al candidato.
        if(helperCandidato.setAsesor(asesor, candidato)){
            JOptionPane.showMessageDialog(this, "El candidato se registro en el grupo: ", "Candidato aceptado", JOptionPane.INFORMATION_MESSAGE);            
            jBtAceptar.setEnabled(false);
            jBtEnEspera.setEnabled(false);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "No se pudo asignar un grupo al candidato", "Error en el sistema", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jBtAceptarActionPerformed
    
//    /*
//    * Funcion que pone los valores por defecto
//    */
//    public void Inicio(){
//        
//        
//        
//    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
        MostrarCandidato();
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }
    
    /*
    * Mostrar la información del candidato en el panel
    */
    public void MostrarCandidato(){
        jLbFoto.setIcon(candidato.getFoto());
        jLbNombre.setText(candidato.getNombre());
        jLbApPaterno.setText(candidato.getApellidoPaterno());
        jLbApMaterno.setText(candidato.getApellidoMaterno());
        jLbCarrera.setText(candidato.getCarrera());
        jLbTemaTesis.setText(candidato.getTemaTesis());
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
    private javax.swing.JLabel jLbApMaterno;
    private javax.swing.JLabel jLbApPaterno;
    private javax.swing.JLabel jLbCarrera;
    private javax.swing.JLabel jLbFoto;
    private javax.swing.JLabel jLbNombre;
    private javax.swing.JLabel jLbTemaTesis;
    // End of variables declaration//GEN-END:variables
}