import java.util.*;

public class LibrarySearch {
    static class Book {
        String title, author; int year;
        Book(String t, String a, int y) { title = t; author = a; year = y; }
        public String toString() { return title + " by " + author + " (" + year + ")"; }
    }

    static List<Book> books = new ArrayList<>(List.of(
        new Book("Clean Code", "Robert Martin", 2008),
        new Book("Introduction to Algorithms", "Thomas Cormen", 2009),
        new Book("Effective Java", "Joshua Bloch", 2018),
        new Book("Deep Learning", "Ian Goodfellow", 2016),
        new Book("Operating System Concepts", "Abraham Silberschatz", 2018)
    ));

    static List<Book> search(String keyword) {
        List<Book> result = new ArrayList<>();
        String k = keyword.toLowerCase();
        for (Book b : books)
            if (b.title.toLowerCase().contains(k) || b.author.toLowerCase().contains(k))
                result.add(b);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Search title/author (or 'exit'): ");
            String q = sc.nextLine().trim();
            if (q.equalsIgnoreCase("exit")) break;
            List<Book> r = search(q);
            if (r.isEmpty()) System.out.println("No books found.");
            else r.forEach(b -> System.out.println("  " + b));
        }
        sc.close();
    }
}
