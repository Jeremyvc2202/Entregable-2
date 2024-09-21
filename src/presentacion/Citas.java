
package presentacion;

import Datos.CitasDAO;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import negocio.CitasControl;





public class Citas extends javax.swing.JInternalFrame {
    
    //invocamos una clase y le damos como propiedad una variable
    private final CitasControl CONTROL;
    private String accion;
    private String NombreAnt;

    
    public Citas() {
        initComponents();
        this.CONTROL= new CitasControl();
        this.listar("");
        this.cargarCliente();
        this.cargarPacientes();
        this.cargarTrabajador();
        this.accion = "Listo";
        //tablalistado.setEnabled(false);
        tabGeneral.setEnabledAt(1, false);
        
        txtBuscarCita.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                listar(txtBuscarCita.getText());
            }
        });
    }
    
    private void listar(String texto){
        tablaRegistroCitas.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden = new TableRowSorter(tablaRegistroCitas.getModel());
        tablaRegistroCitas.setRowSorter(orden);
        txttotalregistrocitas.setText("Mostrando "+ this.CONTROL.totalMostrado()+ " de un total de "+this.CONTROL.total()+" Citas");
    }
    
    //metodo para las ventanas emergentes
    private void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    private void mensajeOK(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"Exitoso",JOptionPane.INFORMATION_MESSAGE);
    }
    
     //metodo para cargar CLIENTES
    private void cargarCliente(){
        DefaultComboBoxModel items = this.CONTROL.seleccionarCliente();
        cbonombrecliente2.setModel(items);
    }
    //metodo para cargar PACIENTES
    private void cargarPacientes(){
        DefaultComboBoxModel items = this.CONTROL.seleccionarPaciente();
        cbonombrepaciente1.setModel(items);
    }
    
    //metodo para cargar trabajador
    private void cargarTrabajador(){
        DefaultComboBoxModel items = this.CONTROL.seleccionarTrabajador();
        cbonombredoctor1.setModel(items);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarCita = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistroCitas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnregistrarcita = new javax.swing.JButton();
        btneditarcita = new javax.swing.JButton();
        btnactivarcita = new javax.swing.JButton();
        btndesactivarcita = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txttotalregistrocitas = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbonombrecliente2 = new javax.swing.JComboBox<>();
        cbonombrepaciente1 = new javax.swing.JComboBox<>();
        cbonombredoctor1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionCita = new javax.swing.JTextArea();
        txtfechacita = new javax.swing.JTextField();
        txtProximaCita = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnguardarcita = new javax.swing.JButton();
        btncancelarcita = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CITAS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cita-medica.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Citas de paciente");

        txtBuscarCita.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscarCita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarCita.setText("buscar cita");
        txtBuscarCita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarCitaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarCitaFocusLost(evt);
            }
        });

        tablaRegistroCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaRegistroCitas);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        jButton1.setText(" Buscar Cita");

        btnregistrarcita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrarcita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrar.png"))); // NOI18N
        btnregistrarcita.setText(" Registrar Cita");
        btnregistrarcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarcitaActionPerformed(evt);
            }
        });

        btneditarcita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneditarcita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btneditarcita.setText(" Editar cita   ");
        btneditarcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarcitaActionPerformed(evt);
            }
        });

        btnactivarcita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnactivarcita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        btnactivarcita.setText(" Activar Cita     ");
        btnactivarcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactivarcitaActionPerformed(evt);
            }
        });

        btndesactivarcita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndesactivarcita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x.png"))); // NOI18N
        btndesactivarcita.setText("Desactivar Cita");
        btndesactivarcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndesactivarcitaActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/programar.png"))); // NOI18N

        txttotalregistrocitas.setText("Total de regitros: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnactivarcita, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(btndesactivarcita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnregistrarcita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btneditarcita, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txttotalregistrocitas)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btnregistrarcita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btneditarcita)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnactivarcita)
                        .addGap(12, 12, 12)
                        .addComponent(btndesactivarcita))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txttotalregistrocitas)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tabGeneral.addTab("LISTADO DE CITAS", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Cita"));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nombre Cliente *");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Nombre Paciente *");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Nombre Doctor *");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Fecha Cita *");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Proxima cita *");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Descripción del motivo *");

        cbonombrecliente2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbonombrepaciente1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbonombredoctor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDescripcionCita.setColumns(20);
        txtDescripcionCita.setForeground(new java.awt.Color(153, 153, 153));
        txtDescripcionCita.setRows(5);
        txtDescripcionCita.setText("ingresa descripción");
        txtDescripcionCita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcionCitaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionCitaFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcionCita);

        txtfechacita.setForeground(new java.awt.Color(153, 153, 153));
        txtfechacita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfechacita.setText("ingresa fecha");
        txtfechacita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfechacitaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfechacitaFocusLost(evt);
            }
        });
        txtfechacita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechacitaActionPerformed(evt);
            }
        });

        txtProximaCita.setForeground(new java.awt.Color(153, 153, 153));
        txtProximaCita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProximaCita.setText("ingresa proxima fecha");
        txtProximaCita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProximaCitaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProximaCitaFocusLost(evt);
            }
        });
        txtProximaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProximaCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(txtfechacita, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(txtProximaCita))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbonombrecliente2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cbonombrepaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbonombredoctor1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbonombrecliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbonombrepaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbonombredoctor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfechacita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProximaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("Los campos obligatorios están marcados con un asterisco (*).");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cita.png"))); // NOI18N

        btnguardarcita.setBackground(new java.awt.Color(51, 204, 255));
        btnguardarcita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnguardarcita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnguardarcita.setText("GUARDAR");

        btncancelarcita.setBackground(new java.awt.Color(51, 204, 255));
        btncancelarcita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncancelarcita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_1.png"))); // NOI18N
        btncancelarcita.setText("CANCELAR");
        btncancelarcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarcitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnguardarcita)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncancelarcita))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnguardarcita, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelarcita, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        tabGeneral.addTab("FORMULARIO DE CITAS", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabGeneral)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabGeneral)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProximaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProximaCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProximaCitaActionPerformed

    private void txtfechacitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechacitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechacitaActionPerformed

    private void txtfechacitaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfechacitaFocusGained
        if(txtfechacita.getText().equals("ingresa fecha")){
           txtfechacita.setText("");
           txtfechacita.setForeground(Color.BLACK);  
        }
    }//GEN-LAST:event_txtfechacitaFocusGained

    private void txtfechacitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfechacitaFocusLost
        if(txtfechacita.getText().equals("")){
           txtfechacita.setText("ingresa fecha");
           txtfechacita.setForeground(Color.GRAY);  
        }
    }//GEN-LAST:event_txtfechacitaFocusLost

    private void txtBuscarCitaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCitaFocusGained
        if(txtBuscarCita.getText().equals("buscar cita")){
           txtBuscarCita.setText("");
           txtBuscarCita.setForeground(Color.BLACK);  
        }
    }//GEN-LAST:event_txtBuscarCitaFocusGained

    private void txtBuscarCitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCitaFocusLost
        if(txtBuscarCita.getText().equals("")){
           txtBuscarCita.setText("buscar cita");
           txtBuscarCita.setForeground(Color.GRAY);  
        }
    }//GEN-LAST:event_txtBuscarCitaFocusLost

    private void txtProximaCitaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProximaCitaFocusGained
        if(txtProximaCita.getText().equals("ingresa proxima fecha")){
           txtProximaCita.setText("");
           txtProximaCita.setForeground(Color.BLACK);  
        }
    }//GEN-LAST:event_txtProximaCitaFocusGained

    private void txtProximaCitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProximaCitaFocusLost
        if(txtProximaCita.getText().equals("")){
           txtProximaCita.setText("ingresa proxima fecha");
           txtProximaCita.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtProximaCitaFocusLost

    private void txtDescripcionCitaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionCitaFocusGained
        if(txtDescripcionCita.getText().equals("ingresa descripción")){
           txtDescripcionCita.setText("");
           txtDescripcionCita.setForeground(Color.BLACK);  
        }
    }//GEN-LAST:event_txtDescripcionCitaFocusGained

    private void txtDescripcionCitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionCitaFocusLost
        if(txtDescripcionCita.getText().equals("")){
           txtDescripcionCita.setText("ingresa descripción");
           txtDescripcionCita.setForeground(Color.GRAY);  
        }
    }//GEN-LAST:event_txtDescripcionCitaFocusLost

    private void btnactivarcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactivarcitaActionPerformed
        if(tablaRegistroCitas.getSelectedRowCount()==1){
            String id = String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 1));
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
    }//GEN-LAST:event_btnactivarcitaActionPerformed

    private void btndesactivarcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesactivarcitaActionPerformed
        if(tablaRegistroCitas.getSelectedRowCount()==1){
            String id = String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 1));
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
    }//GEN-LAST:event_btndesactivarcitaActionPerformed

    private void btnregistrarcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarcitaActionPerformed
        tabGeneral.setEnabledAt(1,true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        this.accion="Guardar";
        btnregistrarcita.setText("Registrar Cita");
    }//GEN-LAST:event_btnregistrarcitaActionPerformed

    private void btncancelarcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarcitaActionPerformed
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);
    }//GEN-LAST:event_btncancelarcitaActionPerformed

    private void btneditarcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarcitaActionPerformed
        if(tablaRegistroCitas.getSelectedRowCount()==1){
            String fecha_cita = String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 1));
            this.NombreAnt= String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 1));
            String proxima_cita = String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 2));
            String id_cliente = String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 3));
            String id_mascota = String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 4));
            String id_trabajadores = String.valueOf(tablaRegistroCitas.getValueAt(tablaRegistroCitas.getSelectedRow(), 5));
           
           
            txtfechacita.setText(fecha_cita);
            txtProximaCita.setText(proxima_cita);
            cbonombrecliente2.setSelectedItem(id_cliente);
            cbonombrepaciente1.setSelectedItem(id_mascota);
            cbonombredoctor1.setSelectedItem(id_trabajadores);
            
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
            this.accion="Editar";
            btnguardarcita.setText("Editar");
        }else{
            this.mensajeError("Selecciona un registro para editar");
        }
    }//GEN-LAST:event_btneditarcitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactivarcita;
    private javax.swing.JButton btncancelarcita;
    private javax.swing.JButton btndesactivarcita;
    private javax.swing.JButton btneditarcita;
    private javax.swing.JButton btnguardarcita;
    private javax.swing.JButton btnregistrarcita;
    private javax.swing.JComboBox<String> cbonombrecliente2;
    private javax.swing.JComboBox<String> cbonombredoctor1;
    private javax.swing.JComboBox<String> cbonombrepaciente1;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaRegistroCitas;
    private javax.swing.JTextField txtBuscarCita;
    private javax.swing.JTextArea txtDescripcionCita;
    private javax.swing.JTextField txtProximaCita;
    private javax.swing.JTextField txtfechacita;
    private javax.swing.JLabel txttotalregistrocitas;
    // End of variables declaration//GEN-END:variables

    public boolean isCondicion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
