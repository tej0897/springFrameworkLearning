package com.tejlearning.springFramework.bootstrap;

import com.tejlearning.springFramework.domain.Author;
import com.tejlearning.springFramework.domain.Book;
import com.tejlearning.springFramework.domain.Publisher;
import com.tejlearning.springFramework.repositories.AuthorRepository;
import com.tejlearning.springFramework.repositories.BookRepository;
import com.tejlearning.springFramework.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setBookName("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setBookName("J2EE development without EJB");
        noEJB.setIsbn("234567");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Penguin Books");
        publisher1.setCity("Bengaluru");
        publisher1.setState("Karnataka");
        publisher1.setZip("560001");

        Publisher publisherSaved = publisherRepository.save(publisher1);

        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(publisherSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap:");
        System.out.println("Author Count: "+authorRepository.count());
        System.out.println("Books Count: " +bookRepository.count());

        System.out.println("Publishers Count: " +publisherRepository.count());

    }
}
