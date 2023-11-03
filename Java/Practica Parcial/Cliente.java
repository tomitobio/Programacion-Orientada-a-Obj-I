public class Cliente extends Usuario {
    protected boolean jubilado;

    public Cliente(String nombre, String apellido, boolean jubilado) {
        super(nombre, apellido);
        this.jubilado = jubilado;
    }

    @Override
    public void hacerPedido(Pedido pe) {
        System.out.println("El pedido es el siguiente: \n ");
        for (int i = 0; i < pe.p.size(); i++) {
            Producto detalles = pe.p.get(i);
            detalles.mostrarDetalles();
        }
        System.out.println("\nEl total a pagar es el siguiente: " + pe.calcularTotal());
    }
}
