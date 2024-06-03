package hust.soict.dsai.aims.Aims;


import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() {
        store.showItems();
        storeMenu();
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                seeMediaDetails();
                break;
            case 2:
                addToCart();
                break;
            case 3:
                playMedia();
                break;
            case 4:
                seeCurrentCart();
                break;
            case 0:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu...");
                break;
        }
    }

    private static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media foundMedia = store.searchByTitle(title);

        if (foundMedia != null) {
            System.out.println("Media Details:");
            System.out.println("ID: " + foundMedia.getId());
            System.out.println("Title: " + foundMedia.getTitle());
            System.out.println("Category: " + foundMedia.getCategory());
            System.out.println("Cost: $" + foundMedia.getCost());
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");    
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                cart.addMedia(media);
                System.out.println("Media added to cart.");
                break;
            case 2:    
                System.out.println("Playing the media: " + media.getTitle());
                break;
            case 0:
                System.out.println("Returning to store menu...");
                break;
            default:
                System.out.println("Invalid choice. Returning to store menu...");
                break;
        }
    }

    private static void addToCart() {
        System.out.print("Enter the title of the media to add to the cart: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            int dvdCount = cart.count();
            System.out.println("Media added to cart.");
            System.out.println("Number of DVDs in cart: " + dvdCount);
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println("Playing media: " + media.getTitle());
            // Add your logic to play the media here
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStore() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                addMediaToStore();
                break;
            case 2:
                removeMediaFromStore();
                break;
            case 0:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu...");
                break;
        }
    }

    public static void addMediaToStore() {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        System.out.println("Enter the cost of the media:");
        double cost = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the category of the media (Book/DVD/CD):");
        String category = scanner.nextLine();

        Media media = null;
        if (category.equalsIgnoreCase("Book")) {
            System.out.println("Enter the author of the book:");
            String author = scanner.nextLine();
            media = new Book();
        
        } else {
            System.out.println("Invalid category. Returning to store menu...");
            return;
        }

        store.addMedia(media);
        System.out.println("Media added to the store.");
    }

    public static void removeMediaFromStore() {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        boolean removed = store.removeMediaByTitle(title);
        if (removed) {
            System.out.println("Media removed from the store.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    public static void seeCurrentCart() {
        cart.print();
        cartMenu();
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                filterMediaInCart();
                break;
            case 2:
                sortMediaInCart();
                break;
            case 3:
                removeMedia();
                break;
            case 4:
                playMedia();
                break;
            case 5:
                placeOrder();
                break;
            case 0:
                System.out.println("Returning to store menu...");
                break;
            default:
                System.out.println("Invalid choice. Returning to store menu...");
                break;
        }
    }

    public static void filterMediaInCart() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                System.out.println("Enter the ID to filter:");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                cart.filterMediaById(id);
                break;
            case 2:
                System.out.println("Enter the title to filter:");
                String title = scanner.nextLine();
                cart.filterMediaByTitle(title);
                break;
            case 0:
                System.out.println("Returning to cart menu...");
                break;
            default:
                System.out.println("Invalid choice. Returning to cart menu...");
                break;
    
        }
    }

    public static void sortMediaInCart() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                cart.sortByTitleThenCost();
                System.out.println("Media sorted by title.");
                break;
            case 2:
                cart.sortByCostThenTitle();
                System.out.println("Media sorted by cost.");
                break;
            case 0:
                System.out.println("Returning to cart menu...");
                break;
            default:
                System.out.println("Invalid choice. Returning to cart menu...");
                break;
        }
    }
    public static void removeMedia() {
        System.out.println("Enter the ID of the media to remove:");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        List<Media> mediaList = cart.filterMediaById(id);
        if (!mediaList.isEmpty()) {
            Media media = mediaList.get(0);
            cart.removeMedia(media);
            System.out.println("Media removed from the cart.");
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    public static void placeOrder() {
       
        System.out.println("Order placed successfully.");
    }
}