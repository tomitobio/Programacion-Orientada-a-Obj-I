public class Pelicula extends Item {
    private String sinopsis;
    private int duracion;
    private int costo = 60;

    public Pelicula(String sinopsis, int duracion, String titulo, int ID) {
    super(titulo,ID);
    this.sinopsis = sinopsis;
    this.duracion = duracion;
    }

    @Override
    public void getDetails(){
        System.out.println("PELICULA: \nTitulo:"+titulo+"\nID:"+ID+"\nSinopsis:"+this.sinopsis+"\nDuracion:"+this.duracion);
    }
}
