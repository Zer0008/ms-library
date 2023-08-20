package org.cleanarchi.mappers;

import org.cleanarchi.data.BookDto;
import org.cleanarchi.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    private BookMapper() {}

    public static BookDto bookToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setDescription( book.getDescription() );
        bookDto.setPrice( book.getPrice() );

        return bookDto;
    }


    public static Book bookDtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setDescription( bookDto.getDescription() );
        book.setPrice( bookDto.getPrice() );

        return book;
    }

    public static List<BookDto> booksToBooksDto(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( books.size() );
        for ( Book book : books ) {
            list.add( bookToBookDto( book ) );
        }

        return list;
    }
}
