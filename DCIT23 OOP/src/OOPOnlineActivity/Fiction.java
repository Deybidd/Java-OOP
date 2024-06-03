package OOPOnlineActivity;

public class Fiction extends Book{
    Fiction(){
        super(  books[0], books[1], books[2], books[3], books[4],
                author[0], author[1], author[2], author[3], author[4],
                publisher[0], publisher[1], publisher[2], publisher[3], publisher[4]);
    }

    public static String[] books = {
        "1984", 
        "The Great Gatsby",
        "To kill a Mocking bird",
        "The Hunger Games",
        "Harry Potter (Series)"
    };

    public static String[] author = {
        "Georde Orwell",
        "F. Scott Fitzgerald",
        "Harper Lee",
        "Suzanne Collins",
        "J.K. Rowling"
    };

    public static String[] publisher = {
        "Secker and Warburg",
        "Charles Scribner's Sons",
        "J.B. Lippincott & Co.",
        "Scholastic",
        "Bloomsbury"
    };
    
    public String getOriginalBook(int index){
        return books[index];
    }

    public String getOriginalAuthor(int index){
        return author[index];
    }

    public String getOriginalPublisher(int index){
        return publisher[index];
    }
}
