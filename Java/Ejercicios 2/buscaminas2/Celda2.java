package buscaminas2;

public class Celda2 {
    private boolean explota;
    private boolean visible = false;
    private int[] ubi = new int[2];
    private int vecinos;

    public Celda2(int[] ubi, boolean explota) {
        this.ubi = ubi;
        this.explota = explota;
    }

    public boolean getExplota() {
        return explota;
    }

    public void setVisible() {
        this.visible = true;
    }

    public int[] getUbi() {
        return ubi;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public int getVecinos() {
        return vecinos;
    }

    public void setVecinos(int vecinos) {
        this.vecinos = vecinos;
    }

}
