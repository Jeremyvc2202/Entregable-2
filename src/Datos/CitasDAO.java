
package Datos;

import Datos.CrudInterface.CitasInterface;
import database.Conexion;
import entidades.Citas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CitasDAO implements CitasInterface<Citas>{
    
    //Variables
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    //Constructor vacio

    public CitasDAO() {
        CON=Conexion.getInstancia();
    }
    
    

    @Override
    public List<Citas> listar(String texto) {
        List<Citas> registros = new ArrayList();
        try{
            ps=CON.conectar().prepareStatement(
                        "SELECT c.id_cita AS idcita, " +
                        "c.fecha_cita, c.proxima_cita, c.motivo, " +
                        "cl.nombre AS nombre_cliente ,ma.nombre AS nombre_mascota, " +
                        "tr.nombre AS nombre_trabajador, " +  
                        "c.condicion " + 
                        "FROM citas c " +
                        "INNER JOIN clientes cl ON c.id_cliente = cl.id_cliente " +
                        "INNER JOIN mascotas ma ON c.id_mascota = ma.id_mascota " +
                        "INNER JOIN trabajadores tr ON c.id_trabajador = tr.id_trabajador " +
                        "WHERE cl.nombre LIKE ?"
            );
            ps.setString(1,"%" + texto + "%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Citas(rs.getInt("idcita"),
                        rs.getString("fecha_cita"),  
                        rs.getString("proxima_cita"),
                        rs.getString("motivo"),
                        rs.getString("nombre_cliente"),
                        rs.getString("nombre_mascota"),
                        rs.getString("nombre_trabajador"),
                        rs.getBoolean("condicion")));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se¨Puede mostrar datos en la tabla" + e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Citas obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO citas(fecha_cita,proxima_cita,motivo,id_cliente,id_mascota,id_trabajador,condicion) VALUES(?,?,?,?,?,?,1)");
            ps.setString(1, obj.getFecha_cita());
            ps.setString(2, obj.getProxima_cita());
            ps.setString(3, obj.getNombre_cliente());
            ps.setString(3, obj.getNombre_mascota());
            ps.setString(3, obj.getNombre_trabajador());
            if(ps.executeUpdate() > 0){
                resp=true;
            }
            ps.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al registrar la cita"+ e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }
    @Override
    public boolean actualizar(Citas obj) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE citas SET fecha_cita=?, proxima_cita=?, motivo=?, id_cliente=?, id_mascota=?, id_trabajador=? WHERE id_cita=?");
            ps.setString(1, obj.getFecha_cita());
            ps.setString(2, obj.getProxima_cita());
            ps.setString(3, obj.getNombre_cliente());
            ps.setString(3, obj.getNombre_mascota());
            ps.setString(3, obj.getNombre_trabajador());
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
            ps=CON.conectar().prepareStatement("UPDATE citas SET condicion=0 WHERE id_cita=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede desactivar la cita"+ e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE citas SET condicion=1 WHERE id_cita=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede activar la cita"+ e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT COUNT(id_cita)FROM citas");
            rs=ps.executeQuery();
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id_cita)");
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se puede obtener el total de citas" + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT id_cliente FROM citas WHERE id_cliente=?");
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
    
}
