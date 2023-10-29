// // Clase abstracta Figura3D
// abstract class Figura3D {
//     public abstract double calcularVolumen();
// }

// // Clase concreta Esfera que extiende Figura3D
// class Esfera extends Figura3D {
//     private double radio;

//     public Esfera(double radio) {
//         this.radio = radio;
//     }

//     @Override
//     public double calcularVolumen() {
//         return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
//     }
// }

// // Clase concreta Cilindro que extiende Figura3D
// class Cilindro extends Figura3D {
//     private double radio;
//     private double altura;

//     public Cilindro(double radio, double altura) {
//         this.radio = radio;
//         this.altura = altura;
//     }

//     @Override
//     public double calcularVolumen() {
//         return Math.PI * Math.pow(radio, 2) * altura;
//     }
// }

// // Clase concreta Cubo que extiende Figura3D
// class Cubo extends Figura3D {
//     private double lado;

//     public Cubo(double lado) {
//         this.lado = lado;
//     }

//     @Override
//     public double calcularVolumen() {
//         return Math.pow(lado, 3);
//     }
// }

// public class Main9 {
//     public static void main(String[] args) {
//         Esfera esfera = new Esfera(3.0);
//         Cilindro cilindro = new Cilindro(2.0, 5.0);
//         Cubo cubo = new Cubo(4.0);

//         System.out.println("Volumen de la esfera: " + esfera.calcularVolumen());
//         System.out.println("Volumen del cilindro: " + cilindro.calcularVolumen());
//         System.out.println("Volumen del cubo: " + cubo.calcularVolumen());
//     }
// }

abstract class Figura3D {
    abstract double volumen();
}

class Esfera extends Figura3D {
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    double volumen() {
        return (4 * 3.14 * radio * radio * radio) / 3;
    }

}

class Cilindro extends Figura3D {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    double volumen() {
        return 3.14 * altura * radio * radio;
    }

}

class Cubo extends Figura3D {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    double volumen() {
        return lado * lado * lado;
    }

}

public class Main9 {
    public static void main(String[] args) {
        Cubo cubo = new Cubo(6.8);
        Cilindro cilindro = new Cilindro(5.87, 15);
        Esfera esfera = new Esfera(12.36);

        System.out.println("El volumen del cubo es: " + cubo.volumen());
        System.out.println("El volumen del cilindro es: " + cilindro.volumen());
        System.out.println("El volumen de la esfera es: " + esfera.volumen());
    }
}