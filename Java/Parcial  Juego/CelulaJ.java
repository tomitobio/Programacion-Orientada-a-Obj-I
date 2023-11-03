public class CelulaJ {
    private boolean vive;
    private int[] pos;
    private int vecinos;

    public CelulaJ(int[] pos) {
        this.vive = false;
        this.pos = pos;
    }

    public boolean vive() {
        if (vive == true) {
            return true;
        } else {
            return false;
        }
    }

    public void sobrevive() {
        if (this.vive() == true) {
            this.vive = true;
        } else {
            this.vive = false;
        }
    }

    public int[] getPos() {
        return pos;
    }

    public void nacer() {
        this.vive = true;
    }

    public int getVecinos() {
        return vecinos;
    }

    public void setVecinos(int i) {
        this.vecinos = i;
    }

    public void matar() {
        this.vive = false;
    }
}
