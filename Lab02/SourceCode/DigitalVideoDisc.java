public class DigitalVideoDisc {
	    
		
		
		
		private String title;
	    private String category;
	    private float cost;
	    private String director;
	    private int length;
	    
	    public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	    public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	    
	    public DigitalVideoDisc(String title, String category, float cost, String director) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.director = director;
	}
	    
	    public DigitalVideoDisc(String title, String category,  String director,int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.director = director;
		this.length = length;
	}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public float getCost() {
			return cost;
		}
		public void setCost(float cost) {
			this.cost = cost;
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
		

}
