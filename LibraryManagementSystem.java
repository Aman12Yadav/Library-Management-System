import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780060935467"));

        while (true) {
            System.out.println("\n1. Register\n2. Add Book\n3. Borrow\n4. Return\n5. List Books\n6. List Members\n7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("ID: " + library.registerMember(scanner.nextLine()).getMemberId());
                case 2 -> library.addBook(new Book(scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
                case 3 -> library.borrowBook(scanner.nextInt(), scanner.next());
                case 4 -> library.returnBook(scanner.nextInt(), scanner.next());
                case 5 -> library.listAllBooks();
                case 6 -> library.listAllMembers();
                case 7 -> { return; }
            }
        }
    }
}
