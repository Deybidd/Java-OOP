package OOPOnlineActivity;
import java.time.LocalDate;

public class Book {
    private String[] books = new String[5];
    
    private String[] publisher = new String[5];

    private String[] author = new String[5];

    private LocalDate[] dateBorrowed = new LocalDate[5];

    private LocalDate[] dueDate = new LocalDate[5];


Book(String book1, String book2, String book3, String book4, String book5,
    String author1, String author2, String author3, String author4, String author5,
    String publisher1, String publisher2, String publisher3, String publisher4, String publisher5){

    this.books[0] = book1;
    this.books[1] = book2;
    this.books[2] = book3;
    this.books[3] = book4;
    this.books[4] = book5;

    this.author[0] = author1;
    this.author[1] = author2;
    this.author[2] = author3;
    this.author[3] = author4;
    this.author[4] = author5;

    this.publisher[0] = publisher1;
    this.publisher[1] = publisher2;
    this.publisher[2] = publisher3;
    this.publisher[3] = publisher4;
    this.publisher[4] = publisher5;
    }

public void call(){
    for (int i = 0; i < books.length; i++){
        System.out.format("""
                -----------------------------------
                Book no. [%d]   : %s
                Author          : %s
                Publisher       : %s
                -----------------------------------
                """, i + 1, books[i], author[i], publisher[i]);

        }
}

public void setBook(int bookNumber){
    this.books[bookNumber] = "Not Available";
    this.author[bookNumber] = "Not Available";
    this.publisher[bookNumber] = "Not Available";
}

public String getBook(int bookNum){
    return books[bookNum];
}

public void setdateBorrowed(int index){
    this.dateBorrowed[index] = LocalDate.now();
}

public LocalDate getdateBorrowed(int index){
    return dateBorrowed[index];
}

public void setdueDate (int index){
    this.dueDate[index] = dateBorrowed[index].plusMonths(1);
}

public LocalDate getdueDate(int index){
    return dueDate[index];
}

public void setReturn(int bookNumber, String bookname, String publisher, String author){
    this.books[bookNumber] = bookname;
    this.author[bookNumber] = author;
    this.publisher[bookNumber] = publisher;
    }
}