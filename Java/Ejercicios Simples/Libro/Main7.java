class Libro {
    private String titulo;
    private String autor;
    private double precio;

    public Libro(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

public class Main7 {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Alquimista", "Paulo Coelho", 19.99);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 24.99);

        // Mostrar información de los libros
        System.out.println("Libro 1:");
        System.out.println("Título: " + libro1.getTitulo());
        System.out.println("Autor: " + libro1.getAutor());
        System.out.println("Precio: $" + libro1.getPrecio());

        System.out.println("\nLibro 2:");
        System.out.println("Título: " + libro2.getTitulo());
        System.out.println("Autor: " + libro2.getAutor());
        System.out.println("Precio: $" + libro2.getPrecio());
    }
}
