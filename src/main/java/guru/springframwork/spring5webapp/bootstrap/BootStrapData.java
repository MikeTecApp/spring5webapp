package guru.springframwork.spring5webapp.bootstrap;

import guru.springframwork.spring5webapp.domain.Author;
import guru.springframwork.spring5webapp.domain.Book;
import guru.springframwork.spring5webapp.domain.Publisher;
import guru.springframwork.spring5webapp.repositories.AuthorRepository;
import guru.springframwork.spring5webapp.repositories.BookRepository;
import guru.springframwork.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started BootStrap ...");

        Author authorOne = new Author("Eric","Jahani");
        Book bookOne = new Book("Wilcome to Spring", "18630986535");
        Publisher publisher = new Publisher("SFG Publishing","St Petersburg","Florida","FL","254487");

//
        authorOne.getBooks().add(bookOne);
        authorOne.getPublishers().add(publisher);
        bookOne.getAuthors().add(authorOne);
        publisher.getAuthors().add(authorOne);

        authorRepository.save(authorOne);
        bookRepository.save(bookOne);



        Author authorTwo = new Author("Mike","Jordan");
        Book bookTwo = new Book("How to shoot like pro ", "12398460048");

        authorTwo.getBooks().add(bookTwo);
        authorTwo.getPublishers().add(publisher);
        bookTwo.getAuthors().add(authorTwo);

        authorRepository.save(authorTwo);
        bookRepository.save(bookTwo);

        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of publisher: " + publisherRepository.count());

    }
}
