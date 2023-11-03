public class TablaJ {
    private CelulaJ[][] tabla;
    private int size;

    public TablaJ(int size) {
        if (size < 10) {
            System.out.println("El tamaño de la tabla es muy chico, el minimo será 10.");
            tabla = new CelulaJ[10][10];
            this.size = 10;
        } else {
            tabla = new CelulaJ[size][size];
            this.size = size;
        }
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int[] pos = { i, j };
                tabla[i][j] = new CelulaJ(pos);
            }
        }
    }

    public void poblarTabla(int c) {
        if (c < 5) {
            System.out.println("Poca cantidad de celulas, el minimo será 5.");
            c = 5;
        }
        System.out.println("Poblamos al mundo con " + c + " celulas.");
        System.out.println("Este tendra un tamaño de " + size + "x" + size + ".");
        for (int i = 0; i < c; i++) {
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);
            tabla[x][y].nacer();
        }
    }

    public int cantVecinos(CelulaJ c) {
        int cont = 0;
        int columna = c.getPos()[1];
        int fila = c.getPos()[0];
        int[] alrededorC = { columna - 1, columna, columna + 1 };
        int[] alrededorF = { fila - 1, fila, fila + 1 };
        for (int i : alrededorF) {
            for (int j : alrededorC) {
                try {
                    if (tabla[i][j].vive() && (i < size && j < size) && (i >= 0 && j >= 0) && tabla[i][j] != c) {
                        cont++;
                    }
                } catch (Exception e) {

                }
            }
        }
        return cont;
    }

    public CelulaJ[][] getTabla() {
        return tabla;
    }

    public void imprimir() {
        System.out.println("-------------------");
        for (CelulaJ[] fila : tabla) {
            for (CelulaJ c : fila) {
                if (c.vive()) {
                    System.out.print("|*");
                } else {
                    System.out.print("| ");
                }
            }
            System.out.print("|\n");
        }

        System.out.println("-------------------");
        System.out.println("\n");
    }
}
