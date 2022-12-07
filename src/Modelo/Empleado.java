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
public class Empleado {
      private int IdEmpleado;
    private String Nombre;
    private String Apellidos;
    private int Edad;
    private String Sexo;
    private String Telefono;
    private String Colonia;
    private String Ciudad;
    private String Estado;
    private String Puesto;
    private String Horario;
    private int CP;
    private String Email;
    private String NumSeg;
    
     public Empleado() {
    }

    public Empleado(int IdEmpleado, String Nombre, String Apellidos, int Edad, String Sexo, String Telefono, String Colonia, String Ciudad, String Estado, String Puesto, String Horario, int CP, String Email, String NumSeg) {
        this.IdEmpleado = IdEmpleado;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Colonia = Colonia;
        this.Ciudad = Ciudad;
        this.Estado = Estado;
        this.Puesto = Puesto;
        this.Horario = Horario;
        this.CP = CP;
        this.Email = Email;
        this.NumSeg = NumSeg;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
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

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNumSeg() {
        return NumSeg;
    }

    public void setNumSeg(String NumSeg) {
        this.NumSeg = NumSeg;
    }
    }
