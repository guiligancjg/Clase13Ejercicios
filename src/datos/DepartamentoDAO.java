package datos;

import empresaQatar2022.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;

public class DepartamentoDAO {
    private static final String SQL_SELECT = "SELECT id_departamento, departamento, presupuesto FROM departamento";
    private static final String SQL_INSERT = "INSERT INTO departamento(departamento,presupuesto) VALUE (?,?)";
    private static final String SQL_UPDATE = "UPDATE departamento SET departamento = ?, presupuesto = ?  WHERE id_departamento = ?";
    private static final String SQL_DELETE = "DELETE FROM departamento WHERE id_departamento = ?";
    private static final String SQL_DEPAR = "SELECT empleado.nombre, empleado.apellido, empleado.dni, empleado.nacionalidad, departamento.departamento FROM qatar2022.empleado INNER JOIN qatar2022.departamento ON empleado.id_departamento = departamento.id_departamento WHERE departamento.id_departamento = ?";

    public List<Departamento> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Departamento departamento = null;
        List<Departamento> departamentos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while(rs.next()){
                int idDepartamento = rs.getInt("id_departamento");
                String depar = rs.getString("departamento");
                Double presupuesto = rs.getDouble("presupuesto");
                departamento = new Departamento(idDepartamento,depar,presupuesto);
                departamentos.add(departamento);
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

        return departamentos;
    }

    public List<Departamento> seleccionarDepartamento(Departamento departamento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //Departamento departamento = null;
        List<Departamento> departamentos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DEPAR);
            stmt.setInt(1, departamento.getIdDepartamento());
            rs = stmt.executeQuery();

            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                String nacionalidad = rs.getString("nacionalidad");
                String depar = rs.getString("departamento");
                departamento = new Departamento(nombre,apellido,dni,nacionalidad,depar);
                departamentos.add(departamento);
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

        return departamentos;
    }
    public int eliminar(Departamento departamento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, departamento.getIdDepartamento());
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
