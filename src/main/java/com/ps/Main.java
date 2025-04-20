package com.ps;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
    public String getTitle() { return title; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public String getCheckedOutTo() { return checkedOutTo; }


    public void checkOut(String name)
    {
        if (!isCheckedOut)
        {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println("Book '" + title + "' checked out successfully to " + name + ".");
        } else
        {
            System.out.println("Book '" + title + "' is already checked out.");
        }
    }


    public void checkIn()
    {
        if (isCheckedOut)
        {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println("Book '" + title + "' checked in successfully.");
        } else
        {
            System.out.println("Book '" + title + "' is not checked out.");
        }
    }
}


public class Main
{
    private static final int INVENTORY_SIZE = 20;
    private static List<Book> inventory = new ArrayList<>(INVENTORY_SIZE);
    private static Scanner scanner;

    public static void main(String[] args)
    {
        initializeInventory();

         scanner = new Scanner(System.in);
        boolean running = true;

        while (running)
        {
            System.out.println("Welcome to the Neighborhood Library!");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int givenCommand = getValidIntegerInput();

            switch (givenCommand)
            {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
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
        inventory.add(new Book(13, "978-0765399837", "Skyward"));
        inventory.add(new Book(14, "978-0399555770", "Starsight"));
        inventory.add(new Book(15, "978-0765399847", "Cytonic"));
        inventory.add(new Book(16, "978-1947954661", "Dawnshard"));
        inventory.add(new Book(17, "978-0765399830", "Edgedancer"));
        inventory.add(new Book(18, "978-0765399832", "Shadows for Silence in the Forests of Hell"));
        inventory.add(new Book(19, "978-0765399838", "Sixth of the Dusk"));
        inventory.add(new Book(20, "978-0765399839", "The Emperor's Soul"));

    }

    private static void showAvailableBooks()
    {
        System.out.println("Available Books: ");
        boolean anyAvailable = false;
        for (Book book : inventory)
        {
            if (!book.isCheckedOut())
            {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
                anyAvailable = true;
            }
        }
        if (!anyAvailable)
        {
            System.out.println("No books are currently available.");
        }

        System.out.print("Enter the ID of the book to check out or 0 to return to the home screen: ");
        int bookId = getValidIntegerInput();

        if (bookId > 0 && bookId <= inventory.size()) {
            System.out.print("Enter your name to check out the book: ");
            String name = scanner.nextLine();
            inventory.get(bookId - 1).checkOut(name);
        }

    }
    private static void showCheckedOutBooks()
    {
        System.out.println("Checked Out Books:");
        boolean anyCheckedOut = false;

        for (Book book : inventory)
        {
            if (book.isCheckedOut())
            {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Checked out to: " + book.getCheckedOutTo());
                anyCheckedOut = true;
            }
        }
        if (!anyCheckedOut)
        {
            System.out.println("No books are currently checked out.");
        }

        System.out.print("Enter the ID of the book to check in or 0 to return to the home screen: ");

        int bookId = getValidIntegerInput();

        if (bookId > 0 && bookId <= inventory.size()) {
            inventory.get(bookId - 1).checkIn();
        }
    }

    private static int getValidIntegerInput()
    {
        int input = -1;
        boolean valid = false;
        while (!valid)
        {
            try
            {
                input = scanner.nextInt();
                scanner.nextLine();
                valid = true;
            } catch (InputMismatchException exception)
            {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        return input;
    }

}

