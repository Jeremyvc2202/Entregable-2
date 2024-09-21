
package presentacion;

import Datos.TrabajadorDAO;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import negocio.TrabajadorControl;
import java.util.Date;  // para el tipo de dato de la fecha


public class Trabajadores extends javax.swing.JInternalFrame {
    
    //invocamos una clase y le damos como propiedad una variable
    private final TrabajadorControl CONTROL;
    private String accion;
    private String NombreAnt;

    public Trabajadores() {
        initComponents();
        this.CONTROL= new TrabajadorControl();
        this.listar("");
        this.accion = "Listo";
        //tablalistado.setEnabled(false);
        tabGeneral.setEnabledAt(1, false);
        
        
        // Agregar el KeyListener para búsqueda automática
        txtbuscartrabajador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                listar(txtbuscartrabajador.getText());
            }
        });
    }
    
     private void listar(String texto){
        tablalistadotrabajadores.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden = new TableRowSorter(tablalistadotrabajadores.getModel());
        tablalistadotrabajadores.setRowSorter(orden);
        txttotalregistros.setText("Mostrando "+ this.CONTROL.totalMostrado()+ " de un total de "+this.CONTROL.total()+" trabajadores");
    }
     
    private void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    private void mensajeOK(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"Exitoso",JOptionPane.INFORMATION_MESSAGE);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbuscartrabajador = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistadotrabajadores = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnregistrartrabajador = new javax.swing.JButton();
        btneditartrabajadores = new javax.swing.JButton();
        btnactivartrabajador = new javax.swing.JButton();
        btndesactivartrabajador = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txttotalregistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnombredoctor = new javax.swing.JTextField();
        txtemaildoctor = new javax.swing.JTextField();
        txtespecialidad = new javax.swing.JTextField();
        txttelefonodoctor = new javax.swing.JTextField();
        txtfechacontrato = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnguardartrabajadores = new javax.swing.JButton();
        btncancelartrabajador = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("TRABAJADORES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/veterinario.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nombre del Trabajador");

        txtbuscartrabajador.setForeground(new java.awt.Color(153, 153, 153));
        txtbuscartrabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtbuscartrabajador.setText("buscar trabajador");
        txtbuscartrabajador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbuscartrabajadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbuscartrabajadorFocusLost(evt);
            }
        });

        tablalistadotrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablalistadotrabajadores);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        jButton1.setText("Buscar Trabajador");

        btnregistrartrabajador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrartrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarpersona.png"))); // NOI18N
        btnregistrartrabajador.setText("Registrar Trabajador   ");
        btnregistrartrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrartrabajadorActionPerformed(evt);
            }
        });

        btneditartrabajadores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneditartrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btneditartrabajadores.setText("  Editar Trabajador      ");
        btneditartrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditartrabajadoresActionPerformed(evt);
            }
        });

        btnactivartrabajador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnactivartrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        btnactivartrabajador.setText("Activar Trabajador      ");
        btnactivartrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactivartrabajadorActionPerformed(evt);
            }
        });

        btndesactivartrabajador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndesactivartrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x.png"))); // NOI18N
        btndesactivartrabajador.setText("Desactivar Trabajador");
        btndesactivartrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndesactivartrabajadorActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/listadoctores.png"))); // NOI18N

        txttotalregistros.setText("total de registros: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscartrabajador))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttotalregistros)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btndesactivartrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnactivartrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btneditartrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnregistrartrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(25, 25, 25))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscartrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnregistrartrabajador)
                        .addGap(12, 12, 12)
                        .addComponent(btneditartrabajadores)
                        .addGap(18, 18, 18)
                        .addComponent(btnactivartrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btndesactivartrabajador))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txttotalregistros)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabGeneral.addTab("LISTADO DE TRABAJADORES", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de los trabajadores"));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre del Doctor *");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Especialidad del Doctor *");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Telefono del Doctor *");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Email del Doctor *");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Fecha de contratato *");

        txtnombredoctor.setForeground(new java.awt.Color(153, 153, 153));
        txtnombredoctor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombredoctor.setText("ingresar nombre");
        txtnombredoctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombredoctorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombredoctorFocusLost(evt);
            }
        });

        txtemaildoctor.setForeground(new java.awt.Color(153, 153, 153));
        txtemaildoctor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemaildoctor.setText("ingresar email");
        txtemaildoctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtemaildoctorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtemaildoctorFocusLost(evt);
            }
        });

        txtespecialidad.setForeground(new java.awt.Color(153, 153, 153));
        txtespecialidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtespecialidad.setText("ingresar especialidad");
        txtespecialidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtespecialidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtespecialidadFocusLost(evt);
            }
        });

        txttelefonodoctor.setForeground(new java.awt.Color(153, 153, 153));
        txttelefonodoctor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttelefonodoctor.setText("ingresar telefono");
        txttelefonodoctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttelefonodoctorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttelefonodoctorFocusLost(evt);
            }
        });

        txtfechacontrato.setForeground(new java.awt.Color(153, 153, 153));
        txtfechacontrato.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfechacontrato.setText("ingresar fecha");
        txtfechacontrato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfechacontratoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfechacontratoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txttelefonodoctor)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombredoctor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtespecialidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfechacontrato, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtemaildoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombredoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemaildoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfechacontrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttelefonodoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setText("Los campos obligatorios están marcados con un asterisco (*).");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/formulariodoctores.png"))); // NOI18N

        btnguardartrabajadores.setBackground(new java.awt.Color(204, 255, 204));
        btnguardartrabajadores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnguardartrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnguardartrabajadores.setText("GUARDAR");
        btnguardartrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardartrabajadoresActionPerformed(evt);
            }
        });

        btncancelartrabajador.setBackground(new java.awt.Color(204, 255, 204));
        btncancelartrabajador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncancelartrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_1.png"))); // NOI18N
        btncancelartrabajador.setText("CANCELAR");
        btncancelartrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelartrabajadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(501, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnguardartrabajadores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncancelartrabajador)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel9)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnguardartrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelartrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        tabGeneral.addTab("FORMULARIO DE TRABAJADORES", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabGeneral)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tabGeneral)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrartrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrartrabajadorActionPerformed
        tabGeneral.setEnabledAt(1,true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        this.accion="Guardar";
        btnregistrartrabajador.setText("Registrar trabajador");
    }//GEN-LAST:event_btnregistrartrabajadorActionPerformed

    private void btnactivartrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactivartrabajadorActionPerformed
        if(tablalistadotrabajadores.getSelectedRowCount()==1){
            String id = String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 0));
            String nombre = String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "¿Deseas activar el registro: "+nombre+" ?","activar",JOptionPane.YES_NO_OPTION)== 0){
                String resp=this.CONTROL.activar(Integer.parseInt(id));
                if(resp.equals("OK")){
                    this.mensajeOK("Registro activado");
                    this.listar("");
                }else{
                    this.mensajeError(resp);
                }
            }
        }else{
            this.mensajeError("Selecciona un registro para activar");
        }
    }//GEN-LAST:event_btnactivartrabajadorActionPerformed

    private void btndesactivartrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesactivartrabajadorActionPerformed
        if(tablalistadotrabajadores.getSelectedRowCount()==1){
            String id = String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 0));
            String nombre = String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "¿Deseas desactivar el registro: "+nombre+" ?","Desactivar",JOptionPane.YES_NO_OPTION)== 0){
                String resp=this.CONTROL.desactivar(Integer.parseInt(id));
                if(resp.equals("OK")){
                    this.mensajeOK("Registro desactivado");
                    this.listar("");
                }else{
                    this.mensajeError(resp);
                }
            }
        }else{
            this.mensajeError("Selecciona un registro para desactivar");
        }
    }//GEN-LAST:event_btndesactivartrabajadorActionPerformed

    private void txtbuscartrabajadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbuscartrabajadorFocusGained
        if(txtbuscartrabajador.getText().equals("buscar trabajador")){
           txtbuscartrabajador.setText("");
           txtbuscartrabajador.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtbuscartrabajadorFocusGained

    private void txtbuscartrabajadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbuscartrabajadorFocusLost
        if(txtbuscartrabajador.getText().equals("")){
           txtbuscartrabajador.setText("buscar trabajador");
           txtbuscartrabajador.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtbuscartrabajadorFocusLost

    private void txtnombredoctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombredoctorFocusGained
        if(txtnombredoctor.getText().equals("ingresar nombre")){
           txtnombredoctor.setText("");
           txtnombredoctor.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtnombredoctorFocusGained

    private void txtnombredoctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombredoctorFocusLost
        if(txtnombredoctor.getText().equals("")){
           txtnombredoctor.setText("ingresar nombre");
           txtnombredoctor.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtnombredoctorFocusLost

    private void txtespecialidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtespecialidadFocusGained
        if(txtespecialidad.getText().equals("ingresar especialidad")){
           txtespecialidad.setText("");
           txtespecialidad.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtespecialidadFocusGained

    private void txtespecialidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtespecialidadFocusLost
        if(txtespecialidad.getText().equals("")){
           txtespecialidad.setText("ingresar especialidad");
           txtespecialidad.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtespecialidadFocusLost

    private void txttelefonodoctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttelefonodoctorFocusGained
        if(txttelefonodoctor.getText().equals("ingresar telefono")){
           txttelefonodoctor.setText("");
           txttelefonodoctor.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txttelefonodoctorFocusGained

    private void txttelefonodoctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttelefonodoctorFocusLost
        if(txttelefonodoctor.getText().equals("")){
           txttelefonodoctor.setText("ingresar telefono");
           txttelefonodoctor.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txttelefonodoctorFocusLost

    private void txtemaildoctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemaildoctorFocusGained
        if(txtemaildoctor.getText().equals("ingresar email")){
           txtemaildoctor.setText("");
           txtemaildoctor.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtemaildoctorFocusGained

    private void txtemaildoctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemaildoctorFocusLost
        if(txtemaildoctor.getText().equals("")){
           txtemaildoctor.setText("ingresar email");
           txtemaildoctor.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtemaildoctorFocusLost

    private void txtfechacontratoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfechacontratoFocusGained
       if(txtfechacontrato.getText().equals("ingresar fecha")){
           txtfechacontrato.setText("");
           txtfechacontrato.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtfechacontratoFocusGained

    private void txtfechacontratoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfechacontratoFocusLost
       if(txtfechacontrato.getText().equals("")){
           txtfechacontrato.setText("ingresar fecha");
           txtfechacontrato.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtfechacontratoFocusLost

    private void btncancelartrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelartrabajadorActionPerformed
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);
    }//GEN-LAST:event_btncancelartrabajadorActionPerformed

    private void btneditartrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditartrabajadoresActionPerformed
       if(tablalistadotrabajadores.getSelectedRowCount()==1){
            String nombre = String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 1));
            this.NombreAnt= String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 1));
            String especialidad = String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 2));
            String telefono = String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 3));
            String email = String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 4));
            String fecha_contratacion = String.valueOf(tablalistadotrabajadores.getValueAt(tablalistadotrabajadores.getSelectedRow(), 5));
           
           
            txtnombredoctor.setText(nombre);
            txtespecialidad.setText(especialidad);
            txttelefonodoctor.setText(telefono);
            txtemaildoctor.setText(email);
            txtfechacontrato.setText(fecha_contratacion);
            
            
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
            this.accion="Editar";
            btnguardartrabajadores.setText("Guardar");
        }else{
            this.mensajeError("Selecciona un registro para editar");
        }
    }//GEN-LAST:event_btneditartrabajadoresActionPerformed

    private void btnguardartrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardartrabajadoresActionPerformed
        if(txtnombredoctor.getText().length()== 0 || txtnombredoctor.getText().length()>100){
            JOptionPane.showMessageDialog(this,"Debes ingresar un nombre y no debe ser mayor a 100 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtnombredoctor.requestFocus();
            return;
        }
        if(txtespecialidad.getText().length()== 0 || txtespecialidad.getText().length()>100){
            JOptionPane.showMessageDialog(this,"Debes ingresar la especialidad del Doctor y no debe ser mayor a 100 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtespecialidad.requestFocus();
            return;
        }
        if(txttelefonodoctor.getText().length()== 0 || txttelefonodoctor.getText().length()>15){
            JOptionPane.showMessageDialog(this,"Debes ingresar un número telefónico y no debe ser mayor a 15 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txttelefonodoctor.requestFocus();
            return;
        }
        if(txtemaildoctor.getText().length()== 0 || txtemaildoctor.getText().length()>100){
            JOptionPane.showMessageDialog(this,"Debes el email del Doctor y no debe ser mayor a 100 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtemaildoctor.requestFocus();
            return;
        }
        if(txtfechacontrato.getText().length()== 0 || txtfechacontrato.getText().length()>10){
            JOptionPane.showMessageDialog(this,"Debes ingresar una fecha y no debe ser mayor a 10 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtfechacontrato.requestFocus();
            return;
        }
        
        //
        String resp;
        if(this.accion.equals("Editar")){
            //Condicional para editar 
            resp = this.CONTROL.actualizar(0, txtnombredoctor.getText(), this.NombreAnt, txtespecialidad.getText(),Integer.parseInt(txttelefonodoctor.getText()), txtemaildoctor.getText(), txtfechacontrato.getText());
            if(resp.equals("OK")){
                this.mensajeOK("Actualizado correctamente");
                this.listar("");
                tabGeneral.setSelectedIndex(0);
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
                
            } else {
                this.mensajeError(resp);
            }
        } else {
            // Condicional para guardar (Insertar)
            resp = this.CONTROL.insertar(0, txtnombredoctor.getText(), txtespecialidad.getText(),Integer.parseInt(txttelefonodoctor.getText()), txtemaildoctor.getText(), txtfechacontrato.getText());
            
            if(resp.equals("OK")){
                this.mensajeOK("Registrado correctamente");
                this.listar("");
                tabGeneral.setSelectedIndex(0);
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
            } else {
                this.mensajeError(resp);
            }
        }
    }//GEN-LAST:event_btnguardartrabajadoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactivartrabajador;
    private javax.swing.JButton btncancelartrabajador;
    private javax.swing.JButton btndesactivartrabajador;
    private javax.swing.JButton btneditartrabajadores;
    private javax.swing.JButton btnguardartrabajadores;
    private javax.swing.JButton btnregistrartrabajador;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablalistadotrabajadores;
    private javax.swing.JTextField txtbuscartrabajador;
    private javax.swing.JTextField txtemaildoctor;
    private javax.swing.JTextField txtespecialidad;
    private javax.swing.JTextField txtfechacontrato;
    private javax.swing.JTextField txtnombredoctor;
    private javax.swing.JTextField txttelefonodoctor;
    private javax.swing.JLabel txttotalregistros;
    // End of variables declaration//GEN-END:variables
}
