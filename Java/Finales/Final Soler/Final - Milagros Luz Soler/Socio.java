public class Socio{
    protected String nombre;
    protected int DNI;

    public Socio(String nombre, int DNI){
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public void getDetails(){
        System.out.println("SOCIO:"+nombre+"\nDNI:"+DNI);
    }

    public int getDNI(){
        return DNI;
    }

}