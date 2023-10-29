import java.util.ArrayList;

abstract class Usuario { // Listo
    public String nombre;
    public String apellido;
    public String email;

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
    public String nombre;
    public double precio;

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
        precio = (precio * porcentajeDescuento) / 100;
        System.out.println("Descuento del " + porcentajeDescuento + "% a " + nombre + " realizado. \n");
    }
}

class Cliente extends Usuario { // Listo
    public int numCliente;
    public boolean jubilado;

    public Cliente(String nombre, String apellido, String email, int numCliente, boolean jubilado) {
        super(nombre, apellido, email);
        this.numCliente = numCliente;
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
    public String puesto;
    public String sector;

    public Empleado(String nombre, String apellido, String email, String puesto, String sector) {
        super(nombre, apellido, email);
        this.puesto = puesto;
        this.sector = sector;
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
    public ArrayList<Producto> productos;
    public Cliente cliente;
    public Empleado empleado;

    public Pedido(ArrayList<Producto> productos, Cliente cliente, Empleado empleado) {
        this.productos = productos;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public void agregarProducto(Producto p) {
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

        Cliente c = new Cliente("Carina", "Zangaro", "catetobio@gmail.com", 1, false);
        Empleado e = new Empleado("Tomas", "Tobio", "tomasetobio@gmail.com", "Cajero", "Supermercado");
        ArrayList<Producto> p = new ArrayList<Producto>();

        Pedido pedido = new Pedido(p, c, e);

        Producto p1 = new Producto("Fideos", 600);
        Producto p2 = new Producto("Salsa de tomate", 450);
        Producto p3 = new Producto("Coca - Cola", 700);
        Producto p4 = new Producto("Verduras varias", 1500);

        p4.aplicarDescuento(64);

        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);
        pedido.agregarProducto(p3);
        pedido.agregarProducto(p4);

        c.hacerPedido(pedido);
        System.out.println("\n");
        e.hacerPedido(pedido);
    }
}
