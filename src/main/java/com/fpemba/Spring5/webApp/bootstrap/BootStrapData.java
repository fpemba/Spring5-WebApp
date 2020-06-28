package com.fpemba.Spring5.webApp.bootstrap;

import com.fpemba.Spring5.webApp.domain.Author;
import com.fpemba.Spring5.webApp.domain.Book;
import com.fpemba.Spring5.webApp.domain.Publisher;
import com.fpemba.Spring5.webApp.repositories.AuthorRepository;
import com.fpemba.Spring5.webApp.repositories.BookRepository;
import com.fpemba.Spring5.webApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Starting in Bootstrap");


        Publisher NYPublisher = new Publisher();
        NYPublisher.setName("NYPublisher");
        NYPublisher.setCity("NY City");
        NYPublisher.setState("New York");

        publisherRepository.save(NYPublisher);

        System.out.println("Number of publishers: " + publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(NYPublisher);
        NYPublisher.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(NYPublisher);


        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","3954873874");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(NYPublisher);
        NYPublisher.getBooks().add(noEJB);



        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(NYPublisher);


        System.out.println("Number of books: " + bookRepository.count());


        System.out.println("Number of books assigned to publisher: " + NYPublisher.getBooks().size());

        }
    }

