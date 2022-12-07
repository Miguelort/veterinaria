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




public class ProveedorDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProveedor(Proveedor pro){
            String sql = "INSERT INTO provedores (IdProveedor,Nombre,Apellidos,Telefonos,Correo,Colonia,Ciudad,Estado,CP) VALUES (?,?,?,?,?,?,?,?,?)";
            try{
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1,pro.getIdProveedor());
                ps.setString(2, pro.getNombre());
                ps.setString(3, pro.getApellidos());
                ps.setString(4, pro.getTelefono());
                ps.setString(5, pro.getCorreo());
                ps.setString(6, pro.getColonia());
                ps.setString(7, pro.getCiudad());
                ps.setString(8, pro.getEstado());
                ps.setInt(9, pro.getCP());
                ps.execute();
                      
            }catch (Exception e){
               System.out.println(e.toString());
          
    }
        return false;
    }
 
    public  List ListarProveedor(){
           List<Proveedor> Listapr = new ArrayList();
       String sql = "SELECT * FROM provedores";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Proveedor pro = new Proveedor();
             pro.setIdProveedor(rs.getInt("IdProveedor"));
             pro.setNombre(rs.getString("Nombre"));
             pro.setApellidos(rs.getString("Apellidos"));
             pro.setTelefono(rs.getString("Telefonos"));
             pro.setCorreo(rs.getString("Correo"));
             pro.setColonia(rs.getString("Colonia"));
             pro.setCiudad(rs.getString("Ciudad"));
             pro.setEstado(rs.getString("Estado"));
             pro.setCP(rs.getInt("CP"));
              Listapr.add(pro);
             
 
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Listapr;
   }
 public boolean EliminarProveedor(int id){
       String sql = "DELETE FROM provedores WHERE IdProveedor = ?";
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
    public boolean ModificarProveedor(Proveedor pro){
       String sql = "UPDATE provedores SET  Nombre=?, Apellidos=?, Telefonos=?, Correo=?, Colonia=?, Ciudad=?, Estado=?,  CP=?  WHERE IdProveedor=?";
       try {
           ps = con.prepareStatement(sql);   
             ps.setInt(9, pro.getIdProveedor());
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getApellidos());
            ps.setString(3, pro.getTelefono());
            ps.setString(4, pro.getCorreo());
            ps.setString(5, pro.getColonia());
             ps.setString(6,pro.getCiudad());
            ps.setString(7, pro.getEstado());
            ps.setInt(8, pro.getCP());
         
              
            
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



