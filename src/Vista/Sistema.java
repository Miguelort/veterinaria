/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.Combo;
import Modelo.Combo2;
import Modelo.Detalle;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.LoginDAO;
import Modelo.Mascota;
import Modelo.MascotaDao;
import Modelo.Productos;
import Modelo.ProductosDAO;
import Modelo.Eventos;
import Modelo.Proveedor;
import Modelo.login;
import Modelo.Venta;
import Modelo.VentaDao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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

import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;



public final class Sistema extends javax.swing.JFrame {
 TableRowSorter<DefaultTableModel> sorter;
   Date fechaVenta = new Date();
    String fechaActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS").format(fechaVenta);
    Cliente cl = new Cliente();
    ClienteDao client = new ClienteDao();
    Proveedor pro = new Proveedor();
    ProveedorDAO prod = new ProveedorDAO();
   Productos  pr = new Productos();
  ProductosDAO prDAO = new ProductosDAO();
    Mascota mas = new Mascota();
    MascotaDao mascot = new MascotaDao();
      Eventos event = new Eventos();
    
    Venta v = new Venta();
    VentaDao Vdao = new VentaDao();
    Detalle Dv = new Detalle();
    login lg = new login();
    LoginDAO login = new LoginDAO();
 Empleado em = new Empleado();
 EmpleadoDAO emDAO = new EmpleadoDAO();
       DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
         int item;
    double Totalpagar = 0.00;
 
    public Sistema() {
        initComponents();
        
        
      
    }
    public Sistema(login priv) {
        initComponents();
        
        this.setLocationRelativeTo(null);
     AutoCompleteDecorator.decorate(jComboBox2);
     AutoCompleteDecorator.decorate(jComboBox1);
    
        txtIdVenta.setVisible(false);
        txtIdPro.setVisible(false);
        
        txtIdCV.setVisible(false);
     
      if (priv.getRol().equals("Asistente")) {
            jButton14.setEnabled(false);
            jButton7.setEnabled(false);
            jButton3.setEnabled(false);
            btnProv.setEnabled(false);
            jButton9.setEnabled(false);
            
            LabelVendedor.setText(priv.getNombre());
        }else{
            LabelVendedor.setText(priv.getNombre());
        }
    }
    
 public void ListarProveedor(){
     List<Proveedor> Listapr = prod.ListarProveedor();
      modelo = (DefaultTableModel) tablepro.getModel();
      Object[] ob = new Object[9];
        for (int i = 0; i < Listapr.size(); i++) {
            ob[0] = Listapr.get(i).getIdProveedor();
            ob[1] = Listapr.get(i).getNombre();
            ob[2] = Listapr.get(i).getApellidos();
            ob[3] = Listapr.get(i).getTelefono();
            ob[4] = Listapr.get(i).getCorreo();
            ob[5] = Listapr.get(i).getColonia();
            ob[6] = Listapr.get(i).getCiudad();
            ob[7] = Listapr.get(i).getEstado();
            ob[8] = Listapr.get(i).getCP();
                modelo.addRow(ob);
                 tablepro.setModel(modelo);
      tablepro.setAutoCreateRowSorter(true);
         sorter = new TableRowSorter<>(modelo);
      tablepro.setRowSorter(sorter);
      
            
        }      
 }

    
         
public void ListarMascota(){
     List<Mascota> Listamas = mascot.ListarMascota();
      modelo = (DefaultTableModel) TableMascota.getModel();
      Object[] ob = new Object[8];
        for (int i = 0; i < Listamas.size(); i++) {
            ob[0] = Listamas.get(i).getIdmascota();
            ob[1] = Listamas.get(i).getNombre();
            ob[2] = Listamas.get(i).getNombremas();
            ob[3] = Listamas.get(i).getRaza();
            ob[4] = Listamas.get(i).getColor();
            ob[5] = Listamas.get(i).getEdad();
            ob[6] = Listamas.get(i).getTamano();
            ob[7] = Listamas.get(i).getDescripcionani();
                modelo.addRow(ob);
                
      TableMascota.setAutoCreateRowSorter(true);
         sorter = new TableRowSorter<>(modelo);
      TableMascota.setRowSorter(sorter);
        }
      TableMascota.setModel(modelo);
}     

