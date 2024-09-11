public class LibrarySystem {
    private UserActions userActions;
    private BorrowingService service;

    public LibrarySystem(UserActions userActions, BorrowingService service) {
        this.userActions = userActions;
        this.service = service;
    }

    public void manageBook(Book book) {
        userActions.performAction(book, service);
    }

    public static void main(String[] args) {
        Book book = new Book("Design Patterns", "Erich Gamma");
        BorrowingService service = new BorrowingService();

        LibrarySystem memberSystem = new LibrarySystem(new Member("Alice"), service);
        memberSystem.manageBook(book);

        LibrarySystem librarianSystem = new LibrarySystem(new Librarian("Bob"), service);
        librarianSystem.manageBook(book);
    }
}
