import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private Map<Integer, Member> members = new HashMap<>();
    private int nextMemberId = 1;

    public void addBook(Book book) {
        books.add(book);
    }

    public Member registerMember(String name) {
        Member member = new Member(name, nextMemberId++);
        members.put(member.getMemberId(), member);
        return member;
    }

    public boolean borrowBook(int memberId, String isbn) {
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.setAvailable(false);
                member.borrowBook(book);
                System.out.println("Book borrowed successfully.");
                return true;
            }
        }
        System.out.println("Book not available.");
        return false;
    }

    public boolean returnBook(int memberId, String isbn) {
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        for (Book book : member.getBorrowedBooks()) {
            if (book.getIsbn().equals(isbn)) {
                book.setAvailable(true);
                member.returnBook(book);
                System.out.println("Book returned successfully.");
                return true;
            }
        }
        System.out.println("Book not found in borrowed list.");
        return false;
    }

    public void listAllBooks() {
        books.forEach(System.out::println);
    }

    public void listAllMembers() {
        for (Member m : members.values()) {
            System.out.println(m);
            m.getBorrowedBooks().forEach(b -> System.out.println("  " + b));
        }
    }
}
