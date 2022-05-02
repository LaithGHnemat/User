package printer;

import java.io.IOException;

public interface UserPrinter {

    void sortAndPrintUsers();

    void printUserByCustomerReference(int customerReference) throws IOException;

    void printUsersValidEmail();

    void printInAlphabetOrder();

    void printDuplicateUsers();

    void printWithoutDuplicateUsers();

    void printJustValidUsers();
}
