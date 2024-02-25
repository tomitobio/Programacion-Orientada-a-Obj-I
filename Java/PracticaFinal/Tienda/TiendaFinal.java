import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Socio {
    private String nombre;
    private String apellido;
    private int dni;
    private double creditos;
    private double precioS;
    private int codigoSocio;

    public Socio(String n, String a, int c, int dni) {
        this.nombre = n;
        this.apellido = a;
        this.dni = dni;
        this.codigoSocio = c;
        if (c == 1) { // BASIC
            this.precioS = 2000;
            this.creditos = 3000;
        }
        if (c == 2) { // PREFER
            this.precioS = 3000;
            this.creditos = 5000;
        }
        if (c == 3) { // PREMIUM
            this.precioS = 3800;
            this.creditos = 8000;
        }
    }

    public String getCodigoSocio() {
        if (this.codigoSocio == 1) {
            return "Basic";
        }
        if (this.codigoSocio == 2) {
            return "Prefer";
        } else {
            return "Premium";
        }
    }

    public String getNombre() {
        String n = this.nombre + " " + this.apellido;
        return n;
    }

    public int getDNI() {
        return this.dni;
    }

    public double getCreditos() {
        return this.creditos;
    }

    public void setCreditos(double c) {
        this.creditos = c;
    }
}

class Item {
    private String codigo;
    private double costo;
    private boolean estado;
    private Socio asociado;

    public Item(String c) {
        this.codigo = c;
        this.estado = false;
        if (c.contains("CD")) { // BASIC
            this.costo = 200;
        }
        if (c.contains("Book")) { // BASIC
            this.costo = 140;
        }
        if (c.contains("Film")) { // BASIC
            this.costo = 300;
        }
    }

