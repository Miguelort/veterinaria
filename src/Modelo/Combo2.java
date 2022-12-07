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
public class Combo2 {
     
    private int IdProveedor;
    private String Nombre;

    public Combo2(int IdProveedor, String Nombre) {
        this.IdProveedor = IdProveedor;
        this.Nombre = Nombre;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
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



