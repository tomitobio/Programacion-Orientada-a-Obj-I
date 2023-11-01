package tetris;

public class Tablero {
    private Celda[][] tabla;
    private int largo;
    private int ancho;

    public Tablero(int largo,int ancho){
        this.tabla = new Celda[largo][ancho];
        this.largo = largo;
        this.ancho = ancho;
        crearTablero();
    }
    //Base
    public void crearTablero(){
        for(int x=0;x<largo;x++){
            for(int y=0;y<ancho;y++){
                tabla[x][y] = new Celda(false);
            }
        }
    }
    public void imprimirTablero(){
        for(int x=0;x<largo;x++){
            for(int y=0;y<ancho;y++){
                System.out.printf(" %s",tabla[x][y].revelar());
            }
            System.out.printf("%n");
        }
        System.out.printf("%n");
    }
    
    //Acciones
    public Celda[][] getTablero(){
        return tabla;
    }
    public boolean nacer(){
        if(tabla[0][ancho/2].getEstado() == false){
            tabla[0][ancho/2].setEstado(true);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean update(int altura,int lateral,int mov){
        int proxAltura = altura+1;
        if(altura == this.largo-1){
            return false;
        }
        try{
            if(tabla[proxAltura][lateral+mov].getEstado() == false){
                tabla[proxAltura][lateral+mov].setEstado(true);
                tabla[altura][lateral].setEstado(false);
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            //choca pared
            if(tabla[proxAltura][lateral].getEstado() == false){
                tabla[proxAltura][lateral].setEstado(true);
                tabla[altura][lateral].setEstado(false);
                return true;
            }
            else{
                return false;
            }
            
        }
    }
}
