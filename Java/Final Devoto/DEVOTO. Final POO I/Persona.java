public class Persona{
    private String nombre;
    private String apellido;
    private String DNI;
    private String genero;
    private int edad;

    Persona(String nombre, String apellido, String DNI, String genero, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.genero = genero;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getGenero(){
        return genero;
    }

    public int getEdad(){
        return edad;
    }
}