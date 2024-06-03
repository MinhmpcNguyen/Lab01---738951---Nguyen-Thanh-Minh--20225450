package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void showItem() {
        for (int k = 0; k < itemsOrdered.size(); k++) {
            Media media = itemsOrdered.get(k);
            System.out.print(k + 1 + " " + media.getTitle() + " " + media.getCost());
            System.out.println();
        }
    }

    public float totalCost() {
        float cost = 0;
        for (int k = 0; k < itemsOrdered.size(); k++) {
            Media media = itemsOrdered.get(k);
            float c = media.getCost();
            cost += c;
        }
        return cost;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int k = 0; k < itemsOrdered.size(); k++) {
            Media media = itemsOrdered.get(k);
            System.out.printf("%1$-2s. DVD - %2$20s - %3$20s - %4$20s - %5$6s \n", k + 1, media.getTitle(),
                    media.getCategory(), media.getCost(), media.getId());
        }
        System.out.println("Total Cost: " + this.totalCost());
        System.out.println("************************************************");
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added " + media.getTitle() + " to cart.");
        } else {
            System.out.println("The cart is full, cannot add more items.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed " + media.getTitle() + " from cart.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
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
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Media found:");
                System.out.println(media.toString());
                return media;
            }
        }
        System.out.println("Cannot find media with the given title.");
        return null;
    }
    
    public void sortByTitleThenCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostThenTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

	public int count() {
		int count =0;
		for (Media meida: itemsOrdered) {
			count++;
		}
		return count;
	}
	
	public List<Media> filterMediaById(int id) {
        List<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                filteredList.add(media);
            }
        }
        return filteredList;
    }

    public List<Media> filterMediaByTitle(String title) {
        List<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                filteredList.add(media);
            }
        }
        return filteredList;
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}


		
		
		
