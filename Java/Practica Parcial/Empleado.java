public class Empleado extends Usuario {
    private boolean puesto;

    public Empleado(String nombre, String apellido, boolean puesto) {
        super(nombre, apellido);
        this.puesto = puesto;
    }

    @Override
    public void hacerPedido(Pedido pe) {
        System.out.printf("El pedido es el siguiente: ");
        for (int i = 0; i < pe.p.size(); i++) {
            Producto detalles = pe.p.get(i);
            detalles.mostrarDetalles();
        }
        System.out.printf("El total a cobrar es el siguiente: %d", pe.calcularTotal());
    }
}
