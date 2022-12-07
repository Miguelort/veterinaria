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

public class ProductosDAO {
    
     Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
       public boolean RegistrarProductos(Productos pr){
       String sql = "INSERT INTO productos (idproducto,nombre,Proveedor,cantidad,precio,Tipo, descripcion) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getId());
            ps.setString(2, pr.getNombreprod());
            ps.setInt(3,pr.getProvedoor());
            ps.setInt(4,pr.getCantidad());
           ps.setDouble(5, pr.getPrecio());
           ps.setString(6, pr.getTipo());
           ps.setString(7,pr.getDescripro());
            ps.execute();
        }catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        
        }
        return false;
    }
       public Proveedor ConsultarProveedor (String nombre){
      Proveedor pro = new Proveedor();
    String sql =  "SELECT * FROM provedores WHERE Nombre = ?";
    try {
    con = cn.getConnection();
    ps = con.prepareStatement(sql);
    ps.setString(1, nombre);
    rs = ps.executeQuery();
    if (rs.next()) {
        pro.setIdProveedor(rs.getInt("IdProveedor"));
    }
    } catch (SQLException e){
            System.out.println(e.toString());
            }
        return pro;
     
    }
         public  List ListarProductos(){
          List<Productos> Listarpro  = new ArrayList();
                             String sql = "SELECT pro.IdProveedor AS Proveedor, pro.Nombre AS Proveedorn, p.* FROM provedores pro INNER JOIN productos p ON pro.IdProveedor = p.Proveedor ORDER BY p.Proveedor DESC";
                    try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Productos pr = new Productos ();
               pr.setId(rs.getInt("idproducto"));
               pr.setNombreprod(rs.getString("Nombre"));
               pr.setProvedoor(rs.getInt("Proveedor"));
               pr.setNombre(rs.getString("Proveedorn"));
               pr.setCantidad(rs.getInt("cantidad"));
               pr.setPrecio(rs.getDouble("precio"));
               pr.setTipo(rs.getString("Tipo"));
               pr.setDescripro(rs.getString("descripcion"));
           Listarpro.add(pr);
               
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Listarpro;
   
}
          public boolean EliminarProducto(int id){
       String sql = "DELETE FROM productos WHERE idproducto = ?";
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
          public boolean ModificarProductos(Productos pr){
       String sql = "UPDATE productos SET  nombre=?, Proveedor=?, cantidad=?, precio=?, Tipo=?, descripcion=? WHERE idproducto=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setInt(7, pr.getId());
            ps.setString(1, pr.getNombreprod());
            ps.setInt(2,pr.getProvedoor());
            ps.setInt(3,pr.getCantidad());
           ps.setDouble(4, pr.getPrecio());
           ps.setString(5, pr.getTipo());
           ps.setString(6,pr.getDescripro());
           
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
           public Productos BuscarPro(String cod){
        Productos producto = new Productos();
        String sql = "SELECT * FROM productos WHERE idproducto=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setId(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripro(rs.getString("Descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
        public Productos BuscarId(int id){
        Productos pr = new Productos();
                String sql = "SELECT pr.IdProveedor AS id_proveedor, pr.Nombre AS nombre_proveedor, p.* FROM provedores pr INNER JOIN productos p ON p.proveedor = pr.IdProveedor  WHERE p.idproducto = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pr.setId(rs.getInt("idproducto"));
                pr.setNombre(rs.getString("nombre"));
                pr.setProvedoor(rs.getInt("proveedor"));
                pr.setNombreprod(rs.getString("nombre_proveedor"));
                pr.setCantidad(rs.getInt("cantidad"));
                pr.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pr;
    }
   }
