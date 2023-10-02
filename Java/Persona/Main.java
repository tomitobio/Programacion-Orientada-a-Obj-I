public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase Persona
        Persona persona = new Persona("Juan Pérez", 30, 'M');

        // Mostrar la información inicial de la persona
        System.out.println("Información de la Persona:");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Género: " + persona.getGenero());

        // Modificar la información utilizando setters
        persona.setNombre("María García");
        persona.setEdad(25);
        persona.setGenero('F');

        // Mostrar la información actualizada de la persona
        System.out.println("\nInformación de la Persona actualizada:");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Género: " + persona.getGenero());
    }
}
