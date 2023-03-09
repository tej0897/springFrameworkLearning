package com.tejlearning.springFramework.repositories;

import com.tejlearning.springFramework.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
