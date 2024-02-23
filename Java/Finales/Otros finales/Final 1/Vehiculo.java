import java.util.ArrayList;

public class Vehiculo {
    private String codigo;
    private Boolean ocupacion;
    private ArrayList<Cliente> ocupantes;
    private int capacidad;
    private int costoDiario;

    Vehiculo(String codigo, int capacidad, int costoDiario) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.ocupacion = false; // por defecto, los vehiculo estan desocupados.
        this.costoDiario = costoDiario;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public Boolean getOcupacion() {
        return this.ocupacion;
    }

    public void setOcupantes(ArrayList<Cliente> ocupantes) {
        this.ocupantes = ocupantes;
    }

    public void setOcupacion(boolean ocupacion) {
        this.ocupacion = ocupacion;
    }

    public ArrayList<Cliente> getOcupantes() {
        return this.ocupantes;
    }
}
