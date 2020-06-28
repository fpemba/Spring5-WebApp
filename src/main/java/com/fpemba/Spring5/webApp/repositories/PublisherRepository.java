package com.fpemba.Spring5.webApp.repositories;

import com.fpemba.Spring5.webApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
