//package org.example;
//
//import org.example.config.SpringConfig;
//import org.example.controller.MyController;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class LibrarySystem {
//    private static Boolean bool = true;
//    private static Boolean userBool = true;
//    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//
//
//    public static void main(String[] args) throws IOException {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//                SpringConfig.class
//        );
//
//        MyController controller = context.getBean("myController", MyController.class);
//
//        System.out.println("WELCOME TO MY APPLICATION");
//        System.out.println("1. To Login as a ADMIN");
//        System.out.println("2. To Login as an User");
//        System.out.println("3. To Register as an User");
//        String adminOrUser = read.readLine();
//
//
//        if (adminOrUser.equals("1")) {
//            if (controller.adminLogin()) {
//
//
//                System.out.println("WELCOME BACK ADMIN:");
//                while (bool) {
//                    System.out.println("1. TO Display AVAILABLE BOOKS");
//                    System.out.println("2. TO ADD NEW BOOK");
//                    System.out.println("3. TO Display Not AVAILABLE BOOKS");
//                    System.out.println("4. To Display Library");
//                    System.out.println("5. To Add New Library");
//                    System.out.println("0. To Quit");
//                    String choice = read.readLine();
//
//                    switch (choice) {
//                        case "1":
//                            controller.selectAvailableOnes();
//                            break;
//                        case "2":
//                            controller.addBook();
//                            break;
//                        case "3":
//                            controller.selectNotAvailableOnes();
//                            break;
//                        case "4":
//                            controller.displayLibrary();
//                            break;
//                        case "5":
//                            controller.addLibrary();
//                            break;
//                        default:
//                            bool = false;
//
//
//                    }
//                }
//            } else
//                System.out.println("WRONG NAME OR PASSWORD");
//
//
//        } else if (adminOrUser.equals("2")) {
//
//
//            if (controller.userLogin()) {
//
//                System.out.println("HELLO USER");
//
//                while (userBool) {
//                    System.out.println("1. To Display my Books");
//                    System.out.println("2. To Display Available Books");
//                    System.out.println("3. To Issue Book");
//                    System.out.println("4. To Return Book");
//                    System.out.println("5. To find book by id");
//                    System.out.println("6. To find book by title");
//                    System.out.println("7. To find book by author");
//                    System.out.println("0. To Quit");
//                    String choice = read.readLine();
//
//                    switch (choice) {
//                        case "1":
//                            controller.selectMyBooks();
//                            break;
//                        case "2":
//                            controller.selectAvailableOnes();
//                            break;
//                        case "3":
//                            controller.issueBook();
//                            break;
//                        case "4":
//                            controller.returnBook();
//                            break;
//                        case "5":
//                            controller.selectById();
//                            break;
//                        case "6":
//                            controller.selectByTitle();
//                            break;
//                        case "7":
//                            controller.selectByAuthor();
//                            break;
//                        default:
//                            userBool = false;
//                    }
//                }
//
//            } else
//                System.out.println("WRONG NAME OR PASSWORD");
//
//        } else if (adminOrUser.equals("3")) {
//            controller.userRegister();
//        } else
//            System.out.println("exit");
//
//
//    }
//}
