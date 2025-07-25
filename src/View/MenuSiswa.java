/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Main.Koneksi;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class MenuSiswa extends javax.swing.JPanel {

    /**
     * Creates new form MenuSiswa
     */
    public MenuSiswa() {
        initComponents();
        Reset();
        load_tabel_siswa();
        comboKelas();
    }

    void Reset() {
        tf_Nis.setText(null);
        tf_Nis.setEditable(true);
        tf_Nama.setText(null);
        cb_Jk.setSelectedItem(null);
        tf_TempatLahir.setText(null);
        dc_TglLahir.setCalendar(null);
        tf_Hp.setText(null);
        cb_Kelas.setSelectedItem(null);
        tf_Alamat.setText(null);
        lb_Foto.setIcon(null);
        lb_Foto.setText("Foto");
        lb_FotoPath.setText(null);
    }

    void comboKelas() {
        try {
            String sql = "SELECT * FROM kelas";
            Connection conn = Koneksi.konek();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                cb_Kelas.addItem(resultSet.getString("id_kelas"));
            }
        } catch (SQLException sQLException) {
        }
        cb_Kelas.setSelectedItem(null);
    }

    void load_tabel_siswa() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("NIS");
        model.addColumn("Nama Siswa");
        model.addColumn("L/P");
        model.addColumn("Tempat Lahir");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Kelas");
        model.addColumn("HP");

        String sql = "SELECT * FROM siswa";
        try {
            Connection conn = Koneksi.konek();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nis = rs.getString("nis");
                String namaSiswa = rs.getString("nama_siswa");
                String jenisKelamin = rs.getString("gender");
                String tempatLahir = rs.getString("tempat_lahir");
                String tglLahir = rs.getString("tgl_lahir");
                String kelas = rs.getString("id_kelas");
                String hp = rs.getString("no_hp");

                Object[] baris = {nis, namaSiswa, jenisKelamin, tempatLahir, tglLahir, kelas, hp};
                model.addRow(baris);
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, sQLException);
            System.out.println(sQLException);
            //System.err.println(sQLException.getMessage());
        }
        tb_Siswa.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Siswa = new javax.swing.JTable();
        bt_Tambah = new javax.swing.JButton();
        bt_Ubah = new javax.swing.JButton();
        bt_Hapus = new javax.swing.JButton();
        bt_Reset = new javax.swing.JButton();
        lb_Foto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_Nis = new javax.swing.JTextField();
        tf_Nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_Jk = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tf_TempatLahir = new javax.swing.JTextField();
        dc_TglLahir = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_Hp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cb_Kelas = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_Alamat = new javax.swing.JTextArea();
        lb_FotoPath = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Siswa");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Close Window.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tb_Siswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_Siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Siswa);

        bt_Tambah.setBackground(new java.awt.Color(0, 204, 51));
        bt_Tambah.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        bt_Tambah.setForeground(new java.awt.Color(255, 255, 255));
        bt_Tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Add.png"))); // NOI18N
        bt_Tambah.setText("Tambah");
        bt_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_TambahActionPerformed(evt);
            }
        });

        bt_Ubah.setBackground(new java.awt.Color(255, 102, 0));
        bt_Ubah.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        bt_Ubah.setForeground(new java.awt.Color(255, 255, 255));
        bt_Ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Edit Property.png"))); // NOI18N
        bt_Ubah.setText("Ubah");
        bt_Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UbahActionPerformed(evt);
            }
        });

        bt_Hapus.setBackground(new java.awt.Color(255, 51, 51));
        bt_Hapus.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        bt_Hapus.setForeground(new java.awt.Color(255, 255, 255));
        bt_Hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Trash.png"))); // NOI18N
        bt_Hapus.setText("Hapus");
        bt_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HapusActionPerformed(evt);
            }
        });

        bt_Reset.setBackground(new java.awt.Color(0, 0, 255));
        bt_Reset.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        bt_Reset.setForeground(new java.awt.Color(255, 255, 255));
        bt_Reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Reboot.png"))); // NOI18N
        bt_Reset.setText("Reset");
        bt_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ResetActionPerformed(evt);
            }
        });

        lb_Foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Foto.setText("Foto");
        lb_Foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_Foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_FotoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("NIS");

        tf_Nis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tf_Nama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Jenis Kelamin");

        cb_Jk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_Jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - Laki", "Perempuan" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("Tempat Lahir");

        tf_TempatLahir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("Tanggal Lahir");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("HP");

        tf_Hp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("Alamat");

        cb_Kelas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("Kelas");

        tf_Alamat.setColumns(20);
        tf_Alamat.setRows(5);
        jScrollPane2.setViewportView(tf_Alamat);

        lb_FotoPath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_FotoPath.setText("jLabel9");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(lb_FotoPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_TempatLahir)
                                    .addComponent(cb_Jk, 0, 260, Short.MAX_VALUE)
                                    .addComponent(tf_Nama)
                                    .addComponent(tf_Nis)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(dc_TglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_Hp)
                                    .addComponent(cb_Kelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(bt_Tambah)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bt_Ubah)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bt_Hapus)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Reset)
                        .addGap(302, 302, 302))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_Hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_Kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_Nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_Jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(lb_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_TempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_FotoPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_Tambah)
                        .addComponent(bt_Ubah)
                        .addComponent(bt_Hapus)
                        .addComponent(bt_Reset))
                    .addComponent(dc_TglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void lb_FotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_FotoMouseClicked
        try {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                
                if (file != null) {
                    
                    ImageIcon icon = new ImageIcon(file.toString());
                    
                    Image image = icon.getImage().getScaledInstance(lb_Foto.getWidth(), lb_Foto.getHeight(), Image.SCALE_SMOOTH);
                    
                    ImageIcon ic = new ImageIcon(image);
                    
                    lb_Foto.setText(null);
                    
                    lb_Foto.setIcon(ic);
                    
                    String filename = file.getAbsolutePath();
                    lb_FotoPath.setText(filename);
                }
            } else {
                System.err.println("Pemilihan file dibatalkan oleh pengguna");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error Upload " + e.getMessage());
        }
    }//GEN-LAST:event_lb_FotoMouseClicked

    private void bt_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_TambahActionPerformed
        String nis = tf_Nis.getText();
        String namaSiswa = tf_Nama.getText();
        String jenisKelamin = cb_Jk.getSelectedItem().toString();
        String jK = null;
        String tempatLahir = tf_TempatLahir.getText();
        Date tglLahirDate = dc_TglLahir.getDate();
        String tglLahir = null;
        if (tglLahirDate != null) {
            tglLahir = new SimpleDateFormat("yyyy-MM-dd").format(tglLahirDate);
        }
        String hp = tf_Hp.getText();
        String kelas = cb_Kelas.getSelectedItem().toString();
        String alamat = tf_Alamat.getText();
        String filePath = lb_FotoPath.getText();
        switch (jenisKelamin) {
            case "Laki - Laki":
                jK = "L";
                break;
            case "Perempuan":
                jK = "P";
                break;
            default:
                jK = null;
                break;
        }
        String foto = null;
        if (filePath.length() != 0) {
            try {
                String sourcePath = filePath;
                File sourceFile = new File(sourcePath);
                String destinationFolderPath = "src/Foto/";
                File destinationFolder = new File(destinationFolderPath);
                if (!destinationFolder.exists()) {
                    destinationFolder.mkdir();
                }
                String extension = sourcePath.substring(sourcePath.lastIndexOf('.') + 1);
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String destinationFileName = "foto-" + timestamp + "." + extension;
                File destinationFile = new File(destinationFolderPath + destinationFileName);
                Files.copy(sourceFile.toPath(), destinationFile.toPath());
                foto = destinationFile.getPath();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal upload file: " + e.getMessage());
                System.out.println(e);
            }
        } else {
            foto = null;
        }

        try {
            String sql = "INSERT INTO siswa(nis,nama_siswa,gender,tempat_lahir,tgl_lahir,alamat,no_hp,id_kelas,foto)"
                    + " VALUES(?,?,?,?,?,?,?,?,?)";
            Connection conn = Koneksi.konek();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nis);
            statement.setString(2, namaSiswa);
            statement.setString(3, jK);
            statement.setString(4, tempatLahir);
            statement.setString(5, tglLahir);
            statement.setString(6, alamat);
            statement.setString(7, hp);
            statement.setString(8, kelas);
            statement.setString(9, foto);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan!");
            System.out.println(e);
        }

        load_tabel_siswa();
        Reset();
    }//GEN-LAST:event_bt_TambahActionPerformed

    private void bt_UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UbahActionPerformed
        String nis = tf_Nis.getText();
        String namaSiswa = tf_Nama.getText();
        String jenisKelamin = cb_Jk.getSelectedItem().toString();
        String jK = null;
        String tempatLahir = tf_TempatLahir.getText();
        Date tglLahirDate = dc_TglLahir.getDate();
        String tglLahir = null;
        if (tglLahirDate != null) {
            tglLahir = new SimpleDateFormat("yyyy-MM-dd").format(tglLahirDate);
        }
        String hp = tf_Hp.getText();
        String kelas = cb_Kelas.getSelectedItem().toString();
        String alamat = tf_Alamat.getText();
        String filePath = lb_FotoPath.getText();

        switch (jenisKelamin) {
            case "Laki - Laki":
                jK = "L";
                break;
            case "Perempuan":
                jK = "P";
                break;
            default:
                jK = null;
                break;
        }

        String fotoAsli = null;

        try {
            String sql = "SELECT foto FROM siswa WHERE nis = ?";
            Connection conn = Koneksi.konek();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nis);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                fotoAsli = rs.getString("Foto");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil foto asli: " + e.getMessage());
            System.out.println(e);
        }

        boolean fotoDiubah = (fotoAsli == null && !filePath.isEmpty())
                || (fotoAsli != null && !fotoAsli.equals(filePath));

        String foto = fotoAsli;

        if (fotoDiubah) {
            try {
                File sourceFile = new File(filePath);

                String extension = filePath.substring(filePath.lastIndexOf('.') + 1);

                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String destinationPath = "src/foto/foto-" + timestamp + "." + extension;

                File destFile = new File(destinationPath);
                Files.copy(sourceFile.toPath(), destFile.toPath());

                foto = destinationPath;

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Gagal upload file: " + e.getMessage());
                System.out.println(e);
            }
        }

        try {
            String sql2;
            if (fotoDiubah) {
                sql2 = "UPDATE siswa SET nama_siswa=?, gender=?, tempat_lahir=?, "
                        + "tgl_lahir=?, alamat=?, no_hp=?, id_kelas=?, foto=? WHERE nis=?";
            } else {
                sql2 = "UPDATE siswa SET nama_siswa=?, gender=?, tempat_lahir=?, "
                        + "tgl_lahir=?, alamat=?, no_hp=?, id_kelas=? WHERE nis=?";
            }

            Connection conn = Koneksi.konek();
            PreparedStatement statement = conn.prepareStatement(sql2);
            statement.setString(1, namaSiswa);
            statement.setString(2, jK);
            statement.setString(3, tempatLahir);
            statement.setString(4, tglLahir);
            statement.setString(5, alamat);
            statement.setString(6, hp);
            statement.setString(7, kelas);

            if (fotoDiubah) {
                statement.setString(8, foto);
                statement.setString(9, nis);
            } else {
                statement.setString(8, nis);
            }

            statement.execute();

            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Gagal memperbarui data: " + e.getMessage());
            System.out.println(e);
        }

        load_tabel_siswa();
        Reset();
    }//GEN-LAST:event_bt_UbahActionPerformed

    private void bt_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HapusActionPerformed
        String nis = tf_Nis.getText();
        String sql = "DELETE FROM siswa WHERE nis = ?";
        try {
            Connection conn = Koneksi.konek();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nis);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
        }
        load_tabel_siswa();
        Reset();
    }//GEN-LAST:event_bt_HapusActionPerformed

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
        Reset();
    }//GEN-LAST:event_bt_ResetActionPerformed

    private void tb_SiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SiswaMouseClicked
        int baris = tb_Siswa.rowAtPoint(evt.getPoint());
        String nis = tb_Siswa.getValueAt(baris, 0).toString();
        String namaSiswa = tb_Siswa.getValueAt(baris, 1).toString();
        Object jkObj = tb_Siswa.getValueAt(baris, 2);
        Object tempatObj = tb_Siswa.getValueAt(baris, 3);
        Object tglObj = tb_Siswa.getValueAt(baris, 4);
        Object kelasObj = tb_Siswa.getValueAt(baris, 5);
        Object hpObj = tb_Siswa.getValueAt(baris, 6);
        tf_Nis.setText(nis);
        tf_Nis.setEditable(false);
        tf_Nama.setText(namaSiswa);
        String jenisKelamin = (jkObj != null) ? jkObj.toString() : null;
        String tempatLahir = (tempatObj != null) ? tempatObj.toString() : "";
        String tglLahir = (tglObj != null) ? tglObj.toString() : null;
        String idKelas = (kelasObj != null) ? kelasObj.toString() : null;
        String noHP = (hpObj != null) ? hpObj.toString() : "";
        tf_TempatLahir.setText(tempatLahir);
        tf_Hp.setText(noHP);
        cb_Kelas.setSelectedItem(idKelas);
        if (tglLahir != null && !tglLahir.isEmpty()) {
            try {
                dc_TglLahir.setDate(java.sql.Date.valueOf(tglLahir));
            } catch (IllegalArgumentException e) {
                dc_TglLahir.setDate(null);
            }
        } else {
            dc_TglLahir.setDate(null);
        }
        switch (jenisKelamin) {
            case "L":
                cb_Jk.setSelectedItem("Laki - Laki");
                break;
            case "P":
                cb_Jk.setSelectedItem("Perempuan");
                break;
            default:
                cb_Jk.setSelectedItem(null);
                break;
        }

        try {
            String sql = "SELECT alamat, foto FROM siswa WHERE nis = ?";
            Connection conn = Koneksi.konek();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nis);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String alamat = rs.getString("alamat");
                String foto = rs.getString("foto");
                tf_Alamat.setText(alamat);
                if (foto != null && !foto.isEmpty()) {
                    ImageIcon icon = new ImageIcon(foto);
                    Image image = icon.getImage().getScaledInstance(lb_Foto.getWidth(), lb_Foto.getHeight(), Image.SCALE_SMOOTH);
                    lb_FotoPath.setText(foto);
                    lb_Foto.setText(null);
                    lb_Foto.setIcon(new ImageIcon(image));
                } else {
                    lb_Foto.setText("Foto");
                    lb_Foto.setIcon(null);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tb_SiswaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Hapus;
    private javax.swing.JButton bt_Reset;
    private javax.swing.JButton bt_Tambah;
    private javax.swing.JButton bt_Ubah;
    private javax.swing.JComboBox<String> cb_Jk;
    private javax.swing.JComboBox<String> cb_Kelas;
    private com.toedter.calendar.JDateChooser dc_TglLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_Foto;
    private javax.swing.JLabel lb_FotoPath;
    private javax.swing.JTable tb_Siswa;
    private javax.swing.JTextArea tf_Alamat;
    private javax.swing.JTextField tf_Hp;
    private javax.swing.JTextField tf_Nama;
    private javax.swing.JTextField tf_Nis;
    private javax.swing.JTextField tf_TempatLahir;
    // End of variables declaration//GEN-END:variables
}
