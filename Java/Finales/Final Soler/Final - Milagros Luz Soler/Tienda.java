import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Tienda {
    private ArrayList<Basic> sociosBasic;
    private ArrayList<Prefer> sociosPrefer;
    private ArrayList<Premium> sociosPremium;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<CD> cds;
    private ArrayList<Libro> libros;

    public Tienda(){
        this.sociosBasic = new ArrayList<Basic>();
        this.sociosPrefer = new ArrayList<Prefer>();
        this.sociosPremium = new ArrayList<Premium>();
        this.peliculas = new ArrayList<Pelicula>();
        this.cds = new ArrayList<CD>();
        this.libros = new ArrayList<Libro>();
    }

    public void addSociosBasic(Basic socio){
        this.sociosBasic.add(socio);
    }

    public void addSociosPrefer(Prefer socio){
        this.sociosPrefer.add(socio);
    }

    public void addSociosPremium(Premium socio){
        this.sociosPremium.add(socio);
    }

    public void addLibro(Libro libro){
        this.libros.add(libro);
    }

    public void addCds(CD cd){
        this.cds.add(cd);
    }

    public void addPelicula(Pelicula pelicula){
        this.peliculas.add(pelicula);
    }

    public Basic registrarBasic(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese DNI:");
        int dni = scanner.nextInt();

        Basic basic = new Basic(nombre,dni);

        return basic;
    }

    public Prefer registrarPrefer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese DNI:");
        int dni = scanner.nextInt();

        Prefer prefer = new Prefer(nombre,dni);

        return prefer;
    }

    public Premium registrarPremium(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese DNI:");
        int dni = scanner.nextInt();

        Premium premium = new Premium(nombre,dni);

        return premium;
    }


    public void registrarNuevoSocio(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("Elija tipo de socio:\nIngrese un numero:\n1. Basic\n2. Prefer\n3. Premium");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                Basic socioNuevo = registrarBasic();
                sociosBasic.add(socioNuevo);
                System.out.println("Socio agregado correctamente");
                break;
        
            case 2:
                Prefer socioNuevo1 = registrarPrefer();
                sociosPrefer.add(socioNuevo1);
                System.out.println("Socio agregado correctamente");
                break;
            
            case 3:
                Premium socioNuevo2 = registrarPremium();
                sociosPremium.add(socioNuevo2);
                System.out.println("Socio agregado correctamente");
                break;
        }
    }

    public void productos(){
        System.out.println("PELICULAS");
        for(Pelicula pelicula : peliculas){
            pelicula.getDetails();
        }
        System.out.println("CDS");
        for(CD cd : cds){
            cd.getDetails();
        }
        System.out.println("LIBROS");
        for(Libro libro : libros){
            libro.getDetails();
        }
    }

    public void socios(){
        System.out.println("SOCIOS BASIC");
        for(Basic basic : sociosBasic){
            basic.getDetails();
        }
        System.out.println("SOCIOS PREFER");
        for(Prefer prefer : sociosPrefer){
            prefer.getDetails();
        }
        System.out.println("SOCIOS PREMIUM");
        for(Premium premium : sociosPremium){
            premium.getDetails();
        }
    }

    public void menuAlquilar(){
        System.out.println("Elija producto a alquilar:\nIngrese un numero:\n1. CD\n2. Libro\n3. Pelicula");
    }

    public void menuDevolver(){
        System.out.println("Elija producto a devolver:\nIngrese un numero:\n1. CD\n2. Libro\n3. Pelicula");
    }

    public void devolver(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su DNI:");
        int DNIinput = scanner.nextInt();
        int opcion;
        int IDbuscado;
        int contador = 0;

        for(Basic basic : sociosBasic){
            if(DNIinput == basic.getDNI()){
                menuDevolver();
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese ID de CD a devolver:");
                        IDbuscado = scanner.nextInt();
                        for(CD cd : cds){
                            if(IDbuscado == cd.getID()){
                                basic.devolverCD();
                                System.out.println("Retorno exitoso!");
                            }
                        }
                        break;
                
                    case 2:
                        System.out.println("Ingrese ID de Libro a devolver:");
                        IDbuscado = scanner.nextInt();
                        for(Libro libro : libros){
                            if(IDbuscado == libro.getID()){
                                basic.devolverLibro();
                                System.out.println("Retorno exitoso!");
                            }
                        }
                        break;
                    
                    case 3:
                        System.out.println("Ingrese ID de Pelicula a devolver:");
                        IDbuscado = scanner.nextInt();
                        for(Pelicula pelicula : peliculas){
                            if(IDbuscado == pelicula.getID()){
                                basic.devolverPelicula();
                                System.out.println("Retorno exitoso!");
                            }
                        }
                        break;
                }
            }else{
                contador = contador +1;
            }
        }

        for(Prefer prefer : sociosPrefer){
            if(DNIinput == prefer.getDNI()){
                menuDevolver();
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese ID de CD a devolver:");
                        IDbuscado = scanner.nextInt();
                        for(CD cd : cds){
                            if(IDbuscado == cd.getID()){
                                prefer.devolverCD();
                                System.out.println("Retorno exitoso!");
                            }
                        }
                        break;
                
                    case 2:
                        System.out.println("Ingrese ID de Libro a devolver:");
                        IDbuscado = scanner.nextInt();
                        for(Libro libro : libros){
                            if(IDbuscado == libro.getID()){
                                prefer.devolverLibro();
                                System.out.println("Retorno exitoso!");
                            }
                        }
                        break;
                    
                    case 3:
                        System.out.println("Ingrese ID de Pelicula a devolver:");
                        IDbuscado = scanner.nextInt();
                        for(Pelicula pelicula : peliculas){
                            if(IDbuscado == pelicula.getID()){
                                prefer.devolverPelicula();
                                System.out.println("Retorno exitoso!");
                            }
                        }
                        break;
                }
            }else{
                contador = contador +1;
            }
        }

        for(Premium premium : sociosPremium){
            if(DNIinput == premium.getDNI()){
                menuDevolver();
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese ID de CD a devolver:");
                        IDbuscado = scanner.nextInt();
                        for(CD cd : cds){
                            if(IDbuscado == cd.getID()){
                                premium.devolverCD();
                                System.out.println("Retorno exitoso!");
                            }
                        }
                        break;
                
                    case 2:
                        System.out.println("Ingrese ID de Libro a devolver:");
                        IDbuscado = scanner.nextInt();
                        for(Libro libro : libros){
                            if(IDbuscado == libro.getID()){
                                premium.devolverLibro();
                                System.out.println("Retorno exitoso!");
                            }
                        }
                        break;
                    
                    case 3:
                        System.out.println("Ingrese ID de Pelicula a devolver:");
                        IDbuscado = scanner.nextInt();
                        for(Pelicula pelicula : peliculas){
                            if(IDbuscado == pelicula.getID()){
                                premium.devolverPelicula();
                                System.out.println("Retorno exitoso!");
                            }
                        }
                        break;
                }
            }else{
                contador = contador +1;
            }
        }

        if(contador == 3){
            System.out.println("No se encontro un usuario con ese DNI.");
        }

    }

    public void alquilar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su DNI:");
        int DNIinput = scanner.nextInt();
        int opcion;
        int IDbuscado;
        int contador = 0;

        for(Basic basic : sociosBasic){
            if(DNIinput == basic.getDNI()){
                menuAlquilar();
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese ID de CD a alquilar:");
                        IDbuscado = scanner.nextInt();
                        for(CD cd : cds){
                            if(IDbuscado == cd.getID()){
                                basic.alquilarCD();
                                System.out.println("Alquiler exitoso!");
                            }
                        }
                        break;
                
                    case 2:
                        System.out.println("Ingrese ID de Libro a alquilar:");
                        IDbuscado = scanner.nextInt();
                        for(Libro libro : libros){
                            if(IDbuscado == libro.getID()){
                                basic.alquilarLibro();
                                System.out.println("Alquiler exitoso!");
                            }
                        }
                        break;
                    
                    case 3:
                        System.out.println("Ingrese ID de Pelicula a alquilar:");
                        IDbuscado = scanner.nextInt();
                        for(Pelicula pelicula : peliculas){
                            if(IDbuscado == pelicula.getID()){
                                basic.alquilarCD();
                                System.out.println("Alquiler exitoso!");
                            }

                        }
                        break;
                }
            }else{
                contador = contador +1;
            }
        }

        for(Prefer prefer : sociosPrefer){
            if(DNIinput == prefer.getDNI()){
                menuAlquilar();
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese ID de CD a alquilar:");
                        IDbuscado = scanner.nextInt();
                        for(CD cd : cds){
                            if(IDbuscado == cd.getID()){
                                prefer.alquilarCD();
                                System.out.println("Alquiler exitoso!");
                            }
                        }
                        break;
                
                    case 2:
                        System.out.println("Ingrese ID de Libro a alquilar:");
                        IDbuscado = scanner.nextInt();
                        for(Libro libro : libros){
                            if(IDbuscado == libro.getID()){
                                prefer.alquilarLibro();
                                System.out.println("Alquiler exitoso!");
                            }
                        }
                        break;
                    
                    case 3:
                        System.out.println("Ingrese ID de Pelicula a alquilar:");
                        IDbuscado = scanner.nextInt();
                        for(Pelicula pelicula : peliculas){
                            if(IDbuscado == pelicula.getID()){
                                prefer.alquilarCD();
                                System.out.println("Alquiler exitoso!");
                            }
                        }
                        break;
                }
            }else{
                contador = contador +1;
            }
        }

        for(Premium premium : sociosPremium){
            if(DNIinput == premium.getDNI()){
                menuAlquilar();
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese ID de CD a alquilar:");
                        IDbuscado = scanner.nextInt();
                        for(CD cd : cds){
                            if(IDbuscado == cd.getID()){
                                premium.alquilarCD();
                                System.out.println("Alquiler exitoso!");
                            }
                        }
                        break;
                
                    case 2:
                        System.out.println("Ingrese ID de Libro a alquilar:");
                        IDbuscado = scanner.nextInt();
                        for(Libro libro : libros){
                            if(IDbuscado == libro.getID()){
                                premium.alquilarLibro();
                                System.out.println("Alquiler exitoso!");
                            }
                        }
                        break;
                    
                    case 3:
                        System.out.println("Ingrese ID de Pelicula a alquilar:");
                        IDbuscado = scanner.nextInt();
                        for(Pelicula pelicula : peliculas){
                            if(IDbuscado == pelicula.getID()){
                                premium.alquilarCD();
                                System.out.println("Alquiler exitoso!");
                            }
                        }
                        break;
                }
            }else{
                contador = contador +1;
            }
        }

        if(contador == 3){
            System.out.println("No se encontro un usuario con ese DNI.");
        }

    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        int opcion;


        while(true){

        try {

            System.out.println("Bienvenido a la tienda... \nIngrese un numero:\n1. Alquilar\n2. Devolver\n3. Listado de productos\n4. Socios\n5. Registrar nuevo socio\n6. Salir");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    alquilar();
                    break;
            
                case 2:
                    devolver();
                    break;

                case 3:
                    productos();
                    break;
                
                case 4:
                    socios();
                    break;

                case 5:
                    registrarNuevoSocio();
                    break;
                
                case 6:
                    System.out.println("Saliendo del sistema...");
                    return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un numero");
            scanner.next();
        }
        
    }
    }   
}
