package empresaQatar2022;

import datos.DepartamentoDAO;
import datos.EmpleadoDAO;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AltaBajasModificaciones {
    int idEmpleado;
    String nombre;
    String apellido;
    int dni;
    String nacionalidad;
    int idDepartamento;

    public void listarEmpleados(){
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.seleccionar();
        System.out.format("\n%-7s%-12s%-12s%-12s%-10s\n","-ID-","-Nombre-","-Apellido-","-DNI-","-Nacionalidad-");
        for (Empleado empleado: empleados) {
            System.out.format("%-7s%-12s%-12s%-12s%-10s\n",empleado.getIdEmpleado(),empleado.getNombre(),empleado.getApellido(),empleado.getDni(),empleado.getNacionalidad());
        }
    }
    public void altaEmpleado(){
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        Scanner consola = new Scanner(System.in);


        System.out.print("Ingrese su Nombre: ");
        String nombre = consola.next();

        System.out.print("Ingrese su Apellido: ");
        String apellido = consola.next();

        System.out.print("Ingrese su DNI: ");
        int dni = consola.nextInt();

        System.out.print("Ingrese su Nacionalidad: ");
        String nacionalidad = consola.next();

        System.out.print("Ingrese su Departamento: ");
        int departamento = consola.nextInt();


        Empleado empleado = new Empleado(nombre,apellido,dni,nacionalidad,departamento);
        if (empleadoDAO.insertar(empleado) == 1){
            System.out.println("\nEl Empleado fue Ingresado...");
        }
    }

    public void modificar(){
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.seleccionar();

        System.out.format("\n%-7s%-12s%-12s%-12s%-18s%-10s\n","-ID-","-Nombre-","-Apellido-","-DNI-","-Nacionalidad-","-Departamento-");
        for (Empleado empleado: empleados) {
            System.out.format("%-7s%-12s%-12s%-12s%-22s%-10s\n",empleado.getIdEmpleado(),empleado.getNombre(),empleado.getApellido(),empleado.getDni(),empleado.getNacionalidad(),empleado.getIdDepartamento());
        }


        Scanner consola = new Scanner(System.in);
        boolean bandera = true;

        System.out.print("Ingrese el ID Empleado: ");
        this.idEmpleado = consola.nextInt();

        while (bandera) {
            System.out.println("\n1. Modificar Nombre \n2. Modificar Apellido \n3. Modificar DNI \n4. Modificar Nacionalidad \n5. Modificar Departamento \n6. Salir");
            System.out.print("Ingrese la opción: ");
            int option = consola.nextInt();
            consola.nextLine();

            switch(option) {
                case 1:
                    System.out.print("Ingrese su Nombre: ");
                    this.nombre = consola.next();
                    break;
                case 2:
                    System.out.print("Ingrese su Apellido: ");
                    this.apellido = consola.next();
                    break;
                case 3:
                    System.out.print("Ingrese su DNI: ");
                    this.dni = consola.nextInt();
                    break;
                case 4:
                    System.out.print("Ingrese su Nacionalidad: ");
                    this.nacionalidad = consola.next();
                    break;
                case 5:
                    System.out.print("Ingrese su Departamento: ");
                    this.idDepartamento = consola.nextInt();
                    break;
                case 6:
                    bandera = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }//cierre while

        for (Empleado empleado: empleados) {
            if(empleado.getIdEmpleado() == this.idEmpleado){
                if(this.nombre == null){
                    this.nombre = empleado.getNombre();
                }
                if(this.apellido == null){
                    this.apellido = empleado.getApellido();
                }
                if(this.dni == 0){
                    this.dni = empleado.getDni();
                }
                if(this.nacionalidad == null){
                    this.nacionalidad = empleado.getNacionalidad();
                }
                if(this.idDepartamento == 0){
                    this.idDepartamento = empleado.getIdDepartamento();
                }

            }
        }
        Empleado empleado = new Empleado(this.idEmpleado,this.nombre,this.apellido,this.dni,this.nacionalidad,this.idDepartamento);
        if (empleadoDAO.actualizar(empleado) == 1){
            System.out.println("\nEmpleado Modificado...");
        }else{
            System.out.println("\nEl Empleado no fue Modificado...");
        }

    }


    public void baja(){
        listarEmpleados();
        Scanner consola = new Scanner(System.in);
        System.out.print("Ingrese el ID Empleado a ELIMINAR: ");
        this.idEmpleado = consola.nextInt();
        Empleado empleado = new Empleado(this.idEmpleado);
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        if(empleadoDAO.eliminar(empleado) > 0){
            System.out.println("\nEl Empleado fue ELIMINADO...");
        }else{
            System.out.println("\nEl Empleado no encontrado...");
        }

    }

    public void departamentos() {
        Scanner consola = new Scanner(System.in);
        boolean bandera = true;

        while (bandera) {
            System.out.println("\n1. Listar Departamentos \n2. Eliminar Departamento \n3. Salir");
            System.out.print("Ingrese la opción: ");
            int option = consola.nextInt();
            consola.nextLine();

            switch (option) {
                case 1:
                    listarDepartamentos();
                    break;
                case 2:
                    bajaDepartamento();
                    break;
                case 3:
                    bandera = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        }
    }

    public void listarDepartamentos(){
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> departamentos = departamentoDAO.seleccionar();
        Collections.sort(departamentos, new Comparator<Departamento>() {
            @Override
            public int compare(Departamento p1, Departamento p2) {
                return p1.getDepartamento().compareTo(p2.getDepartamento());
            }
        });

        System.out.format("\n%-7s%-22s%-10s\n","-ID-","-Departamento-","-Presupuesto-");
        for (Departamento departamento: departamentos) {
            System.out.format("%-7s%-22s%-10s\n",departamento.getIdDepartamento(),departamento.getDepartamento(),departamento.getPresupuesto());
        }
    }

    public void bajaDepartamento(){
        listarDepartamentos();
        Scanner consola = new Scanner(System.in);
        System.out.print("Ingrese el ID Departamento a ELIMINAR: ");
        this.idDepartamento = consola.nextInt();
        Departamento departamento = new Departamento(this.idDepartamento);
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        if(departamentoDAO.eliminar(departamento) > 0){
            System.out.println("\nEl Departamento fue ELIMINADO...");
        }else{
            System.out.println("\nEl Departamento no encontrado...");
        }

    }

    public void listarEmpleadosDepartamentos(){
        listarDepartamentos();
        Scanner consola = new Scanner(System.in);
        System.out.print("Ingrese el ID Departamento: ");
        this.idDepartamento = consola.nextInt();
        Departamento depar = new Departamento(this.idDepartamento);
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> departamentos = departamentoDAO.seleccionarDepartamento(depar);

        System.out.format("\n%-12s%-12s%-12s%-17s%-10s\n","-Nombre-","-Apellido-","-DNI-","-Nacionalidad-","-Departamento-");
        for (Departamento departamento: departamentos) {
            System.out.format("%-12s%-12s%-13s%-17s%-10s\n",departamento.getNombre(),departamento.getApellido(),departamento.getDni(),departamento.getNacionalidad(),departamento.getDepartamento());
        }
    }

}
