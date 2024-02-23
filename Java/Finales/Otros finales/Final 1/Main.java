public class Main {
    public static void main(String[] args) {

        Agencia agencia = new Agencia();

        // COMPRA DE VEHICULOS
        Vehiculo moto1 = new Vehiculo("M1", 2, 1000);
        Vehiculo moto2 = new Vehiculo("M2", 2, 1000);
        Vehiculo moto3 = new Vehiculo("M3", 2, 1000);
        Vehiculo moto4 = new Vehiculo("M4", 2, 1000);
        Vehiculo moto5 = new Vehiculo("M5", 2, 1000);
        Vehiculo auto1 = new Vehiculo("A1", 4, 2000);
        Vehiculo auto2 = new Vehiculo("A2", 4, 2000);
        Vehiculo auto3 = new Vehiculo("A3", 4, 2000);
        Vehiculo auto4 = new Vehiculo("A4", 4, 2000);
        Vehiculo auto5 = new Vehiculo("A5", 4, 2000);
        Vehiculo auto6 = new Vehiculo("A6", 4, 2000);
        Vehiculo auto7 = new Vehiculo("A7", 4, 2000);
        Vehiculo auto8 = new Vehiculo("A8", 4, 2000);
        Vehiculo camioneta1 = new Vehiculo("C1", 5, 3000);
        Vehiculo camioneta2 = new Vehiculo("C2", 5, 3000);
        Vehiculo camioneta3 = new Vehiculo("C3", 5, 3000);
        agencia.addVehiculo(moto1);
        agencia.addVehiculo(moto2);
        agencia.addVehiculo(moto3);
        agencia.addVehiculo(moto4);
        agencia.addVehiculo(moto5);
        agencia.addVehiculo(auto1);
        agencia.addVehiculo(auto2);
        agencia.addVehiculo(auto3);
        agencia.addVehiculo(auto4);
        agencia.addVehiculo(auto5);
        agencia.addVehiculo(auto6);
        agencia.addVehiculo(auto7);
        agencia.addVehiculo(auto8);
        agencia.addVehiculo(camioneta1);
        agencia.addVehiculo(camioneta2);
        agencia.addVehiculo(camioneta3);

        // COMIENZA
        agencia.start();

        // ME QUEDE SIN TIEMPO Y NO PUDE HACER EL CALCULO DE EL PRECIO TENIENDO EN
        // CUENTA LA EDAD DEL CLIENTE
        // SIN EMBARGO EL CODIGO FUNCIONA.
    }
}