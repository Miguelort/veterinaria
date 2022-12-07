/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Productos {
    private int id;
    private String Nombreprod;
    private int Provedoor;
    private String Nombre;
    private double precio;
    private int cantidad;
    private String tipo;
    private String descripro;
    
    public Productos(){
        
    }

    public Productos(int id, String Nombreprod, int Provedoor, String Nombre, double precio, int cantidad, String tipo, String descripro) {
        this.id = id;
        this.Nombreprod = Nombreprod;
        this.Provedoor = Provedoor;
        this.Nombre = Nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripro = descripro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreprod() {
        return Nombreprod;
    }

    public void setNombreprod(String Nombreprod) {
        this.Nombreprod = Nombreprod;
    }

    public int getProvedoor() {
        return Provedoor;
    }

    public void setProvedoor(int Provedoor) {
        this.Provedoor = Provedoor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripro() {
        return descripro;
    }

    public void setDescripro(String descripro) {
        this.descripro = descripro;
    }
}