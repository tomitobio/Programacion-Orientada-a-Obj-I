public abstract class Item {
    protected String titulo;
    protected int ID;

    public Item(String titulo, int ID) {
        this.titulo = titulo;
        this.ID = ID;
    }

    public void getDetails() {};

    public int getID() {
    return ID;
    }
}
