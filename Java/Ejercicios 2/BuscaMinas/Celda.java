package BuscaMinas;

public class Celda {
    private boolean estado; //bomba
    private int[] pos = new int[2];
    private boolean revelado = false;
    private int bombasVecinas;
    
    public Celda(int[] pos, boolean estado){
        this.pos = pos;
        this.estado = estado;
    }
    public boolean getEstado(){
        return this.estado;
    }
    public int[] getPos(){
        return pos;
    }
    public void setRevelado(){
        this.revelado = true;
    }
    public boolean getRevelado(){
        return this.revelado;
    }
    public int getBombas(){
        return bombasVecinas;
    }
    public void setBombas(int bombas){
        this.bombasVecinas = bombas;
    }
    
}
