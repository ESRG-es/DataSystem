/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package esrg.ventana;

import java.sql.*;
import clases.Conexion;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font;
//import com.itextpdf.text.Image;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import java.util.Calendar;

/**
 *
 * @author ESRG
 */
public class InformacionCliente extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel();
    Calendar calendar = Calendar.getInstance();
    public static int table_update;
    
    public static String nombre_cliente, email_cliente, dir_cliente, phone_cliente;

    /**
     * Creates new form InformacionCliente
     */
    public InformacionCliente() {
        initComponents();
        
        setTitle("Data System | Información cliente");
        setResizable(false);
        setLocationRelativeTo(null);
        lbl_footer.setText(Login.footer);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        ImageIcon image_wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon wallpaper = new ImageIcon(image_wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(), lbl_wallpaper.getHeight(),
                Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(wallpaper);
        
        ImageIcon image_icon = new ImageIcon("src/images/informationuser.png");
        Icon icono = new ImageIcon(image_icon.getImage().getScaledInstance(lbl_icon.getWidth(), lbl_icon.getHeight(), Image.SCALE_DEFAULT));
        lbl_icon.setIcon(icono);
        
        this.repaint();
        
        lbl_userEdit.setText("ID de cliente: " + GestionarCliente.table_update);
        lbl_ModificadoPor.setText("Modificado por: " + Login.username);
        try{
            Connection cn = Conexion.conexion();
            PreparedStatement ps = cn.prepareStatement(
                    "select nombre_cliente, email_cliente, tel_cliente, "
                            + "dir_cliente, ultima_modificacion from clientes where id_cliente = '" + GestionarCliente.table_update + "'");
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                fld_name.setText(rs.getString("nombre_cliente"));
                nombre_cliente = fld_name.getText().trim();
                fld_email.setText(rs.getString("email_cliente"));
                email_cliente = fld_email.getText().trim();
                fld_phone.setText(rs.getString("tel_cliente"));
                phone_cliente = fld_phone.getText().trim();
                fld_dir.setText(rs.getString("dir_cliente"));
                dir_cliente = fld_dir.getText().trim();
                lbl_UltimaModificacion.setText("Última modificación: " + rs.getString("ultima_modificacion"));
            }
            
            cn.close();
        } catch(SQLException er){
            System.err.println("Error: " + er);
            
        }
        
        try {
            Connection cn = Conexion.conexion();
            PreparedStatement ps = cn.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + GestionarCliente.table_update + "'");
            
            ResultSet rs = ps.executeQuery();
            
            tbl_equipos = new JTable(model);
            jScrollPane1.setViewportView(tbl_equipos);
            
            model.addColumn("ID equipo");
            model.addColumn("Tipo de equipo");
            model.addColumn("Marca");
            model.addColumn("Estado");
            
            while(rs.next()){
                Object [] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();
            
        } catch (SQLException er) {
            System.err.println("Error: " + er);
        }
        
        tbl_equipos.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                int fila_point = tbl_equipos.rowAtPoint(ev.getPoint());
                int columna_point = 0;
                
                if(fila_point > -1){
                    table_update = (int) model.getValueAt(fila_point, columna_point);
                    InformacionEquipo window = new InformacionEquipo();
                    window.setVisible(true); 
                }
            }
        });
        
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_title = new javax.swing.JLabel();
        lbl_icon = new javax.swing.JLabel();
        lbl_userEdit = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        fld_name = new javax.swing.JTextField();
        fld_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        lbl_phone = new javax.swing.JLabel();
        fld_phone = new javax.swing.JTextField();
        lbl_dir = new javax.swing.JLabel();
        fld_dir = new javax.swing.JTextField();
        bttn_actualizarUsuario = new javax.swing.JButton();
        lbl_footer = new javax.swing.JLabel();
        bttn_agregarEquipo = new javax.swing.JButton();
        lbl_UltimaModificacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_equipos = new javax.swing.JTable();
        bttn_creatividad2 = new javax.swing.JButton();
        lbl_ModificadoPor = new javax.swing.JLabel();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_title.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Información de cliente");
        getContentPane().add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));
        getContentPane().add(lbl_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 80));

        lbl_userEdit.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lbl_userEdit.setForeground(new java.awt.Color(255, 255, 255));
        lbl_userEdit.setText("Nombre de usuario");
        getContentPane().add(lbl_userEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        lbl_name.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_name.setText("Nombre");
        getContentPane().add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 180, -1));

        fld_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fld_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(fld_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 180, 20));

        fld_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fld_email.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(fld_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 180, 20));

        lbl_email.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_email.setText("Correo electrónico");
        getContentPane().add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 180, -1));

        lbl_phone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_phone.setForeground(new java.awt.Color(255, 255, 255));
        lbl_phone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_phone.setText("Teléfono");
        getContentPane().add(lbl_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 120, -1));

        fld_phone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fld_phone.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(fld_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 180, 20));

        lbl_dir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_dir.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_dir.setText("Dirección");
        getContentPane().add(lbl_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 180, -1));

        fld_dir.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fld_dir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(fld_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 180, 20));

        bttn_actualizarUsuario.setBackground(new java.awt.Color(63, 84, 147));
        bttn_actualizarUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bttn_actualizarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        bttn_actualizarUsuario.setText("Actualizar usuario");
        bttn_actualizarUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bttn_actualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_actualizarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(bttn_actualizarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 390, 30));

        lbl_footer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_footer.setText("Powered by: ESRG © 2024");
        getContentPane().add(lbl_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 580, -1));

        bttn_agregarEquipo.setBackground(new java.awt.Color(63, 84, 147));
        bttn_agregarEquipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bttn_agregarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        bttn_agregarEquipo.setText("Agregar equipo");
        bttn_agregarEquipo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bttn_agregarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_agregarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(bttn_agregarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 390, 30));

        lbl_UltimaModificacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lbl_UltimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UltimaModificacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_UltimaModificacion.setText("Última modificación: ");
        getContentPane().add(lbl_UltimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 390, -1));

        tbl_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_equipos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 390, 130));

        bttn_creatividad2.setBackground(new java.awt.Color(63, 84, 147));
        bttn_creatividad2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        bttn_creatividad2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bttn_creatividad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_creatividad2ActionPerformed(evt);
            }
        });
        getContentPane().add(bttn_creatividad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 180, 80));

        lbl_ModificadoPor.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lbl_ModificadoPor.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ModificadoPor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_ModificadoPor.setText("Modificado por:");
        getContentPane().add(lbl_ModificadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 390, -1));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttn_actualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_actualizarUsuarioActionPerformed
        
        String name = fld_name.getText().trim();
        String email = fld_email.getText().trim();
        String phone = fld_phone.getText().trim();
        String dir = fld_dir.getText().trim();
        
        int error = 0;
        
        if(name.equals("")){
            fld_name.setBorder(BorderFactory.createLineBorder(new Color(180,0,0), 1));
            error++;
        } else {
            fld_name.setBorder(BorderFactory.createLineBorder(new Color(0,180,0), 1));
        }
        
        if(email.equals("")){
            fld_email.setBorder(BorderFactory.createLineBorder(new Color(180,0,0), 1));
            error++;
        } else {
            fld_email.setBorder(BorderFactory.createLineBorder(new Color(0,180,0), 1));
        }
        
        if(phone.equals("")){
            fld_phone.setBorder(BorderFactory.createLineBorder(new Color(180,0,0), 1));
            error++;
        } else {
            fld_phone.setBorder(BorderFactory.createLineBorder(new Color(0,180,0), 1));
        }
        
        if(dir.equals("")){
            fld_dir.setBorder(BorderFactory.createLineBorder(new Color(180,0,0), 1));
            error++;
        } else {
            fld_dir.setBorder(BorderFactory.createLineBorder(new Color(0,180,0), 1));
        }
        
        if(error != 0){
            javax.swing.JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados");
        } else {
            try {
                Connection cn = Conexion.conexion();
                PreparedStatement ps = cn.prepareStatement("update clientes set nombre_cliente = ?, email_cliente = ?, tel_cliente = ?,"
                        + "dir_cliente = ?, ultima_modificacion = ? where id_cliente = '" + GestionarCliente.table_update + "'");
                
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.setString(4, dir);
                ps.setString(5, Login.username);
                
                ps.executeUpdate();
                
                javax.swing.JOptionPane.showMessageDialog(null, "Datos del cliente actualizados correctamente");
                
                cn.close();
                
                dispose();
                
            } catch(SQLException er){
                System.out.println("Error: " + er);
            }
        }
        
    }//GEN-LAST:event_bttn_actualizarUsuarioActionPerformed

    private void bttn_agregarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_agregarEquipoActionPerformed
        new RegistroEquipo().setVisible(true);
    }//GEN-LAST:event_bttn_agregarEquipoActionPerformed

    private void bttn_creatividad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_creatividad2ActionPerformed
        
        Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + nombre_cliente + ".pdf"));
            
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);            
            
            Paragraph parrafo1 = new Paragraph();
            parrafo1.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo1.setFont(FontFactory.getFont("Arial", 14, Font.NORMAL, BaseColor.BLACK));
            parrafo1.add("Fecha: " + calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + 
                    calendar.get(Calendar.YEAR) + "\n\n"
                            + "Este reporte pertenece al cliente con número de identificación: " + GestionarCliente.table_update + " \n\n"
                                    + "  Nombre:     " + nombre_cliente + "\n"
                                    + "  Email:        " + email_cliente + "\n"
                                    + "  Teléfono:   " + phone_cliente + "\n"
                                    + "  Dirección:  " + dir_cliente + "\n\n"
                            + "La siguiente lista de equipos forma parte del registro de solicitud de reparación asociado al cliente, e incluye tanto los "
                            + "dispositivos reportados para revisión y mantenimiento como aquellos antiguos que ya han sido revisados previamente \n  ");   
            
            documento.open();
            
            documento.add(header);
            documento.add(parrafo1);
            
            PdfPTable tabla_equipos = new PdfPTable(5);
            tabla_equipos.addCell("ID");
            tabla_equipos.addCell("Tipo");
            tabla_equipos.addCell("Marca");
            tabla_equipos.addCell("Estado");
            tabla_equipos.addCell("Fecha de ingreso");
            
            try {
                Connection cn = Conexion.conexion();
                PreparedStatement ps = cn.prepareStatement("select * from equipos where id_cliente = '" + GestionarCliente.table_update + "'");
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    do {
                        tabla_equipos.addCell(rs.getString("id_equipo"));
                        tabla_equipos.addCell(rs.getString("tipo_equipo"));
                        tabla_equipos.addCell(rs.getString("marca"));
                        tabla_equipos.addCell(rs.getString("estatus"));      
                        tabla_equipos.addCell(rs.getString("dia_ingreso") + "/" + rs.getString("mes_ingreso") + "/" + rs.getString("annio_ingreso"));
                        
                    } while(rs.next());
                    
                    documento.add(tabla_equipos);
                    
                }
                
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
            
            documento.close();
            javax.swing.JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");
            
        } catch (DocumentException | IOException e) {
            System.out.println("Error " + e);
        }
    }//GEN-LAST:event_bttn_creatividad2ActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttn_actualizarUsuario;
    private javax.swing.JButton bttn_agregarEquipo;
    private javax.swing.JButton bttn_creatividad2;
    private javax.swing.JTextField fld_dir;
    private javax.swing.JTextField fld_email;
    private javax.swing.JTextField fld_name;
    private javax.swing.JTextField fld_phone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_ModificadoPor;
    private javax.swing.JLabel lbl_UltimaModificacion;
    private javax.swing.JLabel lbl_dir;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_footer;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_phone;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_userEdit;
    private javax.swing.JLabel lbl_wallpaper;
    private javax.swing.JTable tbl_equipos;
    // End of variables declaration//GEN-END:variables
}
