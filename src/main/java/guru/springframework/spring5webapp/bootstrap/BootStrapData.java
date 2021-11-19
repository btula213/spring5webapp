package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        /* Adding Publishers */
        Publisher p1 = new Publisher("McMillan", "1111 Rod Johnson", "San Francisco", "CA", "94301");
        Publisher p2 = new Publisher("Wrox", "2222 Rod Johnson", "San Francisco", "CA", "94302");
        Publisher p3 = new Publisher("Penguin", "3333 Rod Johnson", "San Francisco", "CA", "94303");
        publisherRepository.save(p1);
        publisherRepository.save(p2);
        publisherRepository.save(p3);

        /* Authors and books */
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "122323");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(p1);


        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123222");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(p2);
        p2.getBooks().add(noEJB);
        p1.getBooks().add(ddd);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Publisher p1: "+p1.getName());
        System.out.println("Publisher p2: "+p2.getName());
        System.out.println("Publisher p3: "+p3.getName());
        System.out.println("Publisher Repository Count: "+publisherRepository.count());

        System.out.println("Started in Bootstrap\n.....................\n\n");
        System.out.println("Number of Books: " + bookRepository.count());

        System.out.println("Publisher p1 books #: "+p1.getBooks().size());
        System.out.println("Publisher p2 books #: "+p2.getBooks().size());
        System.out.println("Publisher p3 books #: "+p3.getBooks().size());


    }
}
