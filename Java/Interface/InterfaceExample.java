/*
 * Sistema de pago 

    Crea una interfaz llamada MetodoDePago que contenga métodos para realizar un pago y obtener información de la transacción. 
    Luego, implementa esta interfaz en las clases TarjetaCredito y PayPal. 
    Cada clase debe implementar los métodos de la interfaz de acuerdo con su lógica de pago. 
    Diseña un programa donde el usuario pueda elegir un método de pago (tarjeta de crédito o PayPal) y simular una transacción. 
 */
interface MetodoDePago {
    void realizarPago(double monto);

    String obtenerInfoTransaccion();
}

class TarjetaCredito implements MetodoDePago {
    private String numeroTarjeta;
    private String nombreTitular;

    public TarjetaCredito(String numeroTarjeta, String nombreTitular) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
    }

    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago realizado con tarjeta de crédito por un monto de $" + monto);
    }

    @Override
    public String obtenerInfoTransaccion() {
        return "Tarjeta de crédito: " + numeroTarjeta + ", Titular: " + nombreTitular;
    }
}

class PayPal implements MetodoDePago {
    private String correo;

    public PayPal(String correo) {
        this.correo = correo;
    }

    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago realizado con PayPal por un monto de $" + monto);
    }

    @Override
    public String obtenerInfoTransaccion() {
        return "PayPal - Correo: " + correo;
    }
}

public class InterfaceExample { // MetodoDePago
    public static void main(String[] args) {
        double montoCompra = 100.0;

        MetodoDePago metodoDePago = new TarjetaCredito("1234567890123456", "Juan Pérez");

        metodoDePago.realizarPago(montoCompra);

        System.out.println("Información de la transacción:");
        System.out.println(metodoDePago.obtenerInfoTransaccion());
    }
}
