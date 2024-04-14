import java.util.ArrayList;
import java.util.List;

interface Searchable {
    boolean search(String query);
}

abstract class Resource {
    private String title;
    private String author;
    private int year;
    private boolean checkedOut;

    public Resource(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checkedOut = false;
    }

    public abstract String getType();

    public void checkout() {
        if (!checkedOut) {
            checkedOut = true;
            System.out.println(getType() + " '" + title + "' checked out successfully.");
        } else {
            System.out.println(getType() + " '" + title + "' is already checked out.");
        }
    }

    public void returnItem() {
        if (checkedOut) {
            checkedOut = false;
            System.out.println(getType() + " '" + title + "' returned successfully.");
        } else {
            System.out.println(getType() + " '" + title + "' is already available.");
        }
    }

    public String getTitle() {
        return title;
    }
}

class Book extends Resource {
    private String isbn;

    public Book(String title, String author, int year, String isbn) {
        super(title, author, year);
        this.isbn = isbn;
    }

    @Override
    public String getType() {
        return "Book";
    }
}

class Journal extends Resource {
    private String issn;

    public Journal(String title, String author, int year, String issn) {
        super(title, author, year);
        this.issn = issn;
    }

    @Override
    public String getType() {
        return "Journal";
    }
}

class Multimedia extends Resource {
    private String format;

    public Multimedia(String title, String author, int year, String format) {
        super(title, author, year);
        this.format = format;
    }

    @Override
    public String getType() {
        return "Multimedia";
    }
}

class Library {
    private List<Resource> resources;

    public Library() {
        resources = new ArrayList<>();
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public List<Resource> search(String query) {
        List<Resource> results = new ArrayList<>();
        for (Resource resource : resources) {
            if (resource instanceof Searchable) {
                Searchable searchableResource = (Searchable) resource;
                if (searchableResource.search(query)) {
                    results.add(resource);
                }
            }
        }
        return results;
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Python Crash Course", "Eric Matthes", 2015, "9781593276034");
        Journal journal1 = new Journal("Nature", "Various", 2021, "0036-8075");
        Multimedia multimedia1 = new Multimedia("Inception", "Christopher Nolan", 2010, "Blu-ray");

        library.addResource(book1);
        library.addResource(journal1);
        library.addResource(multimedia1);

        book1.checkout();
        journal1.checkout();

        System.out.println("\nSearching for 'Python':");
        List<Resource> results = library.search("Python");
        for (Resource result : results) {
            System.out.println("- " + result.getType() + ": " + result.getTitle());
        }

        book1.returnItem();
        journal1.returnItem();
    }
}
