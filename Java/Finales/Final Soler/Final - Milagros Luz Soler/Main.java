public class Main{
    public static void main(String[] args) {
        //inicializo la tienda
        Tienda tienda = new Tienda();


        //creo socios

        Basic basic = new Basic("Milagros Soler", 43107998);
        Prefer prefer = new Prefer("Pablo Lamela",45123123);
        Premium premium = new Premium("Juan Pejinakis",40567567);

        //creo productos

        Libro libro1 = new Libro("AB123","Patti Smith","penguin","Just Kids",34);
        Libro libro2 = new Libro("CD123","Alejandra Pizarnik","Estrada","Poemas varios",55);
        Libro libro3 = new Libro("FG123","Isacc Newton","Aguila","Biografia de Isacc Newton",75);

        Pelicula pelicula1 = new Pelicula("Chica rubia quiere ser abogada",120,"Legalmente rubia",1);
        Pelicula pelicula2 = new Pelicula("Accidente en la cordillera",180,"La sociedad de la nieve",2);
        Pelicula pelicula3 = new Pelicula("La historia de Willy Wonka",125,"Wonka",3);

        CD cd1 = new CD("Emilia mernes","Sony",40,".mp3",80);
        CD cd2 = new CD("C. Tangana","Universal",60,"El Madrileño",65);
        CD cd3 = new CD("Cruz Cafune","Sony",90,"Me muevo con dios",31);


        //agrego a la tienda

        tienda.addCds(cd1);
        tienda.addCds(cd2);
        tienda.addCds(cd3);

        tienda.addLibro(libro1);
        tienda.addLibro(libro2);
        tienda.addLibro(libro3);

        tienda.addPelicula(pelicula1);
        tienda.addPelicula(pelicula2);
        tienda.addPelicula(pelicula3);

        //agrego socios

        tienda.addSociosBasic(basic);
        tienda.addSociosPrefer(prefer);
        tienda.addSociosPremium(premium);

        tienda.start();

        //NO LLEGUE A HACER LA FUNCION DE AGREGAR PRODUCTO NUEVO POR FALTA DE TIEMPO.
    }
}