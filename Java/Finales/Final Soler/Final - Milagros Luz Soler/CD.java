public class CD extends Item {
    private String interprete;
    private String sello;
    private int duracion;
    private int costo = 40;

    public CD(String interprete, String sello, int duracion, String titulo, int ID){
        super(titulo,ID);
        this.interprete = interprete;
        this.sello = sello;
        this.duracion = duracion;
    }

    @Override
    public void getDetails(){
        System.out.println("CD: \nTitulo:"+titulo+"\nID:"+ID+"\nInterprete:"+this.interprete+"\nSello:"+this.sello+"\nDuracion:"+this.duracion);
    }
}
