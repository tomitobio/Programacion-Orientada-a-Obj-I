import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Persona2 {
    private String nombre;
    private int edad;
    private char genero;

    public Persona2(String n, int e, char g) {
        this.nombre = n;
        this.edad = e;
        this.genero = g;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public char getGenero() {
        return this.genero;
    }

}

class Habitacion2 {
    private String codigo;
    private double precio;
    private int capacidad;
    private ArrayList<Persona2> ocupantes;
    private boolean estado;

    public Habitacion2(String c) {
        this.codigo = c;
        this.estado = false;
        if (c.contains("HD")) {
            this.precio = 200;
            this.capacidad = 2;
        }
        if (c.contains("HT")) {
            this.precio = 400;
            this.capacidad = 3;
        }
        if (c.contains("HC")) {
            this.precio = 500;
            this.capacidad = 4;
        }
    }

    public void setEstadoT() {
        this.estado = true;
    }

    public void setEstadoF() {
        this.estado = false;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public ArrayList<Persona2> getOcupantes() {
        return this.ocupantes;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setOcupantes(ArrayList<Persona2> o) {
        this.ocupantes = o;
    }
}

class Hotel2 {
    private Map<String, Habitacion2> habitaciones;

    public Hotel2() {
        habitaciones = new HashMap<>();
        crearHabitaciones();
    }

    public void crearHabitaciones() {
        for (int i = 1; i < 7; i++) {
            habitaciones.put("HD" + Integer.toString(i), new Habitacion2("HD" + Integer.toString(i)));
        }
        for (int i = 1; i < 5; i++) {
            habitaciones.put("HT" + Integer.toString(i), new Habitacion2("HT" + Integer.toString(i)));
        }
        for (int i = 1; i < 8; i++) {
            habitaciones.put("HC" + Integer.toString(i), new Habitacion2("HC" + Integer.toString(i)));
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al hotel. Elija una de las siguientes opciones: ");
        System.out.println("1. Información habitaciones\n2. Realice su check in\n3. Realice su check out\n4. Salir ");

        int sel = scanner.nextInt();
        scanner.nextLine();

        while (sel <= 0 || sel >= 4) {
            System.out.println("Seleccion incorrecta. Elija una de las siguientes opciones: ");
        }

        while (sel != 4) {
            try {
                switch (sel) {
                    case 1:
                        listado();
                        break;
                    case 2:
                        checkin(scanner);
                        break;
                    case 3:
                        checkout(scanner);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error !! ");
            }
            System.out
                    .println("1. Información habitaciones\n2. Realice su check in\n3. Realice su check out\n4. Salir ");
            sel = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public void listado() {
        for (Map.Entry<String, Habitacion2> i : habitaciones.entrySet()) {
            Habitacion2 habi = i.getValue();
            if (habi.getEstado() == false) {
                System.out.println(habi.getCodigo() + "- Disponible ");
            } else {
                System.out.println(habi.getCodigo() + "- Ocupada ");
            }
        }
    }

    public void checkin(Scanner scanner) {

        System.out
                .println(
                        "Elija una habitacion de la siguiente capacidad:\n1. Doble\n2. Triple\n3. Cuadruple\n4. Salir ");
        int sel = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (sel) {
                case 1:
                    for (Map.Entry<String, Habitacion2> i : habitaciones.entrySet()) {
                        Habitacion2 habi = i.getValue();
                        if (habi.getEstado() == false && habi.getCodigo().contains("HD")) {
                            habi.setEstadoT();
                            ArrayList<Persona2> grupo = registrar(1);
                            habi.setOcupantes(grupo);

                            System.out.println("Registro la habitacion: " + habi.getCodigo());
                            break;
                        }
                    }
                    break;
                case 2:
                    for (Map.Entry<String, Habitacion2> i : habitaciones.entrySet()) {
                        Habitacion2 habi = i.getValue();
                        if (habi.getEstado() == false && habi.getCodigo().contains("HT")) {
                            habi.setEstadoT();
                            ArrayList<Persona2> grupo = registrar(2);
                            habi.setOcupantes(grupo);
                            System.out.println("Registro la habitacion: " + habi.getCodigo());
                            break;
                        }
                    }
                    break;
                case 3:
                    for (Map.Entry<String, Habitacion2> i : habitaciones.entrySet()) {
                        Habitacion2 habi = i.getValue();
                        if (habi.getEstado() == false && habi.getCodigo().contains("HC")) {
                            habi.setEstadoT();
                            ArrayList<Persona2> grupo = registrar(3);
                            habi.setOcupantes(grupo);
                            System.out.println("Registro la habitacion: " + habi.getCodigo());
                            break;
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error !! ");
        }

    }

    public ArrayList<Persona2> registrar(int cant) {
        System.out.println("Registre su grupo de: " + (cant + 1));

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese nombre del titular: ");
        String n = s.nextLine();
        System.out.println("Ingrese genero del titular: ");
        char g = s.next().charAt(0);
        System.out.println("Ingrese edad del titular: ");
        int e = s.nextInt();
        s.nextLine();
        Persona2 titular = new Persona2(n, e, g);

        ArrayList<Persona2> grupo = new ArrayList<Persona2>();
        grupo.add(titular);

        for (int i = 0; i < cant; i++) {
            System.out.println("Ingrese nombre del ocupante n" + (i + 1) + ":");
            String n1 = s.nextLine();
            System.out.println("Ingrese genero del ocupante n" + (i + 1) + ":");
            char g1 = s.next().charAt(0);
            System.out.println("Ingrese edad del ocupante n" + (i + 1) + ":");
            int e1 = s.nextInt();
            s.nextLine();

            Persona2 o = new Persona2(n1, e1, g1);
            grupo.add(o);
        }
        return grupo;
    }

    public void checkout(Scanner scanner) {

        System.out
                .println(
                        "Elija una habitacion para hacer checkout:\n1. Doble\n2. Triple\n3. Cuadruple\n4. Salir ");
        int sel = scanner.nextInt();
        scanner.nextLine();
        try {
            switch (sel) {
                case 1:
                    for (Map.Entry<String, Habitacion2> i : habitaciones.entrySet()) {
                        Habitacion2 habi = i.getValue();
                        System.out.println("Busque su habitacion: ");
                        String opcion = scanner.nextLine();
                        if (habi.getEstado() == true && habi.getCodigo().contains(opcion)) {
                            habi.setEstadoF();
                            habi.getOcupantes().clear();

                            System.out.println("Se hizo checkout de la siguiente " + habi.getCodigo());
                            break;
                        }
                    }
                    break;
                case 2:
                    for (Map.Entry<String, Habitacion2> i : habitaciones.entrySet()) {
                        Habitacion2 habi = i.getValue();
                        System.out.println("Busque su habitacion: ");
                        String opcion = scanner.nextLine();
                        if (habi.getEstado() == true && habi.getCodigo().contains(opcion)) {
                            habi.setEstadoF();
                            habi.getOcupantes().clear();

                            System.out.println("Se hizo checkout de la siguiente " + habi.getCodigo());
                            break;
                        }
                    }
                    break;
                case 3:
                    for (Map.Entry<String, Habitacion2> i : habitaciones.entrySet()) {
                        Habitacion2 habi = i.getValue();
                        System.out.println("Busque su habitacion: ");
                        String opcion = scanner.nextLine();
                        if (habi.getEstado() == true && habi.getCodigo().contains(opcion)) {
                            habi.setEstadoF();
                            habi.getOcupantes().clear();

                            System.out.println("Se hizo checkout de la siguiente " + habi.getCodigo());
                            break;
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error !! ");
        }
    }
}

public class Hoteleria2 {
    public static void main(String[] args) {
        Hotel2 h2 = new Hotel2();

        h2.start();
    }
}
