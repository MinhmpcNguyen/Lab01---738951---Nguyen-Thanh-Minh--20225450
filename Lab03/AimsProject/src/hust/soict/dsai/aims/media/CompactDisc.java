package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private List<String> tracks;
    
    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        tracks = new ArrayList<>();
    }
    
    // Method to add a track to the CD
    public void addTrack(String track) {
        if (tracks.contains(track)) {
            System.out.println("Track '" + track + "' already exists in the CD.");
        } else {
            tracks.add(track);
        }
    }
    
    // Method to remove a track from the CD
    public void removeTrack(String track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track '" + track + "' does not exist in the CD.");
        }
    }
    
    // Method to get the total length of the CD
    public int getLength() {
        int totalLength = 0;
        for (String track : tracks) {
            // Assuming each track's length is represented in seconds
            // You can modify this based on your actual implementation
            totalLength += track.length();
        }
        return totalLength;
    }
    @Override
    public void play() {
        // Output information about the CompactDisc
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Tracks:");
        for (String track : tracks) {
            System.out.println("- " + track);
        }
    }
    
}
