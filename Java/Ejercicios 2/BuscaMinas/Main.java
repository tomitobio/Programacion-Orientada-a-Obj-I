package BuscaMinas;

public class Main {
    public static void main(String[] args) {
        Partida partida = new Partida(10,5);
        partida.jugar();

        Campo juegoGuardado = partida.guardarJuego();
        partida.cargarJuego(juegoGuardado);
    }
}
