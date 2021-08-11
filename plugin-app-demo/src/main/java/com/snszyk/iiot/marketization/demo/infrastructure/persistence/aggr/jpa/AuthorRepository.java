package com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.jpa;


import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.one2many.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
