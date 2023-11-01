package ejercicios;

public class Producto implements Descuentable {
    private double precio;
    private String nombre;
    public Producto(String nombre,double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    @Override
    public double aplicarDescuento(double porcentajeDescuento){
        return this.precio = precio*porcentajeDescuento;
    }
    public String getNombre(){
        return this.nombre;
    }
    public double getPrecio(){
        return this.precio;
    }
    public void mostrarDetalles(){
        System.out.printf("%s , %d%n",this.nombre,this.precio);
    }

}
