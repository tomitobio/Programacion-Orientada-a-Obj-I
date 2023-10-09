/*
 * Sistema de pago con herencia múltiple 

Ampliemos el sistema de pago para permitir diferentes métodos de autenticación, además 
de diferentes métodos de pago. Crearemos una interfaz adicional llamada Autenticable 
para establecer métodos de autenticación. Las clases TarjetaCredito 
y PayPal implementarán tanto MetodoDePago como Autenticable. 
 */

/* Interfaz --> Metodo de pago */
interface MetodoDePago {
    void realizarPago(double monto);

    String obtenerInfoTransaccion();
}
/* */

/* Interfaz --> Autenticar user de compra */
interface Autenticable {
    boolean autenticar(String usuario, String contrasena);
}
/* */

// Clase tarjeta de credito --> Es una clase que utiliza los metodos de la
// interfaz de pago, autenticable
class TarjetaCredito implements MetodoDePago, Autenticable {
    // Atributos
    private String numeroTarjeta;
    private String nombreTitular;

    // Constructor
    public TarjetaCredito(String numeroTarjeta, String nombreTitular) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
    }

    // Override: El proximo metodo reemplaza a uno de una superclase (se usa para
    // clases abstractas e interfaces)
    // Pago con Tarjeta
    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago realizado con tarjeta de crédito por un monto de $" + monto);
    }

    // Informacion de tarjeta: Numero y titular (Nuestros atributos)
    @Override
    public String obtenerInfoTransaccion() {
        return "Tarjeta de crédito: " + numeroTarjeta + ", Titular: " + nombreTitular;
    }

    // Autenticador: Solo retorna confirmacion de creacion de usuario
    @Override
    public boolean autenticar(String usuario, String contrasena) {
        return true;
    }
}

class PayPal implements MetodoDePago, Autenticable {
    // Atributos
    private String correo;

    // Constructor
    public PayPal(String correo) {
        this.correo = correo;
    }

    // Override: El proximo metodo reemplaza a uno de una superclase (se usa para
    // clases abstractas e interfaces)
    // Pago con PayPal
    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago realizado con PayPal por un monto de $" + monto);
    }

    // Informacion de PayPal: Correo (Nuestro atributo)
    @Override
    public String obtenerInfoTransaccion() {
        return "PayPal - Correo: " + correo;
    }

    // Autenticador: Solo retorna confirmacion de creacion de usuario
    @Override
    public boolean autenticar(String usuario, String contrasena) {
        return true;
    }
}

public class HerenciaMultipleExample { // MetodoDePago
    public static void main(String[] args) {

        double montoCompra = 100.0;

        // El autenticar no tiene atributos; simplemente sirve para darle sentido a
        // nuestra interfaz
        TarjetaCredito tarjetaCredito = new TarjetaCredito("1234567890123456", "Juan Pérez");
        boolean autenticadoTarjeta = tarjetaCredito.autenticar("usuario123", "contrasena123");

        PayPal payPal = new PayPal("juan@example.com");
        boolean autenticadoPayPal = payPal.autenticar("usuario456", "contrasena456");

        // Chequeamos autenticador con condiciones y realizamos lo mismo que en el
        // InterfazExample
        if (autenticadoTarjeta) {
            tarjetaCredito.realizarPago(montoCompra);

            System.out.println("Información de la transacción con tarjeta de crédito:");
            System.out.println(tarjetaCredito.obtenerInfoTransaccion());
        } else {
            System.out.println("Autenticación fallida para tarjeta de crédito. No se puede realizar el pago.");
        }

        if (autenticadoPayPal) {
            payPal.realizarPago(montoCompra);

            System.out.println("Información de la transacción con PayPal:");
            System.out.println(payPal.obtenerInfoTransaccion());
        } else {
            System.out.println("Autenticación fallida para PayPal. No se puede realizar el pago.");
        }
    }
}