  public void ListarCliente(){
     List<Cliente> ListaCl = client.ListarCliente();
      modelo = (DefaultTableModel) TableCliente.getModel();
      Object[] ob = new Object[12];
        for (int i = 0; i < ListaCl.size(); i++) {
            ob[0] = ListaCl.get(i).getIdCliente();
            ob[1] = ListaCl.get(i).getNombre();
            ob[2] = ListaCl.get(i).getApellidos();
            ob[3] = ListaCl.get(i).getEdad();
            ob[4] = ListaCl.get(i).getFechaDeNacimiento();
            ob[5] = ListaCl.get(i).getSexo();
            ob[6] = ListaCl.get(i).getTelefono();
            ob[7] = ListaCl.get(i).getColonia();
            ob[8] = ListaCl.get(i).getCiudad();
            ob[9] = ListaCl.get(i).getEstado();
            ob[10] = ListaCl.get(i).getCP();
            ob[11] = ListaCl.get(i).getEmail();
                modelo.addRow(ob);
                 TableCliente.setModel(modelo);
      TableCliente.setAutoCreateRowSorter(true);
         sorter = new TableRowSorter<>(modelo);
      TableCliente.setRowSorter(sorter);
        }
     
}     
         
public void ListarEmpleados(){
     List<Empleado> Listaem = emDAO.ListarEmpleado();
      modelo = (DefaultTableModel) jTableEm.getModel();
      Object[] ob = new Object[14];
        for (int i = 0; i < Listaem.size(); i++) {
            
            ob[0] = Listaem.get(i).getIdEmpleado();
            ob[1] = Listaem.get(i).getNombre();
            ob[2] = Listaem.get(i).getApellidos();
            ob[3] = Listaem.get(i).getEdad();
            ob[4] = Listaem.get(i).getSexo();
            ob[5] = Listaem.get(i).getTelefono();
            ob[6] = Listaem.get(i).getColonia();
            ob[7] = Listaem.get(i).getCiudad();
            ob[8] = Listaem.get(i).getEstado();
            ob[9] = Listaem.get(i).getCP();
             ob[10] = Listaem.get(i).getPuesto();
              ob[11] = Listaem.get(i).getHorario();
               ob[12] = Listaem.get(i).getEmail();
            ob[13] = Listaem.get(i).getNumSeg();
                modelo.addRow(ob);
                 jTableEm.setModel(modelo);
      jTableEm.setAutoCreateRowSorter(true);
         sorter = new TableRowSorter<>(modelo);
      jTableEm.setRowSorter(sorter);
        }
     
}     
        public void ListarProducto(){
       List<Productos> Listarpro = prDAO.ListarProductos();
      modelo = (DefaultTableModel) Tableprod.getModel();
      Object[] ob = new Object[7];
        for (int i = 0; i < Listarpro.size(); i++) {
            ob[0] = Listarpro.get(i).getId();
            ob[1] = Listarpro.get(i).getNombreprod();
             ob[2] = Listarpro.get(i).getNombre();
            ob[3] = Listarpro.get(i).getCantidad();
            ob[4] = Listarpro.get(i).getPrecio();
             ob[5] = Listarpro.get(i).getTipo();
            ob[6] = Listarpro.get(i).getDescripro();
                modelo.addRow(ob);
      Tableprod.setAutoCreateRowSorter(true);
         sorter = new TableRowSorter<>(modelo);
      Tableprod.setRowSorter(sorter);
  
            
        }
    
          Tableprod.setModel(modelo);  
}

        
        

        
public void ListarVentas(){
       List<Venta> ListarVenta = Vdao.ListarVentas();
      modelo = (DefaultTableModel) TableVentas.getModel();
      Object[] ob = new Object[5];
        for (int i = 0; i < ListarVenta.size(); i++) {
            ob[0] = ListarVenta.get(i).getId();
            ob[1] = ListarVenta.get(i).getNombre_cli();
             ob[2] = ListarVenta.get(i).getVendedor();
            ob[3] = ListarVenta.get(i).getTotal();
            ob[4] = ListarVenta.get(i).getFecha();
            
                modelo.addRow(ob);
      TableVentas.setAutoCreateRowSorter(true);
         sorter = new TableRowSorter<>(modelo);
      TableVentas.setRowSorter(sorter);
  
            
        }
    
          Tableprod.setModel(modelo);  
}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEliminarVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtCodigoVenta = new javax.swing.JTextField();
        txtCantidadVenta = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtStockDisponible = new javax.swing.JTextField();
        txtIdPro = new javax.swing.JTextField();
        LabelTotal = new javax.swing.JLabel();
        txtRucVenta = new javax.swing.JTextField();
        txtNombreClienteventa = new javax.swing.JTextField();
        txtIdCV = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtApellidoClienteventa = new javax.swing.JTextField();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        txtNombreVenta = new javax.swing.JTextField();
        txtDescripcionVenta1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCliente = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFechaDeNacimiento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnGuardarCliente = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        txtidmascota = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtraza = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtcolor = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txttamano = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtdescripcionani = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btnGuardarMascota = new javax.swing.JButton();
        btnEliminarMascota = new javax.swing.JButton();
        btnEditarMascota = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtnombremas = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableMascota = new javax.swing.JTable();
        txtbuscar1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        txtidprov = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txttelefonopro = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtcorreopro = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtcoloniapro = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtciudadpro = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtcodpro = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        btnGuardarpro = new javax.swing.JButton();
        btnEliminarpro = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        txtapellidospro = new javax.swing.JTextField();
        txtnombrepro = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtestadopro1 = new javax.swing.JTextField();
        btneditarpro = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablepro = new javax.swing.JTable();
        txtbuscar2 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        txtidprod = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtcantidadpro = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtdescrippro = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        btnGuardarprod = new javax.swing.JButton();
        btnEliminarpro1 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        txtnombreprod = new javax.swing.JTextField();
        btneditarpro1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtprecioprod1 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txttipo = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tableprod = new javax.swing.JTable();
        txtbuscar3 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        txtIdEmpleado = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtNombreE = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtApellidosE = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtEdad1 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txttelefonoE = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtSexoE = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtColoniaE = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtCiudadE = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtEstadoE = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtCPE = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtPuestoE = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        btnGuardarEmpleado = new javax.swing.JButton();
        btnEliminarE = new javax.swing.JButton();
        btnEditarEmpleado = new javax.swing.JButton();
        txtNumSeg = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtEmail2 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtHorarioE = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableEm = new javax.swing.JTable();
        txtbuscar4 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        btniniciar = new javax.swing.JButton();
        btnEditarUsu = new javax.swing.JButton();
        txtNombreU = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtCorreoU = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        cbxRol = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        btnEliminarUsu = new javax.swing.JButton();
        txtIdU = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableUsu = new javax.swing.JTable();
        txtbuscar5 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TableVentas = new javax.swing.JTable();
        txtIdVenta = new javax.swing.JTextField();
        btnVentas = new javax.swing.JButton();
        txtbuscar6 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnProv = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        LabelVendedor = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Productos/Servicios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 316, 196, -1));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jLabel2.setText("Cantidad");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel3.setText("Descripcion");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        jLabel4.setText("Precio");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        jLabel5.setText("Total a pagar:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, -1, -1));

        btnEliminarVenta.setText("Eliminar");
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, -1, -1));

        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane1.setViewportView(TableVenta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 880, 190));

        jLabel6.setText("Apellidos:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 60, -1));

        jLabel7.setText("ID");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 30, -1));

        jLabel70.setText("Codigo");
        jPanel2.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtCodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVentaActionPerformed(evt);
            }
        });
        txtCodigoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyTyped(evt);
            }
        });
        jPanel2.add(txtCodigoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 102, 30));

        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidadVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 40, 30));

        txtPrecioVenta.setEditable(false);
        jPanel2.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 80, 30));

        txtStockDisponible.setEditable(false);
        jPanel2.add(txtStockDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 79, 30));
        jPanel2.add(txtIdPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, -1, -1));

        LabelTotal.setForeground(new java.awt.Color(0, 0, 0));
        LabelTotal.setText("-----");
        jPanel2.add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 480, -1, -1));

        txtRucVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucVentaKeyTyped(evt);
            }
        });
        jPanel2.add(txtRucVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 116, 30));

        txtNombreClienteventa.setEditable(false);
        txtNombreClienteventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteventaActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombreClienteventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 110, 30));
        jPanel2.add(txtIdCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, -1, -1));

        jLabel77.setText("Nombre:");
        jPanel2.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 60, -1));

        txtApellidoClienteventa.setEditable(false);
        jPanel2.add(txtApellidoClienteventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 110, 30));

        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 120, 45));

        jLabel78.setText("Stock Disponible");
        jPanel2.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtNombreVenta.setEditable(false);
        txtNombreVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreVentaActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombreVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 110, 30));

        txtDescripcionVenta1.setEditable(false);
        jPanel2.add(txtDescripcionVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 110, 30));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idCliente", "Nombre", "Apellidos", "Edad", "FechaDeNacimiento", "Sexo", "Telefono", "Colonia", "Ciudad", "Estado", "Cp", "Email"
            }
        ));
        TableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableCliente);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 820, 580));

        jLabel20.setText("Buscar");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel3.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 170, -1));

        jPanel11.setBackground(new java.awt.Color(0, 204, 204));

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });
        txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyTyped(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("idCliente:");

        jLabel21.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Cliente Formulario");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nombre:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Apellidos:");

        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Edad:");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("FechaNacimiento:");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Sexo:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Telefono:");

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Colonia:");

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Ciudad:");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Estado:");

        txtCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPKeyTyped(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("CP");

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Email:");

        btnGuardarCliente.setText("Registrar");
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(btnGuardarCliente)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(43, 43, 43)
                                .addComponent(btnEditarCliente)
                                .addGap(57, 57, 57))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel19))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(77, 77, 77)))))
                .addGap(52, 52, 52))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(206, 206, 206))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCliente)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditarCliente))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 320, 630));

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel15.setBackground(new java.awt.Color(0, 204, 204));

        txtidmascota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidmascotaKeyTyped(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("idMascota:");

        jLabel25.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Mascota Formulario");

        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("idCliente");

        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Raza:");

        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Color:");

        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedadKeyTyped(evt);
            }
        });

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Edad:");

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Tamaño:");

        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Descripcion:");

        btnGuardarMascota.setText("Registrar");
        btnGuardarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMascotaActionPerformed(evt);
            }
        });

        btnEliminarMascota.setText("Eliminar");
        btnEliminarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMascotaActionPerformed(evt);
            }
        });

        btnEditarMascota.setText("Editar");
        btnEditarMascota.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnEditarMascotaItemStateChanged(evt);
            }
        });
        btnEditarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMascotaActionPerformed(evt);
            }
        });

        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Nombre Mascota:");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(146, 146, 146)))
                .addGap(52, 52, 52))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtnombremas, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtidmascota)
                                            .addComponent(jComboBox1, 0, 178, Short.MAX_VALUE)))
                                    .addComponent(btnGuardarMascota))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtraza, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttamano, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(txtdescripcionani))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEliminarMascota)
                .addGap(40, 40, 40)
                .addComponent(btnEditarMascota)
                .addGap(15, 15, 15))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidmascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtnombremas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtraza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(8, 8, 8)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(13, 13, 13)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescripcionani, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(57, 57, 57)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarMascota)
                    .addComponent(btnEliminarMascota)
                    .addComponent(btnGuardarMascota))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        TableMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idMascota", "Cliente", "Nombre Mascota", "Raza", "Color", "Edad", "Tamaño", "Descripcion"
            }
        ));
        TableMascota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMascotaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableMascota);

        txtbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar1ActionPerformed(evt);
            }
        });
        txtbuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar1KeyReleased(evt);
            }
        });

        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Buscar:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel43)
                        .addGap(31, 31, 31)
                        .addComponent(txtbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(0, 204, 204));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtidprov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidprovKeyTyped(evt);
            }
        });
        jPanel16.add(txtidprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 38, 140, -1));

        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("idProveedor:");
        jPanel16.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 74, -1));

        jLabel34.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Proveedor Formulario");
        jPanel16.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 140, -1));

        txttelefonopro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoproKeyTyped(evt);
            }
        });
        jPanel16.add(txttelefonopro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, -1));

        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Telefono:");
        jPanel16.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));
        jPanel16.add(txtcorreopro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 140, -1));

        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Correo:");
        jPanel16.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));
        jPanel16.add(txtcoloniapro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 140, -1));

        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Colonia:");
        jPanel16.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));
        jPanel16.add(txtciudadpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 228, 140, -1));

        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Ciudad");
        jPanel16.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        txtcodpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodproKeyTyped(evt);
            }
        });
        jPanel16.add(txtcodpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 150, -1));

        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Estado");
        jPanel16.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        btnGuardarpro.setText("Registrar");
        btnGuardarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarproActionPerformed(evt);
            }
        });
        jPanel16.add(btnGuardarpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        btnEliminarpro.setText("Eliminar");
        btnEliminarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarproActionPerformed(evt);
            }
        });
        jPanel16.add(btnEliminarpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Apellidos:");
        jPanel16.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));
        jPanel16.add(txtapellidospro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 140, -1));

        txtnombrepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreproActionPerformed(evt);
            }
        });
        jPanel16.add(txtnombrepro, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 68, 140, -1));

        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Codigo postal");
        jPanel16.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        txtestadopro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtestadopro1ActionPerformed(evt);
            }
        });
        jPanel16.add(txtestadopro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 260, 150, -1));

        btneditarpro.setText("Editar");
        btneditarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarproActionPerformed(evt);
            }
        });
        jPanel16.add(btneditarpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Nombre:");
        jPanel16.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jPanel5.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 350, 600));

        tablepro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdProveedor", "Nombre", "Apellidos", "Telefono", "Correo", "Colonia", "Ciudad", "Estado", "CP"
            }
        ));
        tablepro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableproMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablepro);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 780, 440));

        txtbuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar2ActionPerformed(evt);
            }
        });
        txtbuscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar2KeyReleased(evt);
            }
        });
        jPanel5.add(txtbuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 140, -1));

        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Buscar:");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jTabbedPane1.addTab("tab4", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(0, 204, 204));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtidprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidprodKeyTyped(evt);
            }
        });
        jPanel17.add(txtidprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 180, -1));

        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("idProducto:");
        jPanel17.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 74, -1));

        jLabel46.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Productos/Servicios Formulario");
        jPanel17.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 220, -1));

        txtcantidadpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadproKeyTyped(evt);
            }
        });
        jPanel17.add(txtcantidadpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 178, -1));

        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Tipo:");
        jPanel17.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));
        jPanel17.add(txtdescrippro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 190, 50));

        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Descripcion");
        jPanel17.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 20));

        btnGuardarprod.setText("Registrar");
        btnGuardarprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarprodActionPerformed(evt);
            }
        });
        jPanel17.add(btnGuardarprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        btnEliminarpro1.setText("Eliminar");
        btnEliminarpro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarpro1ActionPerformed(evt);
            }
        });
        jPanel17.add(btnEliminarpro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("Cantidad:");
        jPanel17.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        txtnombreprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreprodActionPerformed(evt);
            }
        });
        jPanel17.add(txtnombreprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 180, -1));

        btneditarpro1.setText("Editar");
        btneditarpro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarpro1ActionPerformed(evt);
            }
        });
        jPanel17.add(btneditarpro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel17.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 180, -1));

        txtprecioprod1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioprod1KeyTyped(evt);
            }
        });
        jPanel17.add(txtprecioprod1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 178, -1));

        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("Proveedor:");
        jPanel17.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel17.add(txttipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 178, -1));

        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("Precio");
        jPanel17.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Nombre");
        jPanel17.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jPanel6.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 350, 550));

        Tableprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Idproducto", "Nombre", "Proveedor", "Cantidad", "precio", "Tipo", "descripcion"
            }
        ));
        Tableprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableprodMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(Tableprod);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 790, -1));

        txtbuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar3ActionPerformed(evt);
            }
        });
        txtbuscar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar3KeyReleased(evt);
            }
        });
        jPanel6.add(txtbuscar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 160, -1));

        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setText("Buscar:");
        jPanel6.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jTabbedPane1.addTab("tab5", jPanel6);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(0, 204, 204));

        txtIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmpleadoActionPerformed(evt);
            }
        });
        txtIdEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdEmpleadoKeyTyped(evt);
            }
        });

        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("idEmpleado:");

        jLabel51.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Empleado Formulario");

        txtNombreE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEActionPerformed(evt);
            }
        });

        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Nombre:");

        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Apellidos:");

        txtEdad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdad1KeyTyped(evt);
            }
        });

        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Edad:");

        txttelefonoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoEActionPerformed(evt);
            }
        });
        txttelefonoE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoEKeyTyped(evt);
            }
        });

        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setText("Telefono");

        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Sexo:");

        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("Colonia:");

        txtCiudadE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadEActionPerformed(evt);
            }
        });

        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Ciudad:");

        jLabel64.setForeground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("Estado:");

        txtCPE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPEKeyTyped(evt);
            }
        });

        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("CP");

        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("Numero de Seguro:");

        btnGuardarEmpleado.setText("Registrar");
        btnGuardarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarE.setText("Eliminar");
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });

        btnEditarEmpleado.setText("Editar");
        btnEditarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpleadoActionPerformed(evt);
            }
        });

        txtNumSeg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumSegKeyTyped(evt);
            }
        });

        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("Email:");

        jLabel68.setForeground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("Horario:");

        jLabel69.setForeground(new java.awt.Color(0, 0, 0));
        jLabel69.setText("Puesto:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCiudadE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(btnGuardarEmpleado)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarE)
                        .addGap(29, 29, 29)
                        .addComponent(btnEditarEmpleado)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuestoE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColoniaE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSexoE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58)
                            .addComponent(jLabel56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEdad1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidosE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114))))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(206, 206, 206))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidosE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSexoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColoniaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(txtCiudadE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstadoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPuestoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorarioE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarEmpleado)
                    .addComponent(btnEliminarE)
                    .addComponent(btnEditarEmpleado))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 310, 660));

        jTableEm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idEmpleado", "Nombre", "Apellidos", "Edad", "Sexo", "Telefono", "Colonia ", "Ciudad", "Estado", "Cp", "Puesto", "Horario", "Email", "NumSeg"
            }
        ));
        jTableEm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableEm);
        if (jTableEm.getColumnModel().getColumnCount() > 0) {
            jTableEm.getColumnModel().getColumn(10).setResizable(false);
        }

        jPanel7.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 840, -1));

        txtbuscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar4ActionPerformed(evt);
            }
        });
        txtbuscar4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar4KeyReleased(evt);
            }
        });
        jPanel7.add(txtbuscar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 160, -1));

        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Buscar:");
        jPanel7.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, -1));

        jTabbedPane1.addTab("tab6", jPanel7);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(0, 204, 204));

        jLabel71.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 0, 0));
        jLabel71.setText("Usuarios Formulario");

        btniniciar.setText("Registrar");
        btniniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciarActionPerformed(evt);
            }
        });

        btnEditarUsu.setText("Editar");
        btnEditarUsu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnEditarUsuItemStateChanged(evt);
            }
        });
        btnEditarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuActionPerformed(evt);
            }
        });

        txtNombreU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUActionPerformed(evt);
            }
        });

        jLabel72.setForeground(new java.awt.Color(0, 0, 0));
        jLabel72.setText("Nombre:");

        jLabel73.setForeground(new java.awt.Color(0, 0, 0));
        jLabel73.setText("Contraseña:");

        txtCorreoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoUActionPerformed(evt);
            }
        });

        jLabel74.setForeground(new java.awt.Color(0, 0, 0));
        jLabel74.setText("Correo:");

        cbxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Asistente" }));
        cbxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolActionPerformed(evt);
            }
        });

        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setText("Rol:");

        btnEliminarUsu.setText("Eliminar");
        btnEliminarUsu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnEliminarUsuItemStateChanged(evt);
            }
        });
        btnEliminarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuActionPerformed(evt);
            }
        });

        txtIdU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUActionPerformed(evt);
            }
        });
        txtIdU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdUKeyTyped(evt);
            }
        });

        jLabel76.setForeground(new java.awt.Color(0, 0, 0));
        jLabel76.setText("Id:");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(btniniciar)
                        .addGap(32, 32, 32)
                        .addComponent(btnEliminarUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarUsu)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCorreoU, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel75))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPass))))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel72)
                            .addComponent(jLabel76))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdU, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreU, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel71)
                .addGap(36, 36, 36)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addGap(10, 10, 10)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCorreoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btniniciar)
                            .addComponent(btnEditarUsu)
                            .addComponent(btnEliminarUsu)))
                    .addComponent(jLabel75))
                .addContainerGap(318, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, -1, -1));

        jTableUsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Correo", "Contraseña", "Rol"
            }
        ));
        jTableUsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTableUsu);

        jPanel8.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 790, -1));

        txtbuscar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar5ActionPerformed(evt);
            }
        });
        txtbuscar5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar5KeyReleased(evt);
            }
        });
        jPanel8.add(txtbuscar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 160, -1));

        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        jLabel79.setText("Buscar:");
        jPanel8.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 47, -1));

        jTabbedPane1.addTab("tab7", jPanel8);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Cliente", "Vendedor", "Total", "Fecha"
            }
        ));
        TableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableVentasMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TableVentas);

        jPanel9.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 890, -1));

        txtIdVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdVentaMouseClicked(evt);
            }
        });
        txtIdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdVentaActionPerformed(evt);
            }
        });
        jPanel9.add(txtIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 46, -1));

        btnVentas.setText("PDF VENTAS");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jPanel9.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        txtbuscar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar6ActionPerformed(evt);
            }
        });
        txtbuscar6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar6KeyReleased(evt);
            }
        });
        jPanel9.add(txtbuscar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 160, -1));

        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setText("Buscar:");
        jPanel9.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jTabbedPane1.addTab("tab8", jPanel9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab9", jPanel10);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 1150, 640));
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        jButton4.setText("Nueva Venta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 114, 196, -1));

        jButton5.setText("Cliente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 172, 196, -1));

        jButton6.setText("Mascota");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 216, 196, -1));

        btnProv.setText("Proveedores");
        btnProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvActionPerformed(evt);
            }
        });
        jPanel1.add(btnProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 266, 196, -1));

        jButton8.setText("jButton3");
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 846, 196, -1));

        jButton10.setText("jButton3");
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 758, 196, -1));

        jButton11.setText("jButton3");
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 802, 196, -1));

        jPanel13.setBackground(new java.awt.Color(0, 0, 102));
        jPanel13.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -2, 20, 910));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/prron.png"))); // NOI18N
        jLabel22.setText("jLabel22");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 980, 150));

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jPanel14.setBackground(new java.awt.Color(204, 255, 255));
        jPanel14.setForeground(new java.awt.Color(0, 0, 153));

        jButton9.setText("Ventas");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton7.setText("Empleados");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton14.setText("Usuarios");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        LabelVendedor.setForeground(new java.awt.Color(0, 0, 0));
        LabelVendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelVendedor.setText("Veterinaria");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(LabelVendedor)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(LabelVendedor)
                .addGap(281, 281, 281)
                .addComponent(jButton7)
                .addGap(26, 26, 26)
                .addComponent(jButton14)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addContainerGap(406, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 28, 200, 880));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modelo/12.png"))); // NOI18N
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 300, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1400, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
       if (!"".equals(txtIdCliente.getText())|| !"".equals(txtNombre.getText()) || !"".equals(txtApellidos.getText()) || !"".equals(txtEdad.getText())|| !"".equals(txtFechaDeNacimiento.getText()) || !"".equals(txtSexo.getText())|| !"".equals(txtTelefono.getText()) || !"".equals(txtColonia.getText()) || !"".equals(txtCiudad.getText()) || !"".equals(txtEstado.getText()) || !"".equals(txtCP.getText()) || !"".equals(txtEmail.getText())) {
        cl.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
        cl.setNombre(txtNombre.getText());
        cl.setApellidos(txtApellidos.getText());
        cl.setEdad(txtEdad.getText());
        cl.setFechaDeNacimiento(txtFechaDeNacimiento.getText());
        cl.setSexo(txtSexo.getText());
        cl.setTelefono(txtTelefono.getText());
        cl.setColonia(txtColonia.getText());
        cl.setCiudad(txtCiudad.getText());
        cl.setEstado(txtEstado.getText());
        cl.setCP(txtCP.getText());
         cl.setEmail(txtEmail.getText());
       
        client.RegistrarCliente(cl);
        LimpiarTable();
   ListarCliente();
   LimpiarCliente();
   btnEliminar.setEnabled(false);
   btnEditarCliente.setEnabled(false);
   btnGuardarCliente.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Cliente Registrado");
       }else{
               JOptionPane.showMessageDialog(null, "Los Campos estan vacios");
               }
   
                LimpiarCliente();
                
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ListarCliente();
      
       jTabbedPane1.setSelectedIndex(1);
       LimpiarTable();
                LimpiarCliente();
                ListarCliente();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
          filtrar1(); 
        
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
      filtrar1(); 
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void TableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClienteMouseClicked
        int fila = TableCliente.rowAtPoint(evt.getPoint());
        txtIdCliente.setText(TableCliente.getValueAt(fila, 0).toString());
        txtNombre.setText(TableCliente.getValueAt(fila, 1).toString());
        txtApellidos.setText(TableCliente.getValueAt(fila, 2).toString());
        txtEdad.setText(TableCliente.getValueAt(fila, 3).toString());
        txtFechaDeNacimiento.setText(TableCliente.getValueAt(fila, 4).toString());
        txtSexo.setText(TableCliente.getValueAt(fila, 5).toString());
        txtTelefono.setText(TableCliente.getValueAt(fila, 6).toString());
        txtColonia.setText(TableCliente.getValueAt(fila, 7).toString());
        txtCiudad.setText(TableCliente.getValueAt(fila, 8).toString());
        txtEstado.setText(TableCliente.getValueAt(fila, 9).toString());
        txtCP.setText(TableCliente.getValueAt(fila, 10).toString());
        txtEmail.setText(TableCliente.getValueAt(fila, 11).toString());
     
     
        
    }//GEN-LAST:event_TableClienteMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
           if (!"".equals(txtIdCliente.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdCliente.getText());
                client.EliminarCliente(id);
                LimpiarTable();
                LimpiarCliente();
                ListarCliente();
            }
           }else{
             JOptionPane.showMessageDialog(null, "Sleccione un campo para eliminar");
           }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
         if ("".equals(txtIdCliente.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {
           if (!"".equals(txtNombre.getText()) || !"".equals(txtApellidos.getText()) || !"".equals(txtEdad.getText())|| !"".equals(txtFechaDeNacimiento.getText()) || !"".equals(txtSexo.getText())|| !"".equals(txtTelefono.getText()) || !"".equals(txtColonia.getText()) || !"".equals(txtCiudad.getText()) || !"".equals(txtEstado.getText()) || !"".equals(txtCP.getText()) || !"".equals(txtEmail.getText())) {
        cl.setNombre(txtNombre.getText());
        cl.setApellidos(txtApellidos.getText());
        cl.setEdad(txtEdad.getText());
        cl.setFechaDeNacimiento(txtFechaDeNacimiento.getText());
        cl.setSexo(txtSexo.getText());
        cl.setTelefono(txtTelefono.getText());
        cl.setColonia(txtColonia.getText());
        cl.setCiudad(txtCiudad.getText());
        cl.setEstado(txtEstado.getText());
        cl.setCP(txtCP.getText());
         cl.setEmail(txtEmail.getText());
       cl.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
        client.ModificarCliente(cl);
         JOptionPane.showMessageDialog(null, "Cliente Modificado");
                LimpiarTable();
                LimpiarCliente();
                ListarCliente();
                 } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
         }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
             
       jTabbedPane1.setSelectedIndex(0);
       
    }//GEN-LAST:event_jButton4ActionPerformed
 
    private void btnGuardarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMascotaActionPerformed
            if ("".equals(txtidmascota.getText())) {
            JOptionPane.showMessageDialog(null, "ingresar todos los campos");
        } else {
        if (!"".equals(txtidmascota.getText()) || !"".equals(jComboBox1.getSelectedItem()) || !"".equals(txtnombremas.getText()) || !"".equals(txtraza.getText()) || !"".equals(txtcolor.getText()) || !"".equals(txtedad.getText())|| !"".equals(txttamano.getText())|| !"".equals(txtdescripcionani.getText())){
               mas.setIdmascota(Integer.parseInt(txtidmascota.getText()));
               Combo itemP = (Combo) jComboBox1.getSelectedItem();
               mas.setCliente(itemP.getIdCliente());
                  mas.setNombremas(txtnombremas.getText());
               mas.setRaza(txtraza.getText());
               mas.setColor(txtcolor.getText());
               mas.setEdad(Integer.parseInt(txtedad.getText()));
               mas.setTamano(txttamano.getText());
               mas.setDescripcionani(txtdescripcionani.getText());
                mascot.RegistrarMascotas(mas);
             
                  LimpiarTable();
                     ListarMascota();
                   LimpiarMascota();
                   
                  jComboBox1.removeAllItems();
                     llenarcliente();
                     JOptionPane.showMessageDialog(null, "Mascota Registrada");
                   }else{
         JOptionPane.showMessageDialog(null, "Campos Vacios");
         }
            
  
    }//GEN-LAST:event_btnGuardarMascotaActionPerformed
    }

    private void btnEliminarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMascotaActionPerformed
           if (!"".equals(txtidmascota.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtidmascota.getText());
                mascot.EliminarMascota(id);
                LimpiarTable();
                LimpiarMascota();
                ListarMascota();
            }
           }else{
             JOptionPane.showMessageDialog(null, "Sleccione un campo para eliminar");
           
           }                               
    }//GEN-LAST:event_btnEliminarMascotaActionPerformed

    private void btnEditarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMascotaActionPerformed
       if ("".equals(txtidmascota.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {
           if ( !"".equals(txtnombremas.getText()) || !"".equals(txtraza.getText()) || !"".equals(txtcolor.getText())|| !"".equals(txtedad.getText()) || !"".equals(txttamano.getText())|| !"".equals(txtdescripcionani.getText())) {
                Combo itemP = (Combo) jComboBox1.getSelectedItem();
               mas.setCliente(itemP.getIdCliente());
               
               mas.setNombremas(txtnombremas.getText());
        mas.setRaza(txtraza.getText());
      mas.setColor(txtcolor.getText());
      mas.setEdad(Integer.parseInt(txtedad.getText()));
      mas.setTamano(txttamano.getText());
      mas.setDescripcionani(txtdescripcionani.getText());
       mas.setIdmascota(Integer.parseInt(txtidmascota.getText()));
      mascot.ModificarMascota(mas);
         JOptionPane.showMessageDialog(null, "Mascota Modificado");
                LimpiarTable();
                LimpiarMascota();
                ListarMascota();
                jComboBox1.removeAllItems();
                llenarcliente();
                
           }
       }
    }//GEN-LAST:event_btnEditarMascotaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        jTabbedPane1.setSelectedIndex(2);
        ListarMascota();
        LimpiarTable();
        jComboBox1.removeAllItems();
        ListarMascota();
        llenarcliente();
                LimpiarMascota();
                 jComboBox1.removeAllItems();
          
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void txtbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar1ActionPerformed
        filtrar2();
    }//GEN-LAST:event_txtbuscar1ActionPerformed

    private void txtbuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar1KeyReleased
            filtrar2(); 
    }//GEN-LAST:event_txtbuscar1KeyReleased

    private void TableMascotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMascotaMouseClicked
