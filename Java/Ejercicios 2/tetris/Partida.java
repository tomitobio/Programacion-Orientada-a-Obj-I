package tetris;

import java.util.*;

public class Partida {
    private Tablero tablero;
    private int largo;
    private int ancho;
    private int puntos = 0;

    public void crear() {
        // tablero prediseñado
        this.largo = 5;
        this.ancho = 3;
        this.tablero = new Tablero(largo, ancho);
    }

    public void iniciar() {
        int mov;
        int altura;
        int lateral;
        while (true) {
            System.out.printf("Puntaje: %d%n", this.puntos);
            mov = 0;
            altura = 0;
            lateral = this.ancho / 2;
            if (this.tablero.nacer() == false) {
                break;
            }
            while (true) {
                this.tablero.imprimirTablero();
                mov = movimiento();
                if (this.tablero.update(altura, lateral, mov) == false) {
                    break;
                }
                if ((lateral + mov < this.ancho && lateral + mov >= 0)) {
                    lateral = lateral + mov;
                }
                altura++;
                System.out.printf("Puntaje: %d%n", this.puntos);
            }
            if (evaluar(this.tablero, altura) == true) {
                relocate(this.tablero);
                this.puntos = this.puntos + 100;
            }
        }
    }

    public int movimiento() {
        // Der, Izq , No
        int mov = 0;
        try {
            try (Scanner stdin = new Scanner(System.in)) {
                System.out.print("Ingrese Movimiento: ");
                mov = stdin.nextInt();
            }
            if (mov == -1 || mov == 0 || mov == 1) {
                return mov;
            }
            System.out.println("Comando No valido.");
            return movimiento();
        } catch (

        Exception e) {
            // si no es numero
            System.out.println("Ingrese un numero.");
            return movimiento();
        }

    }

    public boolean evaluar(Tablero tablero, int altura) {
        int cont = 0;
        for (int i = 0; i < this.ancho; i++) {
            if (tablero.getTablero()[altura][i].getEstado() == true) {
                cont++;
            }
        }
        if (cont == ancho) {
            for (int i = 0; i < this.ancho; i++) {
                tablero.getTablero()[altura][i].setEstado(false);
            }
            return true;
        } else {
            return false;
        }
    }

    public void relocate(Tablero tablero) {
        Tablero nuevoTablero = new Tablero(this.largo, this.ancho);

        for (int x = 0; x < largo - 1; x++) { // no llega a la ultima fila
            for (int y = 0; y < ancho; y++) {
                nuevoTablero.getTablero()[x + 1][y].setEstado(tablero.getTablero()[x][y].getEstado());
            }
        }
        this.tablero = nuevoTablero;
    }
}
