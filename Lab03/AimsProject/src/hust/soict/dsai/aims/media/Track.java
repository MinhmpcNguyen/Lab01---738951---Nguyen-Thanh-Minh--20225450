package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    @Override
    public void play() {
        // Implement play() method for Track
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("DVD Length " + this.getLength());
        // Logic to play the track...
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Track track = (Track) obj;
        return Objects.equals(getTitle(), track.getTitle()) &&
               getLength() == track.getLength();
    }

}
