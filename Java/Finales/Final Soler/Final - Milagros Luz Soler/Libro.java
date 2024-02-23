public class Libro extends Item {
    private String ISBN;
    private String autor;
    private String editorial;
    private int costo = 20;

    public Libro(String ISBN, String autor, String editorial, String titulo, int ID) {
    super(titulo, ID);
    this.ISBN = ISBN;
    this.autor = autor;
    this.editorial =editorial;
    }

    @Override
    public void getDetails(){
        System.out.println("LIBRO: \nTitulo:"+titulo+"\nID:"+ID+"\nISBN:"+this.ISBN+"\nAutor:"+this.autor+"\nEditorial:"+this.editorial);
    }
}
