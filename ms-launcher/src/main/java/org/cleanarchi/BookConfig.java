package org.cleanarchi;

import org.cleanarchi.adapters.BookJpaAdapter;
import org.cleanarchi.ports.api.BookServicePort;
import org.cleanarchi.ports.spi.BookPersistencePort;
import org.cleanarchi.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public BookPersistencePort bookPersistence(){
        return new BookJpaAdapter();
    }

    @Bean
    public BookServicePort bookService(){
        return new BookServiceImpl(bookPersistence());
    }
}
