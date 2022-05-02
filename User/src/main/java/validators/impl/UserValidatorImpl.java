package validators.impl;

import exceptions.*;
import lombok.extern.java.Log;
import model.User;
import validators.EmailValidator;
import validators.UserValidator;

/*
    this is just a dummy implementation for the Validator
    you can add or remove depending on the business logic
    I created it like this because it's not mentioned
    the type of rules that you expect

   */
    /*
     we can also make all the methods return
     boolean in case we just need to check either this
     object valid or not before store it

     */
@Log
public class UserValidatorImpl implements UserValidator {


    private EmailValidator emailValidator;

    public UserValidatorImpl(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    public void validateUser(User user) {
        isNullUser(user);
        validateId(user.getId());
        validateName(user.getName());
        validateMobile(user.getMobile());
        validateEmail(user.getEmail());
        validateCustomerReference(user.getCustomerReference());
    }

    private void isNullUser(User user) {
        log.info("Invoking isNullUser method in class UserValidatorImpl!!");
        if (user == null) {
            log.warning("user is null !!");
            throw new NullUserException("The user Cant be null");
        }
    }

    private void validateId(long id) {
        log.info("Invoking validateId method in class UserValidatorImpl!!");
        if (id < 100 || id > 2000000) {
            log.warning("invalid Id!!");
            throw new InvalidIdException("The Id not as supposed to be");
        }
    }

    private void validateName(String name) {
        log.info("Invoking validateName method in class UserValidatorImpl!!");
        if (name == null) {
            log.warning("Name can't be null!!");
            throw new InvalidNameException("The name can't be null");
        } else if (name.isEmpty()) {
            log.warning("Name can't be Empty!!");
            throw new InvalidNameException("The name can't be Empty");
        } else if (name.length() < 2) {
            log.warning("Name can't be less than 2 digits!!");
            throw new InvalidNameException("The length of the name can't be less than 2 digits");
        } else if (name.length() > 15) {
            log.warning("Name length can't be less than more than 10 digist!!");
            throw new InvalidNameException("The length of the name can't be more than 10 digits");
        }
    }

    private void validateMobile(String mobile) {
        log.info("Invoking validateMobile method in class UserValidatorImpl!!");
        if (mobile == null) {
            log.warning("Mobile can't be less than 1 digit!!");
            throw new InvalidMobileException("The mobile can't be null");
        } else if (mobile.isEmpty()) {
            log.warning("Mobile can't be be empty!!");
            throw new InvalidMobileException("The mobile can't be empty");
        } else if (mobile.length() > 13 || mobile.length() < 9) {
            log.warning("Mobile can't be be in this length!!");
            throw new InvalidMobileException("The mobile can't be with this length");
        }
    }

    private void validateEmail(String email) {
        log.info("Invoking validateEmail method in class UserValidatorImpl!!");
        if (email == null){
            log.warning("Email can't be null!!");
            throw new InvalidEmailException("The email can't be null");
        }
        else if (email.isEmpty()){
            log.warning("Email can't be empty!!");
            throw new InvalidEmailException("The email can't be empty");
        }
        else if (!emailValidator.isValidEmail(email)) {
            log.warning("Email is invalid!!");
            throw new InvalidEmailException("The email is invalid");
        }
    }
    private void validateCustomerReference(int customerReference) {
        log.info("Invoking validateCustomerReference method in class UserValidatorImpl!!");
        if (customerReference > 999999 || customerReference < 999) {
            log.warning("The customerReference is not in out of the range!!");
            throw new InvalidCustomerReferenceException("The customerReference is not in out of the range");
        }
    }
}
