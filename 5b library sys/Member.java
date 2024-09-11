public class Member implements UserActions {
    private String name;

    public Member(String name) { this.name = name; }

    @Override
    public void performAction(Book book, BorrowingService service) {
        service.borrowBook(book);
    }
}
