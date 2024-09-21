
package Datos;

import Datos.CrudInterface.PacienteInterface;
import database.Conexion;
import entidades.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PacienteDAO implements PacienteInterface<Paciente> {
    
    //Variables
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    
    //Constructor sin parametros
    public PacienteDAO() {
        CON=Conexion.getInstancia();
    }
    
    
    //Método Listar
    @Override
    public List<Paciente> listar(String texto) {
        List<Paciente> registros = new ArrayList<>();
        try {
            // Aquí hacemos un JOIN entre productos y categorias
            ps = CON.conectar().prepareStatement(
                "SELECT m.id_mascota AS IdMascota, " +
                "m.nombre, m.raza, m.color, m.peso, " +
                "m.edad, m.fecha_nacimiento, " +
                "c.nombre AS nombre_cliente, " +  // Aquí asegúrate de incluir la coma.
                "m.condicion " +  // Cambié "p.condicion" por "m.condicion" si "condicion" está en la tabla "mascotas".
                "FROM mascotas m " +
                "INNER JOIN clientes c ON m.id_cliente = c.id_cliente " +
                "WHERE m.nombre LIKE ?"
            );


            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                registros.add(new Paciente(rs.getInt("idmascota"),
                                           rs.getString("nombre"),  
                                           rs.getString("raza"),
                                           rs.getString("color"),
                                           rs.getDouble("peso"),
                                           rs.getInt("edad"),
                                           rs.getString("fecha_nacimiento"),
                                           rs.getString("nombre_cliente"),
                                           rs.getBoolean("condicion")
                ));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar datos en la tabla: " + e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Paciente obj) {
       resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO mascotas(nombre,raza,color,peso,edad,fecha_nacimiento,id_cliente,condicion) VALUES(?,?,?,?,?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getRaza());
            ps.setString(3, obj.getColor());
            ps.setDouble(4, obj.getPeso());
            ps.setInt(5, obj.getEdad());
            ps.setString(6, obj.getFecha_nacimiento());
            ps.setString(5, obj.getNombre_cliente());
            if(ps.executeUpdate() > 0){
                resp=true;
            }
            ps.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al registrar al Cliente"+ e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Paciente obj) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE mascotas SET nombre=?, raza=?, color=?, peso=?,edad=?, fecha_nacimiento=?, idcliente=? WHERE id_mascota=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getRaza());
            ps.setString(3, obj.getColor());
            ps.setDouble(4, obj.getPeso());
            ps.setInt(5, obj.getEdad());
            ps.setString(6, obj.getFecha_nacimiento());
            ps.setString(7, obj.getNombre_cliente());
            if(ps.executeUpdate() > 0){
               resp=true;
           }
           ps.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"No se puede actualizar los datos"+ e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
       resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE mascotas SET condicion=0 WHERE id_mascota=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede desactivar al paciente"+ e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp; 
    }

    @Override
    public boolean activar(int id) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE mascotas SET condicion=1 WHERE id_mascota=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede activar al paciente"+ e.getMessage());
        }finally{
            ps=null;
            CON.conectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros=0;
        try{
            ps=CON.conectar().prepareStatement("SELECT COUNT(id_mascota)FROM mascotas");
            rs=ps.executeQuery();
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id_mascota)");
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede obtener el total de mascotas" + e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("SELECT nombre FROM mascotas WHERE nombre=?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
               resp=true;
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede validar datos"+ e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
    //metodo para la consulta SQL para seleccionar clientes
    public List<Paciente>seleccionarPaciente(){
        List<Paciente> registros = new ArrayList();
        try{
            ps=CON.conectar().prepareStatement("SELECT id_mascota,nombre FROM mascotas ORDER BY nombre ASC");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Paciente(rs.getInt(1),rs.getString(2)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede cargar a las mascotas "+ e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
    
}
