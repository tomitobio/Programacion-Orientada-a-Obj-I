//import java.util.*;

public class Tablero {
    private Celula[][] universo;
    private int size;

    // Constructor de la matriz
    public Tablero(int size) {
        if (size < 10) {
            System.out.println("El valor " + size + " es muy pequeÃ±o se usara el valor minimo de 10");
            universo = new Celula[10][10];
            this.size = 10;
        } else {
            universo = new Celula[size][size];
            this.size = size;
        }
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int[] pos = { i, j };
                universo[i][j] = new Celula(pos);
            }
        }
    }

    // Aleatoriamente puebla de n celulas a la matriz universo
    public void crearMundo(int n) {
        if (n < 5) {
            System.out.println("La cantidad de celulas es muy pequeña se usara 5");
            n = 5;
        }
        System.out.println("Vamos a crear un mundo con " + n + " celulas");
        System.out.println("Con un tamaño de " + size + " x " + size);
        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);
            universo[x][y].nacer();
        }
    }

    // Cantidad de celulas vivas alrededor de la celula
    public int cantVecinos(Celula celula) {
        int contador = 0;
        int columna = celula.getPosicion()[1];
        int fila = celula.getPosicion()[0];
        // int[] pos = celula.getPosicion();
        int[] alrededorColumna = { columna - 1, columna, columna + 1 };
        int[] alrededorFila = { fila - 1, fila, fila + 1 };
        for (int i : alrededorFila) {
            for (int j : alrededorColumna) {
                // int[] posicion = { i, j };
                try {
                    // System.out.println(i+","+j);
                    // System.out.println(pos[0]+","+pos[1]+"/ "+ posicion[0]+" "+posicion[1]);
                    if (universo[i][j].vive() && (i < size && j < size) && (i >= 0 && j >= 0)
                            && universo[i][j] != celula) {
                        contador++;
                    }
                } catch (Exception e) {
                    // System.out.println(j+","+i+", "+e);
                }
            }
        }
        // System.out.println(contador +": Cordenadas "+fila+' '+columna);
        return contador;
    }

    public Celula[][] getMundo() {
        return universo;
    }

    public void imprimir() {
        System.out.println("---------------------");
        for (Celula[] filas : universo) {
            for (Celula celula : filas) {
                if (celula.vive()) {
                    System.out.print("|*");
                } else {
                    System.out.print("| ");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("---------------------");
        System.out.print("\n");
    }

}
