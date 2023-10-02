import java.util.Random;
import java.util.Scanner;

// Hacer un generador de contraseña y que se pruebe la misma
// Preguntar si debe tener mayus, minus o nums; si se da false los primeros dos, nums debe ser true automaticamente
// Luego probar una contraseña y printear si es valida o no 

public class generadorContrasena{
    public static void main(String[] args) {
        
        Scanner stdin = new Scanner (System.in);
        
        System.out.print("Ingrese el largo de la contrasena: ");
        int largo=stdin.nextInt();

        System.out.print("Incluir mayusculas? (true/false): ");
        boolean mayus=stdin.nextBoolean();

        System.out.print("Incluir minusculas? (true/false): ");
        boolean minus=stdin.nextBoolean();

        System.out.print("Incluir numeros? (true/false): ");
        boolean nums=stdin.nextBoolean();
        
        stdin.close();
        
        String res = generarContra(largo, mayus, minus, nums);

        System.out.print("Contraseña generada: " + res);

        
    }

    public static String generarContra(int largo, boolean mayus, boolean minus, boolean nums){
        
        Random random = new Random();
        String valores = "";
        String contra = "";

        if (!mayus && !minus && !nums){
            nums = true;
        }
        if (mayus){
            valores += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (minus){
            valores += "abcdefghijklmnopqrstuvwxyz";
        }
        if (nums){
            valores += "0123456789";
        }
        
        for (int i = 0; i < largo; i++){
            int index = random.nextInt(valores.length());
            contra += valores.charAt(index);
        }
        
        return contra;
    }

}