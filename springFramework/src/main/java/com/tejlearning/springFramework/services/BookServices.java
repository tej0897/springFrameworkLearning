package com.tejlearning.springFramework.services;

import com.tejlearning.springFramework.domain.Book;

public interface BookServices {
    Iterable<Book> findAll();
}
