package empresaQatar2022;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private int dni;

    private String nacionalidad;
    private int idDepartamento;


    public Empleado() {
    }

    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(String nombre, String apellido, int dni, String nacionalidad, int idDepartamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.idDepartamento = idDepartamento;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, int dni, String nacionalidad, int idDepartamento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.idDepartamento = idDepartamento;
    }

      public int getIdEmpleado() {
        return idEmpleado;
    }

    public Empleado(String nombre, String apellido, int dni, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public String toString() {
        return "  ID= " + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni= " + dni +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", Departamento= " + idDepartamento;
    }
}
