public class Persona1 {
    private String nombre; // Atributo para almacenar el nombre
    private int edad; // Atributo para almacenar la edad
    private char genero; // Atributo para almacenar el género

    // Constructor
    public Persona1(String nombre, int edad, char genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    // Setter para establecer el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para establecer la edad
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Getter para obtener la edad
    public int getEdad() {
        return edad;
    }

    // Setter para establecer el género
    public void setGenero(char genero) {
        this.genero = genero;
    }

    // Getter para obtener el género
    public char getGenero() {
        return genero;
    }
}
