package com.fpemba.Spring5.webApp.repositories;

import com.fpemba.Spring5.webApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
