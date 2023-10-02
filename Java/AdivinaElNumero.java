import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero{
    public static void main(String[] args) {
        Scanner stdin = new Scanner (System.in);
        int intentos = 0;
        int numAdi = generarNum();
        int numUsu = 0;

        while (!(numUsu == numAdi)){
            numUsu = numUsuario(stdin);
            intentos++;

            if (numUsu == numAdi){
                System.out.print("Encontraste el número en " + intentos + " intentos. El número es: " + numAdi);
                break;
            }
            else if (numUsu > numAdi){
                System.out.print("El numero debe ser menor.");
            }
            else {
                System.out.print("El numero debe ser mayor.");
            }
        }
        stdin.close();
        
    }

    public static int numUsuario(Scanner stdin)  {
        int num;
        while (true){
            try {
                System.out.print("Ingrese un numero: ");
                num = stdin.nextInt();
                break;
            }
            catch(java.util.InputMismatchException e){
                System.out.print("Ingrese un numero válido. Intente otra vez: ");
                stdin.nextLine(); // Limpia el buffer para evitar bucle infinito
            }
        }
        return num;
    }

    public static int generarNum(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        return numeroAleatorio;
    }

}