int fila = TableMascota.rowAtPoint(evt.getPoint());
        txtidmascota.setText(TableMascota.getValueAt(fila, 0).toString());
        
        txtnombremas.setText(TableMascota.getValueAt(fila, 2).toString());
        txtraza.setText(TableMascota.getValueAt(fila, 3).toString());
        txtcolor.setText(TableMascota.getValueAt(fila, 4).toString());
        txtedad.setText(TableMascota.getValueAt(fila, 5).toString());
        txttamano.setText(TableMascota.getValueAt(fila, 6).toString());
        txtdescripcionani.setText(TableMascota.getValueAt(fila, 7).toString()); 
        jComboBox1.setSelectedItem(new Combo (mas.getCliente(), mas.getNombre()));
    }//GEN-LAST:event_TableMascotaMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        llenarcliente();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void btnEditarMascotaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnEditarMascotaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarMascotaItemStateChanged

    private void btnProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvActionPerformed
        jTabbedPane1.setSelectedIndex(3);
        ListarProveedor();
        LimpiarTable();
   ListarProveedor();
   LimpiarProveedor();
    }//GEN-LAST:event_btnProvActionPerformed

    private void btnGuardarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarproActionPerformed
        // TODO add your handling code here
               if (!"".equals(txtidprov.getText())|| !"".equals(txtnombrepro.getText()) || !"".equals(txtapellidospro.getText()) || !"".equals(txttelefonopro.getText())|| !"".equals(txtcorreopro.getText()) || !"".equals(txtcoloniapro.getText())|| !"".equals(txtciudadpro.getText()) || !"".equals(txtestadopro1.getText()) || !"".equals(txtcodpro.getText())) {
   pro.setIdProveedor(Integer.parseInt(txtidprov.getText()));
   pro.setNombre(txtnombrepro.getText());
   pro.setApellidos(txtapellidospro.getText());
   pro.setTelefono(txttelefonopro.getText());
   pro.setCorreo(txtcorreopro.getText());
   pro.setColonia(txtcoloniapro.getText());
   pro.setCiudad(txtciudadpro.getText());
   pro.setEstado(txtestadopro1.getText());
   pro.setCP(Integer.parseInt(txtcodpro.getText()));
   prod.RegistrarProveedor(pro);
   LimpiarTable();
   ListarProveedor();
   LimpiarProveedor();
   
   
   JOptionPane.showMessageDialog(null, "Proveedor Registrado");
               }else{
                   JOptionPane.showMessageDialog(null, "Los campos estan vacios");
    }//GEN-LAST:event_btnGuardarproActionPerformed
    }
    private void btnEliminarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarproActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtidprov.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar");
            if (pregunta == 0){
                   int id = Integer.parseInt(txtidprov.getText());
                prod.EliminarProveedor(id);
                   LimpiarTable();
   ListarProveedor();
   LimpiarProveedor();
                
                
            }
            }else{
             JOptionPane.showMessageDialog(null, "Sleccione un campo para eliminar");
            
        }
  

    }//GEN-LAST:event_btnEliminarproActionPerformed

    private void txtnombreproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreproActionPerformed

    private void tableproMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableproMouseClicked
        int fila = tablepro.rowAtPoint(evt.getPoint());
        txtidprov.setText(tablepro.getValueAt(fila,0).toString());
        txtnombrepro.setText(tablepro.getValueAt(fila, 1).toString());
        txtapellidospro.setText(tablepro.getValueAt(fila, 2).toString());
        txttelefonopro.setText(tablepro.getValueAt(fila,3).toString());
        txtcorreopro.setText(tablepro.getValueAt(fila,4).toString());
        txtcoloniapro.setText(tablepro.getValueAt(fila, 5).toString());
        txtciudadpro.setText(tablepro.getValueAt(fila,6).toString());
        txtestadopro1.setText(tablepro.getValueAt(fila, 7).toString());
        txtcodpro.setText(tablepro.getValueAt(fila,8).toString());
    }//GEN-LAST:event_tableproMouseClicked

    private void txtestadopro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtestadopro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtestadopro1ActionPerformed

    private void btneditarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarproActionPerformed
        // TODO add your handling code here:
         if ("".equals(txtidprov.getText())){
            JOptionPane.showMessageDialog(null,"Seleciona una fila");
        }else{
            if (!"".equals(txtnombrepro.getText()) || !"".equals(txtapellidospro.getText()) || !"".equals(txttelefonopro.getText())|| !"".equals(txtcorreopro.getText()) || !"".equals(txtcoloniapro.getText())|| !"".equals(txtciudadpro.getText()) || !"".equals(txtestadopro1.getText()) || !"".equals(txtcodpro.getText())) {
        pro.setNombre(txtnombrepro.getText());
        pro.setApellidos(txtapellidospro.getText());
        pro.setTelefono(txttelefonopro.getText());
        pro.setCorreo(txtcorreopro.getText());
        pro.setColonia(txtcoloniapro.getText());
        pro.setCiudad(txtciudadpro.getText());
        pro.setEstado(txtestadopro1.getText());
        pro.setCP(Integer.parseInt(txtcodpro.getText()));
        pro.setIdProveedor(Integer.parseInt(txtidprov.getText()));
        prod.ModificarProveedor(pro);
        JOptionPane.showMessageDialog(null, "Proveedor Modificado");
          LimpiarTable();
   ListarProveedor();
   LimpiarProveedor();
                          } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }                   
         }
    }//GEN-LAST:event_btneditarproActionPerformed

    private void txtbuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar2ActionPerformed
       filtrar3();
    }//GEN-LAST:event_txtbuscar2ActionPerformed

    private void txtbuscar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar2KeyReleased
         filtrar3();
    }//GEN-LAST:event_txtbuscar2KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        jTabbedPane1.setSelectedIndex(4);
    ListarProducto();
     LimpiarTable();
     jComboBox2.removeAllItems();
      ListarProducto();
     llenarProveedor();
     LimpiarProductos();
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnGuardarprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarprodActionPerformed
 if ("".equals(txtidprod.getText())) {
            JOptionPane.showMessageDialog(null, "ingresar todos los campos");
        } else {  
        if (!"".equals(txtidprod.getText()) ||!"".equals(txtnombreprod.getText()) || !"".equals(jComboBox2.getSelectedItem()) || !"".equals(txtcantidadpro.getText())|| !"".equals(txtprecioprod1.getText())|| !"".equals(txttipo.getText())|| !"".equals(txtdescrippro.getText())){
              
    pr.setId(Integer.parseInt(txtidprod.getText()));
    pr.setNombreprod(txtnombreprod.getText());
      Combo2 itemP2 = (Combo2) jComboBox2.getSelectedItem();
      pr.setProvedoor(itemP2.getIdProveedor());
      
   pr.setCantidad(Integer.parseInt(txtcantidadpro.getText()));
   pr.setPrecio(Double.parseDouble(txtprecioprod1.getText()));
   pr.setTipo(txttipo.getText());
   pr.setDescripro(txtdescrippro.getText());
   prDAO.RegistrarProductos(pr);
    LimpiarTable();
    ListarProducto();
    LimpiarProductos();
     jComboBox2.removeAllItems();
     llenarProveedor();
     JOptionPane.showMessageDialog(null, "Proveedor Registrado");
           }else{
             JOptionPane.showMessageDialog(null, "Campos Vacios");
           }
           
    }//GEN-LAST:event_btnGuardarprodActionPerformed
    }
    private void btnEliminarpro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarpro1ActionPerformed
        // TODO add your handling code here:
          if (!"".equals(txtidprod.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtidprod.getText());
                prDAO.EliminarProducto(id);
                LimpiarTable();
                LimpiarProductos();
                ListarProducto();
    }//GEN-LAST:event_btnEliminarpro1ActionPerformed
           }else{
                 JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar");
          }
    }
    private void txtnombreprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreprodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreprodActionPerformed

    private void btneditarpro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarpro1ActionPerformed
        // TODO add your handling code here:
         if ("".equals(txtidprod.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
         }else{
    if (!"".equals(txtnombreprod.getText()) ||  !"".equals(txtcantidadpro.getText())|| !"".equals(txtprecioprod1.getText())|| !"".equals(txttipo.getText())|| !"".equals(txtdescrippro.getText())){
  pr.setNombreprod(txtnombreprod.getText());
      Combo2 itemP2 = (Combo2) jComboBox2.getSelectedItem();
      pr.setProvedoor(itemP2.getIdProveedor());
      
   pr.setCantidad(Integer.parseInt(txtcantidadpro.getText()));
   pr.setPrecio(Double.parseDouble(txtprecioprod1.getText()));
   pr.setTipo(txttipo.getText());
   pr.setDescripro(txtdescrippro.getText());
   prDAO.ModificarProductos(pr);
     JOptionPane.showMessageDialog(null, "Producto/Servicio modificado");
     LimpiarTable();
                LimpiarProductos();
                ListarProducto();
                jComboBox2.removeAllItems();
                llenarProveedor();
                           }
         }
    }//GEN-LAST:event_btneditarpro1ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void TableprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableprodMouseClicked
        // TODO add your handling code here:
           int fila = Tableprod.rowAtPoint(evt.getPoint());
        txtidprod.setText(Tableprod.getValueAt(fila,0).toString());
        txtnombreprod.setText(Tableprod.getValueAt(fila,1).toString());
        jComboBox2.setSelectedItem(new Combo2 (pr.getProvedoor(), pr.getNombre()));
        txtcantidadpro.setText(Tableprod.getValueAt(fila,3).toString());
        txtprecioprod1.setText(Tableprod.getValueAt(fila,4).toString());
        txttipo.setText(Tableprod.getValueAt(fila,5).toString());
        txtdescrippro.setText(Tableprod.getValueAt(fila,6).toString());
    }//GEN-LAST:event_TableprodMouseClicked

    private void txtbuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar3ActionPerformed

        // TODO add your handling code here:
        filtrar4();
    }//GEN-LAST:event_txtbuscar3ActionPerformed

    private void txtbuscar3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar3KeyReleased

        // TODO add your handling code here:
        filtrar4();
    }//GEN-LAST:event_txtbuscar3KeyReleased

    private void txtIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpleadoActionPerformed

    private void btnGuardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEmpleadoActionPerformed
        // TODO add your handling code here:
           if (!"".equals(txtIdEmpleado.getText())|| !"".equals(txtNombreE.getText()) || !"".equals(txtApellidosE.getText()) || !"".equals(txtEdad1.getText())|!"".equals(txtSexoE.getText())|| !"".equals(txttelefonoE.getText()) || !"".equals(txtColoniaE.getText()) || !"".equals(txtCiudadE.getText()) || !"".equals(txtEstadoE.getText()) || !"".equals(txtCPE.getText()) || !"".equals(txtPuestoE.getText())|| !"".equals(txtHorarioE.getText())|| !"".equals(txtEmail2.getText())|| !"".equals(txtNumSeg.getText())) {
        em.setIdEmpleado(Integer.parseInt(txtIdEmpleado.getText()));
        em.setNombre(txtNombreE.getText());
        em.setApellidos(txtApellidosE.getText());
        em.setEdad(Integer.parseInt(txtEdad1.getText()));
        em.setSexo(txtSexoE.getText());
        em.setTelefono(txttelefonoE.getText());
         em.setColonia(txtColoniaE.getText());
        em.setCiudad(txtCiudadE.getText());
        em.setEstado(txtEstadoE.getText());
        em.setCP(Integer.parseInt(txtCPE.getText()));
        em.setPuesto(txtPuestoE.getText());
        em.setHorario(txtHorarioE.getText());
        em.setEmail(txtEmail2.getText());
        em.setNumSeg(txtNumSeg.getText());
        emDAO.RegistrarEmpleado(em);
        LimpiarTable();
   ListarEmpleados();
   LimpiarEmpleado();
   
        JOptionPane.showMessageDialog(null, "Empleado Registrado");
       }else{
               JOptionPane.showMessageDialog(null, "Los Campos estan vacios");
               }
   
                LimpiarEmpleado();
                
    }//GEN-LAST:event_btnGuardarEmpleadoActionPerformed

    private void btnEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEActionPerformed
        // TODO add your handling code here:
          if (!"".equals(txtIdEmpleado.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdEmpleado.getText());
               emDAO.EliminarEmpleado(id);
                LimpiarTable();
                LimpiarEmpleado();
                ListarEmpleados();
            }
           
           
    }else{
                 JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar");
          }
          
    }//GEN-LAST:event_btnEliminarEActionPerformed

    private void btnEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoActionPerformed
        // TODO add your handling code here
        if ("".equals(txtIdEmpleado.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {
           if ( !"".equals(txtNombreE.getText()) || !"".equals(txtApellidosE.getText()) || !"".equals(txtEdad1.getText())|!"".equals(txtSexoE.getText())|| !"".equals(txttelefonoE.getText()) || !"".equals(txtColoniaE.getText()) || !"".equals(txtCiudadE.getText()) || !"".equals(txtEstadoE.getText()) || !"".equals(txtCPE.getText()) || !"".equals(txtPuestoE.getText())|| !"".equals(txtHorarioE.getText())|| !"".equals(txtEmail2.getText())|| !"".equals(txtNumSeg.getText())) {
        em.setNombre(txtNombreE.getText());
        em.setApellidos(txtApellidosE.getText());
        em.setEdad(Integer.parseInt(txtEdad1.getText()));
        em.setSexo(txtSexoE.getText());
        em.setTelefono(txttelefonoE.getText());
         em.setColonia(txtColoniaE.getText());
        em.setCiudad(txtCiudadE.getText());
        em.setEstado(txtEstadoE.getText());
        em.setCP(Integer.parseInt(txtCPE.getText()));
        em.setPuesto(txtPuestoE.getText());
        em.setHorario(txtHorarioE.getText());
        em.setEmail(txtEmail2.getText());
        em.setNumSeg(txtNumSeg.getText());
         em.setIdEmpleado(Integer.parseInt(txtIdEmpleado.getText()));
      
        emDAO.ModificarEmpleado(em);
         JOptionPane.showMessageDialog(null, "Cliente Modificado");
                LimpiarTable();
                LimpiarEmpleado();
                ListarEmpleados();
                 } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
         
    }                            
    }//GEN-LAST:event_btnEditarEmpleadoActionPerformed

    private void txtNombreEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEActionPerformed

    private void txtCiudadEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadEActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ListarEmpleados();
        jTabbedPane1.setSelectedIndex(5);
        LimpiarTable();
        LimpiarEmpleado();
          ListarEmpleados();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTableEmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmMouseClicked
        // TODO add your handling code here:
         int fila = jTableEm.rowAtPoint(evt.getPoint());
        txtIdEmpleado.setText(jTableEm.getValueAt(fila, 0).toString());
        txtNombreE.setText(jTableEm.getValueAt(fila, 1).toString());
        txtApellidosE.setText(jTableEm.getValueAt(fila, 2).toString());
        txtEdad1.setText(jTableEm.getValueAt(fila, 3).toString());
        txtSexoE.setText(jTableEm.getValueAt(fila, 4).toString());
        txttelefonoE.setText(jTableEm.getValueAt(fila, 5).toString());
        txtColoniaE.setText(jTableEm.getValueAt(fila, 6).toString());
        txtCiudadE.setText(jTableEm.getValueAt(fila, 7).toString());
        txtEstadoE.setText(jTableEm.getValueAt(fila, 8).toString());
        txtCPE.setText(jTableEm.getValueAt(fila, 9).toString());
          txtPuestoE.setText(jTableEm.getValueAt(fila, 10).toString());
            txtHorarioE.setText(jTableEm.getValueAt(fila, 11).toString());
        txtEmail2.setText(jTableEm.getValueAt(fila, 12).toString());
          txtNumSeg.setText(jTableEm.getValueAt(fila, 13).toString());
    }//GEN-LAST:event_jTableEmMouseClicked

    private void txtbuscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar4ActionPerformed
        // TODO add your handling code here:
        filtrar5();
    }//GEN-LAST:event_txtbuscar4ActionPerformed

    private void txtbuscar4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar4KeyReleased
        // TODO add your handling code here:
        filtrar5();
    }//GEN-LAST:event_txtbuscar4KeyReleased

    private void btniniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciarActionPerformed
        // TODO add your handling code here:
            if(txtNombreU.getText().equals("") || txtCorreoU.getText().equals("") || txtPass.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "Todo los campos son requeridos");
        }else{
            String correo = txtCorreoU.getText();
            String pass = String.valueOf(txtPass.getPassword());
            String nom = txtNombre.getText();
            String rol = cbxRol.getSelectedItem().toString();
            lg.setNombre(nom);
            lg.setCorreo(correo);
            lg.setPass(pass);
            lg.setRol(rol);
            login.Registrar(lg);
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            LimpiarTable();
            ListarUsuarios();
            nuevoUsuario();
    }//GEN-LAST:event_btniniciarActionPerformed
    }
    private void btnEditarUsuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnEditarUsuItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarUsuItemStateChanged

    private void btnEditarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuActionPerformed
         if(txtIdU.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Todo los campos son requeridos");
         }else{
        if(txtIdU.getText().equals("") ||txtNombreU.getText().equals("") || txtCorreoU.getText().equals("") || txtPass.getPassword().equals("")){
              lg.setId(Integer.parseInt(txtIdU.getText()));
            String correo = txtCorreoU.getText();
            String pass = String.valueOf(txtPass.getPassword());
            String nom = txtNombreU.getText();
            String rol = cbxRol.getSelectedItem().toString();
            lg.setNombre(nom);
            lg.setCorreo(correo);
            lg.setPass(pass);
            lg.setRol(rol);
            login.ModificarUsu(lg);
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            LimpiarTable();
            ListarUsuarios();
            nuevoUsuario();    
         
        
                 }else{
            JOptionPane.showMessageDialog(null, "Necesita selecionar un campo para editar");
        }
                 
                 }
    }//GEN-LAST:event_btnEditarUsuActionPerformed

    private void txtNombreUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUActionPerformed

    private void txtCorreoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoUActionPerformed

    private void cbxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        ListarUsuarios();
         jTabbedPane1.setSelectedIndex(6);
         LimpiarTable();
          ListarUsuarios();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void btnEliminarUsuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnEliminarUsuItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarUsuItemStateChanged

    private void btnEliminarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuActionPerformed
        // TODO add your handling code here:
           if (!"".equals(txtIdU.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdU.getText());
               login.EliminarProveedor(id);
             LimpiarTable();
            ListarUsuarios();
            nuevoUsuario();
            }
           }else{
                  JOptionPane.showMessageDialog(null, "Selecione una fila para eliminar ");
           }
    }//GEN-LAST:event_btnEliminarUsuActionPerformed

    private void jTableUsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuMouseClicked
        // TODO add your handling code here:
         int fila = jTableUsu.rowAtPoint(evt.getPoint());
         txtIdU.setText(jTableUsu.getValueAt(fila, 0).toString());
        txtNombreU.setText(jTableUsu.getValueAt(fila, 1).toString());
        txtCorreoU.setText(jTableUsu.getValueAt(fila, 2).toString());
        txtPass.setText(jTableUsu.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_jTableUsuMouseClicked

    private void txtIdUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUActionPerformed

    private void txtCodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVentaActionPerformed

    private void txtCodigoVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyPressed
           if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCodigoVenta.getText())) {
                String cod = txtCodigoVenta.getText();
                pr = prDAO.BuscarPro(cod);
                if (pr.getNombre() != null) {
                    txtIdPro.setText("" + pr.getId());
                    txtNombreVenta.setText("" + pr.getNombre());
                    txtDescripcionVenta1.setText("" + pr.getDescripro());
                    txtPrecioVenta.setText("" + pr.getPrecio());
                    txtStockDisponible.setText("" + pr.getCantidad());
                    txtCantidadVenta.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Este Producto no existe");
                txtCodigoVenta.requestFocus();
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este Producto no existe");
                txtCodigoVenta.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoVentaKeyPressed

    private void txtCodigoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
        if(txtCodigoVenta.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtCodigoVentaKeyTyped

    private void txtCantidadVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCantidadVenta.getText())) {
                int id = Integer.parseInt(txtIdPro.getText());
                String Nombre = txtNombreVenta.getText();
                   String Descripcion = txtDescripcionVenta1.getText();
                int cant = Integer.parseInt(txtCantidadVenta.getText());
                double precio = Double.parseDouble(txtPrecioVenta.getText());
                double total = cant * precio;
                int stock = Integer.parseInt(txtStockDisponible.getText());
                if (stock >= cant) {
                    item = item + 1;
                        tmp = (DefaultTableModel) TableVenta.getModel();
                    for (int i = 0; i < TableVenta.getRowCount(); i++) {
                        if (TableVenta.getValueAt(i, 1).equals(txtNombreVenta.getText())) {
                            JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                            return;
                        }
                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(id);
                    lista.add(Nombre);
                    lista.add(Descripcion);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(total);
                    Object[] O = new Object[6];
                    O[0] = lista.get(1);
                    O[1] = lista.get(2);
                    O[2] = lista.get(3);
                    O[3] = lista.get(4);
                    O[4] = lista.get(5);
                     O[5] = lista.get(6);
                    tmp.addRow(O);
                    TableVenta.setModel(tmp);
                     TotalPagar();
                    LimparVenta();
                    txtCodigoVenta.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
            }
        }
    }//GEN-LAST:event_txtCantidadVentaKeyPressed

    private void txtCantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
         if(txtCantidadVenta.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtCantidadVentaKeyTyped

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        // TODO add your handling code here:
        if (TableVenta.getRowCount() > 0){
        modelo = (DefaultTableModel) TableVenta.getModel();
        modelo.removeRow(TableVenta.getSelectedRow());
        TotalPagar();
        txtCodigoVenta.requestFocus();
        }else{
        JOptionPane.showMessageDialog(null, "Sleccione un campo para eliminar");
        }
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void txtRucVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucVentaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtRucVenta.getText())) {
                int dni = Integer.parseInt(txtRucVenta.getText());
                cl = client.Buscarcliente(dni);
                if (cl.getNombre() != null) {
                    txtNombreClienteventa.setText("" + cl.getNombre());
                    txtIdCV.setText("" + cl.getIdCliente());
                    txtApellidoClienteventa.setText("" + cl.getApellidos());
                } else {
                    txtRucVenta.setText("");
                    txtRucVenta.requestFocus();
                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                }
            }else{
                         
            }
        }
    }//GEN-LAST:event_txtRucVentaKeyPressed

    private void txtRucVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucVentaKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
         if(txtRucVenta.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtRucVentaKeyTyped

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        // TODO add your handling code here:
        if (TableVenta.getRowCount() > 0) {
            if (!"".equals(txtNombreClienteventa.getText())) {
                RegistrarVenta();
                RegistrarDetalle();
                ActualizarStock();
                 LimpiarTableVenta();
                  LimpiarClienteventa();
                  JOptionPane.showMessageDialog(null, "Venta Realizada");
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Debes buscar un cliente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Noy productos en la venta");
        }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
     ListarVentas();
        jTabbedPane1.setSelectedIndex(7);
      LimpiarTable();
      ListarVentas();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtIdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdVentaActionPerformed
        // TODO add your handling code here
      
    }//GEN-LAST:event_txtIdVentaActionPerformed

    private void txtIdVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdVentaMouseClicked
        // TODO add your handling code here:
              
    }//GEN-LAST:event_txtIdVentaMouseClicked

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
         if(txtIdVenta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        }else{
            v = Vdao.BuscarVenta(Integer.parseInt(txtIdVenta.getText()));
            Vdao.pdfV(v.getId(), v.getCliente(), v.getTotal(), v.getVendedor());
        }
    }//GEN-LAST:event_btnVentasActionPerformed

    private void TableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableVentasMouseClicked
        // TODO add your handling code here:
          int fila = TableVentas.rowAtPoint(evt.getPoint());
               txtIdVenta.setText(TableVentas.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_TableVentasMouseClicked

    private void txtbuscar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar5ActionPerformed
        // TODO add your handling code here:
        filtrar6();
    }//GEN-LAST:event_txtbuscar5ActionPerformed

    private void txtbuscar5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar5KeyReleased
        // TODO add your handling code here:
         filtrar6();
    }//GEN-LAST:event_txtbuscar5KeyReleased

    private void txtbuscar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar6ActionPerformed
     filtrar7();
    }//GEN-LAST:event_txtbuscar6ActionPerformed

    private void txtbuscar6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar6KeyReleased
        filtrar7();
    }//GEN-LAST:event_txtbuscar6KeyReleased

    private void txtIdClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
         if(txtIdCliente.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtIdClienteKeyTyped

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        // TODO add your handling code here:
          event.numberKeyPress(evt);
           if(txtEdad.getText().length() >= 2)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
          event.numberKeyPress(evt);
           if(txtTelefono.getText().length() >= 10)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPKeyTyped
        // TODO add your handling code here:
          event.numberKeyPress(evt);
           if(txtCP.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtCPKeyTyped

    private void txtidmascotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidmascotaKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtidmascota.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtidmascotaKeyTyped

    private void txtedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedadKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtedad.getText().length() >= 2)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtedadKeyTyped

    private void txtidprovKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidprovKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtidprov.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtidprovKeyTyped

    private void txttelefonoproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoproKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txttelefonopro.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txttelefonoproKeyTyped

    private void txtcodproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodproKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtcodpro.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtcodproKeyTyped

    private void txtidprodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidprodKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtidprod.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtidprodKeyTyped

    private void txtprecioprod1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioprod1KeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtprecioprod1.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtprecioprod1KeyTyped

    private void txtIdEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdEmpleadoKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtIdEmpleado.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtIdEmpleadoKeyTyped

    private void txtEdad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdad1KeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtEdad1.getText().length() >= 2)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtEdad1KeyTyped

    private void txtCPEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPEKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtCPE.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtCPEKeyTyped

    private void txtNumSegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSegKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtNumSeg.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtNumSegKeyTyped

    private void txtIdUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdUKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtIdU.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtIdUKeyTyped

    private void txtcantidadproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadproKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
          if(txtcantidadpro.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txtcantidadproKeyTyped

    private void txtNombreClienteventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteventaActionPerformed

    private void txtNombreVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreVentaActionPerformed

    private void txttelefonoEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoEKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt); 
        if(txttelefonoE.getText().length() >= 8)
         {
             evt.consume();
         }
    }//GEN-LAST:event_txttelefonoEKeyTyped

    private void txttelefonoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoEActionPerformed
