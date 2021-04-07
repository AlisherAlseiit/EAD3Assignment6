//package org.example.controller;
//
//import org.example.Service.ServiceImpl;
//import org.example.entity.Address;
//import org.example.entity.Book;
//import org.example.entity.Library;
//import org.example.entity.User;
//import org.example.event.LibraryEvent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.context.ApplicationEventPublisherAware;
//import org.springframework.stereotype.Controller;
//
//import javax.persistence.JoinTable;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//public class MyController implements ApplicationEventPublisherAware {
//    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//    private Long userId;
//    private ApplicationEventPublisher eventPublisher;
//    private final ServiceImpl service;
//
//    @Autowired
//    public MyController(ServiceImpl service) {
//        this.service = service;
//    }
//
//
//
//    public boolean adminLogin() throws IOException {
//        System.out.println("NAME:");
//        String adminName = read.readLine();
//        System.out.println("PASSWORD:");
//        String adminPassword = read.readLine();
//
//
//        if (service.adminLogin(adminName, adminPassword) != null)
//
//            return true;
//        else
//            return false;
//
//    }
//
//    public void userRegister() throws IOException {
//        System.out.println("NAME:");
//        String userName = read.readLine();
//        System.out.println("PASSWORD:");
//        String userPassword = read.readLine();
//
//        User user = new User(userName, userPassword);
//
//        service.registration(user);
//
//        System.out.println("User Successfully registered");
//    }
//
//    public void selectMyBooks(){
//        System.out.println(service.selectMyBooks());
//
//    }
//
//
//    public boolean userLogin() throws IOException {
//        System.out.println("NAME:");
//        String userName = read.readLine();
//        System.out.println("PASSWORD:");
//        String userPassword = read.readLine();
//
//
//        if (service.userLogin(userName, userPassword) != null) {
//            userId = service.userLogin(userName, userPassword).getId();
//            return true;
//        } else {
//            return false;
//
//        }
//    }
//
//    public void addBook() throws IOException {
//        System.out.println("Enter title");
//        String title = read.readLine();
//        System.out.println("Enter Author");
//        String author = read.readLine();
//        String status = "not booked";
//
//        Book book = new Book(title, author, status);
//
//        service.addBook(book);
//    }
//
//    public void addLibrary() throws IOException {
//        System.out.println("Enter name of the Library Building");
//        String libName = read.readLine();
//        System.out.println("Enter street name");
//        String street = read.readLine();
//        System.out.println("Enter building number");
//        Integer buildingNo = Integer.valueOf(read.readLine());
//
//        Address address = new Address();
//        address.setStreet(street);
//        address.setBuildingNo(buildingNo);
//
//        Library library = new Library();
//        library.setName(libName);
//        library.setAddress(address);
//
//        address.setLibrary(library);
//
//        service.addLibrary(address);
//
//    }
//
//
//    public void deleteBook() throws IOException {
//        System.out.println("Enter id of the Book");
//        Long bookId = Long.valueOf(read.readLine());
//        service.deleteBook(bookId);
//    }
//
//    public void issueBook() throws IOException {
//        System.out.println("Enter Id of the Book");
//        Long bookId = Long.valueOf(read.readLine());
//        Book book = new Book("booked");
//
//        service.issueBook(bookId, book, userId);
//
//        this.eventPublisher.publishEvent(new LibraryEvent(this, userId, "issued book"));
//
//    }
//
//    public void returnBook() throws IOException {
//        System.out.println("Enter id of the Book");
//        Long bookId = Long.valueOf(read.readLine());
//
//        Book book = new Book("not booked");
//
//        service.returnBook(bookId, book);
//
//        this.eventPublisher.publishEvent(new LibraryEvent(this, userId, "returned book"));
//    }
//
//    public void selectAvailableOnes(){
//        System.out.println("Available Books" + service.selectAvailableBooks());
//    }
//
//    public void selectNotAvailableOnes(){
//        System.out.println("Already issued Books: " + service.selectNotAvailableBooks());
//    }
//
//    public void selectByAuthor() throws IOException {
//        System.out.println("Enter author name");
//        String author = read.readLine();
//        System.out.println(service.selectBookByAuthor(author));
//    }
//
//    public void selectById() throws IOException {
//        System.out.println("Enter id of the Book");
//        Long id = Long.valueOf(read.readLine());
//        System.out.println(service.selectBookById(id));
//    }
//
//    public void selectByTitle() throws IOException {
//        System.out.println("Enter title");
//        String title = read.readLine();
//        System.out.println(service.selectBookByTitle(title));
//    }
//
//    public void displayLibrary(){
//        System.out.println(service.displayLibrary());
//    }
//
//    @Override
//    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//        this.eventPublisher = applicationEventPublisher;
//    }
//}
