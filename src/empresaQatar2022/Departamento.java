package empresaQatar2022;

public class Departamento extends Empleado{
    private int idDepartamento;
    private String departamento;
    private Double presupuesto;

    public Departamento() {
    }

    public Departamento( String nombre, String apellido, int dni, String nacionalidad, String departamento) {
        super(nombre, apellido, dni, nacionalidad);
        this.departamento = departamento;
    }

    public Departamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Departamento(int idDepartamento, String departamento, Double presupuesto) {
        this.idDepartamento = idDepartamento;
        this.departamento = departamento;
        this.presupuesto = presupuesto;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return  "ID= " + idDepartamento +
                ", departamento='" + departamento + '\'' +
                ", presupuesto=" + presupuesto;
    }


}
