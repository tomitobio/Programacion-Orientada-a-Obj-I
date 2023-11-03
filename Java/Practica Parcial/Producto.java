public class Producto implements Descuentable {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double p) {
        this.precio = p;
    }

    public void mostrarDetalles() {
        System.out.printf("Nombre: " + this.nombre + "Precio: " + this.precio + "\n");
    }

    @Override
    public double aplicarDescuento(double d) {
        double res = (d / 100) * this.precio;
        return res;
    }
}