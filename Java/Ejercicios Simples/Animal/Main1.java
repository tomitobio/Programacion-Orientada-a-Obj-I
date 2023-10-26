// // Definir la clase abstracta Animal
// abstract class Animal {

// private String nombre;
// private int edad;

// // Constructor
// public Animal(String nombre, int edad) {
// this.nombre = nombre;
// this.edad = edad;
// }

// // Metodo clase abstracta
// public abstract void hacerSonido();

// // Get y set
// public String getNombre() {
// return nombre;
// }

// public int getEdad() {
// return edad;
// }
// }

// // Definir la interfaz Mascota
// interface Mascota {
// void jugar();

// void comer();
// }

// // Clase concreta Perro que extiende Animal e implementa Mascota
// class Perro extends Animal implements Mascota {
// // Constructor con clase abstracta
// public Perro(String nombre, int edad) {
// super(nombre, edad);
// }

// // Metodo clase abs
// @Override
// public void hacerSonido() {
// System.out.println("¡Guau!");
// }

// // Metodos interface
// @Override
// public void jugar() {
// System.out.println(getNombre() + " está jugando.");
// }

// @Override
// public void comer() {
// System.out.println(getNombre() + " está comiendo.");
// }
// }

// // Clase concreta Gato que extiende Animal e implementa Mascota
// class Gato extends Animal implements Mascota {
// // Constructor con clase abstracta
// public Gato(String nombre, int edad) {
// super(nombre, edad);
// }

// // Metodo clase abs
// @Override
// public void hacerSonido() {
// System.out.println("¡Miau!");
// }

// // Metodos interface
// @Override
// public void jugar() {
// System.out.println(getNombre() + " está jugando.");
// }

// @Override
// public void comer() {
// System.out.println(getNombre() + " está comiendo.");
// }
// }

// public class Main1 {
// public static void main(String[] args) {
// Perro miPerro = new Perro("Rex", 3);
// Gato miGato = new Gato("Whiskers", 2);

// miPerro.hacerSonido(); // Salida: ¡Guau!
// miPerro.jugar(); // Salida: Rex está jugando.
// miPerro.comer(); // Salida: Rex está comiendo.

// miGato.hacerSonido(); // Salida: ¡Miau!
// miGato.jugar(); // Salida: Whiskers está jugando.
// miGato.comer(); // Salida: Whiskers está comiendo.
// }
// }

abstract class Animal {
    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public abstract void hacerSonido();
}

interface Mascota {
    void jugar();

    void comer();
}

class Gato extends Animal implements Mascota {
    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("¡Miau!");
    }

    @Override
    public void jugar() {
        System.out.println(getNombre() + "esta jugando!");
    }

    @Override
    public void comer() {
        System.out.println(getNombre() + "esta comiendo!");
    }
}

class Perro extends Animal implements Mascota {
    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("Guau!");
    }

    @Override
    public void jugar() {
        System.out.println(getNombre() + "esta jugando!");
    }

    @Override
    public void comer() {
        System.out.println(getNombre() + "esta comiendo!");
    }
}

public class Main1 {
    public static void main(String[] args) {
        Gato cat = new Gato("Obi", 2);
        System.out.println(cat.getNombre());
        System.out.println(cat.getEdad());

        Perro dog = new Perro("Sony", 5);
        System.out.println(dog.getNombre());
        System.out.println(dog.getEdad());

        cat.hacerSonido();
        cat.jugar();
        cat.comer();

        dog.hacerSonido();
        dog.jugar();
        dog.comer();
    }
}