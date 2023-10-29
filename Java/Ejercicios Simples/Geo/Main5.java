// // Clase abstracta FiguraGeometrica
// abstract class Geo {
// public abstract double calcularArea();
// }

// // Clase concreta Circulo que extiende FiguraGeometrica
// class Circulo extends Geo {
// private double radio;

// public Circulo(double radio) {
// this.radio = radio;
// }

// @Override
// public double calcularArea() {
// return Math.PI * radio * radio;
// }
// }

// // Clase concreta Rectangulo que extiende FiguraGeometrica
// class Rectangulo extends Geo {
// private double base;
// private double altura;

// public Rectangulo(double base, double altura) {
// this.base = base;
// this.altura = altura;
// }

// @Override
// public double calcularArea() {
// return base * altura;
// }
// }

// // Clase concreta Triangulo que extiende FiguraGeometrica
// class Triangulo extends Geo {
// private double base;
// private double altura;

// public Triangulo(double base, double altura) {
// this.base = base;
// this.altura = altura;
// }

// @Override
// public double calcularArea() {
// return 0.5 * base * altura;
// }
// }

// public class Main5 {
// public static void main(String[] args) {
// Circulo circulo = new Circulo(5.0);
// Rectangulo rectangulo = new Rectangulo(6.0, 4.0);
// Triangulo triangulo = new Triangulo(3.0, 8.0);

// System.out.println("Área del círculo: " + circulo.calcularArea());
// System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
// System.out.println("Área del triángulo: " + triangulo.calcularArea());
// }
// }

abstract class Geo {
    public abstract double area();
}

class Circulo extends Geo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return 3.14 * radio * radio;
    }
}

class Triangulo extends Geo {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return altura * base * 0.5;
    }
}

class Rectangulo extends Geo {
    private double lado1;
    private double lado2;

    public Rectangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double area() {
        return lado1 * lado2;
    }
}

public class Main5 {
    public static void main(String[] args) {
        Circulo c = new Circulo(7.64);
        Rectangulo r = new Rectangulo(23.5, 6);
        Triangulo t = new Triangulo(16, 9);

        System.out.println("El area del rectangulo es: " + r.area());
        System.out.println("El area del triangulo es: " + t.area());
        System.out.println("El area del circulo es: " + c.area());

    }
}