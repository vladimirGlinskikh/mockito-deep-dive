package kz.zhelezyaka.service;

import kz.zhelezyaka.model.Book;
import kz.zhelezyaka.repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FakeDatabaseTest {

    @Test
    void testFakeDatabase() {
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository, emailService);

        bookService.addBook(new Book(
                "2318",
                "Mockito in Action",
                180,
                LocalDate.now()));
        bookService.addBook(new Book(
                "6273",
                "Spring in Action",
                190,
                LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());
    }
}
