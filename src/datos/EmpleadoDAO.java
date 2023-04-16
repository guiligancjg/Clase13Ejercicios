package datos;

import empresaQatar2022.Empleado;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import static datos.Conexion.*;

public class EmpleadoDAO {
    private static final String SQL_SELECT = "SELECT id_empleado, nombre, apellido, dni, nacionalidad, id_departamento FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado(nombre,apellido,dni,nacionalidad,id_departamento) VALUE (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET nombre = ?, apellido = ?, dni = ?, nacionalidad = ?, id_departamento = ?  WHERE id_empleado = ?";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE id_empleado = ?";


    public List<Empleado> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while(rs.next()){
                int idEmpleado = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                String nacionalidad = rs.getString("nacionalidad");
                int idDepartamento = rs.getInt("id_departamento");
                empleado = new Empleado(idEmpleado,nombre,apellido,dni,nacionalidad,idDepartamento);
                empleados.add(empleado);
            }
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }

        return empleados;
    }


    public int insertar(Empleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setInt(3,empleado.getDni());
            stmt.setString(4, empleado.getNacionalidad());
            stmt.setInt(5,empleado.getIdDepartamento());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
    return registros;
    }

    public int actualizar(Empleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setInt(3,empleado.getDni());
            stmt.setString(4, empleado.getNacionalidad());
            stmt.setInt(5,empleado.getIdDepartamento());
            stmt.setInt(6, empleado.getIdEmpleado());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int eliminar(Empleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getIdEmpleado());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

}
