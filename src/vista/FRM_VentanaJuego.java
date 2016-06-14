/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import static com.sun.management.jmx.Trace.isSelected;
import java.applet.AudioClip;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.Hilo;

/**
 *
 * @author lissette
 */
public class FRM_VentanaJuego extends javax.swing.JFrame {

    /**
     * Creates new form FRM_VentanaJuego
     */
    AudioClip audio,sonidoDisparo;
    Hilo hilo;
    public String estado="Izquierda";
    int contador=0;
    Icon iconoUno, iconoDos,iconoTres,iconoCuatro;
    int balasDisponibles=5;
    ArrayList arrayBala;
    FRM_GameOver frm_GameOver;
    FRM_Mensaje mensaje;
    FRM_Winner frm_Winner;
    JLabel label[];
    int cronometro=0;
    int segundo=0;
    public String modo;
    Image im = Toolkit.getDefaultToolkit().createImage("src/img/mira2.png"); 
    Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(20,20),"WILL");   
    String direccion;
    
    
    public FRM_VentanaJuego() {
        initComponents();
        audio=java.applet.Applet.newAudioClip(getClass().getResource("../musica/Musica_para_circo.wav"));
        sonidoDisparo=java.applet.Applet.newAudioClip(getClass().getResource("../musica/disparo.wav"));
        label =new JLabel[]{jl_Conejo1,jl_Conejo2,jl_Conejo3,jl_Conejo5,jl_ConejoBlanco,jl_ConejoA,jl_ConejoB,jl_ConejoC,jl_ConejoD,jl_ConejoBlanco2};
        iconoUno=new ImageIcon(getClass().getResource("../img/conejo_08.png"));
        iconoDos=new ImageIcon(getClass().getResource("../img/conejo_09.png"));
        iconoTres=new ImageIcon(getClass().getResource("../img/conejo_05.png"));
        iconoCuatro=new ImageIcon(getClass().getResource("../img/conejo_07.png"));
        frm_GameOver=new FRM_GameOver();
        frm_Winner =new FRM_Winner();
        mensaje=new FRM_Mensaje();
        direccion="Derecha";
        modo="Comienzo";
        setCursor(cur); 
        hilo=new Hilo(this);
        hilo.start();
    }
    public void moverConejos()
    {
        if(direccion.equals("Derecha")){
            if(jl_ConejoBlanco.getX()<=1200 && jl_ConejoD.getX()<=1200){
                moverDerecha();
                moverDerechaAbajo();
            }else{
                direccion="Izquierda";
            }
        }//fin de mover derecha
        
        if(direccion.equals("Izquierda")){
             if(jl_Conejo1.getX()>=20 && jl_ConejoA.getX()>=20){
                moverIzquierda();
                moverIzquierdaAbajo();
            }else{
                 direccion="Derecha";
             }
        }//fin de mover izquierda
    }
    
    private void moverIzquierda(){
        this.jl_Conejo1.setLocation(jl_Conejo1.getX()-50, jl_Conejo1.getY());
           this.jl_Conejo2.setLocation(jl_Conejo2.getX()-50, jl_Conejo2.getY());
           this.jl_Conejo3.setLocation(jl_Conejo3.getX()-50, jl_Conejo3.getY());
           this.jl_Conejo5.setLocation(jl_Conejo5.getX()-50, jl_Conejo5.getY());
           this.jl_ConejoBlanco.setLocation(jl_ConejoBlanco.getX()-50, jl_ConejoBlanco.getY());
           
    }
    
    private void moverDerecha(){
        this.jl_Conejo1.setLocation(jl_Conejo1.getX()+50, jl_Conejo1.getY());
          this.jl_Conejo2.setLocation(jl_Conejo2.getX()+50, jl_Conejo2.getY());
          this.jl_Conejo3.setLocation(jl_Conejo3.getX()+50, jl_Conejo3.getY());
          this.jl_Conejo5.setLocation(jl_Conejo5.getX()+50, jl_Conejo5.getY());
          this.jl_ConejoBlanco.setLocation(jl_ConejoBlanco.getX()+50, jl_ConejoBlanco.getY()); 
    }
    private void moverIzquierdaAbajo()
    {
       this.jl_ConejoA.setLocation(jl_ConejoA.getX()-50, jl_ConejoA.getY());
           this.jl_ConejoB.setLocation(jl_ConejoB.getX()-50, jl_ConejoB.getY());
           this.jl_ConejoBlanco2.setLocation(jl_ConejoBlanco2.getX()-50, jl_ConejoBlanco2.getY());
           this.jl_ConejoC.setLocation(jl_ConejoC.getX()-50, jl_ConejoC.getY());
           
           this.jl_ConejoD.setLocation(jl_ConejoD.getX()-50, jl_ConejoD.getY()); 
    }
    private void moverDerechaAbajo()
    {
       this.jl_ConejoA.setLocation(jl_ConejoA.getX()+50, jl_ConejoA.getY());
          this.jl_ConejoB.setLocation(jl_ConejoB.getX()+50, jl_ConejoB.getY());
          this.jl_ConejoBlanco2.setLocation(jl_ConejoBlanco2.getX()+50, jl_ConejoBlanco2.getY());
          this.jl_ConejoC.setLocation(jl_ConejoC.getX()+50, jl_ConejoC.getY());  
          this.jl_ConejoD.setLocation(jl_ConejoD.getX()+50, jl_ConejoD.getY());  
    }
    public void mouseClicked(MouseEvent mouseEvent)
    {
       
    }
    public int balasFallidas()
    {
        balasOcultar(balasDisponibles);
        return balasDisponibles-=1;
        
    }
    public void gameOver()
    {
        if(balasDisponibles<=0)
        {
            frm_GameOver.setVisible(true);
           
            
        }
    }
    public void winner()
    {
        
        frm_Winner.setVisible(true);
        
        
    }
    public void balasOcultar(int balaDisp)
    {
        switch(balaDisp){
            case 1:
               jl_Bala1.setVisible(false);
             break; 
              
            case 2: 
               jl_Bala2.setVisible(false);
             break;
                
            case 3:
               jl_Bala3.setVisible(false);
             break;
                
            case 4: 
               jl_Bala4.setVisible(false);
             break;
                
            case 5:
               jl_Bala5.setVisible(false);
             break;
                
        }
       
    }
    public void setCronometro(){
      if(cron()) {
         segundo+=1;
      if(segundo%8==0){
      cronometro+=1;
      this.a.setText(""+cronometro);
      a.setEnabled(false); 
      }
      
        
        
    }
  }
    public boolean cron(){
        boolean t = false;
        if(!mensaje.isVisible()){
            t = true;
        }
        return t;
    }
    


    public void impactoBala(boolean impactado)
    {
        
        if(impactado)
        {
            impactado=true;
            winner();
            modo="Repetir";
                
        }
        else
        {
            impactado=false;
            balasFallidas();
            gameOver();
            modo="Repetir";
       
            
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

        jl_Conejo1 = new javax.swing.JLabel();
        jl_Conejo2 = new javax.swing.JLabel();
        jl_Conejo3 = new javax.swing.JLabel();
        jl_ConejoBlanco = new javax.swing.JLabel();
        jl_Conejo5 = new javax.swing.JLabel();
        jl_ConejoB = new javax.swing.JLabel();
        jl_ConejoBlanco2 = new javax.swing.JLabel();
        jl_ConejoA = new javax.swing.JLabel();
        jl_ConejoD = new javax.swing.JLabel();
        jl_ConejoC = new javax.swing.JLabel();
        jl_Balas = new javax.swing.JLabel();
        jl_Bala1 = new javax.swing.JLabel();
        jl_Bala2 = new javax.swing.JLabel();
        jl_Bala3 = new javax.swing.JLabel();
        jl_Bala4 = new javax.swing.JLabel();
        jl_Bala5 = new javax.swing.JLabel();
        jl_Time = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        jl_FondoFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_Conejo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_0.png"))); // NOI18N
        jl_Conejo1.setPreferredSize(new java.awt.Dimension(110, 150));
        jl_Conejo1.setRequestFocusEnabled(false);
        jl_Conejo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_Conejo1MousePressed(evt);
            }
        });
        getContentPane().add(jl_Conejo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 140, 150));

        jl_Conejo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_02.png"))); // NOI18N
        jl_Conejo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_Conejo2MousePressed(evt);
            }
        });
        getContentPane().add(jl_Conejo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 130, 140));

        jl_Conejo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_1.png"))); // NOI18N
        jl_Conejo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_Conejo3MousePressed(evt);
            }
        });
        getContentPane().add(jl_Conejo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 110, 130));

        jl_ConejoBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_Blanco.png"))); // NOI18N
        jl_ConejoBlanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_ConejoBlancoMousePressed(evt);
            }
        });
        getContentPane().add(jl_ConejoBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 140, 160));

        jl_Conejo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_04.png"))); // NOI18N
        jl_Conejo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_Conejo5MousePressed(evt);
            }
        });
        getContentPane().add(jl_Conejo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 170, 140));

        jl_ConejoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_0.png"))); // NOI18N
        jl_ConejoB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_ConejoBMousePressed(evt);
            }
        });
        getContentPane().add(jl_ConejoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 120, 140));

        jl_ConejoBlanco2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_Blanco.png"))); // NOI18N
        jl_ConejoBlanco2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_ConejoBlanco2MousePressed(evt);
            }
        });
        getContentPane().add(jl_ConejoBlanco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 140, 150));

        jl_ConejoA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_1.png"))); // NOI18N
        jl_ConejoA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_ConejoAMousePressed(evt);
            }
        });
        getContentPane().add(jl_ConejoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 120, 140));

        jl_ConejoD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_04.png"))); // NOI18N
        jl_ConejoD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_ConejoDMousePressed(evt);
            }
        });
        getContentPane().add(jl_ConejoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, 160, -1));

        jl_ConejoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conejo_3.png"))); // NOI18N
        jl_ConejoC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_ConejoCMousePressed(evt);
            }
        });
        getContentPane().add(jl_ConejoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 460, -1, -1));

        jl_Balas.setBackground(new java.awt.Color(147, 255, 0));
        jl_Balas.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jl_Balas.setForeground(new java.awt.Color(22, 101, 81));
        jl_Balas.setText("Cantidad Balas");
        getContentPane().add(jl_Balas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 30));

        jl_Bala1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bala.gif"))); // NOI18N
        getContentPane().add(jl_Bala1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 30, 40));

        jl_Bala2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bala.gif"))); // NOI18N
        getContentPane().add(jl_Bala2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 30, 40));

        jl_Bala3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bala.gif"))); // NOI18N
        getContentPane().add(jl_Bala3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 30, 40));

        jl_Bala4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bala.gif"))); // NOI18N
        getContentPane().add(jl_Bala4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 30, 40));

        jl_Bala5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bala.gif"))); // NOI18N
        getContentPane().add(jl_Bala5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 30, 40));

        jl_Time.setFont(new java.awt.Font("Arial Black", 2, 24)); // NOI18N
        jl_Time.setForeground(new java.awt.Color(232, 19, 19));
        jl_Time.setText("Time");
        getContentPane().add(jl_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 80, -1));

        a.setBackground(new java.awt.Color(87, 179, 16));
        a.setFont(new java.awt.Font("FreeSans", 2, 18)); // NOI18N
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 50, -1));

        jl_FondoFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoFinal.png"))); // NOI18N
        jl_FondoFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl_FondoFinalMousePressed(evt);
            }
        });
        getContentPane().add(jl_FondoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 1560, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jl_FondoFinalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_FondoFinalMousePressed
        // TODO add your handling code here:
        impactoBala(false);
        sonidoDisparo.play();
    }//GEN-LAST:event_jl_FondoFinalMousePressed

    private void jl_ConejoBlancoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_ConejoBlancoMousePressed
          impactoBala(true);
          jl_ConejoBlanco.setIcon(iconoUno);
          sonidoDisparo.play();
           
    }//GEN-LAST:event_jl_ConejoBlancoMousePressed

    private void jl_ConejoBlanco2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_ConejoBlanco2MousePressed
           impactoBala(true);
           jl_ConejoBlanco2.setIcon(iconoUno);
           sonidoDisparo.play();
       
    }//GEN-LAST:event_jl_ConejoBlanco2MousePressed

    private void jl_Conejo5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_Conejo5MousePressed
        impactoBala(false);
        jl_Conejo5.setIcon(iconoDos);
        sonidoDisparo.play();
        
        
    }//GEN-LAST:event_jl_Conejo5MousePressed

    private void jl_ConejoDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_ConejoDMousePressed
        impactoBala(false);
        jl_ConejoD.setIcon(iconoDos);
        sonidoDisparo.play();
    }//GEN-LAST:event_jl_ConejoDMousePressed

    private void jl_Conejo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_Conejo1MousePressed
        impactoBala(false);
        jl_Conejo1.setIcon(iconoTres);
        sonidoDisparo.play();
    }//GEN-LAST:event_jl_Conejo1MousePressed

    private void jl_ConejoBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_ConejoBMousePressed
        impactoBala(false);
        jl_ConejoB.setIcon(iconoTres);
        sonidoDisparo.play();
    }//GEN-LAST:event_jl_ConejoBMousePressed

    private void jl_Conejo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_Conejo2MousePressed
        impactoBala(false);
        jl_Conejo2.setIcon(iconoCuatro);
        sonidoDisparo.play();
    }//GEN-LAST:event_jl_Conejo2MousePressed

    private void jl_ConejoCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_ConejoCMousePressed
         impactoBala(false);
         jl_ConejoC.setIcon(iconoCuatro);
         sonidoDisparo.play();
    }//GEN-LAST:event_jl_ConejoCMousePressed

    private void jl_Conejo3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_Conejo3MousePressed
        // TODO add your handling code here:
        impactoBala(false);
        sonidoDisparo.play();
    }//GEN-LAST:event_jl_Conejo3MousePressed

    private void jl_ConejoAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_ConejoAMousePressed
        // TODO add your handling code here:
        impactoBala(false);
        sonidoDisparo.play();
    }//GEN-LAST:event_jl_ConejoAMousePressed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JLabel jl_Bala1;
    private javax.swing.JLabel jl_Bala2;
    private javax.swing.JLabel jl_Bala3;
    private javax.swing.JLabel jl_Bala4;
    private javax.swing.JLabel jl_Bala5;
    private javax.swing.JLabel jl_Balas;
    private javax.swing.JLabel jl_Conejo1;
    private javax.swing.JLabel jl_Conejo2;
    private javax.swing.JLabel jl_Conejo3;
    private javax.swing.JLabel jl_Conejo5;
    private javax.swing.JLabel jl_ConejoA;
    private javax.swing.JLabel jl_ConejoB;
    private javax.swing.JLabel jl_ConejoBlanco;
    private javax.swing.JLabel jl_ConejoBlanco2;
    private javax.swing.JLabel jl_ConejoC;
    private javax.swing.JLabel jl_ConejoD;
    private javax.swing.JLabel jl_FondoFinal;
    private javax.swing.JLabel jl_Time;
    // End of variables declaration//GEN-END:variables

    public void dispararConejos(MouseEvent mouse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
