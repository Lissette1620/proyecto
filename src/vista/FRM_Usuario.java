/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.Controlador_FRM_Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author lissette
 */
public class FRM_Usuario extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Usuario
     */
    Controlador_FRM_Usuario controlador;
    public FRM_Usuario() {
        initComponents();
        controlador=new Controlador_FRM_Usuario(this);
        agregarEventos(controlador);
        
    }
    public String devolverNombre()
    {
        return this.jt_ID.getText();
    }
     public String[] devolverInformacionDeInicioDeSesion()
    {
        String arreglo[] = new String[2];
        arreglo[0]= this.jt_ID.getText();
        arreglo[1]= this.contrasena1.getText();
        return arreglo;
    }
     public void agregarEventos(Controlador_FRM_Usuario controlador)
    {
        this.btn_Aceptar.addActionListener(controlador);
        
    }
     public void mostrarMensaje(String mensaje)
    {
        System.out.println(mensaje);
    }
       public boolean confirmarContrasenna()
    {
        boolean confirmar = false;
        //verifico que los campos de los usuarios sean iguales y sino que me devuelva false
        if(contrasena1.getText().equals(contrasena2.getText()))
        confirmar=true;
      
        return confirmar;
    }
    public String[] devolverInformacion()
    {
        String arreglo[] = new String[2];
        arreglo[0]= this.jt_ID.getText();
        arreglo[1]= this.contrasena1.getText();
        
        return arreglo;
    }
     public void inicializarGUI()
    {
        //this.jt_ID.setEnabled(false);
        this.jt_ID.setText("");
        
        //this.contrasena1.setEnabled(false);
        this.contrasena1.setText("");
        
        //this.contrasena2.setEnabled(false);
        this.contrasena2.setText("");
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_ID = new javax.swing.JLabel();
        jl_Password1 = new javax.swing.JLabel();
        jl_Password2 = new javax.swing.JLabel();
        jt_ID = new javax.swing.JTextField();
        contrasena1 = new javax.swing.JPasswordField();
        contrasena2 = new javax.swing.JPasswordField();
        btn_Aceptar = new javax.swing.JButton();

        jl_ID.setText("ID:");

        jl_Password1.setText("Contraseña:");

        jl_Password2.setText("Repetir Contraseña:");

        jt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_IDActionPerformed(evt);
            }
        });

        contrasena2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasena2ActionPerformed(evt);
            }
        });

        btn_Aceptar.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_Password2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contrasena2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_Password1)
                        .addGap(18, 18, 18)
                        .addComponent(contrasena1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Aceptar)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Password1)
                    .addComponent(contrasena1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Password2)
                    .addComponent(contrasena2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btn_Aceptar)
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void contrasena2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasena2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasena2ActionPerformed

    private void jt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_IDActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JPasswordField contrasena1;
    private javax.swing.JPasswordField contrasena2;
    private javax.swing.JLabel jl_ID;
    private javax.swing.JLabel jl_Password1;
    private javax.swing.JLabel jl_Password2;
    private javax.swing.JTextField jt_ID;
    // End of variables declaration//GEN-END:variables
}
