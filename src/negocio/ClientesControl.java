package negocio;

import Datos.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClientesControl {

    // Variables
    private final ClienteDAO DATOS;
    private Cliente obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados = 0;

    // Constructor vacío
    public ClientesControl() {
        this.DATOS = new ClienteDAO();
        this.obj = new Cliente();
        this.registrosMostrados = 0;
    }

    // Método para listar clientes
    public DefaultTableModel listar(String texto) {
        List<Cliente> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));

        String[] titulos = {"id_cliente", "nombre", "direccion", "telefono", "email", "fecha_registro", "condicion"};  
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String condicion;
        String[] registro = new String[7]; // Cambié a 7 para incluir todos los campos

        this.registrosMostrados = 0;

        for (Cliente item : lista) {
            if (item.isCondicion()) {
                condicion = "Activo";
            } else {
                condicion = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId_cliente());
            registro[1] = item.getNombre();
            registro[2] = item.getDireccion();
            registro[3] = String.valueOf(item.getTelefono()); // Corregido el teléfono
            registro[4] = item.getEmail();
            registro[5] = item.getFecha_registro(); // Asegúrate de que el formato de fecha esté bien
            registro[6] = condicion;

            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados +1;
        }
        return this.modeloTabla;
    }
    
    
    // Metodo para actualizar datos de la categoria
    public String actualizar(int id, String nombre, String nombreAnt, String direccion, int telefono, String email, String fecha_registro, boolean condicion) {
    // Verificar si el nombre es el mismo que el anterior
    if (nombre.equals(nombreAnt)) {
        obj.setId_cliente(id);
        obj.setNombre(nombre);
        obj.setDireccion(direccion);
        obj.setTelefono(telefono);
        obj.setEmail(email);
        obj.setFecha_registro(fecha_registro);
        obj.setCondicion(condicion); // Asegurarse de asignar el valor de condicion correctamente

        // Intentar actualizar los datos
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "Error en la actualización";
        }
    } else {
        // Verificar si el nuevo nombre ya existe en la base de datos
        if (DATOS.existe(nombre)) {
            return "El cliente ya existe";
        } else {
            obj.setId_cliente(id);
            obj.setNombre(nombre);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            obj.setFecha_registro(fecha_registro);
            obj.setCondicion(condicion); // Asegurarse de asignar el valor de condicion correctamente

            // Intentar actualizar los datos
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización";
            }
        }
    }
}

    //metodo para registrar categoria
    // Metodo para registrar cliente
public String insertar(int id, String nombre, String direccion, int telefono, String email, String fecha_registro, boolean condicion) {
    // Verificar si el nombre ya existe en la base de datos
    if (DATOS.existe(nombre)) {
        return "El nombre del cliente ya existe en nuestra BD";
    } else {
        obj.setId_cliente(id);
        obj.setNombre(nombre);
        obj.setDireccion(direccion);
        obj.setTelefono(telefono);
        obj.setEmail(email);
        obj.setFecha_registro(fecha_registro);
        obj.setCondicion(condicion); // Asegurarse de asignar el valor de condicion correctamente

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

    
    //metodo para desactivar categoria
    public String desactivar(int id){
        if(DATOS.desactivar(id)){
            return "OK";
        }else{
            return "No se puede desactivar el producto";
        }
    }
    
    public String activar(int id){
        if(DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar el producto";
        }
    }
}
