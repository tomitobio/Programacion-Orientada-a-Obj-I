import java.util.ArrayList;
import java.util.Scanner;

//ACLARACION: No tengo enie.

public class Agencia1 {
    private ArrayList<Vehiculo> vehiculoMoto;
    private ArrayList<Vehiculo> vehiculoAuto;
    private ArrayList<Vehiculo> vehiculoCamioneta;

    Agencia1() {
        this.vehiculoMoto = new ArrayList<Vehiculo>();
        this.vehiculoAuto = new ArrayList<Vehiculo>();
        this.vehiculoCamioneta = new ArrayList<Vehiculo>();
    }

    public void addVehiculo(Vehiculo vehiculo) {
        switch (vehiculo.getCapacidad()) {
            case 2:
                vehiculoMoto.add(vehiculo);
                break;

            case 4:
                vehiculoAuto.add(vehiculo);
                break;

            case 5:
                vehiculoCamioneta.add(vehiculo);
                break;
        }
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Bienvenido a la agencia...\nElegir una opcion: \n\n1- Alquiler de vehiculos\n2- Entrega de vehiculo\n3- Listado de vehiculo\n4- Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        while (opcion <= 0 || opcion >= 5) {
            System.out.println("Ingresar una opcion compatible.");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        while (opcion != 4) {
            switch (opcion) {
                case 1:
                    alquiler(scanner);
                    break;
                case 2:
                    entrega(scanner);
                    break;
                case 3:
                    listado();
                    break;
            }
            System.out.println(
                    "\nElegir una opcion: \n\n1- Alquiler de vehiculos\n2- Entrega de vehiculo\n3- Listado de vehiculo\n4- Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public void listado() {
        for (Vehiculo i : vehiculoMoto) {
            if (i.getOcupacion() == false) {
                System.out.println(i.getCodigo() + "- DISPONIBLE");
            } else {
                System.out.println(i.getCodigo() + " " + i.getOcupantes().get(0).getNombre());
            }
        }
        for (Vehiculo i : vehiculoAuto) {
            if (i.getOcupacion() == false) {
                System.out.println(i.getCodigo() + "- DISPONIBLE");
            } else {
                System.out.println(i.getCodigo() + " " + i.getOcupantes().get(0).getNombre());
            }
        }
        for (Vehiculo i : vehiculoCamioneta) {
            if (i.getOcupacion() == false) {
                System.out.println(i.getCodigo() + "- DISPONIBLE");
            } else {
                System.out.println(i.getCodigo() + " " + i.getOcupantes().get(0).getNombre());
            }
        }
    }

    public void entrega(Scanner scanner) {
        System.out.print("Ingresar codigo de vehiculo a entregar:");
        String codigoVehiculo = scanner.nextLine();

        for (Vehiculo i : vehiculoMoto) {
            if (i.getCodigo() == codigoVehiculo || i.getOcupacion() == true) {
                System.out.println(codigoVehiculo + " entregado.");
                i.setOcupacion(false);
            }
        }
        for (Vehiculo i : vehiculoAuto) {
            if (i.getCodigo() == codigoVehiculo && i.getOcupacion() == true) {
                System.out.println(codigoVehiculo + " entregado.");
                i.setOcupacion(false);
            }
        }
        for (Vehiculo i : vehiculoCamioneta) {
            if (i.getCodigo() == codigoVehiculo && i.getOcupacion() == true) {
                System.out.println(codigoVehiculo + " entregado.");
                i.setOcupacion(false);
            }
        }

    }

    public void alquiler(Scanner scanner) {

        System.out.println(
                "\nPara saber que vehiculo alquilar, debe ingresar la cantidad de acompanantes:\n1 Acompaniante: MOTO\n2 o 3 Acompaniantes: AUTO\n4 Acompaniantes: CAMIONETA");

        int cantAcompanantes = scanner.nextInt();
        scanner.nextLine();

        while (cantAcompanantes <= 0 || cantAcompanantes >= 6) {
            System.out.println("Ingresar una cantidad compatible de acompaniantes.");
            cantAcompanantes = scanner.nextInt();
            scanner.nextLine();
        }

        ArrayList<Cliente> grupoFamiliar = cargaPersonas(scanner, cantAcompanantes);
        for (Cliente i : grupoFamiliar) {
            System.out.println("\n" + i.getNombre() + " cargado correctamente.");
        }

        // ASIGNO GRUPO FAMILIAR AL PRIMER VEHICULO DISPONIBLE
        switch (cantAcompanantes) {
            case 1:
                for (Vehiculo i : vehiculoMoto) {
                    if (i.getOcupacion() == false) {
                        i.setOcupantes(grupoFamiliar);
                        i.setOcupacion(true);
                        System.out.println("\nSe te ha asignado la moto " + i.getCodigo());
                        break;
                    }
                }
                break;
            case 2:
                for (Vehiculo i : vehiculoAuto) {
                    if (i.getOcupacion() == false) {
                        i.setOcupantes(grupoFamiliar);
                        i.setOcupacion(true);
                        System.out.println("\nSe te ha asignado el auto " + i.getCodigo());
                        break;
                    }
                }
                break;
            case 3:
                for (Vehiculo i : vehiculoAuto) {
                    if (i.getOcupacion() == false) {
                        i.setOcupantes(grupoFamiliar);
                        i.setOcupacion(true);
                        System.out.println("\nSe te ha asignado el auto " + i.getCodigo());
                        break;
                    }
                }
                break;
            case 4:
                for (Vehiculo i : vehiculoCamioneta) {
                    if (i.getOcupacion() == false) {
                        i.setOcupantes(grupoFamiliar);
                        i.setOcupacion(true);
                        System.out.println("\nSe te ha asignado la camioneta " + i.getCodigo());
                        break;
                    }
                }
                break;
        }
    }

    public ArrayList<Cliente> cargaPersonas(Scanner scanner, int cantAcompanantes) { // Devuelve un array con los datos
        ArrayList<Cliente> grupoFamiliar = new ArrayList<Cliente>(); // del grupo familiar cargado.
        System.out.println("Ingresar datos de CONDUCTOR / TITULAR:\n");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Genero: ");
        String genero = scanner.nextLine();
        System.out.print("DNI: ");
        int dni = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        Cliente titular = new Cliente(nombre, genero, edad, dni);
        grupoFamiliar.add(titular);

        for (int i = 0; i < cantAcompanantes; i++) {
            System.out.println("Ingresar datos de acompaniante " + (i + 1) + "\n");
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            System.out.print("Genero: ");
            genero = scanner.nextLine();
            System.out.print("DNI: ");
            dni = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Edad: ");
            edad = scanner.nextInt();
            scanner.nextLine();

            Cliente personaAux = new Cliente(nombre, genero, edad, dni);
            grupoFamiliar.add(personaAux);
        }

        return grupoFamiliar;
    }
}
