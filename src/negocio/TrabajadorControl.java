
package negocio;

import Datos.TrabajadorDAO;
import entidades.Trabajador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TrabajadorControl {
    
    //variables
    private final TrabajadorDAO DATOS;
    private Trabajador obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados = 0;
    
    //Constructor vacio

    public TrabajadorControl() {
        this.DATOS = new TrabajadorDAO();
        this.obj = new Trabajador();
        this.registrosMostrados = 0;
    }
    // Método para listar clientes
        public DefaultTableModel listar(String texto) {
        List<Trabajador> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));

        String[] titulos = {"id_trabajador", "Nombre", "Especialidad", "Telefono", "Email", "Fecha_Contratacion", "Condicion"};  
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String condicion;
        String[] registro = new String[7]; // Cambié a 7 para incluir todos los campos

        this.registrosMostrados = 0;

        for (Trabajador item : lista) {
            if (item.isCondicion()) {
                condicion = "Activo";
            } else {
                condicion = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId_trabajador());
            registro[1] = item.getNombre();
            registro[2] = item.getEspecialidad();
            registro[3] = String.valueOf(item.getTelefono()); // Corregido el teléfono
            registro[4] = item.getEmail();
            registro[5] = item.getFecha_contratacion(); // Asegúrate de que el formato de fecha esté bien
            registro[6] = condicion;

            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados +1;
        }
        return this.modeloTabla;
    }  
        // Metodo para actualizar datos de pacientes
    public String actualizar(int id, String nombre, String nombreAnt, String especialidad,int telefono, String email,String fecha_contratacion){
    // Verificar si el nombre es el mismo que el anterior
    if (nombre.equals(nombreAnt)) {
        obj.setId_trabajador(id);
        obj.setNombre(nombre);
        obj.setEspecialidad(especialidad);
        obj.setTelefono(telefono);
        obj.setEmail(email);
        obj.setFecha_contratacion(fecha_contratacion);
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
            obj.setId_trabajador(id);
            obj.setNombre(nombre);
            obj.setEspecialidad(especialidad);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            obj.setFecha_contratacion(fecha_contratacion);

            // Intentar actualizar los datos
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización";
            }
        }
    }
}
    public String insertar(int id, String nombre, String especialidad,int telefono, String email,String fecha_contratacion){
    // Verificar si el nombre ya existe en la base de datos
        if (DATOS.existe(nombre)) {
            return "El nombre del trabajador ya existe en nuestra BD";
        } else {
            obj.setId_trabajador(id);
            obj.setNombre(nombre);
            obj.setEspecialidad(especialidad);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            obj.setFecha_contratacion(fecha_contratacion);
        // Intentar insertar los datos
        if (DATOS.insertar(obj)) {
            return "OK";
        } else {
            return "Error al registrar el trabajador";
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
            return "No se puede desactivar la condición den trabajador";
        }
    }
    //metodo para activar al trabajador
    public String activar(int id){
        if(DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar la condición den trabajador";
        }
    }
}
   
