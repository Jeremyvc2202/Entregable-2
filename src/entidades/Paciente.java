
package entidades;


public class Paciente {
    //variables
    private int id_mascota;
    private String nombre;
    private String raza;
    private String color;
    private double peso;
    private int edad;
    private String fecha_nacimiento;
    private String nombre_cliente;
    private boolean condicion;
    
    //constructor vacio
    public Paciente() {
    }
    
    
    //constructor con parametros
    public Paciente(int id_mascota, String nombre, String raza, String color, double peso, int edad, String fecha_nacimiento, String nombre_cliente, boolean condicion) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.peso = peso;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombre_cliente = nombre_cliente;
        this.condicion = condicion;
    }
    
    public Paciente(int id_mascota, String nombre){
        this.id_mascota= id_mascota;
        this.nombre= nombre;
    }
    
    //getter and setter

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }
    //To String
    @Override
    public String toString() {
        return "Paciente{" + "id_mascota=" + id_mascota + ", nombre=" + nombre + ", raza=" + raza + ", color=" + color + ", peso=" + peso + ", edad=" + edad + ", fecha_nacimiento=" + fecha_nacimiento + ", nombre_cliente=" + nombre_cliente + ", condicion=" + condicion + '}';
    }

    
}

    
    
  

    