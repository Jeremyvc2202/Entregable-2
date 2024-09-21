
package presentacion;
import Datos.PacienteDAO;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import negocio.PacientesControl;


public class Pacientes extends javax.swing.JInternalFrame {

    //invocamos una clase y le damos como propiedad una variable
    private final PacientesControl CONTROL;
    private String accion;
    private String NombreAnt;
    
    
    public Pacientes() {
        initComponents();
        this.CONTROL= new PacientesControl();
        this.listar("");
        this.cargarCliente1();
        this.accion = "Listo";
        //tablalistado.setEnabled(false);
        tabGeneral.setEnabledAt(1, false);
        
         //buscador automatico
        txtbuscarpaciente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                listar(txtbuscarpaciente.getText());
            }
        });
    }
    
    
    private void listar(String texto){
        tablaregistropacientes.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden = new TableRowSorter(tablaregistropacientes.getModel());
        tablaregistropacientes.setRowSorter(orden);
        txttotalregistrado.setText("Mostrando "+ this.CONTROL.totalMostrado()+ " de un total de "+this.CONTROL.total()+" clientes");
    }
    
    private void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    private void mensajeOK(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"Exitoso",JOptionPane.INFORMATION_MESSAGE);
    }
    
    //metodo para cargar categorias
    private void cargarCliente1(){
        DefaultComboBoxModel items = this.CONTROL.seleccionar();
        cbonombrecliente1.setModel(items);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbuscarpaciente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaregistropacientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnregistrarpaciente = new javax.swing.JButton();
        btneditarpaciente = new javax.swing.JButton();
        btnactivarpaciente = new javax.swing.JButton();
        btndesactivarpaciente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txttotalregistrado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbonombrecliente1 = new javax.swing.JComboBox<>();
        txtnombrepaciente = new javax.swing.JTextField();
        txtrazapaciente = new javax.swing.JTextField();
        txtcolorpaciente = new javax.swing.JTextField();
        txtpesopaciente = new javax.swing.JTextField();
        txtedadpaciente = new javax.swing.JTextField();
        txtfechanacimientopaciente = new javax.swing.JTextField();
        txtID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnguardarpaciente = new javax.swing.JButton();
        btncancelarpacientes = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("PACIENTES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pacientes.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nombre del Paciente");

        txtbuscarpaciente.setForeground(new java.awt.Color(153, 153, 153));
        txtbuscarpaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtbuscarpaciente.setText("buscar paciente");
        txtbuscarpaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbuscarpacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbuscarpacienteFocusLost(evt);
            }
        });
        txtbuscarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarpacienteActionPerformed(evt);
            }
        });

        tablaregistropacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaregistropacientes);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        jButton1.setText(" Buscar Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnregistrarpaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrarpaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrar.png"))); // NOI18N
        btnregistrarpaciente.setText(" Registrar Paciente");
        btnregistrarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarpacienteActionPerformed(evt);
            }
        });

        btneditarpaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneditarpaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btneditarpaciente.setText(" Editar Paciente    ");
        btneditarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarpacienteActionPerformed(evt);
            }
        });

        btnactivarpaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnactivarpaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        btnactivarpaciente.setText(" Activar Paciente      ");
        btnactivarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactivarpacienteActionPerformed(evt);
            }
        });

        btndesactivarpaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndesactivarpaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x.png"))); // NOI18N
        btndesactivarpaciente.setText(" Desactivar Paciente");
        btndesactivarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndesactivarpacienteActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mascotas.png"))); // NOI18N

        txttotalregistrado.setText("Total de registros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txttotalregistrado)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbuscarpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btndesactivarpaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnactivarpaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(btnregistrarpaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btneditarpaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbuscarpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btnregistrarpaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btneditarpaciente)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnactivarpaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndesactivarpaciente)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttotalregistrado)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tabGeneral.addTab("LISTADO DE PACIENTES", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nombre del Cliente *");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del Paciente *");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Raza del Paciente *");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Color del Paciente *");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Peso del Paciente *");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Edad del Paciente *");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Fecha de nacimiento *");

        cbonombrecliente1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtnombrepaciente.setForeground(new java.awt.Color(153, 153, 153));
        txtnombrepaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombrepaciente.setText("ingresa nombre");
        txtnombrepaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombrepacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombrepacienteFocusLost(evt);
            }
        });

        txtrazapaciente.setForeground(new java.awt.Color(153, 153, 153));
        txtrazapaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtrazapaciente.setText("ingresa raza");
        txtrazapaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtrazapacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtrazapacienteFocusLost(evt);
            }
        });

        txtcolorpaciente.setForeground(new java.awt.Color(153, 153, 153));
        txtcolorpaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcolorpaciente.setText("ingresa color");
        txtcolorpaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcolorpacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcolorpacienteFocusLost(evt);
            }
        });

        txtpesopaciente.setForeground(new java.awt.Color(153, 153, 153));
        txtpesopaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesopaciente.setText("ingresa peso");
        txtpesopaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpesopacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpesopacienteFocusLost(evt);
            }
        });

        txtedadpaciente.setForeground(new java.awt.Color(153, 153, 153));
        txtedadpaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtedadpaciente.setText("ingresa edad");
        txtedadpaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtedadpacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtedadpacienteFocusLost(evt);
            }
        });

        txtfechanacimientopaciente.setForeground(new java.awt.Color(153, 153, 153));
        txtfechanacimientopaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfechanacimientopaciente.setText("ingresar fecha");
        txtfechanacimientopaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfechanacimientopacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfechanacimientopacienteFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcolorpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cbonombrecliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtrazapaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnombrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpesopaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(txtedadpaciente)
                            .addComponent(txtfechanacimientopaciente))
                        .addGap(24, 24, 24))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtpesopaciente)
                    .addComponent(cbonombrecliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtedadpaciente)
                    .addComponent(txtnombrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfechanacimientopaciente)
                    .addComponent(txtrazapaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcolorpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("Los campos obligatorios están marcados con un asterisco (*).");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perrito.png"))); // NOI18N

        btnguardarpaciente.setBackground(new java.awt.Color(0, 255, 153));
        btnguardarpaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnguardarpaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnguardarpaciente.setText("GUARDAR");
        btnguardarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarpacienteActionPerformed(evt);
            }
        });

        btncancelarpacientes.setBackground(new java.awt.Color(0, 255, 153));
        btncancelarpacientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncancelarpacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_1.png"))); // NOI18N
        btncancelarpacientes.setText("CANCELAR");
        btncancelarpacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarpacientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnguardarpaciente)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelarpacientes))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(47, 47, 47))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnguardarpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelarpacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tabGeneral.addTab("FORMULARIO DE PACIENTES", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btneditarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarpacienteActionPerformed
        if(tablaregistropacientes.getSelectedRowCount()==1){
            String id = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 1));
            this.NombreAnt= String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 1));
            String raza = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 2));
            String color = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 3));
            String peso = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 4));
            String edad = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 5));
            String fecha_nacimiento = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 6));
            String id_cliente = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 7));
           
            txtID.setText(id);
            txtnombrepaciente.setText(nombre);
            txtrazapaciente.setText(raza);
            txtcolorpaciente.setText(color);
            txtpesopaciente.setText(peso);
            txtedadpaciente.setText(edad);
            txtfechanacimientopaciente.setText(fecha_nacimiento);
            cbonombrecliente1.setSelectedItem(id_cliente);
            
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
            this.accion="Editar";
            btnguardarpaciente.setText("Editar");
        }else{
            this.mensajeError("Selecciona un registro para editar");
        }
    }//GEN-LAST:event_btneditarpacienteActionPerformed

    private void btncancelarpacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarpacientesActionPerformed
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);
    }//GEN-LAST:event_btncancelarpacientesActionPerformed

    private void txtbuscarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarpacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarpacienteActionPerformed

    private void txtnombrepacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombrepacienteFocusGained
        if(txtnombrepaciente.getText().equals("ingresa nombre")){
           txtnombrepaciente.setText("");
           txtnombrepaciente.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtnombrepacienteFocusGained

    private void txtnombrepacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombrepacienteFocusLost
        if(txtnombrepaciente.getText().equals("")){
           txtnombrepaciente.setText("ingresa nombre");
           txtnombrepaciente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtnombrepacienteFocusLost

    private void txtrazapacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrazapacienteFocusGained
        if(txtrazapaciente.getText().equals("ingresa raza")){
           txtrazapaciente.setText("");
           txtrazapaciente.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtrazapacienteFocusGained

    private void txtrazapacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrazapacienteFocusLost
        if(txtrazapaciente.getText().equals("")){
           txtrazapaciente.setText("ingresa raza");
           txtrazapaciente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtrazapacienteFocusLost

    private void txtcolorpacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcolorpacienteFocusGained
        if(txtcolorpaciente.getText().equals("ingresa color")){
           txtcolorpaciente.setText("");
           txtcolorpaciente.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtcolorpacienteFocusGained

    private void txtcolorpacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcolorpacienteFocusLost
        if(txtcolorpaciente.getText().equals("")){
           txtcolorpaciente.setText("ingresa color");
           txtcolorpaciente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtcolorpacienteFocusLost

    private void txtpesopacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpesopacienteFocusGained
        if(txtpesopaciente.getText().equals("ingresa peso")){
           txtpesopaciente.setText("");
           txtpesopaciente.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtpesopacienteFocusGained

    private void txtpesopacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpesopacienteFocusLost
        if(txtpesopaciente.getText().equals("")){
           txtpesopaciente.setText("ingresa peso");
           txtpesopaciente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtpesopacienteFocusLost

    private void txtedadpacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtedadpacienteFocusGained
        if(txtedadpaciente.getText().equals("ingresa edad")){
           txtedadpaciente.setText("");
           txtedadpaciente.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtedadpacienteFocusGained

    private void txtedadpacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtedadpacienteFocusLost
       if(txtedadpaciente.getText().equals("")){
           txtedadpaciente.setText("ingresa edad");
           txtedadpaciente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtedadpacienteFocusLost

    private void txtbuscarpacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbuscarpacienteFocusGained
        if(txtbuscarpaciente.getText().equals("buscar paciente")){
           txtbuscarpaciente.setText("");
           txtbuscarpaciente.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtbuscarpacienteFocusGained

    private void txtbuscarpacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbuscarpacienteFocusLost
        if(txtbuscarpaciente.getText().equals("")){
           txtbuscarpaciente.setText("buscar paciente");
           txtbuscarpaciente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtbuscarpacienteFocusLost

    private void btnactivarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactivarpacienteActionPerformed
         if(tablaregistropacientes.getSelectedRowCount()==1){
            String id = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 1));
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
    }//GEN-LAST:event_btnactivarpacienteActionPerformed

    private void btndesactivarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesactivarpacienteActionPerformed
        if(tablaregistropacientes.getSelectedRowCount()==1){
            String id = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaregistropacientes.getValueAt(tablaregistropacientes.getSelectedRow(), 1));
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
    }//GEN-LAST:event_btndesactivarpacienteActionPerformed

    private void btnregistrarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarpacienteActionPerformed
        tabGeneral.setEnabledAt(1,true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        this.accion="Guardar";
        btnregistrarpaciente.setText("Registrar Paciente");
    }//GEN-LAST:event_btnregistrarpacienteActionPerformed

    private void btnguardarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarpacienteActionPerformed
        if(txtnombrepaciente.getText().length()== 0 || txtnombrepaciente.getText().length()>100){
            JOptionPane.showMessageDialog(this,"Debes ingresar un nombre y no debe ser mayor a 100 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtnombrepaciente.requestFocus();
            return;
        }
        if(txtrazapaciente.getText().length()== 0 || txtrazapaciente.getText().length()>50){
            JOptionPane.showMessageDialog(this,"Debes ingresar una dirección y no debe ser mayor a 50 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtrazapaciente.requestFocus();
            return;
        }
        if(txtcolorpaciente.getText().length()== 0 || txtcolorpaciente.getText().length()>50){
            JOptionPane.showMessageDialog(this,"Debes ingresar un número telefónico y no debe ser mayor a 50 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtcolorpaciente.requestFocus();
            return;
        }
        if(txtpesopaciente.getText().length()== 0 || txtpesopaciente.getText().length()>7){
            JOptionPane.showMessageDialog(this,"Debes ingresar un email y no debe ser mayor a 7 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtpesopaciente.requestFocus();
            return;
        }
        if(txtedadpaciente.getText().length()== 0 || txtedadpaciente.getText().length()>2){
            JOptionPane.showMessageDialog(this,"Debes ingresar una fecha y no debe ser mayor a 2 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtedadpaciente.requestFocus();
            return; 
        }
        if(txtfechanacimientopaciente.getText().length()== 0 || txtfechanacimientopaciente.getText().length()>10){
            JOptionPane.showMessageDialog(this,"Debes ingresar una fecha y no debe ser mayor a 10 caracteres, "+ "es obligatorio",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            txtfechanacimientopaciente.requestFocus();
            return; 
        }
        
         // Obtener el cliente seleccionado del ComboBox
        String clienteSeleccionado = cbonombrecliente1.getSelectedItem().toString();
        int idCliente = CONTROL.obtenerIdClientePorNombre(clienteSeleccionado);  // Método para obtener el ID del cliente
        

        
        String resp;
        if(this.accion.equals("Editar")){
            // Actualizar datos del paciente
        resp = this.CONTROL.actualizar(
                Integer.parseInt(txtID.getText()),  
                txtnombrepaciente.getText(),
                this.NombreAnt,
                txtrazapaciente.getText(),
                txtcolorpaciente.getText(),
                Double.parseDouble(txtpesopaciente.getText()),  // Conversión de peso a Double
                Integer.parseInt(txtedadpaciente.getText()),  // Conversión de edad a int
                txtfechanacimientopaciente.getText(),
                clienteSeleccionado  // Nombre del cliente seleccionado
                
        );

        if (resp.equals("OK")) {
            this.mensajeOK("Actualizado correctamente");
            this.listar("");
            tabGeneral.setSelectedIndex(0);
            tabGeneral.setEnabledAt(1, false);
            tabGeneral.setEnabledAt(0, true);
        } else {
            this.mensajeError(resp);
        }
    } else {
        // Insertar nuevo paciente
        resp = this.CONTROL.insertar(
                
                txtnombrepaciente.getText(),
                txtrazapaciente.getText(),
                txtcolorpaciente.getText(),
                Double.parseDouble(txtpesopaciente.getText()),
                Integer.parseInt(txtedadpaciente.getText()),
                txtfechanacimientopaciente.getText(),
                clienteSeleccionado
        );
        if (resp.equals("OK")) {
            this.mensajeOK("Registrado correctamente");
            this.listar("");
            tabGeneral.setSelectedIndex(0);
            tabGeneral.setEnabledAt(1, false);
            tabGeneral.setEnabledAt(0, true);
        } else {
            this.mensajeError(resp);
        }
    }
    }//GEN-LAST:event_btnguardarpacienteActionPerformed

    private void txtfechanacimientopacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfechanacimientopacienteFocusGained
        if(txtfechanacimientopaciente.getText().equals("ingresar fecha")){
           txtfechanacimientopaciente.setText("");
           txtfechanacimientopaciente.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtfechanacimientopacienteFocusGained

    private void txtfechanacimientopacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfechanacimientopacienteFocusLost
        if(txtfechanacimientopaciente.getText().equals("")){
           txtfechanacimientopaciente.setText("ingresar fecha");
           txtfechanacimientopaciente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtfechanacimientopacienteFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactivarpaciente;
    private javax.swing.JButton btncancelarpacientes;
    private javax.swing.JButton btndesactivarpaciente;
    private javax.swing.JButton btneditarpaciente;
    private javax.swing.JButton btnguardarpaciente;
    private javax.swing.JButton btnregistrarpaciente;
    private javax.swing.JComboBox<String> cbonombrecliente1;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaregistropacientes;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtbuscarpaciente;
    private javax.swing.JTextField txtcolorpaciente;
    private javax.swing.JTextField txtedadpaciente;
    private javax.swing.JTextField txtfechanacimientopaciente;
    private javax.swing.JTextField txtnombrepaciente;
    private javax.swing.JTextField txtpesopaciente;
    private javax.swing.JTextField txtrazapaciente;
    private javax.swing.JLabel txttotalregistrado;
    // End of variables declaration//GEN-END:variables
}
