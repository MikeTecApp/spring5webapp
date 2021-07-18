package guru.springframwork.spring5webapp.bootstrap;

import guru.springframwork.spring5webapp.domain.Author;
import guru.springframwork.spring5webapp.domain.Book;
import guru.springframwork.spring5webapp.repositories.AuthorRepository;
import guru.springframwork.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Author authorOne = new Author("Eric","Jahani");
        Book bookOne = new Book("Wilcome to Spring", "18630986535");

//        authorOne.setBooks((Set<Book>) bookOne);
        authorOne.getBooks().add(bookOne);
        bookOne.getAuthors().add(authorOne);

        authorRepository.save(authorOne);
        bookRepository.save(bookOne);

        Author authorTwo = new Author("Mike","Jordan");
        Book bookTwo = new Book("How to shoot like pro ", "12398460048");

 //       authorTwo.setBooks((Set<Book>) bookTwo);
 //       bookTwo.setAuthors((Set<Author>) authorTwo);
        authorRepository.save(authorTwo);
        bookRepository.save(bookTwo);

        System.out.println("Started BootStrap ...");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Autors: " + authorRepository.count());

    }
}
