package org.example.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Library {

    @Id
    @SequenceGenerator(
            name =  "library_sequence",
            sequenceName =  "library_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "library_sequence"
    )
    private Long id;
    private String name;

    @OneToOne(mappedBy = "library", fetch = FetchType.LAZY)
    private Address address;



    @ManyToMany(mappedBy = "libraryList",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> bookList;


    public Library() {
    }


    public Library(String name) {
        this.name = name;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", bookList=" + bookList +
                '}';
    }
}
