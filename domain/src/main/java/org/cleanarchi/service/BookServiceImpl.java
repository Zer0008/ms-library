package org.cleanarchi.service;

import org.cleanarchi.data.BookDto;
import org.cleanarchi.ports.api.BookServicePort;
import org.cleanarchi.ports.spi.BookPersistencePort;

import java.util.List;

public class BookServiceImpl implements BookServicePort {

    private final BookPersistencePort bookPersistencePort;

    public BookServiceImpl(BookPersistencePort bookPersistencePort) {
        this.bookPersistencePort = bookPersistencePort;
    }

    public BookDto addBook(BookDto bookDto) {
        return this.bookPersistencePort.addBook(bookDto);
    }

    public void deleteBookById(Long id) {
        this.bookPersistencePort.deleteBookById(id);
    }

    public BookDto updateBook(BookDto bookDto) {
        return this.bookPersistencePort.updateBook(bookDto);
    }

    public List<BookDto> getBooks() {
        return this.bookPersistencePort.getBooks();
    }

    public BookDto getBookById(Long id) {
        return this.bookPersistencePort.getBookById(id);
    }
}
