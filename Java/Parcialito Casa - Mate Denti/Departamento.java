package parcialito;

public class Departamento extends Vivienda{
    private int piso;
    private boolean ascensor;
    private int cantidadDeAscensores;
    private boolean tieneSum;
    private boolean seguridad; 

    public Departamento(String propietario, String direccion, double metrosCuadrados, int cantidadHabitaciones, boolean tieneCochera, int cantidadBaños, int piso, boolean ascensor, int cantidadDeAscensores, boolean tieneSum, boolean seguridad) {
        super(propietario, direccion, metrosCuadrados, cantidadHabitaciones, tieneCochera, cantidadBaños);
        this.piso = piso;
        this.ascensor = ascensor;
        this.cantidadDeAscensores = cantidadDeAscensores;
        this.tieneSum = tieneSum;
        this.seguridad = seguridad;

        createArrHabitaciones(cantidadHabitaciones);
    }
    public boolean getAscensor(){
        return this.ascensor;
    }
}