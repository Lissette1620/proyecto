/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import vista.FRM_VentanaJuego;

/**
 *
 * @author lissette
 */


public class Cronometro {
    int segundo;
    int minuto;
   public void run()
    {
       while(true)
       {
           try
           {
               //1000 es un segundo
             sleep(100);//tiempo en el que mando a dormir el hilo
             cronometro();
           }
           catch(Exception e)
           {
               System.out.println("Hubo un error en el hilo de ejecución"+e);
           }
       }
    }//esto ya es un hilo
   public void cronometro(){
     for(minuto=0; minuto<=60; minuto++){
      for(segundo=0; segundo<=60; segundo++){
          try{
             getTime();
             sleep(1000);}catch(Exception e){System.out.println("Error: "+e);
            }
          }
        }
    }
   public String getTime()
   {
      return ""+ minuto +":"+ segundo;
   }
}
    

   