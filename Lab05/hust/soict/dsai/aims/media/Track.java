package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            // TODO Play Track as you have implemented
            System.out.println("Playing Track...");
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Track track = (Track) obj;
	    return getTitle().equals(track.getTitle()) && getLength() == track.getLength();
	}

	
	
}
