package com.ps;
import java.util.ArrayList;
import java.util.List;


class Book
{
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title)
    {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitle(int i) { return title; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public String getCheckedOutTo() { return checkedOutTo; }


    public void checkOut(String name)
    {
        if (!isCheckedOut)
        {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println("Book checked out successfully.");
        } else
        {
            System.out.println("Book is already checked out.");
        }
    }


    public void checkIn()
    {
        if (isCheckedOut)
        {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println("Book checked in successfully.");
        } else
        {
            System.out.println("Book is not checked out.");
        }
    }
}


public class Main {
    private static final int INVENTORY_SIZE = 20;
    private static List<Book> inventory = new ArrayList<>(INVENTORY_SIZE);

    public static void main(String[] args)
    {
        initializeInventory();
    }

    private static void initializeInventory() {
        inventory.add(new Book(1, "978-0765326355", "The Way of Kings"));
        inventory.add(new Book(2, "978-0765326379", "Words of Radiance"));
        inventory.add(new Book(3, "978-0765326386", "Oathbringer"));
        inventory.add(new Book(4, "978-0765326393", "Rhythm of War"));
        inventory.add(new Book(5, "978-0765311788", "Mistborn: The Final Empire"));
        inventory.add(new Book(6, "978-0765318428", "The Well of Ascension"));
        inventory.add(new Book(7, "978-0765318435", "The Hero of Ages"));
        inventory.add(new Book(8, "978-0765377142", "The Alloy of Law"));
        inventory.add(new Book(9, "978-0765378477", "Shadows of Self"));
        inventory.add(new Book(10, "978-0765378484", "The Bands of Mourning"));
        inventory.add(new Book(11, "978-0765391179", "Warbreaker"));
        inventory.add(new Book(12, "978-0765320322", "Elantris"));
        inventory.add(new Book(13, "978-0765399830", "Skyward"));
        inventory.add(new Book(14, "978-0399555770", "Starsight"));
        inventory.add(new Book(15, "978-0765399847", "Cytonic"));
        inventory.add(new Book(16, "978-1947954661", "Dawnshard"));
        inventory.add(new Book(17, "978-0765399830", "Edgedancer"));
        inventory.add(new Book(18, "978-0765399830", "Shadows for Silence in the Forests of Hell"));
        inventory.add(new Book(19, "978-0765399830", "Sixth of the Dusk"));
        inventory.add(new Book(20, "978-0765399830", "The Emperor's Soul"));

    }
}
