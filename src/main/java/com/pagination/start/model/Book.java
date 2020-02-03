package com.pagination.start.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;



@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "books")
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private LocalDate publishDate;

}
