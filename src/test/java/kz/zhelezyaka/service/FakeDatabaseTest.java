package kz.zhelezyaka.service;

import kz.zhelezyaka.model.Book;
import kz.zhelezyaka.repository.BookRepository;
import kz.zhelezyaka.repository.impl.BookRepositoryImpl;
import kz.zhelezyaka.service.impl.EmailServiceImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FakeDatabaseTest {

    @Test
    void testFakeDatabase() {
        BookRepository bookRepository = new BookRepositoryImpl();
        EmailService emailService = new EmailServiceImpl();
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

    @Test
    void shouldGetAppliedDiscountBooks() {
        BookRepository bookRepository = new BookRepositoryImpl();
        BookService bookService = new BookService(bookRepository);

        List<Book> newBooksWithAppliedDiscount =
                bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}
