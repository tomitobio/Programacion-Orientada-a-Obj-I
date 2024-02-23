import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Hecho estatico

// class Persona {
//     private String nombre;
//     private String apellido;
//     private char genero;
//     private int dni;
//     private int edad;

//     public Persona(String nombre, String apellido, char genero, int dni, int edad) {
//         this.nombre = nombre;
//         this.apellido = apellido;
//         if (genero == 'M' || genero == 'F') {
//             this.genero = genero;
//         } else {
//             System.out.println("Genero no identificado.");
//         }
//         this.dni = dni;
//         this.edad = edad;
//     }

//     public String getNombre() {
//         return this.nombre;
//     }

//     public String getApellido() {
//         return this.apellido;
//     }

//     public char getGenero() {
//         return this.genero;
//     }

//     public int getDni() {
//         return this.dni;
//     }

//     public int getEdad() {
//         return this.edad;
//     }

//     public void detallesP() {
//         System.out.println("Detalles de: " + this.getNombre() + " " + this.getApellido());
//         System.out.println("Genero: " + this.getGenero());
//         System.out.println("DNI: " + this.getDni());
//         System.out.println("Edad: " + this.getEdad());
//     }

// }

// class Habitacion {
//     private String codigo;
//     // private int cantidad;
//     private double precio;
//     private Persona titular;
//     private ArrayList<Persona> ocupantes;
//     private boolean ocupada;

//     public Habitacion(String codigo, int precio, int capacidad) {
//         this.codigo = codigo;
//         this.precio = precio;
//         this.ocupantes = new ArrayList<>(capacidad - 1);

//     }

//     public boolean getOcupada() {
//         return this.ocupada;
//     }

//     public void setTitular(Persona titular) {
//         if (this.titular != null) {
//             System.out.println("Ya se encuentra un titular en la habitacion. ");

//         } else if (titular.getEdad() >= 18) {
//             this.titular = titular;
//             this.ocupada = true;

//         } else {
//             System.out.println("Titular debe ser mayor de edad.");

//         }
//     }

//     public Persona getTitular() {
//         return this.titular;
//     }

//     public ArrayList<Persona> getOcupantes() {
//         return this.ocupantes;
//     }

//     public void checkIn(Persona p) {
//         this.setTitular(p);
//         if (this.getTitular() != p) {

//             int cantidadO = 0;
//             for (int i = 0; i < ocupantes.size(); i++) {
//                 cantidadO++;
//             }

//             if (cantidadO == 0) {
//                 this.ocupantes.add(p);
//             }

//             else if (cantidadO >= ocupantes.size()) {
//                 System.out.println("Habitacion llena.");

//             } else {
//                 this.ocupantes.add(p);
//             }

//         }

//     }

//     public void checkOut(int dias) {
//         this.titular = null;
//         this.ocupantes.clear();
//         this.ocupada = false;
//         double pagare = dias * precio;
//         System.out.println("Precio a pagar por estancia: " + pagare);

//     }

//     public void detallesO() {
//         if (ocupada == false) {
//             System.out.println("No hay nadie en la habitacion. ");
//         } else {
//             this.getTitular().detallesP();
//             for (Persona i : this.ocupantes) {
//                 i.detallesP();
//             }
//         }
//     }

// }

// class Hotel {
//     private Map<String, Habitacion> habitaciones;

//     public Hotel() {
//         habitaciones = new HashMap<>();
//         crearHabitaciones();
//     }

//     public void crearHabitaciones() {
//         habitaciones.put("HD21", new Habitacion("HD21", 2000, 2));
//         habitaciones.put("HT31", new Habitacion("HT31", 2800, 3));
//         habitaciones.put("HC41", new Habitacion("HC41", 2500, 4));
//     }

//     public Habitacion getH(String h) {
//         return habitaciones.get(h);
//     }

//     public void mostrarEstadoOcupacion() {
//         for (Map.Entry<String, Habitacion> set : habitaciones.entrySet()) {

//             String codigo = set.getKey();
//             Habitacion habitacion = set.getValue();
//             System.out.println("Habitación " + codigo + ": " + habitacion.getOcupada());
//         }
//     }

//     public void hacerCheckIn(String codigo, Persona p) {
//         Habitacion habitacion = habitaciones.get(codigo);
//         if (habitacion != null) {
//             habitacion.checkIn(p);
//         }
//     }

//     public void hacerCheckOut(String codigo, int dias) {
//         Habitacion habitacion = habitaciones.get(codigo);
//         if (habitacion != null && habitacion.getOcupada()) {
//             habitacion.checkOut(dias);
//         }
//     }
// }

// public class Hoteleria {
//     public static void main(String[] args) {

//         Persona p1 = new Persona("Tomas", "Tobio", 'M', 44851196, 20);
//         Persona p2 = new Persona("Martina", "Caputo", 'F', 46892814, 18);
//         Persona p3 = new Persona("Roberto", "Caputo", 'F', 46892814, 18);

//         Hotel h = new Hotel();

