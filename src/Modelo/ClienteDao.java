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
 * @author USUARIO
 */
public class ClienteDao {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(Cliente cl){
       String sql = "INSERT INTO cliente (IdCliente, Nombre, Apellidos, Edad, FechaDeNacimiento, Sexo, Telefono, Colonia, Ciudad, Estado, CP, Email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,cl.getIdCliente());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getApellidos());
            ps.setString(4, cl.getEdad());
            ps.setString(5, cl.getFechaDeNacimiento());
            ps.setString(6, cl.getSexo());
             ps.setString(7, cl.getTelefono());
            ps.setString(8, cl.getColonia());
            ps.setString(9, cl.getCiudad());
            ps.setString(10, cl.getEstado());
            ps.setString (11,cl.getCP());
            ps.setString(12, cl.getEmail());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
       
        }
    }
      public  List ListarCliente(){
           List<Cliente> ListaCl = new ArrayList();
       String sql = "SELECT * FROM cliente";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Cliente cl = new Cliente();
              cl.setIdCliente(rs.getInt("idCliente"));
              cl.setNombre(rs.getString("Nombre"));
              cl.setApellidos(rs.getString("Apellidos"));
              cl.setEdad(rs.getString("Edad"));
              cl.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
              cl.setSexo(rs.getString("Sexo"));
              cl.setTelefono(rs.getString("Telefono"));
              cl.setColonia(rs.getString("Colonia"));
              cl.setCiudad(rs.getString("Ciudad"));
              cl.setEstado(rs.getString("Estado"));
              cl.setCP(rs.getString("CP"));
              cl.setEmail(rs.getString("Email"));
              
              
              
               ListaCl.add(cl);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaCl;
   }
      public boolean EliminarCliente(int id){
       String sql = "DELETE FROM cliente WHERE idcliente = ?";
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
     public boolean ModificarCliente(Cliente cl){
       String sql = "UPDATE cliente SET  Nombre=?, Apellidos=?, Edad=?, FechaDeNacimiento=?, Sexo=?, Telefono=?, Colonia=?, Ciudad=?, Estado=?, CP=?, Email=? WHERE idcliente=?";
       try {
           ps = con.prepareStatement(sql);   
             ps.setInt(12,cl.getIdCliente());
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getApellidos());
            ps.setString(3, cl.getEdad());
            ps.setString(4, cl.getFechaDeNacimiento());
            ps.setString(5, cl.getSexo());
             ps.setString(6, cl.getTelefono());
            ps.setString(7, cl.getColonia());
            ps.setString(8, cl.getCiudad());
            ps.setString(9, cl.getEstado());
            ps.setString (10,cl.getCP());
            ps.setString(11, cl.getEmail());
              
            
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
       public Cliente Buscarcliente(int dni){
       Cliente cl = new Cliente();
       String sql = "SELECT * FROM cliente WHERE idcliente = ?";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, dni);
           rs = ps.executeQuery();
           if (rs.next()) {
                cl.setIdCliente(rs.getInt("idCliente"));
              cl.setNombre(rs.getString("Nombre"));
              cl.setApellidos(rs.getString("Apellidos"));
              cl.setEdad(rs.getString("Edad"));
              cl.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
              cl.setSexo(rs.getString("Sexo"));
              cl.setTelefono(rs.getString("Telefono"));
              cl.setColonia(rs.getString("Colonia"));
              cl.setCiudad(rs.getString("Ciudad"));
              cl.setEstado(rs.getString("Estado"));
              cl.setCP(rs.getString("CP"));
              cl.setEmail(rs.getString("Email"));
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return cl;
   }
   }
      


  