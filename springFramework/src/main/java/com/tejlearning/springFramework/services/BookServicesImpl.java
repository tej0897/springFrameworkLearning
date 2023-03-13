package com.tejlearning.springFramework.services;

import com.tejlearning.springFramework.domain.Book;
import com.tejlearning.springFramework.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServicesImpl implements BookServices {

    private final BookRepository bookRepository;

    public BookServicesImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