//         h.hacerCheckIn("HD21", p1);

//         h.hacerCheckIn("HD21", p2);

//         h.hacerCheckIn("HD21", p3);

//         h.mostrarEstadoOcupacion();

//         h.getH("HD21").detallesO();

//         h.hacerCheckOut("HD21", 5);

//         h.mostrarEstadoOcupacion();

//         h.getH("HD21").detallesO();
//     }
// }

// Insertar cosas desde el Usuario

class Persona {
    private String nombre;
    private String apellido;
    private char genero;
    private int dni;
    private int edad;

    public Persona(String nombre, String apellido, char genero, int dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        if (genero == 'M' || genero == 'F') {
            this.genero = genero;
        } else {
            System.out.println("Genero no identificado.");
        }
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public char getGenero() {
        return this.genero;
    }

    public int getDni() {
        return this.dni;
    }

    public int getEdad() {
        return this.edad;
    }

    public void detallesP() {
        System.out.println("Detalles de: " + this.getNombre() + " " + this.getApellido());
        System.out.println("Genero: " + this.getGenero());
        System.out.println("DNI: " + this.getDni());
        System.out.println("Edad: " + this.getEdad());
    }

}

class Habitacion {
    private String codigo;
    // private int cantidad;
    private double precio;
    private Persona titular;
    private ArrayList<Persona> ocupantes;
    private boolean ocupada;

    public Habitacion(String codigo, int precio, int capacidad) {
        this.codigo = codigo;
        this.precio = precio;
        this.ocupantes = new ArrayList<>(capacidad - 1);

    }

    public String getCodigo() {
        return this.codigo;
    }

    public boolean getOcupada() {
        return this.ocupada;
    }

    public void setTitular(Persona titular) {
        if (this.titular != null) {
            System.out.println("Ya se encuentra un titular en la habitacion. ");

        } else if (titular.getEdad() >= 18) {
            this.titular = titular;
            this.ocupada = true;

        } else {
            System.out.println("Titular debe ser mayor de edad.");

        }
    }

    public Persona getTitular() {
        return this.titular;
    }

    public ArrayList<Persona> getOcupantes() {
        return this.ocupantes;
    }

    public void checkIn(Persona p) {
        this.setTitular(p);
        if (this.getTitular() != p) {

            int cantidadO = 0;
            for (int i = 0; i < ocupantes.size(); i++) {
                cantidadO++;
            }

            if (cantidadO == 0) {
                this.ocupantes.add(p);
            }

            else if (cantidadO >= ocupantes.size()) {
                System.out.println("Habitacion llena.");

            } else {
                this.ocupantes.add(p);
            }
        }

    }

    public void checkOut(int dias) {
        this.titular = null;
        this.ocupantes.clear();
        this.ocupada = false;
        double pagare = dias * precio;

        System.out.println("Precio a pagar por estancia: " + pagare);

    }

    public double promocion(double precio) {
        double precioFinal = 0.0;
        if (this.titular.getGenero() == 'M') {
            if (this.titular.getEdad() >= 70) {
                precioFinal = precio * 0.75;
                System.out.println("Tiene un descuento del 25%");
                return precioFinal;
            }
        } else if (this.titular.getGenero() == 'F') {
            if (this.titular.getEdad() >= 65) {
                precioFinal = precio * 0.75;
                System.out.println("Tiene un descuento del 25%");
                return precioFinal;
            }
        }
        System.out.println("No tiene descuento.");
        return precio;
    }

    public void detallesO() {
        if (ocupada == false) {
            System.out.println("No hay nadie en la habitacion. ");
        } else {
            this.getTitular().detallesP();
            for (Persona i : this.ocupantes) {
                i.detallesP();
            }
        }
    }

}

class Hotel {
    private Map<String, Habitacion> habitaciones;

    public Hotel() {
        habitaciones = new HashMap<>();
        crearHabitaciones();
    }

    public void crearHabitaciones() {
        for (int i = 1; i < 14; i++) {
            habitaciones.put("HD" + Integer.toString(i), new Habitacion("HD" + Integer.toString(i), 2000, 2));
        }
        for (int i = 1; i < 9; i++) {
            habitaciones.put("HT" + Integer.toString(i), new Habitacion("HT" + Integer.toString(i), 2800, 3));
        }
        for (int i = 1; i < 6; i++) {
            habitaciones.put("HC" + Integer.toString(i), new Habitacion("HC" + Integer.toString(i), 2500, 4));
        }
    }

    public Map<String, Habitacion> getTodasLibres() {
        Map<String, Habitacion> libres = new HashMap<>();
        for (Map.Entry<String, Habitacion> set : habitaciones.entrySet()) {
            String llave = set.getKey();
            Habitacion h = set.getValue();
            if (h.getOcupada() == false) {
                libres.put(llave, h);
            }
        }
        return libres;
    }

