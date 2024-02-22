import java.util.*;

public class Habitacion {
    private String id;
    private String nombre;
    private int capacidad;
    private double costo;
    private boolean estado;
    private Persona titular;
    private List<Persona> ocupantes;

    Habitacion(String id, String nombre, int capacidad, int costo, boolean estado, Persona titular, List<Persona> ocupantes){
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costo = costo;
        this.estado = estado;
        this.titular = titular;
        this.ocupantes = ocupantes;
    }

    public Persona getTitular(){
        return titular;
    }

    public String getId(){
        return id;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public String getNombre(){
        return nombre;
    }

    public double getCosto(){
        return costo;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public void setTitular(Persona titular){
        this.titular = titular;
    }

    public void setOcupantes(List<Persona> ocupantes){
        this.ocupantes = ocupantes;
    }
}
