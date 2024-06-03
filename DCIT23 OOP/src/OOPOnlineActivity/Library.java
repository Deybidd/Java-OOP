package OOPOnlineActivity;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.LocalDate;

public class Library {
    private final int Cost = 50;

    private final Scanner sc = new Scanner(System.in);

    private final Fiction fictionBook = new Fiction();

    private final NonFiction nonFictionBook = new NonFiction();

    Library(){
        libraryManagementSystem();
    }

    private void libraryManagementSystem(){
        int userInput;
        System.out.print("""
                -----------------------------------
                Library Management System

                [0] Exit
                [1] Borrowing
                [2] Returning

                Please input your choice:
                """);
        userInput = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (userInput) {
            case 0:
                System.out.println("Exiting System");
                System.exit(0);
            case 1:
                borrowing();
            case 2: 
                returning();
            default:
                System.out.println("Invalid input please try again.");
                libraryManagementSystem();
        }
    }

    private void borrowing(){
        int userInput;
        System.out.print("""
                -----------------------------------
                Borrowing Books
                Borrowing fee: 50Php
                [0] Back
                [1] Fiction Books
                [2] Non-Fiction Books

                Please input your choice:  
                """);
        userInput = sc.nextInt();
        sc.nextLine();

        switch (userInput) {
            case 0: 
                libraryManagementSystem();

            case 1: 
                fictionList();
                borrowing();

            case 2:
                nonFictionList();
                borrowing();
            
            default:
                System.out.println("Invalid input please try again.");
                borrowing();

        }
    }

    private void borrowingBook(String getBook, LocalDate getBorrowed, LocalDate getDue, int cost, int bookNum){
        System.out.println("\nBook Borrowed " + 
                            "\nBook #" + bookNum + "      :" + getBook + 
                            "\nDate Borrowed  : " + getBorrowed +
                            "\nDue Date       :" + getDue + 
                            "\nCost           :" + cost + 
                            "\nYou successfully borrowed " + "Book #" + bookNum + ", the book must be returned within a month. " +
                            "\nFailure to comply will result in an additional 15Php per day passed after the one month." +
                            "\nAlong with the initial payment of 50Php");
    }

    private void returning(){
        int booknum, userInput;
        System.out.print("""
                -----------------------------------
                Returning process:

                Failure to return the book within a month will result in an additional 15Php per day that has passed after one month.
                E.g. Three days has passed since the due date of the book. There is going to be an additional 45Php penalty cost.

                Choose the genre of the borrowed book:
                [0] Back
                [1] Fiction
                [2] Non-Fiction

                Please input your choice: 
                """);
        userInput = sc.nextInt();
        sc.nextLine();
        
        switch (userInput) {
            case 0: 
                libraryManagementSystem();
            case 1:
                System.out.print("----------------------------------- \nInput the book number you borrowed:");
                booknum = sc.nextInt();
                sc.nextLine();
                if (fictionBook.getBook(booknum-1).equalsIgnoreCase("Not Available")){
                    if (booknum <= 5){
                        fictionBook.setReturn(booknum - 1, 
                        fictionBook.getOriginalBook(booknum - 1), 
                        fictionBook.getOriginalPublisher(booknum - 1),
                        fictionBook.getOriginalAuthor(booknum - 1));

                        bookRecord( booknum,
                                    fictionBook.getdateBorrowed(booknum - 1),
                                    fictionBook.getdueDate(booknum - 1),
                                    fictionBook.getBook(booknum - 1));
                        returning();
                    }
                    else {
                        System.out.println("Invalid input. Please try again.");
                        returning();
                    }
                }
                else {
                    System.out.println("----------------------------------- \nThe book is currently in the library.");
                    returning();
                }
            case 2:
                System.out.print("----------------------------------- \nInput the book number you borrowed:");
                booknum = sc.nextInt();
                sc.nextLine();
                if (nonFictionBook.getBook(booknum-1).equalsIgnoreCase("Not Available")){
                    if (booknum <= 5){
                        nonFictionBook.setReturn(booknum - 1, 
                        nonFictionBook.getOriginalBook(booknum - 1), 
                        nonFictionBook.getOriginalPublisher(booknum - 1),
                        nonFictionBook.getOriginalAuthor(booknum - 1));

                        bookRecord( booknum,
                                    nonFictionBook.getdateBorrowed(booknum - 1),
                                    nonFictionBook.getdueDate(booknum - 1),
                                    nonFictionBook.getBook(booknum - 1));
                        returning();
                    }
                    else {
                        System.out.println("Invalid input. Please try again.");
                        returning();
                    }
                }
                else {
                    System.out.println("----------------------------------- \nThe book is currently in the library");
                    returning();
                }
            default:
                System.out.println("Invalid input. Please try again.");
                returning();
        }
    }
    private void bookRecord(int booknum, LocalDate getBorrowed, LocalDate getDue, String getBook) {
        LocalDate returnDate;
        String returnDateString;
        long days;
        long penalty;
        System.out.print("Book Record" + 
                        "\nBook Num: " + booknum + "        : " + getBook + 
                        "\nDate Borrowed: " + getBorrowed + 
                        "\nDue Date     : " + getDue + 
                        "\n\nInput the date of Return using the following format (e.g. 2004-08-21)"); 
        returnDateString = sc.nextLine();
        returnDate = LocalDate.parse(returnDateString);
        if (returnDate.isAfter(getDue)){
            days = ChronoUnit.DAYS.between(getDue, returnDate);
            penalty = days * 15;
            System.out.format("""
                    You are %d days late
                    A penalty of %d will be added

                    """, days, penalty);
        }
        else {
            System.out.println("----------------------------------- \nThank you for returning the book. ");
        }
        
    }