    public Map<String, Habitacion> getTodasOcupadas() {
        Map<String, Habitacion> ocupada = new HashMap<>();
        for (Map.Entry<String, Habitacion> set : habitaciones.entrySet()) {
            String llave = set.getKey();
            Habitacion h = set.getValue();
            if (h.getOcupada() == true) {
                ocupada.put(llave, h);
            }
        }
        return ocupada;
    }

    public Habitacion getH(String h) {
        return habitaciones.get(h);
    }

    public void mostrarEstadoOcupacion() {
        for (Map.Entry<String, Habitacion> set : habitaciones.entrySet()) {

            String codigo = set.getKey();
            Habitacion habitacion = set.getValue();
            System.out.println("Habitación " + codigo + ": " + habitacion.getOcupada());
        }
    }

    public void hacerCheckIn(String codigo, Persona p) {
        Habitacion habitacion = habitaciones.get(codigo);
        if (habitacion != null) {
            habitacion.checkIn(p);
        }
    }

    public void hacerCheckOut(String codigo, int dias) {
        Habitacion habitacion = habitaciones.get(codigo);
        if (habitacion != null && habitacion.getOcupada()) {
            habitacion.checkOut(dias);
        }
    }

    public Persona ingresarPersona(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("DNI: ");
        int DNI = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Genero: ");
        char genero = scanner.next().charAt(0);
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        return new Persona(nombre, apellido, genero, DNI, edad);
    }

}

public class Hoteleria {
    public static void main(String[] args) {

        // Persona p1 = new Persona("Tomas", "Tobio", 'M', 44851196, 20);
        // Persona p2 = new Persona("Martina", "Caputo", 'F', 46892814, 18);
        // Persona p3 = new Persona("Roberto", "Caputo", 'F', 46892814, 18);

        Hotel h = new Hotel();

        Scanner scanner = new Scanner(System.in);
        int select = -1;
        System.out.println("Regístrese.");
        Persona p = h.ingresarPersona(scanner);
        while (select != 0) {
            try {

                System.out.println("Bienvenido al hotel. Elija un tipo de habitacion: ");
                System.out.println("(2 para doble, 3 para triple, 4 para cuadruple, 5 si desea hacer check out)");
                // Hacer un 1 para agregar a una persona mas a la habitacion
                select = Integer.parseInt(scanner.nextLine());
                int i = 1;
                switch (select) {

                    case 2:

                        for (Map.Entry<String, Habitacion> set : h.getTodasLibres().entrySet()) {
                            String codigo = set.getKey();
                            Habitacion habitacion = set.getValue();
                            String check = "HD" + Integer.toString(i);

                            if (codigo.contains("HD")) {
                                h.hacerCheckIn(habitacion.getCodigo(), p);
                                System.out.println("Habitación " + habitacion.getCodigo() + " ha sido ocupada.");
                                break;
                            } else if (codigo.contains("HT") || codigo.contains("HC")) {
                            } else {
                                System.out.println("Habitaciones dobles llenas.");
                            }
                            i++;

                        }
                        break;

                    case 3:
                        for (Map.Entry<String, Habitacion> set : h.getTodasLibres().entrySet()) {
                            String codigo = set.getKey();
                            Habitacion habitacion = set.getValue();
                            String check = "HT" + Integer.toString(i);

                            if (codigo.contains("HT")) {
                                h.hacerCheckIn(habitacion.getCodigo(), p);
                                System.out.println("Habitación " + habitacion.getCodigo() + " ha sido ocupada.");
                                break;
                            } else if (codigo.contains("HD") || codigo.contains("HC")) {
                            } else {
                                System.out.println("Habitaciones dobles llenas.");
                            }
                            i++;
                        }
                        break;

                    case 4:
                        for (Map.Entry<String, Habitacion> set : h.getTodasLibres().entrySet()) {
                            String codigo = set.getKey();
                            Habitacion habitacion = set.getValue();
                            String check = "HC" + Integer.toString(i);

                            if (codigo.contains("HC")) {
                                h.hacerCheckIn(habitacion.getCodigo(), p);
                                System.out.println("Habitación " + habitacion.getCodigo() + " ha sido ocupada.");
                                break;
                            } else if (codigo.contains("HT") || codigo.contains("HD")) {
                            } else {
                                System.out.println("Habitaciones dobles llenas.");
                            }
                            i++;
                        }
                        break;
                    case 5:
                        for (Map.Entry<String, Habitacion> set : h.getTodasOcupadas().entrySet()) {

                            String codigo = set.getKey();
                            Habitacion habitacion = set.getValue();

                            System.out.println("Cuantos días se ha hospedado?");
                            int dias = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Usted hará un check out de la siguiente habitacion: ");
                            String habi = scanner.nextLine();

                            if (codigo.contains(habi)) {
                                h.hacerCheckOut(habitacion.getCodigo(), dias);
                                System.out.println("Habitación " + codigo + " ha sido desocupada.");
                                break;
                            } else {
                                System.out.println("Habitación no ocupada.");
                            }
                        }
                        break;
                }

            } catch (

            Exception e) {
                System.out.println("Uoop! Error!");
            }

        }
    }
}
