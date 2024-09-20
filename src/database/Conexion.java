
package database;

//Libreria para la conexion SQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
    //Variables
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/";
    private final String DB="bdveterinaria";
    private final String USER="root";
    private final String PASSWORD="";
    
    
    public Connection cadena;//variable que importa la libreria sql
    public static Conexion instancia;// variable de instancia a la clase
    
    //constructor vacio

    public Conexion() {
        this.cadena=null;
    }
    
    //metodo para conectarme de la base de datos
    public Connection conectar(){
        //
        try{
            Class.forName(DRIVER);
            this.cadena=DriverManager.getConnection(URL+DB,USER,PASSWORD);
            System.out.println("Conexion establecida a bdveterinaria");
        }catch(ClassNotFoundException | SQLException e ){
            JOptionPane.showMessageDialog(null,"Error de conexion"+ e.getMessage());
            System.exit(0);
        }
        return this.cadena;
    }
    
    //metodo para desconectar la base de datos
    public void desconectar(){
        
        try{
            this.cadena.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo cerrar la consulta Statement"+ e.getMessage());
        }
    }  
    
    //metodo para intanciar a la conexion - sincronización
    public synchronized static Conexion getInstancia(){
    
        if(instancia==null){
            instancia=new Conexion();
        }
        return instancia;
    }
}
    
    
    

