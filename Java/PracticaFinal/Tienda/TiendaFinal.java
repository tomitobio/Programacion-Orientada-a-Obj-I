import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Socio {
    private String nombre;
    private String apellido;
    private double precioS;
    private int codigoSocio;

    public Socio(String n, String a, int c) {
        this.nombre = n;
        this.apellido = a;
        this.codigoSocio = c;
        if (c == 1) { // BASIC
            this.precioS = 2000;
        }
        if (c == 2) { // PREFER
            this.precioS = 3000;
        }
        if (c == 3) { // PREMIUM
            this.precioS = 3800;
        }
    }

    public int getCodigoSocio() {
        return this.codigoSocio;
    }

    public String getNombre() {
        String n = this.nombre + " " + this.apellido;
        return n;
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
    private Map<String, Socio> socios;

    public Tienda() {
        this.items = new HashMap<>();
        this.socios = new HashMap<>();
        crearItems();
    }

    public void crearItems() {
        for (int i = 1; i < 6; i++) {
            items.put("CD " + Integer.toString(i), new Item("CD " + Integer.toString(i)));
        }

        for (int i = 1; i < 8; i++) {
            items.put("Book " + Integer.toString(i), new Item("Book " + Integer.toString(i)));
        }

        for (int i = 1; i < 11; i++) {
            items.put("Film " + Integer.toString(i), new Item("Film " + Integer.toString(i)));
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

        while (sel >= 0 || sel <= 7) {
            System.out.println("Ingrese un numero correcto: ");
            sel = scanner.nextInt();
            scanner.nextLine();
        }

        while (sel != 6) {
            try {
                switch (sel) {
                    case 1:
                        // listado();
                        break;
                    case 2:
                        // registro();
                        break;
                    case 3:
                        // alquiler();
                        break;
                    case 4:
                        // devolver();
                        break;
                    case 5:
                        // verSocios();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error. Vuelva a intentar: ");
            }

            System.out
                    .println(
                            "\n1. Listado de items. \n2. Regístrese \n3.Alquilar \n4.Devolver \n5.Ver socios actuales. \n6.Salir.");

            sel = scanner.nextInt();
            scanner.nextLine();
        }
    }
}

public class TiendaFinal {
    public static void main(String[] args) {
        Tienda t = new Tienda();

        t.start();

    }
}
