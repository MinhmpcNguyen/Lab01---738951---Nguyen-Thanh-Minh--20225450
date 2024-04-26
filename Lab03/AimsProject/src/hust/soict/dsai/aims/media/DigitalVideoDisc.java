package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable {
	    
		
		
	    private String director;
	    private int length;
	    
	    public DigitalVideoDisc(String title) {
	    super(title);
		
	}
	    public DigitalVideoDisc(int id, String title, String category, float cost) {
	    super(id, title, category, cost);
		
	}
	    
	    public DigitalVideoDisc(String title, String category, float cost, String director) {
	    super( title, category, cost);
		
		this.director = director;
	}
	    
	    public DigitalVideoDisc(int id,String title, String category,  String director,int length, float cost) {
	    super(id, title, category, cost);
		
		this.director = director;
		this.length = length;
	}
	    
	   
	    
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		@Override
	    public String toString() {
	        return "Title: " + getTitle() + " - Category: " + getCategory() + " - Director: " + getDirector() + " - Length: " + getLength();
	    }

	    
	    @Override
	    public void play() {
	        // Implement play() method for DigitalVideoDisc
	    	System.out.println("Playing track: " + this.getTitle());
	        System.out.println("DVD Length " + this.getLength());
	        // Logic to play the DVD...
	    }

	   

}
