package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "library", fetch = FetchType.LAZY)
    private Address address;

    @ManyToMany(mappedBy = "libraryList",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> bookList;








}
