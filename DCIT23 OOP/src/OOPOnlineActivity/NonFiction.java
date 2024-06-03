package OOPOnlineActivity;

public class NonFiction extends Book{
    NonFiction(){
        super(  books[0], books[1], books[2], books[3], books[4],
                author[0], author[1], author[2], author[3], author[4],
                publisher[0], publisher[1], publisher[2], publisher[3], publisher[4]);
    }
    
    public static String[] books = {
        "A Brief History of Time", 
        "In Cold Blood",
        "The Diary of a Young Girl",
        "A Short History of Nearly Everything",
        "Between the World and Me"
    };

    public static String[] author = {
        "Stephen Hawking",
        "Truman Capote",
        "Anne Frank",
        "Bill Bryson",
        "Ta-Nehisi Coates"
    };

    public static String[] publisher = {
        "Bantam Dell Publishing Group",
        "Random House",
        "Contact Publishing",
        "Double Day Broadway Books",
        "Spiegel & Grau"
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