    public String getCodigo() {
        return this.codigo;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setEstadoT() {
        this.estado = true;
    }

    public void setEstadoF() {
        this.estado = false;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public Socio getSocio() {
        return this.asociado;
    }

    public void setSocio(Socio s) {
        this.asociado = s;
    }

}

class Tienda {
    private Map<String, Item> items;
    private ArrayList<Socio> socios;

    public Tienda() {
        this.items = new HashMap<>();
        this.socios = new ArrayList<>();
        crearItems();
    }

    public void crearItems() {
        for (int i = 1; i < 6; i++) {
            items.put("CD" + Integer.toString(i), new Item("CD" + Integer.toString(i)));
        }

        for (int i = 1; i < 8; i++) {
            items.put("Book" + Integer.toString(i), new Item("Book" + Integer.toString(i)));
        }

        for (int i = 1; i < 11; i++) {
            items.put("Film" + Integer.toString(i), new Item("Film" + Integer.toString(i)));
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenidos a Blockbuster. Elija una de las siguientes opciones del menú: ");

        System.out
                .println(
                        "\n1. Listado de items. \n2. Regístrese \n3.Alquilar \n4.Devolver \n5.Ver socios actuales. \n6.Salir.");

        int sel = scanner.nextInt();
        scanner.nextLine();

        while (sel <= 0 || sel >= 7) {
            System.out.println("Ingrese un numero correcto: ");
            sel = scanner.nextInt();
            scanner.nextLine();
        }

        while (sel != 6) {
            try {
                switch (sel) {
                    case 1:
                        listado();
                        break;
                    case 2:
                        registro();
                        break;
                    case 3:
                        if (socios.get(0) == null) {
                            System.out.println("\nNo hay usuarios creados. Registrese. ");
                            break;
                        }
                        alquiler();
                        break;
                    case 4:
                        if (socios.get(0) == null) {
                            System.out.println("\nNo hay usuarios creados. Registrese. ");
                            break;
                        }
                        devolver();
                        break;
                    case 5:
                        verSocios();
                        break;
                }
            } catch (Exception e) {
                System.out.println("No hay usuarios creados. Registrese. ");
            }

            System.out
                    .println(
                            "\n1. Listado de items. \n2. Regístrese \n3. Alquilar \n4. Devolver \n5. Ver socios actuales. \n6. Salir. \n");

            sel = scanner.nextInt();
            scanner.nextLine();

        }
        scanner.close();
    }

    public void listado() {
        int num = 0;
        for (Map.Entry<String, Item> i : items.entrySet()) {
            Item item = i.getValue();
            num++;
            if (item.getEstado() == false) {
                System.out.println("Item " + num + ": " + item.getCodigo() + " - Disponible. ");
            } else {
                System.out.println("Item " + num + ": " + item.getCodigo() + " - Alquilado. ");
            }
        }
    }

    public void registro() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; // 1 Basic - 2 Prefer - 3 Premium

        System.out.println("Elija opcion de socio: \n1. Basic \n2. Prefer \n3. Premium \n4. Cancelar");
        opcion = scanner.nextInt();
        scanner.nextLine();

        while (opcion <= 0 || opcion >= 5) {
            System.out.println("Ingrese un numero correcto: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        if (opcion != 4) {
            try {
                switch (opcion) {
                    case 1:
                        socios.add(registrarS(1));
                        System.out.println("Precio a pagar: 2000");
                        System.out.println("Creditos disponibles: 3000");
                        break;
                    case 2:
                        socios.add(registrarS(2));
                        System.out.println("Precio a pagar: 3000");
                        System.out.println("Creditos disponibles: 5000");
                        break;
                    case 3:
                        socios.add(registrarS(3));
                        System.out.println("Precio a pagar: 3800");
                        System.out.println("Creditos disponibles: 8000");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error. Vuelva a intentar. ");
            }
        }
    }

    public Socio registrarS(int codigo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un nombre: ");
        String n = scanner.nextLine();
        System.out.println("Ingrese un apellido: ");
        String a = scanner.nextLine();
        System.out.println("Ingrese un dni: ");
        int dni = scanner.nextInt();
        scanner.nextLine();

        Socio s = new Socio(n, a, codigo, dni);
        return s;
    }

    public void verSocios() {
        int num = 0;
        for (Socio i : socios) {
            num++;
            System.out.println("Socio " + num + ": " + "Nombre :" + i.getNombre() + " Nivel: " + i.getCodigoSocio());
        }
    }

    public void alquiler() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuál es su usuario? (dni) ");
        int dni = scanner.nextInt();
        scanner.nextLine();

        int contador = 0;
        for (Socio s : socios) {
            while (s.getDNI() != dni && contador < 2) {
                contador++;
                System.out.println("Cuenta no encontrada. Vuelva a intentar: ");
                dni = scanner.nextInt();
                scanner.nextLine();
            }

            if (contador == 2) {
                System.out.println("Cuenta no encontrada. Vuelva a inicio. ");
            }

            if (s.getDNI() == dni) {

                System.out
                        .println("Elija una opcion de alquiler: \n1. CD. \n2. Book \n3. Film \n4. Cancelar.");

                int sel = scanner.nextInt();
                scanner.nextLine();

                while (sel <= 0 || sel >= 5) {
                    System.out.println("Ingrese un numero correcto: ");
                    sel = scanner.nextInt();
                    scanner.nextLine();
                }

                switch (sel) {
                    case 1:
                        System.out.println("Ingrese codigo de producto a alquilar: ");
                        String p = scanner.nextLine();
                        for (Map.Entry<String, Item> i : items.entrySet()) {
                            String codigo = i.getKey();
                            Item item = i.getValue();
                            if (item.getCodigo().contains(p) && item.getEstado() == false) {
                                s.setCreditos(s.getCreditos() - 400);
                                item.setEstadoT();
                                System.out
                                        .println("Has alquilado el " + item.getCodigo() + ". Tus nuevos creditos son: "
                                                + s.getCreditos());
                                break;
                            }

                        }
                        break;
                    case 2:
                        System.out.println("Ingrese codigo de producto a alquilar: ");
                        String p2 = scanner.nextLine();
                        for (Map.Entry<String, Item> i : items.entrySet()) {
                            String codigo = i.getKey();
                            Item item = i.getValue();
                            if (item.getCodigo().contains(p2) && item.getEstado() == false) {
                                item.setEstadoT();
                                s.setCreditos(s.getCreditos() - 300);
                                System.out
                                        .println("Has alquilado el " + item.getCodigo() + ". Tus nuevos creditos son: "
                                                + s.getCreditos());
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese codigo de producto a alquilar: ");
                        String p3 = scanner.nextLine();
                        for (Map.Entry<String, Item> i : items.entrySet()) {
                            String codigo = i.getKey();
                            Item item = i.getValue();
                            if (item.getCodigo().contains(p3) && item.getEstado() == false) {
                                item.setEstadoT();
                                s.setCreditos(s.getCreditos() - 500);
                                System.out
                                        .println("Has alquilado el " + item.getCodigo() + ". Tus nuevos creditos son: "
                                                + s.getCreditos());
                                break;
                            }
                        }
                        break;
                }
            }
        }
    }

    public void devolver() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuál es su usuario? ");
        int dni = scanner.nextInt();
        scanner.nextLine();

        int contador = 0;
        for (Socio s : socios) {
            while (s.getDNI() != dni && contador < 2) {
                contador++;
                System.out.println("Cuenta no encontrada. Vuelva a intentar: ");
                dni = scanner.nextInt();
                scanner.nextLine();
            }

            if (contador == 2) {
                System.out.println("Cuenta no encontrada. Vuelva a inicio. ");
            }

            System.out
                    .println("Elija una opcion de devolución: \n1. CD. \n2. Book \n3. Film \n4. Cancelar.");

            int sel = scanner.nextInt();
            scanner.nextLine();

            while (sel <= 0 || sel >= 5) {
                System.out.println("Ingrese un numero correcto: ");
                sel = scanner.nextInt();
                scanner.nextLine();
            }

            switch (sel) {
                case 1:
                    System.out.println("Ingrese codigo de producto a devolver: ");
                    String p = scanner.nextLine();
                    for (Map.Entry<String, Item> i : items.entrySet()) {
                        String codigo = i.getKey();
                        Item item = i.getValue();
                        if (item.getCodigo().contains(p) && item.getEstado() == true) {
                            item.setEstadoF();
                            System.out.println("Has devuelto el " + item.getCodigo());
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese codigo de producto a devolver: ");
                    String p2 = scanner.nextLine();
                    for (Map.Entry<String, Item> i : items.entrySet()) {
                        String codigo = i.getKey();
                        Item item = i.getValue();
                        if (item.getCodigo().contains(p2) && item.getEstado() == true) {
                            item.setEstadoF();
                            System.out.println("Has devuelto el " + item.getCodigo());
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese codigo de producto a devolver: ");
                    String p3 = scanner.nextLine();
                    for (Map.Entry<String, Item> i : items.entrySet()) {
                        String codigo = i.getKey();
                        Item item = i.getValue();
                        if (item.getCodigo().contains(p3) && item.getEstado() == true) {
                            item.setEstadoF();
                            System.out.println("Has devuelto el " + item.getCodigo());
                            break;
                        }
                    }
                    break;
            }
        }
    }
}

public class TiendaFinal {
    public static void main(String[] args) {
        Tienda t = new Tienda();

        t.start();

    }
}
