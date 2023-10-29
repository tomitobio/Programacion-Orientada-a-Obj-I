// // Definir la interfaz Vehiculo
// interface Vehiculo {
//     void acelerar(int cantidad);

//     void frenar(int cantidad);

//     int obtenerVelocidad();
// }

// // Clase concreta Coche que implementa Vehiculo
// class Coche implements Vehiculo {
//     private int velocidad;

//     public Coche() {
//         velocidad = 0;
//     }

//     @Override
//     public void acelerar(int cantidad) {
//         velocidad += cantidad;
//     }

//     @Override
//     public void frenar(int cantidad) {
//         velocidad -= cantidad;
//     }

//     @Override
//     public int obtenerVelocidad() {
//         return velocidad;
//     }
// }

// // Clase concreta Moto que implementa Vehiculo
// class Moto implements Vehiculo {
//     private int velocidad;

//     public Moto() {
//         velocidad = 0;
//     }

//     @Override
//     public void acelerar(int cantidad) {
//         velocidad += cantidad;
//     }

//     @Override
//     public void frenar(int cantidad) {
//         velocidad -= cantidad;
//     }

//     @Override
//     public int obtenerVelocidad() {
//         return velocidad;
//     }
// }

// // Clase concreta Bicicleta que implementa Vehiculo
// class Bicicleta implements Vehiculo {
//     private int velocidad;

//     public Bicicleta() {
//         velocidad = 0;
//     }

//     @Override
//     public void acelerar(int cantidad) {
//         velocidad += cantidad;
//     }

//     @Override
//     public void frenar(int cantidad) {
//         velocidad -= cantidad;
//     }

//     @Override
//     public int obtenerVelocidad() {
//         return velocidad;
//     }
// }

// public class Main4 {
//     public static void main(String[] args) {
//         Coche coche = new Coche();
//         Moto moto = new Moto();
//         Bicicleta bicicleta = new Bicicleta();

//         coche.acelerar(60);
//         moto.acelerar(80);
//         bicicleta.acelerar(15);

//         System.out.println("Velocidad del coche: " + coche.obtenerVelocidad() + " km/h");
//         System.out.println("Velocidad de la moto: " + moto.obtenerVelocidad() + " km/h");
//         System.out.println("Velocidad de la bicicleta: " + bicicleta.obtenerVelocidad() + " km/h");
//     }
// }

interface Vehiculo {
    void acelerar(double c);

    void frenar(double c);

    double obtenerVelocidad();
}

class Coche implements Vehiculo {
    private double vel;

    public Coche() {
        vel = 0;
    }

    @Override
    public void acelerar(double c) {
        vel += c;
    }

    @Override
    public void frenar(double c) {
        vel -= c;
    }

    @Override
    public double obtenerVelocidad() {
        return vel;
    }
}

class Bici implements Vehiculo {
    private double vel;

    public Bici() {
        vel = 0;
    }

    @Override
    public void acelerar(double c) {
        vel += c;
    }

    @Override
    public void frenar(double c) {
        vel -= c;
    }

    @Override
    public double obtenerVelocidad() {
        return vel;
    }
}

class Moto implements Vehiculo {
    private double vel;

    public Moto() {
        vel = 0;
    }

    @Override
    public void acelerar(double c) {
        vel += c;
    }

    @Override
    public void frenar(double c) {
        vel -= c;
    }

    @Override
    public double obtenerVelocidad() {
        return vel;
    }
}

public class Main4 {
    public static void main(String[] args) {
        Bici b = new Bici();
        Moto m = new Moto();
        Coche c = new Coche();

        b.acelerar(6);
        m.acelerar(44);
        c.acelerar(65);

        System.out.println("Velocidad de la bicicleta: " + b.obtenerVelocidad());
        System.out.println("Velocidad de la moto: " + m.obtenerVelocidad());
        System.out.println("Velocidad del auto: " + c.obtenerVelocidad());
    }
}