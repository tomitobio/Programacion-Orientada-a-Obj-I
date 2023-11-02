import java.util.ArrayList;

abstract class Usuario { // Listo
    protected String nombre;
    protected String apellido;
    protected String email;

    public Usuario(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public abstract void hacerPedido(Pedido pedido);
}

interface Descuentable { // Listo
    void aplicarDescuento(double porcentajeDescuento);
}

class Producto implements Descuentable { // Listo
    private String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void mostrarDetalles() {
        System.out.println("Producto: " + nombre + " | " + "Precio: " + precio);
    }

    public void aplicarDescuento(double porcentajeDescuento) {
        precio = (precio * (100 - porcentajeDescuento) / 100);
        System.out.println("Descuento del " + porcentajeDescuento + "% a " + nombre + " realizado. \n");
    }
}

class Cliente extends Usuario { // Listo
    protected boolean jubilado;

    public Cliente(String nombre, String apellido, String email, int numCliente, boolean jubilado) {
        super(nombre, apellido, email);
        this.jubilado = jubilado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void hacerPedido(Pedido p) {
        System.out.println("El pedido es el siguiente: ");
        for (int i = 0; i < p.productos.size(); i++) {
            Producto detalles = p.productos.get(i);
            detalles.mostrarDetalles();
        }
        System.out.println("El total a pagar es el siguiente: " + "$" + p.calcularTotal());
    }

}

class Empleado extends Usuario { // Listo
    public Empleado(String nombre, String apellido, String email, String puesto, String sector) {
        super(nombre, apellido, email);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void hacerPedido(Pedido p) {
        System.out.println("Preparando el pedido de: " + p.cliente.getNombre());

        for (int i = 0; i < p.productos.size(); i++) {
            Producto detalles = p.productos.get(i);
            detalles.mostrarDetalles();
        }
        System.out.println("El total a cobrar es el siguiente: " + "$" + p.calcularTotal());

    }

}

class Pedido { // Listo
    protected ArrayList<Producto> productos; //
    protected Cliente cliente;
    protected Empleado empleado;

    public Pedido(ArrayList<Producto> productos, Cliente cliente, Empleado empleado) {
        this.productos = productos; //
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public void agregarProducto(Producto p) {
        if (cliente.jubilado == true) {
            p.aplicarDescuento(30);
        }

        productos.add(p);
        System.out.println("El producto " + p.getNombre() + " ha sido agregado con éxito! ");
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto i : productos) {
            total += i.getPrecio();
        }
        return total;
    }
}

public class Parcial {
    public static void main(String[] args) {

        Cliente c = new Cliente("Carina", "Zangaro", "catetobio@gmail.com", 1, true);
        Empleado e = new Empleado("Tomas", "Tobio", "tomasetobio@gmail.com", "Cajero", "Supermercado");
        ArrayList<Producto> p = new ArrayList<Producto>(); //

        Pedido pedido = new Pedido(p, c, e);

        Producto p1 = new Producto("Fideos", 600);
        Producto p2 = new Producto("Salsa de tomate", 450);
        Producto p3 = new Producto("Coca - Cola", 700);
        Producto p4 = new Producto("Verduras varias", 1500);

        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);
        pedido.agregarProducto(p3);
        pedido.agregarProducto(p4);

        c.hacerPedido(pedido);
        System.out.println("\n");
        e.hacerPedido(pedido);
    }
}
