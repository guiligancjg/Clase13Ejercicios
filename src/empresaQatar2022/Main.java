package empresaQatar2022;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AltaBajasModificaciones empleado = new AltaBajasModificaciones();
        Scanner consola = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Mostrar Lista Empleados\n2. Departamentos\n3. Ingresar un nuevo Empleado \n4. Modificar Empleado \n5. Eliminar Empleado\n6. Listar Empleados con Departamentos\n7. Salir");
            System.out.print("Ingrese su opción: ");
            int option = consola.nextInt();
            consola.nextLine();

            switch(option) {
                case 1:
                    empleado.listarEmpleados();
                    break;
                case 2:
                    empleado.departamentos();
                    break;
                case 3:
                    empleado.altaEmpleado();
                    break;
                case 4:
                    empleado.modificar();
                    break;
                case 5:
                    empleado.baja();
                    break;
                case 6:
                    empleado.listarEmpleadosDepartamentos();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }//cierre while
    }
}