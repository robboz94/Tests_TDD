package mockito2;

import java.util.stream.Collectors;

public class BooksProcessor {

    private Database database;

    public BooksProcessor(Database database) {
        this.database = database;
    }

    // zwraca sumę cen książek
    public double getTotalPrice() {
        try {
            return this.database.getBooks().stream().mapToDouble(Book::getPrice).sum();
        } catch (RuntimeException e) {
            throw new BooksProcessorException("Database has thrown exception with message: " + e.getMessage(), e);
        }
    }

    // zwraca listę tytułów książek (tytuły oddzielone przecinkami)
    public String getListOfTitles() {
        try {
            return this.database.getBooks().stream().map(Book::getTitle).collect(Collectors.joining(","));
        } catch (RuntimeException e) {
            throw new BooksProcessorException("Database has thrown exception with message: " + e.getMessage(), e);
        }
    }
}

class BooksProcessorException extends RuntimeException {
    BooksProcessorException(String message, Throwable cause) {
        super(message, cause);
    }
}