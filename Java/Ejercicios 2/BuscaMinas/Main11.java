package BuscaMinas;

public class Main11 {
    public static void main(String[] args) {
        Partida partida = new Partida(10, 5);
        partida.jugar();

        Campo juegoGuardado = partida.guardarJuego();
        partida.cargarJuego(juegoGuardado);
    }
}
