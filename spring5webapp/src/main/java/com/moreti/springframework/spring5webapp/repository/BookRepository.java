package com.moreti.springframework.spring5webapp.repository;

import com.moreti.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {
}