    private void fictionList(){
        int userInput;
        System.out.println("Fiction Books List: ");
        fictionBook.call();
        System.out.println("Please choose a book number: ");
        userInput = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (userInput) {
            case 0: 
                borrowing();

            case 1: 
                if (!fictionBook.getBook(0).equalsIgnoreCase("Not Available")){
                    fictionBook.setdateBorrowed(0);
                    fictionBook.setdueDate(0);
                    borrowingBook(fictionBook.getBook(0), fictionBook.getdateBorrowed(0), 
                        fictionBook.getdueDate(0), Cost, 1);
                    fictionBook.setBook(0);
                }

                else {
                    System.out.println("----------------------------------- \nThis book is currently being borrowed or is unavailable. Please choose another book.");
                }
                break;
            case 2:
                if (!fictionBook.getBook(1).equalsIgnoreCase("Not Available")){
                    fictionBook.setdateBorrowed(1);
                    fictionBook.setdueDate(1);
                    borrowingBook(fictionBook.getBook(1), fictionBook.getdateBorrowed(1),
                        fictionBook.getdueDate(1), Cost, 2);
                    fictionBook.setBook(1);
                }
                else {
                    System.out.println("----------------------------------- \nThis book is currently being borrowed or is unavailable. Please choose another book.");
                }
                break;

            case 3: 
                if (!fictionBook.getBook(2).equalsIgnoreCase("Not Available")){
                    fictionBook.setdateBorrowed(2);
                    fictionBook.setdueDate(2);
                    borrowingBook(fictionBook.getBook(2), fictionBook.getdateBorrowed(2),
                        fictionBook.getdueDate(2), Cost, 3);
                    fictionBook.setBook(2);
                }
                else {
                    System.out.println("----------------------------------- \nThis book is currently being borrowed or is unavailable. Please choose another book.");
                }
                break;
            case 4:
                if (!fictionBook.getBook(3).equalsIgnoreCase("Not Available")){
                        fictionBook.setdateBorrowed(3);
                        fictionBook.setdueDate(3);
                        borrowingBook(fictionBook.getBook(3), fictionBook.getdateBorrowed(3),
                            fictionBook.getdueDate(3), Cost, 4);
                        fictionBook.setBook(3);
                    }
                    else {
                        System.out.println("----------------------------------- \nThis book is currently being borrowed or is unavailable. Please choose another book.");
                    }
                    break;
            case 5:
                if (!fictionBook.getBook(4).equalsIgnoreCase("Not Available")){
                        fictionBook.setdateBorrowed(4);
                        fictionBook.setdueDate(4);
                        borrowingBook(fictionBook.getBook(4), fictionBook.getdateBorrowed(4),
                            fictionBook.getdueDate(4), Cost, 5);
                        fictionBook.setBook(4);
                    }
                    else {
                        System.out.println("----------------------------------- \nThis book is currently being borrowed or is unavailable. Please choose another book.");
                    }
                    break;
            default:
                System.out.println("----------------------------------- \nInvalid input. Please choose a given book.");
                fictionList();
        }
    }

