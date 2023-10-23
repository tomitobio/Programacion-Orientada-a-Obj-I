// Definir la interfaz Ave
interface Ave {
    void volar();
}

// Definir la interfaz Pez
interface Pez {
    void nadar();
}

// Clase Pingüino que implementa ambas interfaces
class Pingüino implements Ave, Pez {
    @Override
    public void volar() {
        System.out.println("El pingüino no puede volar, ¡pero puede nadar!");
    }

    @Override
    public void nadar() {
        System.out.println("El pingüino está nadando en el agua.");
    }
}

public class Main {
    public static void main(String[] args) {
        Pingüino miPingüino = new Pingüino();
        miPingüino.volar();
        miPingüino.nadar();
    }
}
