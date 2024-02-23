public class Cliente {
    private String nombre;
    private String genero;
    private int edad;
    private int dni;

    Cliente(String nombre, String genero, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }
}
