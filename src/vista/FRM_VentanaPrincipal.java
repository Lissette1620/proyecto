/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Hilo;
import modelo.Metodos_XML_Usuarios;
import modelo.Usuario;

/**
 *
 * @author Lissette
 */
public class FRM_VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FRM_VentanaPrincipal
     */
    FRM_VentanaJuego ventana;
    FRM_Usuario usuario;
    Metodos_XML_Usuarios xml;
    Icon iconoBlanco;
    public FRM_VentanaPrincipal() {
        initComponents();
        ventana=new FRM_VentanaJuego();
        usuario=new FRM_Usuario(); 
        xml=new Metodos_XML_Usuarios(usuario);
       iconoBlanco=new ImageIcon(getClass().getResource("../img/conejito10.png"));
   
    }
     public void limpiar()
     {
         this.jt_Usuario.setText("");
         this.jt_Contrasena.setText("");
     }
     public void iniciarSesion()
     {
         String id=""+this.jt_Usuario.getText();
         String contrasena=""+this.jt_Contrasena.getText();
        if(xml.consultarInformacionDelXml(id) && xml.consultarInformacionDelXmlC(contrasena))
        {
           
            ventana.setVisible(true);
            JOptionPane.showMessageDialog(null,"El objetivo de este juego"
                  + " consiste en matar al conejito de la galleta,"
                  + "al jugador se le daran 5 tiros. "
                  + "De no conseguirse el objetivo la partida estará perdida ","Juego",JOptionPane.PLAIN_MESSAGE,iconoBlanco);
            //ventana.audio.play();
          
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No se ha agregado un ID procesa a Ingresar");
            
        }
         
     }
    
  
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Jugar = new javax.swing.JButton();
        jl_Titulo = new javax.swing.JLabel();
        jl_Usuario = new javax.swing.JLabel();
        jt_Usuario = new javax.swing.JTextField();
        jl_Contrasena = new javax.swing.JLabel();
        jt_Contrasena = new javax.swing.JPasswordField();
        jl_Fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setTitle("LISSETTE GAME");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Jugar.setFont(new java.awt.Font("URW Chancery L", 1, 36)); // NOI18N
        btn_Jugar.setForeground(java.awt.Color.black);
        btn_Jugar.setText("Inicio");
        btn_Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_JugarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, 140, 40));

        jl_Titulo.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        jl_Titulo.setForeground(new java.awt.Color(124, 219, 35));
        jl_Titulo.setText(" Rabbit Slaughter");
        getContentPane().add(jl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 280, 70));

        jl_Usuario.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        jl_Usuario.setForeground(new java.awt.Color(135, 8, 28));
        jl_Usuario.setText("ID:");
        getContentPane().add(jl_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 130, -1));
        getContentPane().add(jt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 170, -1));

        jl_Contrasena.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        jl_Contrasena.setForeground(new java.awt.Color(136, 23, 32));
        jl_Contrasena.setText("Password:");
        getContentPane().add(jl_Contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 190, 30));
        getContentPane().add(jt_Contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 190, -1));

        jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejoZombie.jpg"))); // NOI18N
        getContentPane().add(jl_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 640));

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Usuario");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Registrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_JugarActionPerformed
       if(evt.getActionCommand().equals("Inicio")) 
       {
          iniciarSesion();
          limpiar();
         
       }
        
    }//GEN-LAST:event_btn_JugarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        usuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Jugar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel jl_Contrasena;
    private javax.swing.JLabel jl_Fondo;
    private javax.swing.JLabel jl_Titulo;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JPasswordField jt_Contrasena;
    private javax.swing.JTextField jt_Usuario;
    // End of variables declaration//GEN-END:variables
}