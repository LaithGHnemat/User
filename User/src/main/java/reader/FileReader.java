package reader;

import model.User;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<User> getUsers() throws IOException;
}
