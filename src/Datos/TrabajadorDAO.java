
package Datos;

import Datos.CrudInterface.TrabajadorInterface;
import database.Conexion;
import entidades.Trabajador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




public class TrabajadorDAO implements TrabajadorInterface<Trabajador> {
    
    //Varaibles
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    //Constructor vacio

    public TrabajadorDAO() {
        CON=Conexion.getInstancia();
    }
    
    

    @Override
    public List<Trabajador> listar(String texto) {
        List<Trabajador> registros = new ArrayList<>();
        try {
            // Aquí hacemos un JOIN entre productos y categorias
            ps = CON.conectar().prepareStatement("SELECT * FROM trabajadores WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Trabajador(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getBoolean(7)));
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
    public boolean insertar(Trabajador obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO trabajadores(nombre,especialidad,telefono,email,fecha_contratacion,condicion) VALUES(?,?,?,?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getEspecialidad());
            ps.setInt(3, obj.getTelefono());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getFecha_contratacion());
            if(ps.executeUpdate() > 0){
                resp=true;
            }
            ps.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al registrar al trabajador"+ e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Trabajador obj) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE trabajadores SET nombre=?, especialidad=?, telefono=?, email=?, fecha_contratacion=? WHERE id_trabajador=?");
            ps.setString(1,obj.getNombre());
            ps.setString(2, obj.getEspecialidad());
            ps.setInt(3, obj.getTelefono());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getFecha_contratacion());
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
            ps=CON.conectar().prepareStatement("UPDATE trabajadores SET condicion=0 WHERE id_trabajador=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede desactivar al trabajador"+ e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE trabajadores SET condicion=1 WHERE id_trabajador=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede activar al trabajador"+ e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT COUNT(id_trabajador)FROM trabajadores");
            rs=ps.executeQuery();
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id_trabajador)");
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede obtener el total de trabajadores" + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT nombre FROM trabajadores WHERE nombre=?");
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
    public List<Trabajador>seleccionarTrabajador(){
        List<Trabajador> registros = new ArrayList();
        try{
            ps=CON.conectar().prepareStatement("SELECT id_trabajador,nombre FROM trabajadores ORDER BY nombre ASC");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Trabajador(rs.getInt(1),rs.getString(2)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede cargar los trabajadores "+ e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

}
    

