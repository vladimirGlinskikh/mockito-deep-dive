package kz.zhelezyaka.repository;

import kz.zhelezyaka.model.Book;

import java.util.Collection;

public interface BookRepository {
    void save(Book book);

    Collection<Book> findAll();
}
