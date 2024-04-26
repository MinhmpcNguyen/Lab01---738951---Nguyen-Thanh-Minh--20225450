package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Media added to the store: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media removed from the store: " + media.getTitle());
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    public void showItems() {
        System.out.println("Items in the store:");
        System.out.println("--------------------------------");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("--------------------------------");
    }
    
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                System.out.println("Media found:");
                System.out.println(media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot find media with the given ID.");
        }
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Media found:");
                System.out.println(media.toString());
                return media;
            }
        }
        System.out.println("Cannot find media with the given title.");
        return null;
    }

    public boolean removeMediaByTitle(String title) {
        Media media = searchByTitle(title);
        if (media != null) {
        	return itemsInStore.remove(media);
        }
        return false;
        
    }
    

}

