import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Persona {
    private String nombre;
    private String apellido;
    private char genero;
    private int dni;
    private int edad;

    public Persona(String nombre, String apellido, char genero, int dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        if (genero == 'M' || genero == 'F') {
            this.genero = genero;
        } else {
            System.out.println("Genero no identificado.");
        }
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public char getGenero() {
        return this.genero;
    }

    public int getDni() {
        return this.dni;
    }

    public int getEdad() {
        return this.edad;
    }

    public void detallesP() {
        System.out.println("Detalles de: " + this.getNombre() + " " + this.getApellido());
        System.out.println("Genero: " + this.getGenero());
        System.out.println("DNI: " + this.getDni());
        System.out.println("Edad: " + this.getEdad());
    }

}

class Habitacion {
    private String codigo;
    // private int cantidad;
    private double precio;
    private Persona titular;
    private ArrayList<Persona> ocupantes;
    private boolean ocupada;

    public Habitacion(String codigo, int precio, int capacidad) {
        this.codigo = codigo;
        this.precio = precio;
        this.ocupantes = new ArrayList<>(capacidad - 1);

    }

    public boolean getOcupada() {
        return this.ocupada;
    }

    public void setTitular(Persona titular) {
        if (this.titular != null) {
            System.out.println("Ya se encuentra un titular en la habitacion. ");

        } else if (titular.getEdad() >= 18) {
            this.titular = titular;
            this.ocupada = true;

        } else {
            System.out.println("Titular debe ser mayor de edad.");

        }
    }

    public Persona getTitular() {
        return this.titular;
    }

    public ArrayList<Persona> getOcupantes() {
        return this.ocupantes;
    }

    public void checkIn(Persona p) {
        this.setTitular(p);
        if (this.getTitular() != p) {

            int cantidadO = 0;
            for (int i = 0; i < ocupantes.size(); i++) {
                cantidadO++;
            }

            if (cantidadO == 0) {
                this.ocupantes.add(p);
            }

            else if (cantidadO >= ocupantes.size()) {
                System.out.println("Habitacion llena.");

            } else {
                this.ocupantes.add(p);
            }

        }

    }

    public void checkOut(int dias) {
        this.titular = null;
        this.ocupantes.clear();
        this.ocupada = false;
        double pagare = dias * precio;
        System.out.println("Precio a pagar por estancia: " + pagare);

    }

    public void detallesO() {
        if (ocupada == false) {
            System.out.println("No hay nadie en la habitacion. ");
        } else {
            this.getTitular().detallesP();
            for (Persona i : this.ocupantes) {
                i.detallesP();
            }
        }
    }

}

class Hotel {
    private Map<String, Habitacion> habitaciones;

    public Hotel() {
        habitaciones = new HashMap<>();
        crearHabitaciones();
    }

    public void crearHabitaciones() {
        habitaciones.put("HD21", new Habitacion("HD21", 2000, 2));
        habitaciones.put("HT31", new Habitacion("HT31", 2800, 3));
        habitaciones.put("HC41", new Habitacion("HC41", 2500, 4));
    }

    public Habitacion getH(String h) {
        return habitaciones.get(h);
    }

    public void mostrarEstadoOcupacion() {
        for (Map.Entry<String, Habitacion> set : habitaciones.entrySet()) {

            String codigo = set.getKey();
            Habitacion habitacion = set.getValue();
            System.out.println("Habitación " + codigo + ": " + habitacion.getOcupada());
        }
    }

    public void hacerCheckIn(String codigo, Persona p) {
        Habitacion habitacion = habitaciones.get(codigo);
        if (habitacion != null) {
            habitacion.checkIn(p);
        }
    }

    public void hacerCheckOut(String codigo, int dias) {
        Habitacion habitacion = habitaciones.get(codigo);
        if (habitacion != null && habitacion.getOcupada()) {
            habitacion.checkOut(dias);
        }
    }
}

public class Hoteleria {
    public static void main(String[] args) {

        Persona p1 = new Persona("Tomas", "Tobio", 'M', 44851196, 20);
        Persona p2 = new Persona("Martina", "Caputo", 'F', 46892814, 18);
        Persona p3 = new Persona("Roberto", "Caputo", 'F', 46892814, 18);

        Hotel h = new Hotel();

        h.hacerCheckIn("HD21", p1);

        h.hacerCheckIn("HD21", p2);

        h.hacerCheckIn("HD21", p3);

        h.mostrarEstadoOcupacion();

        h.getH("HD21").detallesO();

        h.hacerCheckOut("HD21", 5);

        h.mostrarEstadoOcupacion();

        h.getH("HD21").detallesO();
    }
}
