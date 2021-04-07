package org.example.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Address {

    @Id
    @SequenceGenerator(
            name =  "address_sequence",
            sequenceName =  "address_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;
    private String street;
    private Integer buildingNo;

    @Column(name = "library_id")
    private  Long libraryId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id", insertable = false, updatable = false)
    private Library library;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", buildingNo=" + buildingNo +
                '}';
    }
}
