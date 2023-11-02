package tetris2;

public class Tablero2 {
    private Celda2[][] tabla;
    private int largo;
    private int ancho;

    public void crearTabla() {
        for (int x = 0; x < largo; x++) {
            for (int y = 0; y < ancho; y++) {
                tabla[x][y] = new Celda2(false);
            }
        }
    }

    public void imprimir() {
        for (int x = 0; x < largo; x++) {
            for (int y = 0; y < ancho; y++) {
                System.out.printf(" %s", tabla[x][y].revelar());
            }
        }
    }

    // Metodos
    public Celda2[][] getTabla() {
        return tabla;
    }

    public boolean nacer() {
        if (tabla[0][ancho / 2].getEstado() == false) {
            tabla[0][ancho / 2].setEstado(true);
            return true;
        } else {
            return false;
        }
    }

    public boolean update(int altura, int lateral, int mov) {
        int sigA = altura + 1;
        if (altura == largo - 1) {
            return false;
        }
        try {
            if (tabla[sigA][lateral + mov].getEstado() == false) {
                tabla[sigA][lateral + mov].setEstado(true);
                tabla[altura][lateral].setEstado(false);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            // Choca con la pared
            if (tabla[sigA][lateral].getEstado() == false) {
                tabla[sigA][lateral].setEstado(true);
                tabla[altura][lateral].setEstado(false);
                return true;
            } else {
                return false;
            }

        }
    }

}
