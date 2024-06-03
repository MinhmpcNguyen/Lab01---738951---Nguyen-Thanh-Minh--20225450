package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors;

	// Constructor
    public Book( String title, String category, float cost) {
    	
        super( title, category, cost);
        
        
    }
    public Book(int id, String title, String category, float cost, List<String> authors) {
    	
        super(id, title, category, cost);
        
        this.authors = authors;
    }

   
	// Additional method to add an author
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) { // Ensure author is not already in the list
            authors.add(authorName);
        }
    }

    // Additional method to remove an author
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) { // Ensure author is present in the list
            authors.remove(authorName);
        }
    }
}