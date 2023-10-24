// Definir la interfaz Trabajo
interface Trabajo {
    void realizarTrabajo();
}

// Clase Empleado que implementa la interfaz Trabajo
class Empleado implements Trabajo {
    @Override
    public void realizarTrabajo() {
        System.out.println("El empleado está trabajando.");
    }

    public void trabajar() {
        realizarTrabajo();
    }
}

// Clase concreta Programador que extiende Empleado
class Programador extends Empleado {
    @Override
    public void realizarTrabajo() {
        System.out.println("El programador está programando código.");
    }
}

// Clase concreta Diseñador que extiende Empleado
class Diseñador extends Empleado {
    @Override
    public void realizarTrabajo() {
        System.out.println("El diseñador está creando diseños.");
    }
}

public class Main10 {
    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        Programador programador = new Programador();
        Diseñador diseñador = new Diseñador();

        empleado.trabajar();
        programador.trabajar();
        diseñador.trabajar();
    }
}
