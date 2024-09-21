
package presentacion;

import Datos.ClienteDAO;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TabableView;
import negocio.ClientesControl;
import java.util.Date;  // para el tipo de dato de la fecha


public class Clientes extends javax.swing.JInternalFrame {
    
    //invocamos una clase y le damos como propiedad una variable
    private final ClientesControl CONTROL;
    private String accion;
    private String NombreAnt;
   
    
    public Clientes() {
        initComponents();
        this.CONTROL= new ClientesControl();
        this.listar("");
        this.accion = "Listo";
        //tablalistado.setEnabled(false);
        tabGeneral.setEnabledAt(1, false);
        
        // Agregar el KeyListener para búsqueda automática
        txtBuscarNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                listar(txtBuscarNombre.getText());
            }
        });
    }
    

    private void listar(String texto){
        tablaregistroclientes.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden = new TableRowSorter(tablaregistroclientes.getModel());
        tablaregistroclientes.setRowSorter(orden);
        txttotalregistros.setText("Mostrando "+ this.CONTROL.totalMostrado()+ " de un total de "+this.CONTROL.total()+" clientes");
    }
    
    //metodo para las ventanas emergentes
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaregistroclientes = new javax.swing.JTable();
        txtBuscarNombre = new javax.swing.JTextField();
        btnbuscarcliente = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        btneditarpaciente = new javax.swing.JButton();
        btnactivarcliente = new javax.swing.JButton();
        btndesactivarcliente = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txttotalregistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnombrecliente = new javax.swing.JTextField();
        txttelefonocliente = new javax.swing.JTextField();
        txtemailcliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdireccioncliente = new javax.swing.JTextArea();
        txtfecharegistro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnGuardarCliente = new javax.swing.JButton();
        btnCancelarCliente = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CLIENTES");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente veterinario.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nombre del Cliente");

        tablaregistroclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaregistroclientes);

        txtBuscarNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscarNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarNombre.setText("ingresa nombre");
        txtBuscarNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarNombreFocusLost(evt);
            }
        });

        btnbuscarcliente.setBackground(new java.awt.Color(255, 255, 153));
        btnbuscarcliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnbuscarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        btnbuscarcliente.setText(" Buscar Cliente     ");
        btnbuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarclienteActionPerformed(evt);
            }
        });

        btnRegistrarCliente.setBackground(new java.awt.Color(255, 255, 153));
        btnRegistrarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarpersona.png"))); // NOI18N
        btnRegistrarCliente.setText(" Registrar Cliente   ");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btneditarpaciente.setBackground(new java.awt.Color(255, 255, 153));
        btneditarpaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneditarpaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btneditarpaciente.setText(" Editar Cliente       ");
        btneditarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarpacienteActionPerformed(evt);
            }
        });

        btnactivarcliente.setBackground(new java.awt.Color(153, 153, 153));
        btnactivarcliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnactivarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        btnactivarcliente.setText(" Activar Cliente     ");
        btnactivarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactivarclienteActionPerformed(evt);
            }
        });

        btndesactivarcliente.setBackground(new java.awt.Color(153, 153, 153));
        btndesactivarcliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndesactivarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x.png"))); // NOI18N
        btndesactivarcliente.setText(" Desactivar Cliente");
        btndesactivarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndesactivarclienteActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clientes1.png"))); // NOI18N

        txttotalregistros.setText("Tota de registros: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarNombre))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addComponent(txttotalregistros))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneditarpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnactivarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndesactivarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txttotalregistros))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscarcliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneditarpaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnactivarcliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndesactivarcliente)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tabGeneral.addTab("LISTADO DE CLIENTES", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 255, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre del Cliente *");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Dirección del Cliente *");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Telefono del Cliente *");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Email del Cliente *");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Fecha de Registro *");

        txtnombrecliente.setForeground(new java.awt.Color(153, 153, 153));
        txtnombrecliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombrecliente.setText("ingresa nombre");
        txtnombrecliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombreclienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombreclienteFocusLost(evt);
            }
        });

        txttelefonocliente.setForeground(new java.awt.Color(153, 153, 153));
        txttelefonocliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttelefonocliente.setText("ingresa telefono");
        txttelefonocliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttelefonoclienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttelefonoclienteFocusLost(evt);
            }
        });

        txtemailcliente.setForeground(new java.awt.Color(153, 153, 153));
        txtemailcliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemailcliente.setText("ingresa email");
        txtemailcliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtemailclienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtemailclienteFocusLost(evt);
            }
        });

        txtdireccioncliente.setColumns(20);
        txtdireccioncliente.setForeground(new java.awt.Color(153, 153, 153));
        txtdireccioncliente.setRows(5);
        txtdireccioncliente.setText("ingresa dirección");
        txtdireccioncliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdireccionclienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdireccionclienteFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txtdireccioncliente);

        txtfecharegistro.setForeground(new java.awt.Color(153, 153, 153));
        txtfecharegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfecharegistro.setText("ingresar fecha");
        txtfecharegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfecharegistroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfecharegistroFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2)
                    .addComponent(txtnombrecliente)
                    .addComponent(jLabel3))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefonocliente, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtemailcliente)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfecharegistro))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnombrecliente, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txttelefonocliente))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtemailcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel7.setText("Los campos obligatorios están marcados con un asterisco (*).");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gente.png"))); // NOI18N

        btnGuardarCliente.setBackground(new java.awt.Color(0, 255, 153));
        btnGuardarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardarCliente.setText("  GUARDAR");
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnCancelarCliente.setBackground(new java.awt.Color(0, 255, 153));
        btnCancelarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_1.png"))); // NOI18N
        btnCancelarCliente.setText(" CANCELAR");
        btnCancelarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnGuardarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarCliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(13, 13, 13)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        tabGeneral.addTab("FORMULARIO DE CLIENTES", jPanel2);

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
                .addContainerGap()
                .addComponent(tabGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    private void txtBuscarNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarNombreFocusGained
        if (txtBuscarNombre.getText().equals("ingresa nombre")){
            txtBuscarNombre.setText("");
            txtBuscarNombre.setForeground(Color.BLACK);  
        }
        
    }//GEN-LAST:event_txtBuscarNombreFocusGained

    private void txtBuscarNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarNombreFocusLost
        if (txtBuscarNombre.getText().equals("")){
            txtBuscarNombre.setText("ingresa nombre");
            txtBuscarNombre.setForeground(Color.GRAY);  
        }
    }//GEN-LAST:event_txtBuscarNombreFocusLost

    private void txtnombreclienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreclienteFocusGained
        if (txtnombrecliente.getText().equals("ingresa nombre")){
            txtnombrecliente.setText("");
            txtnombrecliente.setForeground(Color.BLACK);  
        }
    }//GEN-LAST:event_txtnombreclienteFocusGained

    private void txtnombreclienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreclienteFocusLost
        if (txtnombrecliente.getText().equals("")){
            txtnombrecliente.setText("ingresa nombre");
            txtnombrecliente.setForeground(Color.GRAY);  
        }
    }//GEN-LAST:event_txtnombreclienteFocusLost

    private void txtdireccionclienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdireccionclienteFocusGained
        if (txtdireccioncliente.getText().equals("ingresa dirección")){
            txtdireccioncliente.setText("");
            txtdireccioncliente.setForeground(Color.BLACK);  
        }
    }//GEN-LAST:event_txtdireccionclienteFocusGained

    private void txtdireccionclienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdireccionclienteFocusLost
        if (txtdireccioncliente.getText().equals("")){
            txtdireccioncliente.setText("ingresa dirección");
            txtdireccioncliente.setForeground(Color.GRAY);  
        }
    }//GEN-LAST:event_txtdireccionclienteFocusLost

    private void txttelefonoclienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttelefonoclienteFocusGained
        if (txttelefonocliente.getText().equals("ingresa telefono")){
            txttelefonocliente.setText("");
            txttelefonocliente.setForeground(Color.BLACK);  
        }
    }//GEN-LAST:event_txttelefonoclienteFocusGained

    private void txttelefonoclienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttelefonoclienteFocusLost
        if (txttelefonocliente.getText().equals("")){
            txttelefonocliente.setText("ingresa telefono");
            txttelefonocliente.setForeground(Color.GRAY);  
        }
    }//GEN-LAST:event_txttelefonoclienteFocusLost

    private void txtemailclienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailclienteFocusGained
        if (txtemailcliente.getText().equals("ingresa email")){
            txtemailcliente.setText("");
            txtemailcliente.setForeground(Color.BLACK);  
        }
    }//GEN-LAST:event_txtemailclienteFocusGained

    private void txtemailclienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailclienteFocusLost
        if (txtemailcliente.getText().equals("")){
            txtemailcliente.setText("ingresa email");
            txtemailcliente.setForeground(Color.GRAY);  
        }
    }//GEN-LAST:event_txtemailclienteFocusLost

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        tabGeneral.setEnabledAt(1,true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        this.accion="Guardar";
        btnRegistrarCliente.setText("Registrar Cliente");
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnCancelarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarClienteActionPerformed
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);
       
    }//GEN-LAST:event_btnCancelarClienteActionPerformed

    
    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        if(txtnombrecliente.getText().length()== 0 || txtnombrecliente.getText().length()>100){
            JOptionPane.showMessageDialog(this,"Debes ingresar un nombre y no debe ser mayor a 100 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtnombrecliente.requestFocus();
            return;
        }
        if(txtdireccioncliente.getText().length()== 0 || txtdireccioncliente.getText().length()>255){
            JOptionPane.showMessageDialog(this,"Debes ingresar una dirección y no debe ser mayor a 255 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtdireccioncliente.requestFocus();
            return;
        }
        if(txttelefonocliente.getText().length()== 0 || txttelefonocliente.getText().length()>15){
            JOptionPane.showMessageDialog(this,"Debes ingresar un número telefónico y no debe ser mayor a 15 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txttelefonocliente.requestFocus();
            return;
        }
        if(txtemailcliente.getText().length()== 0 || txtemailcliente.getText().length()>100){
            JOptionPane.showMessageDialog(this,"Debes ingresar un email y no debe ser mayor a 100 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtemailcliente.requestFocus();
            return;
        }
        if(txtfecharegistro.getText().length()== 0 || txtfecharegistro.getText().length()>10){
            JOptionPane.showMessageDialog(this,"Debes ingresar una fecha y no debe ser mayor a 10 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtfecharegistro.requestFocus();
            return;
        }
        
        
        String resp;
        if(this.accion.equals("Editar")){
            // Condicional para editar
            resp = this.CONTROL.actualizar(0, txtnombrecliente.getText(), this.NombreAnt,
                    txtdireccioncliente.getText(), Integer.parseInt(txttelefonocliente.getText()), txtemailcliente.getText(), txtfecharegistro.getText()); // Pasar `true` o `false` para la condición
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
            resp = this.CONTROL.insertar(0, txtnombrecliente.getText(), txtdireccioncliente.getText(),
                    Integer.parseInt(txttelefonocliente.getText()), txtemailcliente.getText(), txtfecharegistro.getText()); // Pasar `true` o `false` para la condición
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
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnbuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarclienteActionPerformed
        this.listar(txtBuscarNombre.getText());
    }//GEN-LAST:event_btnbuscarclienteActionPerformed

    private void btndesactivarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesactivarclienteActionPerformed
        if(tablaregistroclientes.getSelectedRowCount()==1){
            String id = String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 1));
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
    }//GEN-LAST:event_btndesactivarclienteActionPerformed

    private void btnactivarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactivarclienteActionPerformed
        if(tablaregistroclientes.getSelectedRowCount()==1){
            String id = String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 1));
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
    }//GEN-LAST:event_btnactivarclienteActionPerformed

    private void txtfecharegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfecharegistroFocusGained
        if (txtfecharegistro.getText().equals("ingresar fecha")){
            txtfecharegistro.setText("");
            txtfecharegistro.setForeground(Color.BLACK);  
        }
    }//GEN-LAST:event_txtfecharegistroFocusGained

    private void txtfecharegistroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfecharegistroFocusLost
        if (txtfecharegistro.getText().equals("")){
            txtfecharegistro.setText("ingresar fecha");
            txtfecharegistro.setForeground(Color.GRAY);  
        }
    }//GEN-LAST:event_txtfecharegistroFocusLost

    private void btneditarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarpacienteActionPerformed
        if(tablaregistroclientes.getSelectedRowCount()==1){
            String nombre = String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 1));
            this.NombreAnt= String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 1));
            String direccion = String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 2));
            String telefono = String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 3));
            String email = String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 4));
            String fecha_registro = String.valueOf(tablaregistroclientes.getValueAt(tablaregistroclientes.getSelectedRow(), 5));
           
           
            txtnombrecliente.setText(nombre);
            txtdireccioncliente.setText(direccion);
            txttelefonocliente.setText(telefono);
            txtemailcliente.setText(email);
            txtfecharegistro.setText(fecha_registro);
            
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
            this.accion="Editar";
            btnGuardarCliente.setText("Editar");
        }else{
            this.mensajeError("Selecciona un registro para editar");
        }
    }//GEN-LAST:event_btneditarpacienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCliente;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnactivarcliente;
    private javax.swing.JButton btnbuscarcliente;
    private javax.swing.JButton btndesactivarcliente;
    private javax.swing.JButton btneditarpaciente;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaregistroclientes;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextArea txtdireccioncliente;
    private javax.swing.JTextField txtemailcliente;
    private javax.swing.JTextField txtfecharegistro;
    private javax.swing.JTextField txtnombrecliente;
    private javax.swing.JTextField txttelefonocliente;
    private javax.swing.JLabel txttotalregistros;
    // End of variables declaration//GEN-END:variables
}
