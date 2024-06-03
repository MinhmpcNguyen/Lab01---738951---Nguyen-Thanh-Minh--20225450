package hust.soict.dsai.aims.media;

public class Disc extends Media{

    private int length;
    private String director;

    public Disc(String title, int length, String director) {
        super();
    	setTitle(title);
    	this.length = length;
        this.director = director;
    }

	public Disc() {
		// TODO Auto-generated constructor stub
	}

	public Disc(String title, String category, float cost) {
		super();
		setTitle(title);
		setCategory(category);
		setCost(cost);
		
	}

	public Disc(String title) {
		super();
		setTitle(title);
	}

	public Disc(String title, String category, float cost, String director) {
		super();
		setTitle(title);
		setCategory(category);
		setCost(cost);
		this.director=director;
	}


	public Disc(String title, String category, String director, int length, float cost) {
		super();
		setTitle(title);
		setCategory(category);
		setCost(cost);
		this.director=director;
		this.length =length;
	}

	public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
    
    

}
