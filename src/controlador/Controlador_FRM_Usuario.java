/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Metodos_XML_Usuarios;
import modelo.Usuario;
import vista.FRM_Usuario;
import vista.FRM_VentanaPrincipal;

/**
 *
 * @author lissette
 */
public class Controlador_FRM_Usuario implements ActionListener {
    FRM_Usuario ventana;
    Metodos_XML_Usuarios metodos;
    boolean creado=false;
    public Controlador_FRM_Usuario( FRM_Usuario ventana) 
    {
        this.ventana = ventana;
        metodos = new Metodos_XML_Usuarios(ventana);
        
    }
  public void actionPerformed(ActionEvent e)
 {
        if (e.getActionCommand().equalsIgnoreCase("Aceptar")) 
        {
            if(ventana.confirmarContrasenna())
            {   
                metodos.guardarEnXML(ventana.devolverInformacion());
                metodos.registrarLogin(ventana.devolverInformacionDeInicioDeSesion());
                JOptionPane.showMessageDialog(ventana, "Usuario agregado");
                ventana.inicializarGUI();
            }
            else
            {
                JOptionPane.showMessageDialog(ventana, "Contraseñas no coinciden");
            }
        }
        
   }

    public boolean iniciarSesion(String arreglo[])
    {
       return metodos.iniciarSesion(arreglo);
    }   
}
