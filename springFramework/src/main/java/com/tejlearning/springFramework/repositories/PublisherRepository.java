package com.tejlearning.springFramework.repositories;

import com.tejlearning.springFramework.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
