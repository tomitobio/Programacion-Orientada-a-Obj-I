// package ejercicios;

// public class Pedido {
// private Cliente cliente;
// private Empleado empleado;
// //SUPONGO QUE EL CLIENTE NO VA A COMPRAR MAS DE 10 PRODUCTOS
// private Producto[] productos = new Producto[10];
// private int contador;

// public void agregarProducto(){
// this.productos[contador] = cliente.hacerPedido();
// this.empleado.procesarPedido(productos[contador]);
// contador++;
// }
// public double calcularTotal(){
// double suma = 0;
// try{
// for (Producto pro : productos){
// suma = suma + pro.getPrecio();
// }
// }catch(Exception e){
// //
// }
// return suma;
// }

// //Seters de cliente y empleado
// public void setCliente(String nombre,String apellido,String email,double
// numeroCliente,boolean jubilado ){
// this.cliente = new Cliente(nombre,apellido,email,numeroCliente,jubilado);
// this.contador = 0;
// }
// public void setEmpleado(String nombre, String apellido, String email,String
// puesto , String sector){
// this.empleado = new Empleado(nombre,apellido,email,puesto,sector);
// }
// }
