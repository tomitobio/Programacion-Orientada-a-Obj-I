// Definir la interfaz Vehiculo
interface Vehiculo {
    void acelerar(int cantidad);

    void frenar(int cantidad);

    int obtenerVelocidad();
}

// Clase concreta Coche que implementa Vehiculo
class Coche implements Vehiculo {
    private int velocidad;

    public Coche() {
        velocidad = 0;
    }

    @Override
    public void acelerar(int cantidad) {
        velocidad += cantidad;
    }

    @Override
    public void frenar(int cantidad) {
        velocidad -= cantidad;
    }

    @Override
    public int obtenerVelocidad() {
        return velocidad;
    }
}

// Clase concreta Moto que implementa Vehiculo
class Moto implements Vehiculo {
    private int velocidad;

    public Moto() {
        velocidad = 0;
    }

    @Override
    public void acelerar(int cantidad) {
        velocidad += cantidad;
    }

    @Override
    public void frenar(int cantidad) {
        velocidad -= cantidad;
    }

    @Override
    public int obtenerVelocidad() {
        return velocidad;
    }
}

// Clase concreta Bicicleta que implementa Vehiculo
class Bicicleta implements Vehiculo {
    private int velocidad;

    public Bicicleta() {
        velocidad = 0;
    }

    @Override
    public void acelerar(int cantidad) {
        velocidad += cantidad;
    }

    @Override
    public void frenar(int cantidad) {
        velocidad -= cantidad;
    }

    @Override
    public int obtenerVelocidad() {
        return velocidad;
    }
}

public class Main4 {
    public static void main(String[] args) {
        Coche coche = new Coche();
        Moto moto = new Moto();
        Bicicleta bicicleta = new Bicicleta();

        coche.acelerar(60);
        moto.acelerar(80);
        bicicleta.acelerar(15);

        System.out.println("Velocidad del coche: " + coche.obtenerVelocidad() + " km/h");
        System.out.println("Velocidad de la moto: " + moto.obtenerVelocidad() + " km/h");
        System.out.println("Velocidad de la bicicleta: " + bicicleta.obtenerVelocidad() + " km/h");
    }
}
