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
                "1. Mirar vehiculos disponibles. \n 2. Alquilar. \n 3. Devolver auto. \n 4. Salir del sistema.");

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
                        // alquilar(scanner);
                        break;
                    case 3:
                        // devolver(scanner);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Uoop! Error!");
            }
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

}

public class Concesionario {
    public static void main(String[] args) {
        // Moto moto = new Moto("hola");
        Agencia agencia = new Agencia();

        agencia.start();

    }
}
