//package org.example.Service;
//
//import org.example.entity.*;
//import org.example.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ServiceImpl {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Autowired
//    private LibraryRepository libraryRepository;
//
//    @Autowired
//    private AddressRepository addressRepository;
//
//    public Admin adminLogin(String name, String password) {
//        return adminRepository.findByUserNameAndPasswordAdmin(name, password);
//    }
//
//    public User userLogin(String name, String password) {
//        return userRepository.findByUserNameAndPasswordUser(name, password);
//    }
//
//    public void registration(User user) {
//        userRepository.save(user);
//    }
//
//    public void addBook(Book book) {
//        bookRepository.save(book);
//    }
//
//    public void issueBook(Long id, Book book, Long user_id) {
//        Optional<Book> bookOptional = bookRepository.findById(id);
//
//        if (bookOptional.isPresent()) {
//
//            if (bookOptional.get().getUserId() != null) {
//                System.out.println("This book is already booked");
//                return;
//            }
//            System.out.println("You successfully issued");
//            Book updatedBook = bookOptional.get();
//            updatedBook.setStatus(book.getStatus());
//            updatedBook.setUserId(user_id);
//
//            bookRepository.save(updatedBook);
//        }
//    }
//
//    public void returnBook(Long bookId, Book book) {
//        Optional<Book> bookOptional = bookRepository.findById(bookId);
//
//        if (bookOptional.isPresent()) {
//            Book updatedBook = bookOptional.get();
//            updatedBook.setStatus(book.getStatus());
//            updatedBook.setUserId(null);
//
//            bookRepository.save(updatedBook);
//        }
//    }
//
//    public Optional<Book> selectBookById(Long id) {
//        return bookRepository.findById(id);
//    }
//
//    public List<Book> selectBookByAuthor(String author) {
//        return bookRepository.findByAuthor(author);
//    }
//
//    public Book selectBookByTitle(String title) {
//        return bookRepository.findByTitle(title);
//    }
//
//    public List<Book> selectAvailableBooks() {
//        return bookRepository.findAvailableOnes("not booked");
//    }
//
//    public List<Book> selectNotAvailableBooks() {
//        return bookRepository.findAvailableOnes("booked");
//    }
//
//    public List<User> selectMyBooks() {
//        return userRepository.findAll();
//    }
//
//    public void deleteBook(Long id) {
//        bookRepository.deleteById(id);
//    }
//
//    public List<Library> displayLibrary(){
//        return libraryRepository.findAll();
//    }
//
//    public void addLibrary(Address address){
//        addressRepository.saveAndFlush(address);
//    }
//
//
//
//
//}
