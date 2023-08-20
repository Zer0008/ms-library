package org.cleanarchi.adapters;

import org.cleanarchi.data.BookDto;
import org.cleanarchi.entity.Book;
import org.cleanarchi.mappers.BookMapper;
import org.cleanarchi.ports.spi.BookPersistencePort;
import org.cleanarchi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookJpaAdapter implements BookPersistencePort {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = BookMapper.bookDtoToBook(bookDto);

        Book bookSaved = this.bookRepository.save(book);

        return BookMapper.bookToBookDto(bookSaved);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return addBook(bookDto);
    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();

        return BookMapper.booksToBooksDto(books);
    }

    @Override
    public BookDto getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        return book.map(BookMapper::bookToBookDto).orElse(null);
    }
}
