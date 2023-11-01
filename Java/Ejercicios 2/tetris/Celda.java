package tetris;

public class Celda {
    private boolean estado;
    private int posX;

    public Celda(boolean estado){
        this.estado = estado;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    public boolean getEstado(){
        return estado;
    }
    public int getPosicion(){
        return posX;
    }
    public String revelar(){
        if (estado == true){
            return "#";
        }
        else{
            return "-";
        }
    }
}
