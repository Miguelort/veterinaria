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
public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String Apellidos;
    private String Telefono;
    private String Correo;
    private String Colonia;
    private String Ciudad;
    private String Estado;
    private int CP;
    
    public Proveedor (){
        
    }

    public Proveedor(int idProveedor, String nombre, String Apellidos, String Telefono, String Correo, String Colonia, String Ciudad, String Estado, int CP) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Colonia = Colonia;
        this.Ciudad = Ciudad;
        this.Estado = Estado;
        this.CP = CP;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

}