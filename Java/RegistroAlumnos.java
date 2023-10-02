import java.util.InputMismatchException;
import java.util.Scanner;
public class RegistroAlumnos{
    public static void main(String[] args) {
        int edad;
        
        int[] arrEdades = new int[100];
        String[] arrNombres = new String[100];
        
        
        Scanner stdin = new Scanner(System.in);
        System.out.print("Ingrese Nombre: ");
        String nombre = stdin.next();
        try{
            int i=0;
            while(!nombre.equals("salir") && i<100){
                edad = PreguntarEdad();
                
                arrEdades[i] = edad;
                arrNombres[i] = nombre;
                
                //System.out.print(arrEdades[i]);
                //System.out.print(arrNombres[i]);
                
                System.out.print("Ingrese Nombre: ");
                nombre = stdin.next();
                //System.out.print("\n"+nombre);
                i++;
                
            }
            for(int j=0; j<i ;j++){
                System.out.println(j + "- Nombre: "+ arrNombres[j]+". Edad: " + arrEdades[j]);
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Se fue del rango en algun array");
        }

        stdin.close();
    }
    public static int PreguntarEdad(){
        int a=-1;
        Scanner stdin = new Scanner(System.in);
        try {
            
            System.out.print("Ingrese Edad: ");
            a = stdin.nextInt();
            
        } catch (InputMismatchException ex) {
            System.out.println("Pusiste otra cosa en el int de edad");
        }
        stdin.close();
        return a;
    }

}