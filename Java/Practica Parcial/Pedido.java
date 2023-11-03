import java.util.ArrayList;

public class Pedido {
    protected ArrayList<Producto> p;
    private Cliente c;
    private Empleado e;

    public Pedido(Cliente c, Empleado e) {
        this.c = c;
        this.e = e;
        p = new ArrayList<Producto>();
    }

    public void addP(Producto n) {
        if (c.jubilado == true) {
            double descuento = n.aplicarDescuento(30);
            n.setPrecio(descuento);
        }
        p.add(n);
        System.out.printf("El producto " + n.getNombre() + " - " + n.getPrecio() + "fue agregado con exito!");
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto i : p) {
            total += i.getPrecio();
        }
        return total;
    }
}