private void filtrar1(){
    try{
       sorter.setRowFilter(RowFilter.regexFilter(txtbuscar.getText()));
    }catch (Exception e){
        
        
    }
}
private void filtrar2(){
    try{
       sorter.setRowFilter(RowFilter.regexFilter(txtbuscar1.getText()));
    }catch (Exception e){
        
    }   
    }
private void filtrar3(){
    try{
       sorter.setRowFilter(RowFilter.regexFilter(txtbuscar2.getText()));
    }catch (Exception e){
        
    }   
    }
private void filtrar4(){
    try{
       sorter.setRowFilter(RowFilter.regexFilter(txtbuscar3.getText()));
    }catch (Exception e){
        
    }   
    }
private void filtrar5(){
    try{
       sorter.setRowFilter(RowFilter.regexFilter(txtbuscar4.getText()));
    }catch (Exception e){
    }
}
private void filtrar6(){
    try{
       sorter.setRowFilter(RowFilter.regexFilter(txtbuscar5.getText()));
    }catch (Exception e){
    }
}
private void filtrar7(){
    try{
       sorter.setRowFilter(RowFilter.regexFilter(txtbuscar6.getText()));
    }catch (Exception e){
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelVendedor;
    private javax.swing.JTable TableCliente;
    private javax.swing.JTable TableMascota;
    private javax.swing.JTable TableVenta;
    private javax.swing.JTable TableVentas;
    private javax.swing.JTable Tableprod;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarEmpleado;
    private javax.swing.JButton btnEditarMascota;
    private javax.swing.JButton btnEditarUsu;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnEliminarMascota;
    private javax.swing.JButton btnEliminarUsu;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnEliminarpro;
    private javax.swing.JButton btnEliminarpro1;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarEmpleado;
    private javax.swing.JButton btnGuardarMascota;
    private javax.swing.JButton btnGuardarpro;
    private javax.swing.JButton btnGuardarprod;
    private javax.swing.JButton btnProv;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btneditarpro;
    private javax.swing.JButton btneditarpro1;
    private javax.swing.JButton btniniciar;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<Object> jComboBox1;
    private javax.swing.JComboBox<Object> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableEm;
    private javax.swing.JTable jTableUsu;
    private javax.swing.JTable tablepro;
    private javax.swing.JTextField txtApellidoClienteventa;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosE;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtCPE;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCiudadE;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtColoniaE;
    private javax.swing.JTextField txtCorreoU;
    private javax.swing.JTextField txtDescripcionVenta1;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEdad1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstadoE;
    private javax.swing.JTextField txtFechaDeNacimiento;
    private javax.swing.JTextField txtHorarioE;
    private javax.swing.JTextField txtIdCV;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdPro;
    private javax.swing.JTextField txtIdU;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreClienteventa;
    private javax.swing.JTextField txtNombreE;
    private javax.swing.JTextField txtNombreU;
    private javax.swing.JTextField txtNombreVenta;
    private javax.swing.JTextField txtNumSeg;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtPuestoE;
    private javax.swing.JTextField txtRucVenta;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoE;
    private javax.swing.JTextField txtStockDisponible;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtapellidospro;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtbuscar1;
    private javax.swing.JTextField txtbuscar2;
    private javax.swing.JTextField txtbuscar3;
    private javax.swing.JTextField txtbuscar4;
    private javax.swing.JTextField txtbuscar5;
    private javax.swing.JTextField txtbuscar6;
    private javax.swing.JTextField txtcantidadpro;
    private javax.swing.JTextField txtciudadpro;
    private javax.swing.JTextField txtcodpro;
    private javax.swing.JTextField txtcoloniapro;
    private javax.swing.JTextField txtcolor;
    private javax.swing.JTextField txtcorreopro;
    private javax.swing.JTextField txtdescripcionani;
    private javax.swing.JTextField txtdescrippro;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtestadopro1;
    private javax.swing.JTextField txtidmascota;
    private javax.swing.JTextField txtidprod;
    private javax.swing.JTextField txtidprov;
    private javax.swing.JTextField txtnombremas;
    private javax.swing.JTextField txtnombrepro;
    private javax.swing.JTextField txtnombreprod;
    private javax.swing.JTextField txtprecioprod1;
    private javax.swing.JTextField txtraza;
    private javax.swing.JTextField txttamano;
    private javax.swing.JTextField txttelefonoE;
    private javax.swing.JTextField txttelefonopro;
    private javax.swing.JTextField txttipo;
    // End of variables declaration//GEN-END:variables

    private void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
  private void LimpiarEmpleado() {
        txtIdEmpleado.setText("");
       txtNombreE.setText("");
        txtApellidosE.setText("");
        txtEdad1.setText("");
        txtSexoE.setText("");
        txttelefonoE.setText("");
        txtColoniaE.setText("");
        txtCiudadE.setText("");
        txtEstadoE.setText("");
       txtCPE.setText("");
       txtPuestoE.setText("");
       txtHorarioE.setText("");
        txtEmail2.setText("");
        txtNumSeg.setText("");
    }
    private void LimpiarCliente() {
        
        
        txtIdCliente.setText("");
       txtNombre.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        txtFechaDeNacimiento.setText("");
        txtSexo.setText("");
        txtTelefono.setText("");
        txtColonia.setText("");
        txtCiudad.setText("");
        txtEstado.setText("");
       txtCP.setText("");
        txtEmail.setText("");
    }
      private void llenarProveedor() {
        List<Proveedor> lista = prod.ListarProveedor();
        for (int i = 0; i < lista.size(); i++) {
            int IdProveedor = lista.get(i).getIdProveedor();
            String Nombre = lista.get(i).getNombre();
            jComboBox2.addItem(new Combo2(IdProveedor,Nombre));
        }
    }
   
 private void LimpiarMascota() {
        txtidmascota.setText("");
       jComboBox1.setSelectedItem(null);
        txtnombremas.setText("");
        txtraza.setText("");
        txtcolor.setText("");
        txtedad.setText("");
        txttamano.setText("");
                txtdescripcionani.setText("");
    }
 private void LimpiarProductos() {
        txtidprod.setText("");
        txtnombreprod.setText("");
       jComboBox2.setSelectedItem(null);
        txtcantidadpro.setText("");
        txtprecioprod1.setText("");
        txttipo.setText("");
        txtdescrippro.setText("");
        
    }
   private void llenarcliente() {
        List<Cliente> lista = client.ListarCliente();
        for (int i = 0; i < lista.size(); i++) {
            int IdCliente = lista.get(i).getIdCliente();
            String Nombre = lista.get(i).getNombre();
            jComboBox1.addItem(new Combo(IdCliente, Nombre));
        }
        
    }
   public void LimpiarProveedor(){
       txtidprov.setText("");
       txtnombrepro.setText("");
       txtapellidospro.setText("");
       txttelefonopro.setText("");
       txtciudadpro.setText("");
       txtcorreopro.setText("");
       txtcoloniapro.setText("");
      txtestadopro1.setText("");
      txtcodpro.setText("");
       
        
       
   }
   public void ListarUsuarios() {
        List<login> Listar = login.ListarUsuarios();
        modelo = (DefaultTableModel) jTableUsu.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId();
            ob[1] = Listar.get(i).getNombre();
            ob[2] = Listar.get(i).getCorreo();
              ob[3] = Listar.get(i).getPass();
            ob[4] = Listar.get(i).getRol();
            modelo.addRow(ob);
        
        jTableUsu.setModel(modelo);
         jTableUsu.setAutoCreateRowSorter(true);
         sorter = new TableRowSorter<>(modelo);
      jTableUsu.setRowSorter(sorter);
        }
      jTableUsu.setModel(modelo);

}
     private void nuevoUsuario(){
         txtIdU.setText("");
        txtNombreU.setText("");
        txtCorreoU.setText("");
        txtPass.setText("");
    }
      private void TotalPagar() {
        Totalpagar = 0.00;
        int numFila = TableVenta.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(TableVenta.getModel().getValueAt(i, 5)));
            Totalpagar = Totalpagar + cal;
        }
        LabelTotal.setText(String.format("%.2f", Totalpagar));
    }
          private void LimparVenta() {
        txtCodigoVenta.setText("");
        txtNombreVenta.setText("");
        txtDescripcionVenta1.setText("");
        txtCantidadVenta.setText("");
        txtStockDisponible.setText("");
        txtPrecioVenta.setText("");
        
    }

  
    
    private void RegistrarVenta(){
         
          int cliente = Integer.parseInt(txtIdCV.getText());
        String vendedor = LabelVendedor.getText();
        double monto = Totalpagar;
        v.setCliente(cliente);
        v.setVendedor(vendedor);
        v.setTotal(monto);
        v.setFecha(fechaActual);
        Vdao.RegistrarVenta(v);
    }
       private void RegistrarDetalle() {
        int id = Vdao.IdVenta();
        for (int i = 0; i < TableVenta.getRowCount(); i++) {
            int id_pro = Integer.parseInt(TableVenta.getValueAt(i, 0).toString());
            int cant = Integer.parseInt(TableVenta.getValueAt(i, 3).toString());
            double precio = Double.parseDouble(TableVenta.getValueAt(i, 4).toString());
            Dv.setId_pro(id_pro);
            Dv.setCantidad(cant);
            Dv.setPrecio(precio);
            Dv.setId(id);
            Vdao.RegistrarDetalle(Dv);

            
        }
        
         int cliente = Integer.parseInt(txtIdCV.getText());
        Vdao.pdfV(id, cliente, Totalpagar, LabelVendedor.getText());
        
    }
         private void ActualizarStock() {
        for (int i = 0; i < TableVenta.getRowCount(); i++) {
            int id = Integer.parseInt(TableVenta.getValueAt(i, 0).toString());
            int cant = Integer.parseInt(TableVenta.getValueAt(i, 3).toString());
            pr = prDAO.BuscarId(id);
            int StockActual = pr.getCantidad() - cant;
            Vdao.ActualizarStock(StockActual, id);
}
         }
          private void LimpiarTableVenta() {
        tmp = (DefaultTableModel) TableVenta.getModel();
        int fila = TableVenta.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
          }
             private void LimpiarClienteventa() {
        txtRucVenta.setText("");
        txtNombreClienteventa.setText("");
        txtApellidoClienteventa.setText("");
        txtIdCV.setText("");
         }
}

