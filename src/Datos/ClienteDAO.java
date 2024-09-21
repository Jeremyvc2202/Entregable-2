package Datos;
import Datos.CrudInterface.ClienteInterface;
import database.Conexion;
import entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO implements ClienteInterface<Cliente> {
    // Variables
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    // Constructor
    public ClienteDAO() {
        CON = Conexion.getInstancia();
    }

    // Método Listar
    @Override
    public List<Cliente> listar(String texto) {
        List<Cliente> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM clientes WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar datos en la tabla: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return registros;
    }

    @Override
    public boolean insertar(Cliente obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO clientes(nombre, direccion, telefono, email, fecha_registro, condicion) VALUES(?,?,?,?,?,?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            ps.setInt(3, obj.getTelefono());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getFecha_registro());
            ps.setBoolean(6, obj.isCondicion());  // Si "condicion" es boolean
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar al Cliente: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Cliente obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE clientes SET nombre=?, direccion=?, telefono=?, email=?, fecha_registro=? WHERE id_cliente=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            ps.setInt(3, obj.getTelefono());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getFecha_registro());
            ps.setInt(6, obj.getId_cliente());
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE clientes SET condicion=0 WHERE id_cliente=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede desactivar Clientes: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE clientes SET condicion=1 WHERE id_cliente=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede activar Clientes: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(id_cliente) FROM clientes");
            rs = ps.executeQuery();
            if (rs.next()) {
                totalRegistros = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede obtener el total de clientes: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("SELECT nombre FROM clientes WHERE nombre=?");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            if (rs.next()) {
                resp = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede validar datos: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return resp;
    }

    // Método para la consulta SQL para seleccionar clientes
    public List<Cliente> seleccionarCliente() {
        List<Cliente> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT id_cliente, nombre FROM clientes ORDER BY nombre ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Cliente(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede cargar categorías: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return registros;
    }

    // Implementación del método obtenerIdPorNombre
    public int obtenerIdPorNombre(String nombreCliente) {
        int idCliente = -1;
        try {
            ps = CON.conectar().prepareStatement("SELECT id_cliente FROM clientes WHERE nombre = ?");
            ps.setString(1, nombreCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                idCliente = rs.getInt("id_cliente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID del cliente: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return idCliente;
    }

    // Método para cerrar recursos (PreparedStatement y ResultSet)
    private void cerrarRecursos() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            CON.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
        }
    }
}