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
import javax.swing.JComboBox;

public class MascotaDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
 
   public boolean RegistrarMascotas(Mascota mas){
       
        String sql = "INSERT INTO animales (idmascota,Cliente, Nombre, Raza, Color, Edad, Tamaño, Descripcion) VALUES (?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, mas.getIdmascota());
            ps.setInt(2, mas.getCliente());
            ps.setString(3, mas.getNombremas());
            ps.setString(4,mas.getRaza());
            ps.setString(5,mas.getColor());
            ps.setInt(6, mas.getEdad());
            ps.setString(7,mas.getTamano());
            ps.setString(8, mas.getDescripcionani());
            ps.execute();
        }catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        
        }
        return false;
    }
public Cliente ConsultarCliente(String nombre){
    Cliente cl = new Cliente();
    String sql =  "SELECT * FROM cliente WHERE Nombre = ?";
    try {
    con = cn.getConnection();
    ps = con.prepareStatement(sql);
    ps.setString(1, nombre);
    rs = ps.executeQuery();
    if (rs.next()) {
        cl.setIdCliente(rs.getInt("IdCliente"));
       
    }
    } catch (SQLException e){
            System.out.println(e.toString());
            }
        return cl;
     
    }
   public  List ListarMascota(){
           List<Mascota> Listamas = new ArrayList();
                  String sql = "SELECT cl.idcliente AS IdCl, cl.Nombre AS Nombre_cliente, m.* FROM cliente cl INNER JOIN animales m ON cl.IdCliente = m.Cliente ORDER BY m.Cliente DESC";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Mascota mas = new Mascota ();
               mas.setIdmascota(rs.getInt("idmascota"));
               mas.setCliente(rs.getInt("IdCl"));
               mas.setNombre(rs.getString("Nombre_cliente"));
              mas.setNombremas(rs.getString("Nombre"));
              mas.setRaza(rs.getString("Raza"));
              mas.setColor(rs.getString("Color"));
              mas.setEdad(rs.getInt("Edad"));
              mas.setTamano(rs.getString("Tamaño"));
              mas.setDescripcionani(rs.getString("Descripcion"));
               Listamas.add(mas);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Listamas;
   
}
 public boolean EliminarMascota(int id){
       String sql = "DELETE FROM animales WHERE idmascota = ?";
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
  public boolean ModificarMascota(Mascota mas){
       String sql = "UPDATE animales SET  Cliente=?, Nombre=?, Raza=?, Color=?, Edad=?, Tamaño=?, Descripcion=? WHERE idmascota=?";
       try {
           ps = con.prepareStatement(sql);   
             ps.setInt(8,mas.getIdmascota());
            ps.setInt(1, mas.getCliente());
            ps.setString(2, mas.getNombremas());
            ps.setString(3, mas.getRaza());
            ps.setString(4, mas.getColor());
            ps.setInt(5, mas.getEdad());
             ps.setString(6, mas.getTamano());
            ps.setString(7, mas.getDescripcionani());           
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
      


  


            
            
            
            
            
        


