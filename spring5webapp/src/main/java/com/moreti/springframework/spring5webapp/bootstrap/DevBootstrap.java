package com.moreti.springframework.spring5webapp.bootstrap;

import com.moreti.springframework.spring5webapp.model.Author;
import com.moreti.springframework.spring5webapp.model.Book;
import com.moreti.springframework.spring5webapp.model.Publisher;
import com.moreti.springframework.spring5webapp.repository.AuthorRepository;
import com.moreti.springframework.spring5webapp.repository.BookRepository;
import com.moreti.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Publisher harper = new Publisher("Harper Collins","1st street");
        publisherRepository.save(harper);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Publisher worx = new Publisher("Worx","Main street");
        publisherRepository.save(worx);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE Development without EJB", "23444", worx);

        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }
}
