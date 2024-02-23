public class Doble extends Habitacion{
    private final double COSTO = 2000.0;
    private final int CAPACIDAD = 2;
    private String codigo;
    private static int numHabitacion = 1;

    Doble(){
        if(numHabitacion < 10){
            this.codigo = String.format("D0%d", numHabitacion); 
        }
        else{
            this.codigo = String.format("D%d", numHabitacion);
        }
        numHabitacion++;
    }

    public void mostrarDatos(){
        String datos;
        if(this.ocupada){
            datos = String.format("%s - %s, %s", this.codigo, this.titular.getApellido(), this.titular.getNombre());
        }
        else{
            datos = String.format("%s - Desocupado", this.codigo);
        }
        
        System.out.println(datos);
    }

    public int getCapacidad(){
        return this.CAPACIDAD;
    }

    public double getCosto(){
        return this.COSTO;
    }
    
}
