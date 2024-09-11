public class BorrowingService {
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book is not available: " + book.getTitle());
        }
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
        System.out.println("Book returned: " + book.getTitle());
    }
}
