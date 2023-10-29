// // Definir la interfaz InstrumentoMusical
// interface InstrumentoMusical {
//     void tocar();

//     void afinar();
// }

// // Clase concreta Guitarra que implementa InstrumentoMusical
// class Guitarra implements InstrumentoMusical {
//     @Override
//     public void tocar() {
//         System.out.println("Tocando la guitarra...");
//     }

//     @Override
//     public void afinar() {
//         System.out.println("Afinando la guitarra...");
//     }
// }

// // Clase concreta Piano que implementa InstrumentoMusical
// class Piano implements InstrumentoMusical {
//     @Override
//     public void tocar() {
//         System.out.println("Tocando el piano...");
//     }

//     @Override
//     public void afinar() {
//         System.out.println("Afinando el piano...");
//     }
// }

// public class Main8 {
//     public static void main(String[] args) {
//         // Crear un arreglo de InstrumentoMusical
//         InstrumentoMusical[] instrumentos = new InstrumentoMusical[2];
//         instrumentos[0] = new Guitarra();
//         instrumentos[1] = new Piano();

//         // Llamar al método tocar() en cada instrumento
//         for (InstrumentoMusical instrumento : instrumentos) {
//             instrumento.tocar();
//         }
//     }
// }

interface InstrumentoMusical {
    void afinar();

    void tocar();
}

class Guitarra implements InstrumentoMusical {
    @Override
    public void afinar() {
        System.out.println("Afinando guitarra...");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando guitarra. ");
    }
}

class Piano implements InstrumentoMusical {
    @Override
    public void afinar() {
        System.out.println("Afinando piano...");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando piano. ");
    }
}

public class Main8 {
    public static void main(String[] args) {
        InstrumentoMusical[] instrumentos = new InstrumentoMusical[2];
        instrumentos[0] = new Guitarra();
        instrumentos[1] = new Piano();

        instrumentos[0].afinar();
        instrumentos[0].tocar();

        instrumentos[1].afinar();
        instrumentos[1].tocar();
    }
}