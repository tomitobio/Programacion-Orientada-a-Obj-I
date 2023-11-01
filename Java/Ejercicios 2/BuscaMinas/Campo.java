package BuscaMinas;
import java.util.*;


public class Campo {
    private int base;
    private Celda[][] mapa;

    public Campo(int base,int dificultad){
        this.base = base;
        this.mapa = new Celda[base][base];
        crear(dificultad+1);
        setProximidad();
        imprimir();
    }
    public void crear(int dificultad){
        int[] pos= new int[2];
        int rndom;
        boolean estado;
        for(int x = 0;x<this.base;x++){
            for(int y=0;y<this.base;y++){
                rndom = (int)(Math.random()*dificultad);
                pos[0] = x;
                pos[1] = y;

                if(rndom == 1){
                    estado = true;
                }
                else{
                    estado = false;
                }
                mapa[x][y] = new Celda(pos ,estado);
            }
        }
    }
    
    public void imprimir(){
        for(int x = 0;x<this.base;x++){
            for(int y=0;y<this.base;y++){
                if(mapa[x][y].getRevelado() == false){
                    System.out.printf("|%d| ");
                }
                else{
                    System.out.printf("|%d| ",mapa[x][y].getBombas());
                }
            }
            System.out.printf("%n");

        }
    }
    public void admin(){
        System.out.printf("%n");
        for(int x = 0;x<this.base;x++){
            for(int y=0;y<this.base;y++){
                if(mapa[x][y].getEstado() == false){
                    System.out.printf("|%d| ",mapa[x][y].getBombas());
                }
                else{
                    System.out.printf("|X| ");
                }
            }
            System.out.printf("%n");
        }
    }
    public boolean revelar(int x, int y){
        mapa[x][y].setRevelado();
        return mapa[x][y].getEstado();
    }
    public void setProximidad(){
        int cont = 0;
        for(int x = 0;x<this.base;x++){
            for(int y=0;y<this.base;y++){
                if(x == 0){
                    if(y==0){
                        cuenta(0,0,1,0);
                    }
                }
                mapa[x][y].setBombas(cont);
            }
        }
    }
    //SIGUE ACA
    public int cuenta(int xizq,int xder,int yup,int ydw){
        int cont = 0;
        for(int x = xizq;x<xder+1;x++){
            for(int y=yup;y<ydw+1;y++){
                if(mapa[x][y].getEstado() == true){
                    cont++;
                }

            }
        }
        return cont;
    }
}
