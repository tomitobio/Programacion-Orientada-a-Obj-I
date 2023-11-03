public class Celula {
    private boolean viva;
    private int[] posicion;
    private int vecinos;

    public Celula(int[] pos) {
        this.viva = false;
        this.posicion = pos;
    }

    // Retorna si la celula esta viva o no;
    public boolean vive() {
        if (viva == true) {
            return true;
        } else {
            return false;
        }
    }

    public int getVecinos() {
        return vecinos;
    }

    public void setVecinos(int auxVecinos) {
        this.vecinos = auxVecinos;
    }

    public void sobrevivir() {
        if (this.vive()) {
            this.viva = true;
        } else {
            this.viva = false;
        }
    }

    public void nacer() {
        this.viva = true;
    }

    public void morir() {
        this.viva = false;
    }

    public int[] getPosicion() {
        return posicion;
    }

}
