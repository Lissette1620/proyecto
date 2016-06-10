/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import vista.FRM_VentanaJuego;

/**
 *
 * @author lissette
 */
public class Cronometro {
    int miliseundo;
    int segundos;
    int minutos;
    int hora;
    Thread cronometro;
    JLabel jlbCronometro;
    int alarma;
    FRM_VentanaJuego ventana;

    public Cronometro(JLabel jlb) {
        miliseundo = 0;
        segundos = 0;
        minutos = 0;
        hora = 0;
        ventana=new FRM_VentanaJuego();
        jlbCronometro = jlb;
        cronometro = new Thread();
        cronometro.start();
    }

    public void run() {
        while (true) {
            try {
                miliseundo++;
                //jlbCronometro.setText(""+hr+":"+mi+":"+s+":");
                if (miliseundo == 100) {
                    miliseundo = 0;
                    segundos++;
                    cronometro.sleep(1000);
                    alarma++;
                    ventana.a.setValue(segundos);
                }
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                }
                if (minutos == 60) {
                    hora++;
                    minutos = 0;
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public int getMiliseundo() {
        return miliseundo;
    }

    public int getSegundos() {
        return segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getHora() {
        return hora;
    }

    public Thread getCronometro() {
        return cronometro;
    }

    public JLabel getJlbCronometro() {
        return jlbCronometro;
    }

    public int getAlarma() {
        return alarma;
    }

    public void setMiliseundo(int miliseundo) {
        this.miliseundo = miliseundo;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setCronometro(Thread cronometro) {
        this.cronometro = cronometro;
    }

    public void setJlbCronometro(JLabel jlbCronometro) {
        this.jlbCronometro = jlbCronometro;
    }

    public void setAlarma(int activa) {
        this.alarma = activa;
    }

    public void stopCronometro() {
        cronometro.stop();
    }

    public void suspender() {
        cronometro.suspend();
    }

    public void resumen() {
        cronometro.resume();
    }

    public void detenerHilo() {
        cronometro.stop();
    }

}
