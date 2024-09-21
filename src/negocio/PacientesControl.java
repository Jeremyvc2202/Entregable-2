package negocio;

import Datos.ClienteDAO;
import Datos.PacienteDAO;
import entidades.Cliente;
import entidades.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class PacientesControl {

    private final ClienteDAO DATOSCLI;
    private final PacienteDAO DATOS;
    private Paciente obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados = 0;

    // Constructor vacío
    public PacientesControl() {
        this.DATOSCLI = new ClienteDAO();
        this.DATOS = new PacienteDAO();
        this.obj = new Paciente();
        this.registrosMostrados = 0;
    }

    // Método para seleccionar cliente
    public DefaultComboBoxModel seleccionar() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Cliente> lista = DATOSCLI.seleccionarCliente();
        for (Cliente item : lista) {
            items.addElement(item.getNombre());  // Agregar solo el nombre del cliente al ComboBox
        }
        return items;
    }

    // Método para listar Pacientes
    public DefaultTableModel listar(String texto) {
        List<Paciente> lista = DATOS.listar(texto);
        String[] titulos = {"id_mascota", "Nombre", "Raza", "Color", "Peso", "Edad", "Fecha_Nacimiento", "Cliente", "Condicion"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        String[] registro = new String[9];
        this.registrosMostrados = 0;
        for (Paciente item : lista) {
            registro[0] = Integer.toString(item.getId_mascota());
            registro[1] = item.getNombre();
            registro[2] = item.getRaza();
            registro[3] = item.getColor();
            registro[4] = Double.toString(item.getPeso());
            registro[5] = Integer.toString(item.getEdad());
            registro[6] = item.getFecha_nacimiento();
            registro[7] = item.getNombre_cliente();
            registro[8] = item.isCondicion() ? "Activo" : "Inactivo";
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }
    // --- Aquí agregamos el nuevo método ---
    public int obtenerIdClientePorNombre(String nombreCliente) {
        return DATOSCLI.obtenerIdPorNombre(nombreCliente);  // Este método debe estar implementado en ClienteDAO
    }

    // Método para actualizar datos de pacientes
    public String actualizar(int id, String nombre, String nombreAnt, String raza, String color, double peso, int edad, String fecha_nacimiento, String nombre_cliente) {
        if (nombre.equals(nombreAnt) || !DATOS.existe(nombre)) {  // Verificar si es el mismo nombre o no existe en la BD
            obj.setId_mascota(id);
            obj.setNombre(nombre);
            obj.setRaza(raza);
            obj.setColor(color);
            obj.setPeso(peso);
            obj.setEdad(edad);
            obj.setFecha_nacimiento(fecha_nacimiento);
            obj.setNombre_cliente(nombre_cliente);

            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización";
            }
        } else {
            return "El nombre del paciente ya existe";
        }
    }

    // Método para insertar datos de pacientes
    public String insertar(String nombre, String raza, String color, double peso, int edad, String fecha_nacimiento, String nombre_cliente) {
        if (DATOS.existe(nombre)) {
            return "El nombre del paciente ya existe en nuestra BD";
        } else {
            
            obj.setNombre(nombre);
            obj.setRaza(raza);
            obj.setColor(color);
            obj.setPeso(peso);
            obj.setEdad(edad);
            obj.setFecha_nacimiento(fecha_nacimiento);
            obj.setNombre_cliente(nombre_cliente);

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error al registrar el paciente";
            }
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrado() {
        return this.registrosMostrados;
    }

    // Método para desactivar paciente
    public String desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el paciente";
        }
    }

    public String activar(int id) {
        if (DATOS.activar(id)) {
            return "OK";
        } else {
            return "No se puede activar el paciente";
        }
    }
   
    
    
}