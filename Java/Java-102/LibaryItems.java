public class LibaryItems {
    public final String title;
    public final String itemId;
    
    protected boolean isCheckedOut = false;

    public LibaryItems(String title, String itemId) {
        this.title = title;
        this.itemId = itemId;
    }

	public boolean available() {
		return !isCheckedOut;
	}

    public void checkOut() {
        isCheckedOut = true;
    }

    public void returnItem() {
        isCheckedOut = false;
    }
      // Method to display item information
      public void displayInfo() {
        System.out.println("Title: " + title + ", Item ID: " + itemId + ", Available: " + available());
    }
}