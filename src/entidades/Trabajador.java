
package entidades;


public class Trabajador {
    
    //variables 
    private int id_trabajador;
    private String nombre;
    private String especialidad;
    private int telefono;
    private String email;
    private String fecha_contratacion;
    private boolean condicion;
    
    //Constructor Vacio
    public Trabajador() {
    }
    
    
    //Constructor con parametros

    public Trabajador(int id_trabajador, String nombre, String especialidad, int telefono, String email, String fecha_contratacion, boolean condicion) {
        this.id_trabajador = id_trabajador;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
        this.fecha_contratacion = fecha_contratacion;
        this.condicion = condicion;
    }
    
     public Trabajador(int id_trabajador, String nombre){
        this.id_trabajador= id_trabajador;
        this.nombre= nombre;
    }
    
    //getter and setter

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public boolean isCondicion() {
        return condicion;
    }

    
    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }

    //ToString

    @Override
    public String toString() {
        return "Trabajador{" + "id_trabajador=" + id_trabajador + ", nombre=" + nombre + ", especialidad=" + especialidad + ", telefono=" + telefono + ", email=" + email + ", fecha_contratacion=" + fecha_contratacion + ", condicion=" + condicion + '}';
    }
    
}
