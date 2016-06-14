/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lissette
 */


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Thread.sleep;
import vista.FRM_Mensaje;
import vista.FRM_VentanaJuego;
import vista.FRM_VentanaPrincipal;

public class Hilo extends Thread {
  FRM_VentanaJuego  ventana;  
  FRM_Mensaje mensaje;
  
  int tiempo = 0;
  
    public Hilo(FRM_VentanaJuego ventana)
    {
        this.ventana=ventana;
        mensaje=new FRM_Mensaje();
        
    }
    public void run()
    {
        while(true)
       {
           try
           {
               //1000 es un segundo
             sleep(100);//tiempo en el que mando a dormir el hilo
             ventana.moverConejos();
             ventana.setCronometro();

           }
           catch(Exception e)
           {
               System.out.println("Hubo un error en el hilo de ejecución"+e);
           }
       }
    }
 
 
}
