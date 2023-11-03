import java.util.ArrayList;

public class MainP {
    public static void main(String[] args) {
        Cliente c = new Cliente("Tomas", "Tobio", true);
        Empleado e = new Empleado("Carina", "Zangaro", true);
        Pedido p = new Pedido(c, e);

        Producto p1 = new Producto("Fideos", 1200);
        Producto p2 = new Producto("Salsa", 1000);
        Producto p3 = new Producto("Bebida", 3000);

        p.addP(p1);
        p.addP(p2);
        p.addP(p3);

        c.hacerPedido(p);
    }
}