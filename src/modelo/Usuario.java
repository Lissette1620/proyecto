/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author lissette
 */
public class Usuario {
    private String nombre;
    private String contrasena;
    private int cronometro;

    public Usuario(String nombre, String contrasena,int cronometro) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.cronometro=cronometro;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setCronometro(int cronometro)
    {
        this.cronometro=cronometro;
    }
    public int getCronometro()
    {
        return cronometro;
    }
    
    
}
