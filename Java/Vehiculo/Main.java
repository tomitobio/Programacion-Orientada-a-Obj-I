public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("Toyota", "Corolla", 2020, 4);
        Bicicleta bicicleta = new Bicicleta("Giant", "Defy", 2021, 26);

        System.out.println("Detalles del Auto:");
        auto.mostrarDetalles();

        System.out.println("\nDetalles de la Bicicleta:");
        bicicleta.mostrarDetalles();
    }
}
