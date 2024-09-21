
package negocio;

import Datos.CitasDAO;
import Datos.ClienteDAO;
import Datos.PacienteDAO;
import Datos.TrabajadorDAO;
import entidades.Citas;
import entidades.Cliente;
import entidades.Paciente;
import entidades.Trabajador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class CitasControl {
    
    private final ClienteDAO DATOSCLIENTE;
    private final PacienteDAO DATOSPACIENTE;
    private final TrabajadorDAO DATOSTRABAJADOR;
    
    //Variables
    private final CitasDAO DATOS;
    private Citas obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados = 0;
    
    //Constructor Vacio

    public CitasControl() {
        this.DATOSCLIENTE = new ClienteDAO();
        this.DATOSPACIENTE = new PacienteDAO();
        this.DATOSTRABAJADOR = new TrabajadorDAO();
        this.DATOS = new CitasDAO();
        this.obj = new Citas();
        this.registrosMostrados = 0;
    }
    
    //metodo para seleccionar al cliente
    public DefaultComboBoxModel seleccionarCliente(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Cliente> lista = new ArrayList();
        lista=DATOSCLIENTE.seleccionarCliente();
        for(Cliente item:lista){
            items.addElement(new Cliente(item.getId_cliente(),item.getNombre()));
        }
        return items;

    }
    //metodo para seleccionar al paciente
    public DefaultComboBoxModel seleccionarPaciente(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Paciente> lista = new ArrayList();
        lista=DATOSPACIENTE.seleccionarPaciente();
        for(Paciente item:lista){
            items.addElement(new Paciente(item.getId_mascota(),item.getNombre()));
        }
        return items;

    }
    
    //metodo para seleccionar al trabajador
    public DefaultComboBoxModel seleccionarTrabajador(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Trabajador> lista = new ArrayList();
        lista=DATOSTRABAJADOR.seleccionarTrabajador();
        for(Trabajador item:lista){
            items.addElement(new Trabajador(item.getId_trabajador(),item.getNombre()));
        }
        return items;

    }
    
   
    
    // Método para listar clientes
    public DefaultTableModel listar(String texto) {
        List<Citas> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));

        String[] titulos = {"id_cita","Fecha_cita","Proxima_cita","Motivo","Cliente","Mascota","Trabajador","Condicion"};  
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String condicion;
        String[] registro = new String[8]; // Cambié a 8 para incluir todos los campos

        this.registrosMostrados = 0;

        for (Citas item:lista) {
            if (item.isCondicion()) {
                condicion = "Activo";
            } else {
                condicion = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId_cita());
            registro[1] = item.getFecha_cita();                 
            registro[2] = item.getProxima_cita();               
            registro[3] = item.getMotivo();                    
            registro[4] = item.getNombre_cliente();             
            registro[5] = item.getNombre_mascota();            
            registro[6] = item.getNombre_trabajador();         
            registro[7] = condicion;

            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados +1;
        }
        return this.modeloTabla;  
    }
    
    // Metodo para actualizar datos de pacientes
    public String actualizar(int id, String fecha_cita, String nombreAnt, String proxima_cita,String motivo,String nombre_cliente, String nombre_mascota, String nombre_trabajador){
    // Verificar si el nombre es el mismo que el anterior
    if (fecha_cita.equals(nombreAnt)) {
        obj.setId_cita(id);
        obj.setFecha_cita(fecha_cita);
        obj.setProxima_cita(proxima_cita);
        obj.setMotivo(motivo);
        obj.setNombre_cliente(nombre_cliente);
        obj.setNombre_mascota(nombre_mascota);
        obj.setNombre_trabajador(nombre_trabajador);

        // Intentar actualizar los datos
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "Error en la actualización";
        }
    } else {
        // Verificar si el nuevo nombre ya existe en la base de datos
        if (DATOS.existe(fecha_cita)) {
            return "La cita ya existe";
        } else {
            obj.setId_cita(id);
            obj.setFecha_cita(fecha_cita);
            obj.setProxima_cita(proxima_cita);
            obj.setMotivo(motivo);
            obj.setNombre_cliente(nombre_cliente);
            obj.setNombre_mascota(nombre_mascota);
            obj.setNombre_trabajador(nombre_trabajador);

            // Intentar actualizar los datos
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización";
            }
        }
    }
}
    public String insertar(int id, String fecha_cita, String nombreAnt, String proxima_cita,String motivo,String nombre_cliente, String nombre_mascota, String nombre_trabajador){
    // Verificar si el nombre ya existe en la base de datos
        if (DATOS.existe(fecha_cita)) {
            return "La cita ya existe en nuestra BD";
        } else {
            obj.setId_cita(id);
            obj.setFecha_cita(fecha_cita);
            obj.setProxima_cita(proxima_cita);
            obj.setMotivo(motivo);
            obj.setNombre_cliente(nombre_cliente);
            obj.setNombre_mascota(nombre_mascota);
            obj.setNombre_trabajador(nombre_trabajador);

        // Intentar insertar los datos
        if (DATOS.insertar(obj)) {
            return "OK";
        } else {
            return "Error al registrar el cliente";
        }
    }
}
    
    public int total(){
        return DATOS.total();
    }  
    public int totalMostrado(){
        return this.registrosMostrados;
    }
    
    //metodo para desactivar al trabajador
    public String desactivar(int id){
        if(DATOS.desactivar(id)){
            return "OK";
        }else{
            return "No se puede desactivar la condición de la cita";
        }
    }
    //metodo para activar al trabajador
    public String activar(int id){
        if(DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar la condición de la cita";
        }
    }
}
