package com.moreti.springframework.spring5webapp.repository;

import com.moreti.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
