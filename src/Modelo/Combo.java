/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author home
 */
public class Combo {
    
    private int IdCliente;
    private String Nombre;

    public Combo(int IdCliente, String Nombre) {
        this.IdCliente = IdCliente;
        this.Nombre = Nombre;
    }


    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    @Override
    public String toString(){
  return this.getNombre();
    
}
    }

