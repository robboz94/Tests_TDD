package mockito2;

import mockito2.Book;
import mockito2.BooksProcessor;
import mockito2.Database;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BooksProcessorWithAdnotationsTest {

    @InjectMocks
    BooksProcessor booksProcessor;

    @Mock
    Database database;

    @Test
    public void getTotalPrice_whenThereIsOnlyOneBook_shouldReturnPriceOfThisBook() {
        //Stworzenie obiektu do testowania
        Book book = new Book("W pustyni i w puszczy", 99.99);
        // utworzenie listy
        List<Book> list = Collections.singletonList(book);
        //jezeli wywolana metoda getBooks() to zwroc obiekt typu list
        when(database.getBooks()).thenReturn(list);

        double totalPrice = booksProcessor.getTotalPrice();
        assertThat(totalPrice).isEqualTo(99.99);
        // srawdzenie czy dana metoda zostala wywolana

        // # sprawdzanie czy dana metoda zostala wywolana wiele razy - funkcja times(2)
        //verify(database,times(2)).getBooks();
        verify(database).getBooks();
    }

    @Test
    public void getTotalPrice_whenThereIsTwoBooks_shouldReturnPricesOfThoseBooks() {
        // Tworzenie instancji klasy na ktorych bedziemy testowac
        Book book1 = new Book("Wiedzmin", 200.0);
        Book book2 = new Book("Dziady", 5.0);
        // dodawanie ksiazek do listy
        List<Book> list = Arrays.asList(book1, book2);
        // Jezeli metoda getBooks() zostanie wywolana to zwracaj listę książek
        when(database.getBooks()).thenReturn(list);

        double totalPrice = booksProcessor.getTotalPrice();
        assertThat(totalPrice).isEqualTo(205.0);

    }

    @Test
    public void getListOfTitles_whenThereIsOnlyOneBook_shouldReturnTitleOfThisBook() {
        //  Arrange
        Book book = new Book("Pan Tadeusz", 35.0);
        List<Book> list = Collections.singletonList(book);
        when(database.getBooks()).thenReturn(list);
        //  Act
        String listOfTitles = booksProcessor.getListOfTitles();
        //  Assert
        assertThat(listOfTitles).isEqualTo("Pan Tadeusz");
        verify(database).getBooks();
    }

    @Test
    public void getTotalPrice_whenThereIsTwoBooks_shouldReturnPTheirTitles() {
        //  Arrange
        Book book1 = new Book("Potop", 15);
        Book book2 = new Book("Pan Wołodyjowski", 16);
        List<Book> list = Arrays.asList(book1, book2);
        when(database.getBooks()).thenReturn(list);
        //Act
        String listOfTitles = booksProcessor.getListOfTitles();
        assertThat(listOfTitles).isEqualTo("Potop,Pan Wołodyjowski");
        verify(database).getBooks();
    }

    @Test
    public void getTotalPrice_whenDatabaseThrowsAnException_shouldThrowABookProcessorExceptionWithProperMessageAndCause() {
        //  Arrange
        RuntimeException exception = new RuntimeException("wiadomosc"); //zmienna lokalna
        when(database.getBooks()).thenThrow(exception);
        //  Act - wywolanie czegos
        assertThatExceptionOfType(BooksProcessorException.class).isThrownBy(() -> booksProcessor.getTotalPrice())
                .withCause(exception)
                .withMessage("Database has thrown exception with message: wiadomosc");
        //  Sprawdzenie czy pobrane dane zostaly trzykrotnie z bazy danych
        verify(database, times(3)).getBooks();

    }

    @Test
    public void getTotalPrice_whenDatabaseThrowsExceptionButWhenCalledSecondTimeReturnsTheListOfBooks() {
        //  Arrange
        Book book = new Book("Czarodziejka", 250);
        Exception exception = new RuntimeException("wiadomosc");
        List<Book> list = Arrays.asList(book);
        when(database.getBooks())
                .thenThrow(exception)
                .thenReturn(list);
        //  Act
        double totalPrice = booksProcessor.getTotalPrice();
        //  Assert
    assertThat(totalPrice).isEqualTo(250);
    verify(database,times(2)).getBooks();

    }
}
