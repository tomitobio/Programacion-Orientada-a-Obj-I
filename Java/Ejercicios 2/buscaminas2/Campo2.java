package buscaminas2;

public class Campo2 {
    private int base;
    private Celda2[][] mapa;

    public Campo2(int base, int dificultad) {
        this.base = base;
        this.mapa = new Celda2[base][base];
        crear(dificultad + 1);

    }

    public void crear(int dificultad) {
        int[] pos = new int[2];
        int random;
        boolean explota;
        for (int x = 0; x < base; x++) {
            for (int y = 0; y < base; y++) {
                random = (int) (Math.random() * dificultad);
                pos[0] = x;
                pos[1] = y;
                if (random == 1) {
                    explota = true;
                } else {
                    explota = false;
                }
                mapa[x][y] = new Celda2(pos, explota);
            }
        }
    }

    public void imprimir() {
        for (int x = 0; x < base; x++) {
            for (int y = 0; y < base; y++) {
                if (mapa[x][y].getVisible() == false) {
                    System.out.printf("| | ");
                } else {
                    System.out.printf("|%d| ", mapa[x][y].getVecinos());
                }
            }
            System.out.printf("%n");
        }
    }

    public void iTodo() {
        for (int x = 0; x < base; x++) {
            for (int y = 0; y < base; y++) {
                if (mapa[x][y].getExplota() == false) {
                    System.out.printf("|%d| ", mapa[x][y].getVecinos());
                } else {
                    System.out.printf("|X| ");
                }
            }
            System.out.printf("%n");
        }
    }

    public boolean revelar(int x, int y) {
        mapa[x][y].setVisible();
        return mapa[x][y].getExplota();
    }

}
