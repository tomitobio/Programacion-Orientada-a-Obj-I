import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Doble> habDobles;
    private ArrayList<Triple> habTriples;
    private ArrayList<Cuadruple> habCuadruples;

    Hotel(){
        habDobles = new ArrayList<>();
        habTriples = new ArrayList<>();
        habCuadruples = new ArrayList<>();
        Doble habDoble;
        Triple habTriple;
        Cuadruple habCuadruple;
        for(int i=0; i<12; i++){
            habDoble = new Doble();
            habDobles.add(habDoble);
            if(i < 8){
                habTriple = new Triple();
                habTriples.add(habTriple);
            }
            if(i<5){
                habCuadruple = new Cuadruple();
                habCuadruples.add(habCuadruple);
            }
        }
    }

    public void mostrarMenu(){
        System.out.println("1- Realizar check-in");
        System.out.println("2- Realizar check-out");
        System.out.println("3- Mostrar estado de ocupacion");
        System.out.println("4- Salir");
    }

    public void start(){
        System.out.println("Bienvenido al hotel...");
        mostrarMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese valor: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        while(opcion != 4){
            switch(opcion){
                case 1:
                realizarCheckIn();
                break;
                case 2:
                //realizarCheckOut();
                break;
                case 3:
                mostrarEstado();
                break;
                default:
                System.out.println("Opcion no disponible!");
            }
            mostrarMenu();
            System.out.print("Ingrese valor: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        scanner.close();
    }

    public void mostrarEstado(){
        for(Doble habDoble : habDobles){
            habDoble.mostrarDatos();
        }
        for(Triple habTriple : habTriples){
            habTriple.mostrarDatos();
        }
        for(Cuadruple habCuadruple : habCuadruples){
            habCuadruple.mostrarDatos();
        }
    }

    public void realizarCheckIn(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccionar tipo de habitacion:");
        System.out.println("1- Doble");
        System.out.println("2- Triple:");
        System.out.println("3- Cuadruple:");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1:
            for(Doble habDoble : habDobles){
                if(!habDoble.getOcupada()){
                    Habitacion habitacion = habDoble;
                    registrarPersonas(habitacion);
                    break;
                }
            }
            break;
            case 2:
            for(Triple habTriple : habTriples){
                if(!habTriple.getOcupada()){
                    Habitacion habitacion = habTriple;
                    registrarPersonas(habitacion);
                    break;
                }
            }
            break;
            case 3:
            for(Cuadruple habCuadruple : habCuadruples){
                if(!habCuadruple.getOcupada()){
                    Habitacion habitacion = habCuadruple;
                    registrarPersonas(habitacion);
                    break;
                }
            }
            break;
        }

        scanner.close();
    }

    private Persona pedirDatosPersona(){
        Scanner scanner = new Scanner(System.in);
        String nombre, apellido, genero;
        int DNI, edad;
        System.out.println("Ingrese nombre:");
        nombre = scanner.nextLine();
        System.out.println("Ingrese apellido:");
        apellido = scanner.nextLine();
        System.out.println("Ingrese DNI:");
        try{
            DNI = scanner.nextInt();
            scanner.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Debe ingresar un numero!");
            System.out.println("Ingrese DNI:");
            DNI = scanner.nextInt();
            scanner.nextLine();
        }
        
        System.out.println("Ingrese genero:");
        genero = scanner.nextLine();
        while(!genero.equalsIgnoreCase("hombre") || !genero.equalsIgnoreCase("mujer")){
            System.out.println("Debe ingresar hombre o mujer");
            genero = scanner.nextLine();
        }
        System.out.println("Ingrese edad:");
        edad = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        Persona persona = new Persona(nombre, apellido, DNI, genero, edad);
        return persona;
    }

    private void registrarPersonas(Habitacion habitacion){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<habitacion.getCapacidad(); i++){
            System.out.printf("Registrando persona %d%n", i+1);
            Persona persona = pedirDatosPersona();
            System.out.println("La persona es el titular?(true/false):");
            boolean esTitular = scanner.nextBoolean();
            scanner.nextLine();
            if(esTitular){
                habitacion.setTitular(persona);
            }
            habitacion.agregarOcupante(persona);
        }
        scanner.close();
    }

    private void realizarCheckOut(){
        System.out.println("Ingrese el codigo de la habitacion:");
    }
    
}
