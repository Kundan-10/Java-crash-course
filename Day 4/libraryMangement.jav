import java.util.*;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class Book {
    private int id;
    private String title;
    private boolean available;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class LibraryMember {
    private int memberId;
    private String name;

    public LibraryMember(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}

public class LibraryManagementSystem {
    private ArrayList<Book> books;
    private LinkedList<LibraryMember> waitingList;
    private Vector<LibraryMember> members;
    private Stack<Book> returnLog;
    private HashSet<LibraryMember> uniqueMembers;
    private LinkedHashSet<Book> borrowedBooks;
    private TreeSet<String> sortedTitles;
    private HashMap<Integer, Book> bookDetails;
    private LinkedHashMap<Integer, Book> checkoutLog;
    private TreeMap<Integer, Book> sortedBooksById;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        waitingList = new LinkedList<>();
        members = new Vector<>();
        returnLog = new Stack<>();
        uniqueMembers = new HashSet<>();
        borrowedBooks = new LinkedHashSet<>();
        sortedTitles = new TreeSet<>();
        bookDetails = new HashMap<>();
        checkoutLog = new LinkedHashMap<>();
        sortedBooksById = new TreeMap<>();
    }

    public void addBook(int id, String title) {
        Book book = new Book(id, title);
        books.add(book);
        bookDetails.put(id, book);
        sortedBooksById.put(id, book);
        sortedTitles.add(title);
    }

    public void addMember(int memberId, String name) {
        LibraryMember member = new LibraryMember(memberId, name);
        members.add(member);
        uniqueMembers.add(member);
    }

    public void checkoutBook(int memberId, int bookId) {
        try {
            Book book = bookDetails.get(bookId);
            if (book == null || !book.isAvailable()) {
                throw new BookNotAvailableException("Book not available for checkout.");
            }

            LibraryMember member = null;
            for (LibraryMember m : members) {
                if (m.getMemberId() == memberId) {
                    member = m;
                    break;
                }
            }

            if (member != null) {
                book.setAvailable(false);
                borrowedBooks.add(book);
                checkoutLog.put(bookId, book);
                System.out.println("Book '" + book.getTitle() + "' checked out by " + member.getName());
            } else {
                System.out.println("Member not found.");
            }
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
            waitingList.add(new LibraryMember(memberId, "Unknown"));
        } finally {
            System.out.println("Checkout process completed.");
        }
    }

    public void returnBook(int bookId) {
        Book book = bookDetails.get(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            borrowedBooks.remove(book);
            returnLog.push(book);
            System.out.println("Book '" + book.getTitle() + "' returned.");
        } else {
            System.out.println("Book not found or already returned.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle());
        }
    }

    public void displaySortedTitles() {
        System.out.println("Sorted Titles:");
        for (String title : sortedTitles) {
            System.out.println(title);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook(1, "Java Programming");
        library.addBook(2, "Python Basics");
        library.addBook(3, "Data Structures and Algorithms");

        library.addMember(101, "John Doe");
        library.addMember(102, "Jane Smith");

        library.checkoutBook(101, 1);
        library.checkoutBook(102, 2);
        library.checkoutBook(103, 3); // This will go to waiting list

        library.displayBorrowedBooks();
        library.displaySortedTitles();

        library.returnBook(1);

        library.displayBorrowedBooks();
    }
}
