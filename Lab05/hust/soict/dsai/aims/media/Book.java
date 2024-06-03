package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	
	
	public List<String> getAuthors() {
		return authors;
	}


	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("The name already exists");
		}
		else {
			authors.add(authorName);
			System.out.println("Name added successfully");
		}
		
	}
	
	public void removeAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			System.out.println("Name not present");
		}
		else {
			authors.remove(authorName);
			System.out.println("Remove successfully");
		}
	}
	
    public Book() {
        super();
    }

    public Book(int id, String title, String category, List<String> authors) {
        super(id, title, category);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category) {
        super(id, title, category);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    @Override
    public String toString() {
        return "Book - " + super.toString();
    }

}
