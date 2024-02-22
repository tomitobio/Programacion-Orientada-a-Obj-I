/*
 * ALUMNO : TOMAS SEBASTIAN TOBIO
 * 
 * 
 */

import java.util.ArrayList;

interface Borrowable {
    void borrow();

    void returnItem();
}

abstract class Item {
    protected String title;
    protected int publishYear;

    public Item(String t, int p) {
        this.title = t;
        this.publishYear = p;
    }

    public abstract int getPublishYear();

    public abstract String getTitle();

    public abstract void displayDetails();
}

class Book extends Item implements Borrowable {
    public String author;
    public String ISBN;

    public Book(String t, int p, String i, String author) {
        super(t, p);
        this.author = author;
        this.ISBN = i;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int getPublishYear() {
        return publishYear;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayDetails() {
        System.out.println("Este libro es " + this.getTitle() + ", fue publicado en " + this.getPublishYear());
    }

    @Override
    public void returnItem() {
        System.out.println("Este libro fue devuelto!");
    }

    @Override
    public void borrow() {
        System.out.println("Este libro fue prestado!");
    }

}

class Magazine extends Item implements Borrowable {
    public int issueNumber;

    public Magazine(String t, int p, int i) {
        super(t, p);
        this.issueNumber = i;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public int getPublishYear() {
        return publishYear;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayDetails() {
        System.out.println("Esta maga es " + this.getTitle() + ", fue publicada en " + this.getPublishYear());
    }

    @Override
    public void returnItem() {
        System.out.println("Esta maga fue devuelta!");
    }

    @Override
    public void borrow() {
        System.out.println("Esta maga fue prestada!");
    }

}

class Member implements Borrowable {
    protected String name;

    // Cambio la lista de Borrowables, a una lista de Items.
    // Esto me va a permitir usar los métodos de Items
    // que me dan acceso a ciertas variables que utilizaré
    // para completar métodos de esta clase
    protected ArrayList<Item> borrowed;

    public Member(String name) {
        this.name = name;
        borrowed = new ArrayList<Item>();
    }

    public void borrowItem(Item i) {
        borrowed.add(i);
        this.borrow();
        i.displayDetails();
    }

    public void returnItemA(Item item) {
        for (int i = 0; i < borrowed.size(); i++) {
            if (item == borrowed.get(i)) {
                borrowed.remove(i);
                this.returnItem();
            } else {
                System.out.println("Esta persona no tomo este item.");
            }
        }

    }

    @Override
    public void returnItem() {
        System.out.println("Esta persona devolvio un item.");
    }

    @Override
    public void borrow() {
        System.out.println("Esta persona tomo prestado un item.");
    }
}

class Library {
    protected ArrayList<Item> items;
    protected ArrayList<Member> miembros;

    public Library() {
        this.items = new ArrayList<Item>();
        this.miembros = new ArrayList<Member>();
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public void registerMember(Member m) {
        miembros.add(m);
    }
}

public class Libreria {
    public static void main(String args[]) {
        Member m = new Member("Mariano");
        Library l = new Library();

        Book l1 = new Book("El retrato de Dorian Gray", 1892, "1", "Oscar Wilde");
        Magazine m1 = new Magazine("Gente", 2020, 3);

        // Libreria registra a miembro
        l.registerMember(m);
        // Libreria agrega sus libros
        l.addItem(l1);
        l.addItem(m1);
        // Miembro toma un item
        m.borrowItem(l1);
        // El item se presenta como prestado
        l1.borrow();
        // Lo mismo pero ahora con la revista
        m.borrowItem(m1);
        m1.borrow();
        // Devolvemos libro
        m.returnItemA(l1);
        l1.returnItem();
        // Que pasa si devolvemos libro que no existe
        m.returnItemA(l1);

    }

}