package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String category, float cost, String director, String artist, ArrayList<Track> tracks) {
        super();
    	this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed successfully.");
        } else {
            System.out.println("Track not found");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    @Override
    public void play() throws PlayerException{
    	if(this.getLength() > 0) {
    		java.util.Iterator iter = tracks.iterator();
    		Track nextTrack;
    		while(iter.hasNext()) {
    			nextTrack = (Track) iter.next();
    			try {
    				nextTrack.play();
    			}catch(PlayerException e) {
    				throw e;
    			}
    		}
    	}else {
    		throw new PlayerException("ERROR: CD length is non-positive!");
    	}
    }

}

