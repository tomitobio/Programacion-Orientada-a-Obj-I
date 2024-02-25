import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Cliente {
    private String nombre;
    private String apellido;
    private int edad;

    public Cliente(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void detallesP() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
        System.out.println("Edad: " + this.edad);
    }
}

class Vehiculo {
    private String codigo;
    private boolean estado;
    private ArrayList<Cliente> ocupantes;
    private double precio;
    private int cantP;

    public Vehiculo(String c, double precio, int cantP) {
        this.codigo = c;
        this.precio = precio;
        this.cantP = cantP;
        this.estado = false;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCant() {
        return this.cantP;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setC(ArrayList<Cliente> ocupantes) {
        this.ocupantes = ocupantes;
    }

    public ArrayList<Cliente> getC() {
        return this.ocupantes;
    }

}

class Rental {
    private Map<String, Vehiculo> vehiculos;

    public Rental() {
        this.vehiculos = new HashMap<>();
        crearVehiculos();
    }

    public void crearVehiculos() {
        for (int i = 1; i < 6; i++) {
            vehiculos.put("Moto" + Integer.toString(i), new Vehiculo("Moto" + Integer.toString(i), 1300, 2));
        }
        for (int i = 1; i < 9; i++) {
            vehiculos.put("Auto" + Integer.toString(i), new Vehiculo("Auto" + Integer.toString(i), 2200, 4));
        }
        for (int i = 1; i < 4; i++) {
            vehiculos.put("Cam" + Integer.toString(i), new Vehiculo("Cam" + Integer.toString(i), 300, 5));
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la agencia de autos. Por favor seleccione una de las siguientes opciones:");

        System.out.println(
                "1. Mirar vehiculos disponibles. \n2. Alquilar. \n3. Devolver auto. \n4. Salir del sistema.");

        int sel = scanner.nextInt();
        scanner.nextLine();

        while (sel <= 0 || sel >= 5) {
            System.out.println("Seleccione una opcion adecuada.");
            sel = scanner.nextInt();
            scanner.nextLine();
        }

        while (sel != 4) {
            try {
                switch (sel) {
                    case 1:
                        listado();
                        break;
                    case 2:
                        alquilar(scanner);
                        break;
                    case 3:
                        devolver(scanner);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Uoop! Error!");
            }
            System.out.println(
                    "\n 1. Mirar vehiculos disponibles. \n2. Alquilar. \n3. Devolver auto. \n4. Salir del sistema.");

            sel = scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
    }

    public void listado() {
        for (Map.Entry<String, Vehiculo> i : vehiculos.entrySet()) {
            Vehiculo v = i.getValue();
            if (v.getEstado() == false) {
                System.out.println(v.getCodigo() + "- DISPONIBLE");
            } else {
                System.out.println(v.getCodigo() + "- Ocupada. ");
            }
        }
    }

    public void alquilar(Scanner scanner) {
        System.out.println(
                "\nPara saber que vehiculo alquilar, debe ingresar la cantidad de acompanantes:\n1 Acompaniante: MOTO\n2 o 3 Acompaniantes: AUTO\n4 Acompaniantes: CAMIONETA");

        int cant = scanner.nextInt();
        scanner.nextLine();

        while (cant <= 0 || cant >= 5) {
            System.out.println("Seleccione una opcion adecuada.");
            cant = scanner.nextInt();
            scanner.nextLine();
        }

        ArrayList<Cliente> grupo = cargarGrupo(scanner, cant);
        for (Cliente i : grupo) {
            System.out.println("\n" + i.getNombre() + " cargado correctamente.");
        }

        switch (cant) {
            case 1:
                for (Map.Entry<String, Vehiculo> i : vehiculos.entrySet()) {
                    String codigo = i.getKey();
                    Vehiculo v = i.getValue();
                    if (v.getEstado() == false && codigo.contains("Moto")) {
                        v.setC(grupo);
                        v.setEstado(true);
                        System.out.println("Se le ha asignado la moto: " + codigo);
                        break;
                    }
                }
                break;

            case 2:
                for (Map.Entry<String, Vehiculo> i : vehiculos.entrySet()) {
                    String codigo = i.getKey();
                    Vehiculo v = i.getValue();
                    if (v.getEstado() == false && codigo.contains("Auto")) {
                        v.setC(grupo);
                        v.setEstado(true);
                        System.out.println("Se le ha asignado el auto: " + codigo);
                        break;
                    }
                }
                break;

            case 3:
                for (Map.Entry<String, Vehiculo> i : vehiculos.entrySet()) {
                    String codigo = i.getKey();
                    Vehiculo v = i.getValue();
                    if (v.getEstado() == false && codigo.contains("Auto")) {
                        v.setC(grupo);
                        v.setEstado(true);
                        System.out.println("Se le ha asignado el auto: " + codigo);
                        break;
                    }
                }
                break;

            case 4:
                for (Map.Entry<String, Vehiculo> i : vehiculos.entrySet()) {
                    String codigo = i.getKey();
                    Vehiculo v = i.getValue();
                    if (v.getEstado() == false && codigo.contains("Cam")) {
                        v.setC(grupo);
                        v.setEstado(true);
                        System.out.println("Se le ha asignado la camioneta: " + codigo);
                        break;
                    }
                }
                break;
        }
    }

    public ArrayList<Cliente> cargarGrupo(Scanner scanner, int cant) {

        ArrayList<Cliente> grupo = new ArrayList<Cliente>();

        System.out.println("Ingresar datos de conductor: \n");
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        Cliente titular = new Cliente(nombre, apellido, edad);
        grupo.add(titular);

        for (int i = 0; i < cant; i++) {
            System.out.println("Ingresar datos de acompañante n° " + (i + 1) + "\n");
            System.out.println("Nombre: ");
            String nombre1 = scanner.nextLine();
            System.out.println("Apellido: ");
            String apellido1 = scanner.nextLine();
            System.out.println("Edad: ");
            int edad1 = scanner.nextInt();
            scanner.nextLine();

            Cliente aux = new Cliente(nombre1, apellido1, edad1);
            grupo.add(aux);
        }
        return grupo;
    }

    public void devolver(Scanner scanner) {
        System.out.println("Ingrese codigo de vehiculo a entregar: ");
        String c = scanner.nextLine();
        System.out.println(c);

        for (Map.Entry<String, Vehiculo> i : vehiculos.entrySet()) {
            Vehiculo v = i.getValue();
            System.out.println(v.getCodigo());
            if (v.getEstado() == true && v.getCodigo().contains(c)) {
                System.out.println("Debe pagar: " + v.getPrecio());
                System.out.println(v.getCodigo() + "- Entregado");
            }
        }
    }
}

public class Concesionario {
    public static void main(String[] args) {
        // Moto moto = new Moto("hola");
        Rental agencia = new Rental();

        agencia.start();

    }
}
