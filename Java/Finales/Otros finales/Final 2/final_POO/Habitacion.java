import java.util.ArrayList;

public abstract class Habitacion {
    protected boolean ocupada = false;
    protected ArrayList<Persona> ocupantes;
    protected Persona titular;

    Habitacion(){
        ocupantes = new ArrayList<>();
    }

    public abstract void mostrarDatos();
    public abstract int getCapacidad();

    public void agregarOcupante(Persona ocupante){
        ocupantes.add(ocupante);
    }

    public void setTitular(Persona titular){
        this.titular = titular;
    }

    public boolean getOcupada(){
        return this.ocupada;
    }
}
