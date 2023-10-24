// Clase abstracta Figura3D
abstract class Figura3D {
    public abstract double calcularVolumen();
}

// Clase concreta Esfera que extiende Figura3D
class Esfera extends Figura3D {
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }
}

// Clase concreta Cilindro que extiende Figura3D
class Cilindro extends Figura3D {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }
}

// Clase concreta Cubo que extiende Figura3D
class Cubo extends Figura3D {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularVolumen() {
        return Math.pow(lado, 3);
    }
}

public class Main9 {
    public static void main(String[] args) {
        Esfera esfera = new Esfera(3.0);
        Cilindro cilindro = new Cilindro(2.0, 5.0);
        Cubo cubo = new Cubo(4.0);

        System.out.println("Volumen de la esfera: " + esfera.calcularVolumen());
        System.out.println("Volumen del cilindro: " + cilindro.calcularVolumen());
        System.out.println("Volumen del cubo: " + cubo.calcularVolumen());
    }
}
