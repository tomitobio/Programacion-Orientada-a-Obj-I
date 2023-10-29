// // Definir la interfaz Trabajo
// interface Trabajo {
//     void realizarTrabajo();
// }

// // Clase Empleado que implementa la interfaz Trabajo
// class Empleado implements Trabajo {
//     @Override
//     public void realizarTrabajo() {
//         System.out.println("El empleado está trabajando.");
//     }

//     public void trabajar() {
//         realizarTrabajo();
//     }
// }

// // Clase concreta Programador que extiende Empleado
// class Programador extends Empleado {
//     @Override
//     public void realizarTrabajo() {
//         System.out.println("El programador está programando código.");
//     }
// }

// // Clase concreta Diseñador que extiende Empleado
// class Diseñador extends Empleado {
//     @Override
//     public void realizarTrabajo() {
//         System.out.println("El diseñador está creando diseños.");
//     }
// }

// public class Main10 {
//     public static void main(String[] args) {
//         Empleado empleado = new Empleado();
//         Programador programador = new Programador();
//         Diseñador diseñador = new Diseñador();

//         empleado.trabajar();
//         programador.trabajar();
//         diseñador.trabajar();
//     }
// }

interface Trabajo {
    void realizarTrabajo();
}

class Empleado implements Trabajo {
    @Override
    public void realizarTrabajo() {
        System.out.println("Este empleado esta trabajando.");
    }

    public void trabajar() {
        realizarTrabajo();
    }
}

class Programador extends Empleado {
    @Override
    public void realizarTrabajo() {
        System.out.println("Este programador esta trabajando.");
    }

    public void trabajar() {
        realizarTrabajo();
    }
}

class Diseñador extends Empleado {
    @Override
    public void realizarTrabajo() {
        System.out.println("Este diseñador esta trabajando.");
    }

    public void trabajar() {
        realizarTrabajo();
    }
}

public class Main10 {
    public static void main(String[] args) {
        Empleado e = new Empleado();
        Programador p = new Programador();
        Diseñador d = new Diseñador();

        e.trabajar();
        p.trabajar();
        d.trabajar();
    }
}