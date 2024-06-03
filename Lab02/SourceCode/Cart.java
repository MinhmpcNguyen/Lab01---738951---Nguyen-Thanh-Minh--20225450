public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int qtyOrdered =0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	        itemsOrdered[qtyOrdered] = disc;
	        qtyOrdered++;
	        System.out.println("The disc has been added to the cart.");
	        System.out.println("Total cost: " + totalCost()); 
	    } else {
	        System.out.println("The cart is almost full.");
	    }
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	    for (DigitalVideoDisc disc : dvdList) {
	        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	            itemsOrdered[qtyOrdered] = disc;
	            qtyOrdered++;
	            System.out.println("The disc has been added to the cart.");
	            System.out.println("Total cost: " + totalCost());
	        } else {
	            System.out.println("The cart is almost full.");
	            break; // Stop adding discs if the cart is full
	        }
	    }
	}
	
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	    
	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i] == disc) {
	            
	           
	            itemsOrdered[i] = itemsOrdered[qtyOrdered - 1];
	            itemsOrdered[qtyOrdered - 1] = null;
	            qtyOrdered--;
	            System.out.println("The disc has been removed from the cart.");
	            System.out.println("Total cost: " + totalCost()); 
	            break;
	        }
	    }
	    
	    
	}
	
    
	public float totalCost() {
	    float totalCost = 0.0f;
	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i] != null) {
	            totalCost += itemsOrdered[i].getCost();
	        }
	    }
	    return totalCost;
	}
	
}	
	