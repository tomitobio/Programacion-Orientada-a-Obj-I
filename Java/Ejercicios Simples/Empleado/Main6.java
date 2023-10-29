// class Empleado1 {
// private String nombre;
// private double salario;

// public Empleado1(String nombre, double salario) {
// this.nombre = nombre;
// this.salario = salario;
// }

// public double calcularSalarioAnual() {
// return salario * 12;
// }

// public String getNombre() {
// return nombre;
// }

// public double getSalario() {
// return salario;
// }
// }

// class Gerente extends Empleado1 {
// private double bonoAnual;

// public Gerente(String nombre, double salario, double bonoAnual) {
// super(nombre, salario);
// this.bonoAnual = bonoAnual;
// }

// @Override
// public double calcularSalarioAnual() {
// return super.calcularSalarioAnual() + bonoAnual;
// }
// }

// class Vendedor extends Empleado1 {
// private double comisionAnual;

// public Vendedor(String nombre, double salario, double comisionAnual) {
// super(nombre, salario);
// this.comisionAnual = comisionAnual;
// }

// @Override
// public double calcularSalarioAnual() {
// return super.calcularSalarioAnual() + comisionAnual;
// }
// }

// public class Main6 {
// public static void main(String[] args) {
// Empleado1 empleado1 = new Empleado1("Juan", 50000);
// Gerente gerente = new Gerente("Ana", 80000, 10000);
// Vendedor vendedor = new Vendedor("Carlos", 60000, 5000);

// System.out.println("Salario anual de " + empleado1.getNombre() + ": " +
// empleado1.calcularSalarioAnual());
// System.out.println("Salario anual de " + gerente.getNombre() + ": " +
// gerente.calcularSalarioAnual());
// System.out.println("Salario anual de " + vendedor.getNombre() + ": " +
// vendedor.calcularSalarioAnual());
// }
// }

class Empleado1 {
    public String nombre;
    public double salario;

    public Empleado1(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public double calcularAnual() {
        return salario * 12;
    }
}

class Gerente extends Empleado1 {
    private double bonoAnual;

    public Gerente(String nombre, double salario, double bonoAnual) {
        super(nombre, salario);
        this.bonoAnual = bonoAnual;
    }

    @Override
    public double calcularAnual() {
        double anual = salario * 12;
        return anual + bonoAnual;
    }
}

class Vendedor extends Empleado1 {
    private double comision;

    public Vendedor(String nombre, double salario, double comision) {
        super(nombre, salario);
        this.comision = comision;
    }

    @Override
    public double calcularAnual() {
        double anual = salario * 12;
        return anual + comision;
    }
}

public class Main6 {
    public static void main(String[] args) {
        Empleado1 e = new Empleado1("Martin Saenz", 30000);
        Gerente g = new Gerente("Soler Gonzi", 50000, 20000);
        Vendedor v = new Vendedor("Mariana Salmuera", 30000, 60000);

        System.out.println("El salario anual de " + e.getNombre() + "es: " + e.calcularAnual());
        System.out.println("El salario anual de " + g.getNombre() + "es: " + g.calcularAnual());
        System.out.println("El salario anual de " + v.getNombre() + "es: " + v.calcularAnual());

    }
}