package printer;

import lombok.extern.java.Log;

import model.User;
import repository.UserRepository;
import validators.EmailValidator;
import validators.UserValidator;

import java.io.IOException;
import java.util.*;

@Log
public class UserPrinterImpl implements UserPrinter {


    private final UserRepository userRepo;
    private  final List<User> userList;
    private final EmailValidator emailValidator;
    private final UserValidator userValidator;


    public UserPrinterImpl(UserRepository userRepo, EmailValidator emailValidator, UserValidator userValidator) {
        this.userRepo = userRepo;
        this.emailValidator = emailValidator;
        this.userValidator = userValidator;
        userList =userRepo.getAll();
    }

    @Override
    public void sortAndPrintUsers() {
        log.info("Invoking sortAndPrintUsers method in class UserPrinterImpl");
        userList.sort(User.customerReferenceComparator);
        for (User u : userList) {
            System.out.println(u);
        }
    }

    @Override
    public void printUserByCustomerReference(int customerReference) throws IOException {
        log.info("Invoking printUserByCustomerReference method in class UserPrinterImpl ");
        User user = userRepo.getUserByCustomerReference(customerReference);
        System.out.println(user);
    }

    @Override
    public void printUsersValidEmail() {
        log.info(" Invoking printUsersValidEmail method in class UserPrinterImpl");
        for (User user : userList) {
            if (emailValidator.isValidEmail(user.getEmail())) {
                  System.out.println(user);
            }
        }
    }

    @Override
    public void printInAlphabetOrder() {
        log.info("Invoking printInAlphabetOrder method in class UserPrinterImpl");
        userList.sort(User.nameComparator);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public void printDuplicateUsers() {
        log.info("Invoking printDuplicateUsers method in class UserPrinterImpl");
        Map<Integer, User> map = new TreeMap<>();
        for (User user : userList) {
            if (!map.containsKey(user.getCustomerReference()))
                map.put(user.getCustomerReference(), user);
            else {
                System.out.println(user);
            }
        }
    }

    @Override
    public void printWithoutDuplicateUsers() {
        log.info("Invoking printWithoutDuplicateUsers method in class UserPrinterImpl");
        Map<Integer, User> map = new TreeMap<>();
        userList.sort(User.nameComparator);
        for (User user : userList) {
            if (!map.containsKey(user.getCustomerReference())) {
                map.put(user.getCustomerReference(), user);
                System.out.println(user);
            }
        }
    }

    @Override
    public void printJustValidUsers() {
        log.info("Invoking printJustValidUsers");
        for (User user : userList) {
            try {
                userValidator.validateUser(user);
                System.out.println(user);
            }
            catch (Exception e) {
                log.info(e.getMessage()+" for user :" +user);
            }
        }
    }
}
