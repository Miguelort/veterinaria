/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.filechooser.FileSystemView;
/**
 *
 * @author home
 */
public class VentaDao {
      Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
     public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM ventas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
      public int RegistrarVenta(Venta v){
        String sql = "INSERT INTO ventas (cliente, vendedor, total, fecha) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.setString(4, v.getFecha());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
        
      
}    public int RegistrarDetalle(Detalle Dv){
       String sql = "INSERT INTO detalle (id_pro, cantidad, precio, id_venta) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Dv.getId_pro());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio());
            ps.setInt(4, Dv.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
  public boolean ActualizarStock(int cant, int id){
        String sql = "UPDATE productos SET cantidad = ? WHERE idproducto = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,cant);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
  }
      public void pdfV(int idventa, int Cliente, double total, String usuario) {
        try {
            FileOutputStream archivo;
        
             File file = new File ("src/pdf/venta.pdf");
             archivo = new FileOutputStream(file);
            Document doc = new Document ();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
             Image img = Image.getInstance(getClass().getResource("/Img/logo_pdf.png"));
             Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
               fecha.add("Vendedor: " + usuario + "\nFolio: " + idventa + "\nFecha: "
                    + new SimpleDateFormat("dd/MM/yyyy").format(date) + "\n\n");
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnWidthsEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(columnWidthsEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
                Encabezado.addCell(img);
                
                //datos de la veterianaria
              String m = "a";
                String ruc = "182391";
                String nom = "Veterinaria huellitas";
                String tel = "871 750 7199";
                String dir = "Torreón - San Pedro De las Colonias KM 7.5, Ejido Ana, 27170 Torreón, Coah.";
                String ra = "Gracias por confiar en nosotros";
             try {
                 
                con = cn.getConnection();
                ps = con.prepareStatement(m);
                rs = ps.executeQuery();
                if (rs.next()) {
                    
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
             
              Encabezado.addCell("");
              Encabezado.addCell("ruc:  " +ruc+ "\nNombre: "+nom+ "\nTelefono: " +tel+ "\nDireccion: " +dir+ "\n"+ra);
               Encabezado.addCell(fecha);
            doc.add(Encabezado);
            //cliente
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("DATOS DEL CLIENTE" + "\n\n");
            doc.add(cli);

            PdfPTable proveedor = new PdfPTable(3);
            proveedor.setWidthPercentage(100);
            proveedor.getDefaultCell().setBorder(0);
            float[] columnWidthsCliente = new float[]{50f, 25f, 25f};
            proveedor.setWidths(columnWidthsCliente);
            proveedor.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliNom = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell cliape = new PdfPCell(new Phrase("Apellidos", negrita));
            PdfPCell clitel = new PdfPCell(new Phrase("Telefono", negrita));
            cliNom.setBorder(Rectangle.NO_BORDER);
            cliape.setBorder(Rectangle.NO_BORDER);
            clitel.setBorder(Rectangle.NO_BORDER);
            proveedor.addCell(cliNom);
            proveedor.addCell(cliape);
            proveedor.addCell(clitel);
            String prove = "SELECT * FROM cliente WHERE IdCliente = ?";
            try {
                ps = con.prepareStatement(prove);
                ps.setInt(1, Cliente);
                rs = ps.executeQuery();
                if (rs.next()) {
                    proveedor.addCell(rs.getString("nombre"));
                    proveedor.addCell(rs.getString("Apellidos"));
                    proveedor.addCell(rs.getString("Telefono") + "\n\n");
                } else {
                    proveedor.addCell("Publico en General");
                    proveedor.addCell("S/N");
                    proveedor.addCell("S/N" + "\n\n");
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
             doc.add(proveedor);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.getDefaultCell().setBorder(0);
            float[] columnWidths = new float[]{10f, 50f, 15f, 15f};
            tabla.setWidths(columnWidths);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell c1 = new PdfPCell(new Phrase("Cant.", negrita));
            PdfPCell c2 = new PdfPCell(new Phrase("Nombre.", negrita));
            PdfPCell c3 = new PdfPCell(new Phrase("P. unt.", negrita));
            PdfPCell c4 = new PdfPCell(new Phrase("P. Total", negrita));
            c1.setBorder(Rectangle.NO_BORDER);
            c2.setBorder(Rectangle.NO_BORDER);
            c3.setBorder(Rectangle.NO_BORDER);
            c4.setBorder(Rectangle.NO_BORDER);
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabla.addCell(c1);
            tabla.addCell(c2);
            tabla.addCell(c3);
            tabla.addCell(c4);
            String product = "SELECT d.id, d.id_pro,d.id_venta, d.precio, d.cantidad, p.idproducto, p.nombre FROM detalle d INNER JOIN productos p ON d.id_pro = p.idproducto WHERE d.id_venta = ?";
            try {
                ps = con.prepareStatement(product);
                ps.setInt(1, idventa);
                rs = ps.executeQuery();
                while (rs.next()) {
                    double subTotal = rs.getInt("cantidad") * rs.getDouble("precio");
                    tabla.addCell(rs.getString("cantidad"));
                    tabla.addCell(rs.getString("nombre"));
                    tabla.addCell(rs.getString("precio"));
                    tabla.addCell(String.valueOf(subTotal));
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            doc.add(tabla);
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total S/: " + total);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion \n\n");
            firma.add("------------------------------------\n");
            firma.add("Firma \n");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            Paragraph gr = new Paragraph();
            gr.add(Chunk.NEWLINE);
            gr.add(ra);
            gr.setAlignment(Element.ALIGN_CENTER);
            doc.add(gr);
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println(e.toString());
        }
    }
 public  List ListarVentas(){
          List<Venta> ListarVenta  = new ArrayList();
           String sql = "SELECT c.IdCliente AS id_cli, c.Nombre, v.* FROM cliente c INNER JOIN ventas v ON c.IdCliente = v.Cliente";
                    try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Venta vent = new Venta ();
               vent.setId(rs.getInt("id"));
               vent.setNombre_cli(rs.getString("Nombre"));
               vent.setVendedor(rs.getString("Vendedor"));
               vent.setTotal(rs.getDouble("total"));
              vent.setFecha(rs.getString("fecha"));
               ;
           ListarVenta.add(vent);
               
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListarVenta;
    
}
  public Venta BuscarVenta(int id){
         Venta cl = new Venta();
        String sql = "SELECT * FROM ventas WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setId(rs.getInt("id"));
                cl.setCliente(rs.getInt("cliente"));
                cl.setTotal(rs.getDouble("total"));
                cl.setVendedor(rs.getString("vendedor"));
                cl.setFecha(rs.getString("fecha"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cl;
}
}