public class Persona{
    private String nombre;
    private String apellido;
    private int DNI;
    private String genero;
    private int edad;

    Persona(String nombre, String apellido, int DNI, String genero, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.genero = genero;
        this.edad = edad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public String getGenero(){
        return this.genero;
    }

    public int getEdad(){
        return this.edad;
    }
}