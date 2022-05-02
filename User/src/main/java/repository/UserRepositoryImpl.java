package repository;

import exceptions.NotFoundUserException;
import exceptions.UserRetrievalException;
import lombok.extern.java.Log;
import model.User;
import reader.FileReader;


import java.io.IOException;
import java.util.List;

@Log
public class UserRepositoryImpl implements UserRepository {

    private final FileReader fileReader;

    public UserRepositoryImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }


    @Override
    public List<User> getAll() {
        try {
            return fileReader.getUsers();
        } catch (IOException e) {
            log.warning("Couldn't get users using getAll method from UserRepositoryImpl ");
            throw new UserRetrievalException("couldn't get users", e);
        }
    }

    @Override
    public User getUserByCustomerReference(int customerReference) throws IOException {
        for (User u : fileReader.getUsers()) {
            if (u.getCustomerReference() == customerReference) {
                return u;
            }
        }
        log.warning("There is no such user from getUserByCustomerReference ");
        throw new NotFoundUserException("couldn't get users");
    }
}
