package parcialito;

public class Main {
    public static void main(String[] args) {
        Casa casa = new Casa("Mateo", "Fincas", 200, 4, true, 3, 2, true);
        Departamento depto = new Departamento("Gonza", "Arenales 1171", 10, 4, false, 1, 10, true, 1, false, false);

        // Set habitaciones de Depto
        Habitaciones[] habitacionesDepto = {
                new Habitaciones("Cocina", 10),
                new Habitaciones("Baño", 5),
                new Habitaciones("Living", 15),
                new Habitaciones("Cuarto", 12)
        };

        depto.setArrHabitaciones(habitacionesDepto);

        // Set habitaciones de Casa
        Habitaciones[] habitacionesCasa = {
                new Habitaciones("Cocina", 10),
                new Habitaciones("Baño", 5),
                new Habitaciones("Living", 15),
                new Habitaciones("Cuarto", 12)
        };

        casa.setArrHabitaciones(habitacionesCasa);

        // Set baños Casa y Depto:
        depto.setBaño(new Baño(true, true, true));
        casa.setBaño(new Baño(true, true, true));

        // Recompilador de informacion
        depto.RecompiladorInfo();
        casa.RecompiladorInfo();

        // Un par de Gets
        System.out.printf("Tiene Patio? %b%n", casa.getPatio());
        System.out.printf("Tiene Ascensor? %b%n", depto.getAscensor());

    }
}