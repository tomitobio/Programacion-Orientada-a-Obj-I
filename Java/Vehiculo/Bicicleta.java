public class Bicicleta extends Vehiculo {
    private int tamanoLlanta;

    public Bicicleta(String marca, String modelo, int anio, int tamanoLlanta) {
        super(marca, modelo, anio);
        this.tamanoLlanta = tamanoLlanta;
    }

    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Bicicleta");
        System.out.println("Tamaño de Llanta: " + tamanoLlanta);
    }
}
