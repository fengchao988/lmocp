package com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.jpa;


import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.one2many.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
