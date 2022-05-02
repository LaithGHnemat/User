package repository;

import model.User;

import java.io.IOException;
import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User getUserByCustomerReference(int customerReference) throws IOException;
}
