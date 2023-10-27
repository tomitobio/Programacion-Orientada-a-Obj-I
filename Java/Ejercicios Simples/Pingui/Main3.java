// // Definir la interfaz Ave
// interface Ave {
//     void volar();
// }

// // Definir la interfaz Pez
// interface Pez {
//     void nadar();
// }

// // Clase Pingüino que implementa ambas interfaces
// class Pingüino implements Ave, Pez {
//     @Override
//     public void volar() {
//         System.out.println("El pingüino no puede volar, ¡pero puede nadar!");
//     }

//     @Override
//     public void nadar() {
//         System.out.println("El pingüino está nadando en el agua.");
//     }
// }

// public class Main3 {
//     public static void main(String[] args) {
//         Pingüino miPingüino = new Pingüino();
//         miPingüino.volar();
//         miPingüino.nadar();
//     }
// }

interface Ave {
    void volar();
}

interface Pez {
    void nadar();
}

class Pinguino implements Ave, Pez {
    @Override
    public void volar() {
        System.out.println("Esta ave esta volando!!");
    }

    @Override
    public void nadar() {
        System.out.println("Esta pez esta nadando!!");
    }
}

public class Main3 {
    public static void main(String[] args) {
        Pinguino pingui = new Pinguino();

        pingui.volar();
        pingui.nadar();
    }
}