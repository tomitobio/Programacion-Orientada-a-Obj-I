import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Habitacion {
    private String codigo;
    private int capacidad;
    private double precioPorDia;
    private boolean ocupada;
    private String[] ocupantes;

    public Habitacion(String codigo, int capacidad, double precioPorDia) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.precioPorDia = precioPorDia;
        this.ocupada = false;
        this.ocupantes = new String[capacidad]; // Inicializa el arreglo de ocupantes con la capacidad máxima
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public boolean checkIn(String[] nombres) {
        if (nombres.length <= capacidad) {
            System.arraycopy(nombres, 0, ocupantes, 0, nombres.length);
            ocupada = true;
            return true;
        }
        return false;
    }

    public void checkOut(int dias) {
        ocupada = false;
        double cobranza = dias * precioPorDia;
        System.out.println("Cobranza total: " + cobranza);
    }

    public String getEstadoOcupacion() {
        return ocupada ? "Ocupada" : "Desocupada";
    }
}

class Hotel {
    private Map<String, Habitacion> habitaciones;

    public Hotel() {
        habitaciones = new HashMap<>();
        inicializarHabitaciones();
    }

    private void inicializarHabitaciones() {
        habitaciones.put("D01", new Habitacion("D01", 2, 2000));
        habitaciones.put("T01", new Habitacion("T01", 3, 2800));
        habitaciones.put("C01", new Habitacion("C01", 4, 3500));
        // Agregar más habitaciones si es necesario
    }

    public void mostrarEstadoOcupacion() {
        for (Map.Entry<String, Habitacion> entry : habitaciones.entrySet()) {
            String codigo = entry.getKey();
            Habitacion habitacion = entry.getValue();
            System.out.println("Habitación " + codigo + ": " + habitacion.getEstadoOcupacion());
        }
    }

    public boolean hacerCheckIn(String codigo, String[] nombres) {
        Habitacion habitacion = habitaciones.get(codigo);
        if (habitacion != null && !habitacion.estaOcupada()) {
            return habitacion.checkIn(nombres);
        }
        return false;
    }

    public void hacerCheckOut(String codigo, int dias) {
        Habitacion habitacion = habitaciones.get(codigo);
        if (habitacion != null && habitacion.estaOcupada()) {
            habitacion.checkOut(dias);
        }
    }
}

public class Habitaciones {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // Ejemplo de check-in
        String[] ocupantesHabitacionDoble = {"Titular", "Ocupante"};
        hotel.hacerCheckIn("D01", ocupantesHabitacionDoble);

        // Mostrar estado de ocupación
        hotel.mostrarEstadoOcupacion();

        // Ejemplo de check-out
        hotel.hacerCheckOut("D01", 3); // Suponiendo 3 días de estadía
    }
}
