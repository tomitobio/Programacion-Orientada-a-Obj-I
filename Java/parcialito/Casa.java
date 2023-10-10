package parcialito;

public class Casa extends Vivienda {
    private int cantidadDePisos;
    private boolean patio;    
    
    public Casa(String propietario, String direccion, double metrosCuadrados, int cantidadHabitaciones,boolean tieneCochera,int cantidadBaños,int cantidadDePisos, boolean patio){
        super( propietario, direccion, metrosCuadrados, cantidadHabitaciones, tieneCochera, cantidadBaños);
        this.cantidadDePisos = cantidadDePisos;
        this.patio = patio; 
        createArrHabitaciones(cantidadHabitaciones);
    }
    public boolean getPatio(){
        return this.patio;
    }

}
