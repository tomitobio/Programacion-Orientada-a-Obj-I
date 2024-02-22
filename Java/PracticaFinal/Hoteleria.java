import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ;

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
    private int cantidad;
    private double precio;
    private Persona titular;
    private ArrayList<Persona> ocupantes;

    public Habitacion(String codigo, Persona titular) {
        if (codigo == "HD2") {
            this.cantidad = 12;
            this.precio = 2000;
            this.ocupantes = new ArrayList<>(1);
        } else if (codigo == "HT3") {
            this.cantidad = 8;
            this.precio = 2800;
            this.ocupantes = new ArrayList<>(2);
        } else if (codigo == "HC4") {
            this.cantidad = 5;
            this.precio = 3500;
            this.ocupantes = new ArrayList<>(3);
        } else {
            System.out.println("Codigo de habitacion incorrecto.");
        }

        if (titular.getEdad() > 18) {
            this.titular = titular;
        } else {
            System.out.println("Titular debe ser mayor de edad.");
        }
    }

    public Persona getTitular() {
        return this.titular;
    }
}

public class Hoteleria {
    public static void main(String[] args) {

        Persona p1 = new Persona("Tomas", "Tobio", 'M', 44851196, 20);
        Persona p2 = new Persona("Martina", "Caputo", 'F', 46892814, 18);

        Habitacion h1 = new Habitacion("HD2", p1);

        h1.getTitular();

    }
}
