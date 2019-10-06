package com.metin.where.annotation.repository;

import com.metin.where.annotation.entity.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Metin on 6.10.2019.
 */

public interface BookRepository extends CrudRepository<Book, Long> {

}
