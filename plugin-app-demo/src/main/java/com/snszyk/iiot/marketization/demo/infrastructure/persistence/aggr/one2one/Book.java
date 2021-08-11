package com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.one2one;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String title;
    private String isbn;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + '}';
    }

}
