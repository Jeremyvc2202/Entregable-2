
package entidades;

public class Cliente {
    
    //variables
    private int id_cliente;
    private String Nombre;
    private String direccion;
    private int telefono;
    private String email;
    private String fecha_registro;
    private boolean condicion;
    
    //Constructor vacio
    public Cliente() {
    }
    
    
    //Constructor con parametros
    public Cliente(int id_cliente, String Nombre, String direccion, int telefono, String email, String fecha_registro, boolean condicion) {
        this.id_cliente = id_cliente;
        this.Nombre = Nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_registro = fecha_registro;
        this.condicion = condicion;
    }
    
    
    //getter and setter 
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }
    
    //To string

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", Nombre=" + Nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", fecha_registro=" + fecha_registro + ", condicion=" + condicion + '}';
    }
    

    
    

    
}

    
    
    
    

   
