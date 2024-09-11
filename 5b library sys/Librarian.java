public class Librarian implements UserActions {
    private String name;

    public Librarian(String name) { this.name = name; }

    @Override
    public void performAction(Book book, BorrowingService service) {
        service.borrowBook(book);
    }
}
