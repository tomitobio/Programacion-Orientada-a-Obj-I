import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Habitacion> habitaciones = new ArrayList<>();

        Hotel hotel = new Hotel(habitaciones);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Iniciamos carga de habitaciones:");

        System.out.println("Habitaciones dobles:");
        for (int i = 1; i < 13; i++) {
            Habitacion habitacion = new Habitacion("D" + Integer.toString(i), "Doble", 2, 2000, false, null, null);
            hotel.agregarHabitaciones(habitacion);
        }

        System.out.println("Habitaciones triples:");
        for (int i = 1; i < 9; i++) {
            Habitacion habitacion = new Habitacion("T" + Integer.toString(i), "Triple", 3, 2800, false, null, null);
            hotel.agregarHabitaciones(habitacion);
        }

        System.out.println("Habitaciones cuadruples:");
        for (int i = 1; i < 5; i++) {
            Habitacion habitacion = new Habitacion("C" + Integer.toString(i), "Cuadruple", 4, 3500, false, null, null);
            hotel.agregarHabitaciones(habitacion);
        }

        Habitacion eleccion = hotel.mostrarEstado();

        hotel.checkIn(eleccion);
        hotel.checkOut(eleccion);
    }
}
