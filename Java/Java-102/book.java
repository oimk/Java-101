public class book extends LibaryItems {
    public final String author;
    public final int pageCount;

    public book(String title, String itemId, String author, int pageCount) {
        super(title, itemId);
        this.author = author;
        this.pageCount = pageCount;
    }

	@Override
    public String toString() {
        return "Book: " + title + " by " + author + ", " + 
		        pageCount + " pages";
    }
}