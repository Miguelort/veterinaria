/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author home
 */
public class EmpleadoDAO {
       Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
      public boolean RegistrarEmpleado(Empleado em){
       String sql = "INSERT INTO empleados (idEmpleado, Nombre, apellidos, edad, sexo, telefono, Colonia, Ciudad, Estado, CodigoPostal, puesto, Horario, Email, NumeroSeguro) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,em.getIdEmpleado());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getApellidos());
            ps.setInt(4, em.getEdad());
            ps.setString(5, em.getSexo());
             ps.setString(6, em.getTelefono());
            ps.setString(7, em.getColonia());
            ps.setString(8, em.getCiudad());
            ps.setString(9, em.getEstado());
            ps.setInt (10,em.getCP());
            ps.setString(11, em.getPuesto());
            ps.setString(12, em.getHorario());
            ps.setString(13,em.getEmail());
            ps.setString(14, em.getNumSeg());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
       
        }
    }
       public  List ListarEmpleado(){
           List<Empleado> Listaem = new ArrayList();
       String sql = "SELECT * FROM empleados";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Empleado em = new Empleado();
               em.setIdEmpleado(rs.getInt("idEmpleado"));
             em.setNombre(rs.getString("Nombre"));
             em.setApellidos(rs.getString("Apellidos"));
             em.setEdad(rs.getInt("Edad"));
             em.setSexo(rs.getString("Sexo"));
             em.setTelefono(rs.getString("Telefono"));
             em.setColonia(rs.getString("Colonia"));
             em.setCiudad(rs.getString("Ciudad"));
             em.setEstado(rs.getString("Estado"));
             em.setCP(rs.getInt("CodigoPostal"));
             em.setPuesto(rs.getString("Puesto"));
             em.setHorario(rs.getString("Horario"));
             em.setEmail(rs.getString("Email"));
             em.setNumSeg(rs.getString("NumeroSeguro"));
              
              
              
               Listaem.add(em);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Listaem;
   }
        public boolean EliminarEmpleado(int id){
       String sql = "DELETE FROM empleados WHERE  idEmpleado= ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println(ex.toString());
           }
       }
        }
         public boolean ModificarEmpleado(Empleado em){
       String sql = "UPDATE empleados SET  Nombre=?, apellidos=?, edad=?, sexo=?, telefono=?, Colonia=?, Ciudad=?, Estado=?, CodigoPostal=?, puesto=?, Horario=?, Email=?, NumeroSeguro=? WHERE idEmpleado=?";
        try {
           ps = con.prepareStatement(sql);   
             ps.setInt(14,em.getIdEmpleado());
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getApellidos());
            ps.setInt(3, em.getEdad());
            ps.setString(4, em.getSexo());
             ps.setString(5, em.getTelefono());
            ps.setString(6, em.getColonia());
            ps.setString(7, em.getCiudad());
            ps.setString(8, em.getEstado());
            ps.setInt (9,em.getCP());
            ps.setString(10, em.getPuesto());
            ps.setString(11, em.getHorario());
            ps.setString(12,em.getEmail());
            ps.setString(13, em.getNumSeg());
             ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }
       
   }
           


   
