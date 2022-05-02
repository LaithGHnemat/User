package validators.impl;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import validators.EmailValidator;

import java.util.regex.Pattern;

@Log
public class EmailValidatorImpl implements EmailValidator {
    private final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public boolean isValidEmail(String email) {
        log.info("Invoking EmailValidatorImpl in class EmailValidatorImpl");
        if (email == null) return false;
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
}
