package com.tejlearning.springFramework.repositories;

import com.tejlearning.springFramework.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Long> {
}
