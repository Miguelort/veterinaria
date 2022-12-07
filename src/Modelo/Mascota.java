/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Logger;
import javafx.scene.control.ComboBox;

/**
 *
 * @author home
 */
public class Mascota {
    private int idmascota;
    private String Nombre;
    private int Cliente;
    private String nombremas;
    private String raza;
    private String color;
    private int edad;
   private String tamano;
   private String descripcionani;
   
  public Mascota() {
  }

    public Mascota(int idmascota, String Nombre, int Cliente, String nombremas, String raza, String color, int edad, String tamano, String descripcionani) {
        this.idmascota = idmascota;
        this.Nombre = Nombre;
        this.Cliente = Cliente;
        this.nombremas = nombremas;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
        this.tamano = tamano;
        this.descripcionani = descripcionani;
    }

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCliente() {
        return Cliente;
    }

    public void setCliente(int Cliente) {
        this.Cliente = Cliente;
    }

    public String getNombremas() {
        return nombremas;
    }

    public void setNombremas(String nombremas) {
        this.nombremas = nombremas;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getDescripcionani() {
        return descripcionani;
    }

    public void setDescripcionani(String descripcionani) {
        this.descripcionani = descripcionani;
    }

}    