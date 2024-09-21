
package entidades;


public class Citas {
    //variables
    private int id_cita;
    private String fecha_cita;
    private String proxima_cita;
    private String motivo;
    private String nombre_cliente;
    private String nombre_mascota;
    private String nombre_trabajador;
    private boolean condicion;
    
    
    //Constructor vacio 

    public Citas() {
    }
    
   
    
    //Constructor con parametros 

    public Citas(int id_cita, String fecha_cita, String proxima_cita, String motivo, String nombre_cliente, String nombre_mascota, String nombre_trabajador, boolean condicion) {
        this.id_cita = id_cita;
        this.fecha_cita = fecha_cita;
        this.proxima_cita = proxima_cita;
        this.motivo = motivo;
        this.nombre_cliente = nombre_cliente;
        this.nombre_mascota = nombre_mascota;
        this.nombre_trabajador = nombre_trabajador;
        this.condicion = condicion;
    }

    //Getter and setter

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getProxima_cita() {
        return proxima_cita;
    }

    public void setProxima_cita(String proxima_cita) {
        this.proxima_cita = proxima_cita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
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
        return "Citas{" + "id_cita=" + id_cita + ", fecha_cita=" + fecha_cita + ", proxima_cita=" + proxima_cita + ", motivo=" + motivo + ", nombre_cliente=" + nombre_cliente + ", nombre_mascota=" + nombre_mascota + ", nombre_trabajador=" + nombre_trabajador + ", condicion=" + condicion + '}';
    }
    
}
