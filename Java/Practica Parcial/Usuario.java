public abstract class Usuario {
    private String nombre;
    private String apellido;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public abstract void hacerPedido(Pedido p);
}
