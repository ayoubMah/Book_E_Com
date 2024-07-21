package com.e_com.Ayoub.sCenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id ;

    @Column(name = "Name")
    private String name;

    @Column(name = "Author")
    private String author;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Product> products ;

}
