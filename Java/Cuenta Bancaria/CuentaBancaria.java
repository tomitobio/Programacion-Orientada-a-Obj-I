public class CuentaBancaria {

    // Atributos
    private String titular;
    private double saldo;
    //

    // Constructor
    public CuentaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }
    //

    // Getters - buscador de atributos -
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
    //

    /* METODOS ESTRICTOS */

    // Deposito dinero en objeto (Condicion: que cantidad ingresada sea positiva)
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito de " + cantidad + " realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("El monto del depósito debe ser mayor que cero.");
        }
    }

    // Retiro dinero en objeto (Condicion: que cantidad ingresada sea positiva y que
    // sea MENOR al saldo - plata que tiene la cuenta)
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro de " + cantidad + " realizado. Nuevo saldo: " + saldo);
        } else if (cantidad > saldo) {
            System.out.println("Fondos insuficientes. Saldo actual: " + saldo);
        } else {
            System.out.println("Monto de retiro no válido.");
        }
    }

    // Envio dinero a otro objeto (Variable monto, que debe ser MENOR al saldo y
    // mayor a 0 --> restarle al saldo)
    public void realizarTransferencia(double monto, CuentaBancaria cuentaDestino) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            cuentaDestino.depositar(monto);
            System.out.println("Transferencia de $" + monto + " realizada a " + cuentaDestino.getTitular());
            System.out.println("Saldo actual de " + this.titular + ": $" + this.saldo);
            System.out.println("Saldo actual de " + cuentaDestino.getTitular() + ": $" + cuentaDestino.getSaldo());
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes para realizar la transferencia. Saldo actual: $" + saldo);
        } else {
            System.out.println("Monto de transferencia no válido.");
        }
    }

    // Comrpo un producto (Variable valorProducto, que debe ser MENOR al saldo y
    // mayor a 0 --> restarle al saldo)
    public void realizarCompra(double valorProducto) {
        if (valorProducto > 0 && valorProducto <= saldo) {
            saldo -= valorProducto;
            System.out.println("Compra realizada por un valor de $" + valorProducto + ". Nuevo saldo: $" + saldo);
        } else if (valorProducto > saldo) {
            System.out.println("Fondos insuficientes para realizar la compra. Saldo actual: $" + saldo);
        } else {
            System.out.println("Valor de compra no válido.");
        }
    }
}
