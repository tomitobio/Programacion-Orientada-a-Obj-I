public class ParImpar{
    public static void main(String[] args){
        int num = 5;
        String nota; 

        /*
        //Ejercicio 1
        if(numero1 == numero2){
            System.out.println(numero1 + " es igual que " + numero2);
        }else{
            if(numero1 < numero2){
                System.out.println(numero1 + " es menor que " + numero2);
            }else{
                System.out.println(numero1 + " es mayor que " + numero2);
            }
            
        }
        */
        /*
        //Ejercicio 2
        switch(num) {
            case num < 5:
                nota = "La pelicula es horrible";
                break;
            case num == 5:
                nota = "La pelicula es promedio";
                break;
            case 10 > num > 5:
                nota = "La pelicula esta buena";
                break;
            case 10 == num:
                nota = "La pelicula esta buenisima";
                break;
            default:
                System.out.println(nota);
        }
        */
        /*
        //Ejercicio 3
        int[][] matriz = {
                {1, 4, 7 },
                {2, 5, 8 },
                {3, 6, 9 }
        };

        
        for (int i = 0 ; i < 3 ; i++){
           for (int j = 0 ; j < 3 ; j++){
                System.out.print(matriz[j][i] + " ");
            } 
            System.out.println();
        }
        */

        //Ejercicio 4
        char[][] tablero = new char[8][8];
        
        for(int filas = 0; filas < 8 ; filas++){
            for(int col = 0; col < 8 ; col++){
                if ((col + filas) %2 == 0){
                    tablero[filas][col] = '#';  
                }else{
                    tablero[filas][col] = '*';  
                }
            }
        }
        for(int i = 0; i < 8 ; i++){
           for(int j = 0; j < 8 ; j++){
                System.out.print(tablero[i][j] + " ");
            } 
            System.out.println();
        }
    }
}