    private void nonFictionList(){
        int userInput;
        System.out.println("Non-Fiction Books List: ");
        nonFictionBook.call();
        System.out.println("Please choose a book number: ");
        userInput = sc.nextInt();
        sc.nextLine();
        System.out.println();
        
        switch (userInput) {
            case 0: 
                borrowing();

            case 1: 
                if (!nonFictionBook.getBook(0).equalsIgnoreCase("Not Available")){
                    nonFictionBook.setdateBorrowed(0);
                    nonFictionBook.setdueDate(0);
                    borrowingBook(nonFictionBook.getBook(0), nonFictionBook.getdateBorrowed(0), 
                        nonFictionBook.getdueDate(0), Cost, 1);
                    nonFictionBook.setBook(0);
                }

                else {
                    System.out.println("----------------------------------- \nThis book is currently being borrowed. Please choose another book.");
                }
                break;
            case 2:
                if (!nonFictionBook.getBook(1).equalsIgnoreCase("Not Available")){
                    nonFictionBook.setdateBorrowed(1);
                    nonFictionBook.setdueDate(1);
                    borrowingBook(nonFictionBook.getBook(1), nonFictionBook.getdateBorrowed(1),
                        nonFictionBook.getdueDate(1), Cost, 2);
                    nonFictionBook.setBook(1);
                }
                else {
                    System.out.println("----------------------------------- \nThis book is currently being borrowed. Please choose another book.");
                }
                break;

            case 3: 
                if (!nonFictionBook.getBook(2).equalsIgnoreCase("Not Available")){
                    nonFictionBook.setdateBorrowed(2);
                    nonFictionBook.setdueDate(2);
                    borrowingBook(nonFictionBook.getBook(2), nonFictionBook.getdateBorrowed(2),
                        nonFictionBook.getdueDate(2), Cost, 3);
                    nonFictionBook.setBook(2);
                }
                else {
                    System.out.println("----------------------------------- \nThis book is currently being borrowed. Please choose another book.");
                }
                break;
            case 4:
                if (!nonFictionBook.getBook(3).equalsIgnoreCase("Not Available")){
                        nonFictionBook.setdateBorrowed(3);
                        nonFictionBook.setdueDate(3);
                        borrowingBook(nonFictionBook.getBook(3), nonFictionBook.getdateBorrowed(3),
                            nonFictionBook.getdueDate(3), Cost, 4);
                        nonFictionBook.setBook(3);
                    }
                    else {
                        System.out.println("----------------------------------- \nThis book is currently being borrowed. Please choose another book.");
                    }
                    break;
            case 5:
                if (!nonFictionBook.getBook(4).equalsIgnoreCase("Not Available")){
                        nonFictionBook.setdateBorrowed(4);
                        nonFictionBook.setdueDate(4);
                        borrowingBook(nonFictionBook.getBook(4), nonFictionBook.getdateBorrowed(4),
                            nonFictionBook.getdueDate(4), Cost, 5);
                        nonFictionBook.setBook(4);
                    }
                    else {
                        System.out.println("----------------------------------- \nThis book is currently being borrowed. Please choose another book.");
                    }
                    break;
            default:
                System.out.println("----------------------------------- \nInvalid input. Please choose a given book.");
                nonFictionList();
        }
    }

}