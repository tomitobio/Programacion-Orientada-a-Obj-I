import java.util.*;

public class Hotel {
    private List<Habitacion> habitaciones;

    Hotel(List<Habitacion> habitaciones){
        this.habitaciones = habitaciones;
    }

    public void agregarHabitaciones(Habitacion habitacion){
        habitaciones.add(habitacion);
    }

    public Habitacion mostrarEstado(){
        Scanner scanner = new Scanner(System.in);
        Habitacion eleccion = new Habitacion(null, null, 0, 0, false, null, null);

        for(Habitacion habitacion : habitaciones){
            System.out.print(habitacion.getId());
            if(habitacion.getEstado()){
               System.out.println(" - " + habitacion.getTitular().getApellido() + ", " + habitacion.getTitular().getNombre()); 
            }else{
                System.out.println(" Desocupado");
            }
        }

        System.out.println("Ingrese id de la habitacion que desea:");
        System.out.print("-> ");
        boolean entradaValida1 = false;

        while(!entradaValida1){
            try{
                String id = scanner.nextLine();
                for(Habitacion habitacion : habitaciones){
                    if(id.equals(habitacion.getId()) && !habitacion.getEstado()){
                        eleccion = habitacion;
                        entradaValida1 = true;
                    }else if(id.equals(habitacion.getId()) && habitacion.getEstado()){
                        throw new ArithmeticException("ERROR");
                    }
                }
            }catch(ArithmeticException e){
                System.out.println(e.getMessage() + " - esa habitacion esta ocupada.");
                System.out.println("Elija otra.");
                //scanner.nextLine();
            }
        }

        scanner.close();

        return eleccion;
    }

    public void checkIn(Habitacion habitacion){
        Scanner scanner = new Scanner(System.in);
        int capacidad = habitacion.getCapacidad();
        List<Persona> ocupantes = new ArrayList<>();

        System.out.println("Ingrese datos del titular:");
        Persona titular = ingresarPersona(scanner);

        System.out.println("Ingrese los ocupantes:");
        for (int i = 0; i < capacidad; i++) {
            System.out.println("Ingrese datos del ocupante " + (i + 1) + ":");
            Persona ocupante = ingresarPersona(scanner);
            ocupantes.add(ocupante);
        }

        for(Habitacion habita : habitaciones){
            if(habita.getId() == habitacion.getId()){
                habita.setEstado(true);
                habita.setTitular(titular);
                habita.setOcupantes(ocupantes);
            }
        }

        scanner.close();
    }

    public void checkOut(Habitacion habitacion){
        Scanner scanner = new Scanner(System.in);
        double costo = habitacion.getCosto();
        String generoTitular = habitacion.getTitular().getGenero();
        int edadTitular = habitacion.getTitular().getEdad();
        int dias;

        System.out.println("Ingrese cantidad de dias hospedado:");
        dias = ingresarEntero(scanner);

        while (dias == 0) {
            System.out.println("ERROR - Ingrese una cantidad válida.");
            dias = ingresarEntero(scanner);
        }

        costo = calcularCostoFinal(costo, dias, generoTitular, edadTitular);
        System.out.println("El costo final es: " + costo);

        for(Habitacion habita : habitaciones){
            if(habita.getId() == habitacion.getId()){
                habita.setEstado(false);
                habita.setTitular(null);
                habita.setOcupantes(null);
            }
        }

        scanner.close();
    }

    private Persona ingresarPersona(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("DNI: ");
        String DNI = scanner.nextLine();
        System.out.print("Genero: ");
        String genero = scanner.nextLine().toLowerCase();
        System.out.print("Edad: ");
        int edad = ingresarEntero(scanner);
        scanner.nextLine();

        return new Persona(nombre, apellido, DNI, genero, edad);
    }

    private int ingresarEntero(Scanner scanner) {
        int enteroIngresado = 0;
        boolean entradaValida = false;
    
        while (!entradaValida) {
            try {
                String entrada = scanner.nextLine();
                enteroIngresado = Integer.parseInt(entrada);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("ERROR - Ingrese un número entero válido.");
            }
        }
    
        return enteroIngresado;
    }
    

    private double calcularCostoFinal(double costo, int dias, String generoTitular, int edadTitular) {
        costo *= dias;

        if ("masculino".equals(generoTitular) && edadTitular >= 70) {
            costo -= costo * 0.25;
        } else if ("femenino".equals(generoTitular) && edadTitular >= 65) {
            costo -= costo * 0.25;
        }

        return costo;
    }
}
