package buscaminas2;

import java.util.Scanner;

public class Partida2 {
    private Campo2 campo;
    private int base;

    public Partida2(int base, int dificultad) {
        this.base = base;
        this.campo = new Campo2(base, dificultad);
    }

    public int movimiento(String t) {
        int mov = 0;
        try {
            Scanner stdin = new Scanner(System.in);
            System.out.printf("Inserte un numero de %s: ", t);

            mov = stdin.nextInt();
            if (mov >= 0 && mov <= base - 1) {

                return mov;
            }

            System.out.println("Dentro del rango.");
            return movimiento(t);

        } catch (Exception e) {
            System.out.println("Ingrese un numero.");
            return movimiento(t);
        }
    }

    public void jugar() {
        int f;
        int c;

        while (true) {
            campo.imprimir();
            f = movimiento("fila");

            c = movimiento("columna");

            // campo.imprimir();

            if (campo.revelar(f, c) == true) {
                System.out.printf("Perdiste!! %n");
                campo.iTodo();
                break;
            }
        }

    }

}
