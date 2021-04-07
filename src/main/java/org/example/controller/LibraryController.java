package org.example.controller;


import org.example.entity.Address;
import org.example.entity.Book;
import org.example.entity.Library;
import org.example.repository.AddressRepository;
import org.example.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("")
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Library> getLibraryById(@PathVariable("id") Long id) {
        return libraryRepository.findById(id);
    }

    @PostMapping("")
    public Library createLibrary(@RequestBody Library library) {
        return libraryRepository.saveAndFlush(library);
    }


    @PatchMapping("/{id}")
    public Library updateLibraryName(@PathVariable("id") Long id,
                                     @RequestParam String name) {
        Library library = libraryRepository.findById(id).get();

        library.setName(name);
        return libraryRepository.saveAndFlush(library);
    }

    @GetMapping("/address")
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id) {

        libraryRepository.deleteById(id);
    }

    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.saveAndFlush(address);
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable Long id,
                                 @RequestBody Address address) {
        address.setId(id);
        return addressRepository.saveAndFlush(address);
    }

    @PatchMapping("/address/{id}")
    public Address updateLibraryAddress(@PathVariable Long id,
                                        @RequestParam Long libraryId) {
        Address address = addressRepository.findById(id).get();
        address.setLibraryId(libraryId);

        return addressRepository.saveAndFlush(address);
    }


}
