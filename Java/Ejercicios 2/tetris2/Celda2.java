package tetris2;

public class Celda2 {
    private boolean estado;
    private int pos;

    public Celda2(boolean estado) {
        this.estado = estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setPos(int p) {
        this.pos = p;
    }

    public int getPos() {
        return pos;
    }

    public String revelar() {
        if (estado == true) {
            return "X";
        } else {
            return "-";
        }
    }
}
