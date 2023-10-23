// Clase base CuentaBancaria
class CuentaBancaria {
    private String numeroCuenta;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Depósito de $" + cantidad + " realizado. Saldo actual: $" + saldo);
    }

    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro de $" + cantidad + " realizado. Saldo actual: $" + saldo);
        } else {
            System.out.println("Saldo insuficiente para retirar $" + cantidad);
        }
    }

    public void mostrarSaldo() {
        System.out.println("Saldo actual en la cuenta " + numeroCuenta + ": $" + saldo);
    }
}

// Subclase CuentaCorriente
class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }
}

// Subclase CuentaAhorro
class CuentaAhorro extends CuentaBancaria {
    public CuentaAhorro(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println(
                    "Retiro de $" + cantidad + " desde la cuenta de ahorro realizado. Saldo actual: $" + saldo);
        } else {
            System.out.println("Saldo insuficiente para retirar $" + cantidad + " desde la cuenta de ahorro.");
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        CuentaCorriente cuentaCorriente = new CuentaCorriente("123456", 1000);
        CuentaAhorro cuentaAhorro = new CuentaAhorro("789012", 2000);

        cuentaCorriente.mostrarSaldo(); // Saldo actual en la cuenta 123456: $1000.0
        cuentaAhorro.mostrarSaldo(); // Saldo actual en la cuenta 789012: $2000.0

        cuentaCorriente.depositar(500); // Depósito de $500.0 realizado. Saldo actual: $1500.0
        cuentaCorriente.retirar(200); // Retiro de $200.0 realizado. Saldo actual: $1300.0

        cuentaAhorro.depositar(300); // Depósito de $300.0 realizado. Saldo actual: $2300.0
        cuentaAhorro.retirar(2500); // Saldo insuficiente para retirar $2500.0 desde la cuenta de ahorro.

        cuentaCorriente.mostrarSaldo(); // Saldo actual en la cuenta 123456: $1300.0
        cuentaAhorro.mostrarSaldo(); // Saldo actual en la cuenta 789012: $2300.0
    }
}
