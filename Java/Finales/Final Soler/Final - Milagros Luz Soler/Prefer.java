public class Prefer extends Socio {
    private int creditos = 300;


    public Prefer(String nombre, int DNI) {
        super(nombre, DNI);
    };

    public void alquilarLibro(){
        creditos = creditos - 20;
    }

    public void alquilarCD(){
        creditos = creditos - 40;
    }

    public void alquilarPelicula(){
        creditos = creditos - 60;
    }

    public void devolverLibro(){
        creditos = creditos + 10;
    }

    public void devolverCD(){
        creditos = creditos + 20;
    }

    public void devolverPelicula(){
        creditos = creditos + 30;
    }
}

