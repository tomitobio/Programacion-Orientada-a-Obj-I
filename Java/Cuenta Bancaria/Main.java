import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del titular de la primera cuenta: ");
        String titularCuenta1 = scanner.nextLine();
        CuentaBancaria cuenta1 = new CuentaBancaria(titularCuenta1);

        System.out.print("Ingrese el nombre del titular de la segunda cuenta: ");
        String titularCuenta2 = scanner.nextLine();
        CuentaBancaria cuenta2 = new CuentaBancaria(titularCuenta2);

        // Realizar operaciones
        cuenta1.depositar(1000);
        cuenta2.depositar(500);

        cuenta1.retirar(200);
        cuenta2.retirar(100);

        // Mostrar saldos
        System.out.println("Saldo de " + cuenta1.getTitular() + ": $" + cuenta1.getSaldo());
        System.out.println("Saldo de " + cuenta2.getTitular() + ": $" + cuenta2.getSaldo());

        // Realizar transferencia
        System.out.print("Ingrese el nombre del titular de la cuenta origen para la transferencia: ");
        String titularOrigen = scanner.nextLine();

        System.out.print("Ingrese el nombre del titular de la cuenta destino para la transferencia: ");
        String titularDestino = scanner.nextLine();

        System.out.print("Ingrese el monto a transferir: ");
        double montoTransferencia = scanner.nextDouble();

        if (titularOrigen.equalsIgnoreCase(cuenta1.getTitular())
                && titularDestino.equalsIgnoreCase(cuenta2.getTitular())) {
            cuenta1.realizarTransferencia(montoTransferencia, cuenta2);
        } else if (titularOrigen.equalsIgnoreCase(cuenta2.getTitular())
                && titularDestino.equalsIgnoreCase(cuenta1.getTitular())) {
            cuenta2.realizarTransferencia(montoTransferencia, cuenta1);
        } else {
            System.out.println("Operación no válida. Verifique los nombres de los titulares.");
        }

        // Mostrar saldos actualizados
        System.out.println("Saldo de " + cuenta1.getTitular() + " después de la transferencia: $" + cuenta1.getSaldo());
        System.out.println("Saldo de " + cuenta2.getTitular() + " después de la transferencia: $" + cuenta2.getSaldo());

        scanner.close();
    }
}
