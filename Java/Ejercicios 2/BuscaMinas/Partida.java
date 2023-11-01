package BuscaMinas;
import java.util.*;

public class Partida {
    private int base;
    private Campo campo;

    public Partida(int base,int dificultad){
        this.base = base; 
        this.campo = new Campo(base,dificultad);
        campo.admin();
    }
    public void jugar(){
        int fila;
        int columna;
        while(true){
            fila = movimiento("Fila");
            columna = movimiento("Columna");

            if(campo.revelar(fila,columna) == true){
                break;
            }
            campo.imprimir();
            
        }
        System.out.println("GAME OVER");
        campo.admin();
    }
    public int movimiento(String txt){
        //Der, Izq , No
        int mov=0; 
        try{
            //verifica movimiento valido (-1)-0-1
            Scanner stdin = new Scanner(System.in);
            System.out.printf("Ingrese %s: ",txt);
            mov = stdin.nextInt();
            
            if(mov >= 0 && mov<=this.base-1){
                return mov;
            }
            System.out.println("Dentro del rango.");
            return movimiento(txt);
        }catch(Exception e){
            //si no es numeros
            System.out.println("Ingrese un numero.");
            return movimiento(txt);
        }
        
    }
    public Campo guardarJuego(){
        return campo;
    }
    public void cargarJuego(Campo campo){
        this.campo = campo;
    }
    
    
}