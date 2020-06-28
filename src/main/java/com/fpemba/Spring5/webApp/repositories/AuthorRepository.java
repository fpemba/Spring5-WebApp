package com.fpemba.Spring5.webApp.repositories;

import com.fpemba.Spring5.webApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
