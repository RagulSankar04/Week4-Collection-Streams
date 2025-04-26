import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + " - Rating: " + rating;
    }
}

public class BookRecommendations {
    public static List<List<BookRecommendation>> getRecommendations(List<Book> books) {
        List<BookRecommendation> filtered = books.stream()
                .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
                .map(b -> new BookRecommendation(b.title, b.rating))
                .sorted(Comparator.comparingDouble(b -> -b.rating))
                .limit(10)
                .collect(Collectors.toList());

        List<List<BookRecommendation>> pages = new ArrayList<>();
        for (int i = 0; i < filtered.size(); i += 5) {
            pages.add(filtered.subList(i, Math.min(i + 5, filtered.size())));
        }
        return pages;
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.6),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.3),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.2),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.5),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.4),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.7),
                new Book("Brave New World", "Aldous Huxley", "Science Fiction", 4.0),
                new Book("Ready Player One", "Ernest Cline", "Science Fiction", 4.3),
                new Book("Altered Carbon", "Richard K. Morgan", "Science Fiction", 4.2),
                new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", "Science Fiction", 4.3));

        List<List<BookRecommendation>> pages = getRecommendations(books);

        for (int i = 0; i < pages.size(); i++) {
            System.out.println("Page " + (i + 1));
            pages.get(i).forEach(System.out::println);
            System.out.println();
        }
    }
}
