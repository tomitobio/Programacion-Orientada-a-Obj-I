package parcialito;

public class Vivienda {
    protected String propietario;
    protected String direccion;
    protected double metrosCuadrados;
    protected int cantidadHabitaciones;
    protected boolean tieneCochera;
    protected int cantidadBaños;
    protected Habitaciones[] habit;
    protected int contador;
    
    public Vivienda(String propietario, String direccion, double metrosCuadrados, int cantidadHabitaciones,boolean tieneCochera,int cantidadBaños){
        this.propietario = propietario; 
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.tieneCochera = tieneCochera;
        this.cantidadBaños = cantidadBaños;

        this.habit = new Habitaciones[cantidadHabitaciones];
        this.contador  = 0;
    }
    public Habitaciones setArrHabitaciones(String nombreHabitacion, double metrosCuadrados){
        this.habit[contador];
    }
}
