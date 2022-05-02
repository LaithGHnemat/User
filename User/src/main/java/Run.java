import lombok.extern.java.Log;
import reader.FileReader;
import reader.JsonReader;
import printer.UserPrinter;
import printer.UserPrinterImpl;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import validators.EmailValidator;
import validators.UserValidator;
import validators.impl.EmailValidatorImpl;
import validators.impl.UserValidatorImpl;

import java.io.IOException;
import java.util.Scanner;

@Log
public class Run {

    private static final int ONE = 1;
    private static final int TOW = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        log.info("Invoking method run in main class to start run the programme");
        FileReader fileReader = new JsonReader();
        EmailValidator emailValidator = new EmailValidatorImpl();
        UserValidator userValidator = new UserValidatorImpl(emailValidator);
        UserRepository userRepo = new UserRepositoryImpl(fileReader);
        UserPrinter userPrinter = new UserPrinterImpl(userRepo, emailValidator, userValidator);
        displayWindow(userPrinter);
    }

    private static void displayWindow(UserPrinter userPrinter) {
        while (true) {
            try {
                mainMenu();
                Scanner input = new Scanner(System.in);
                int number = input.nextInt();
                if (number == ONE)
                    partOne(userPrinter);
                else if (number == TOW)
                    partTow(userPrinter);
                else if (number == THREE)
                    partThree(userPrinter);
                else if (number == FOUR)
                    partFour(userPrinter);
                else if (number == FIVE)
                    partFive(userPrinter);
                else if (number == SIX)
                    partSix(userPrinter);
                else if (number == SEVEN)
                    partSeven(userPrinter);
                else if (number == EIGHT)
                    System.exit(0);
                else System.out.println("Please enter form 1 to 8 just");

            } catch (Exception ignore) {
            }
        }
    }

    private static void mainMenu() {
        System.out.println("");
        System.out.println("Choose the number of question you wanna see its result");
        System.out.println("1. Sort and Print the users based on Customer Reference Number");
        System.out.println("2. With Customer Reference Number as input; Print Name, Mobile & Email");
        System.out.println("3. Print Users with valid Email ID");
        System.out.println("5. Print duplicate Users");
        System.out.println("4. Print Users in alphabetical order.");
        System.out.println("6. Sort Users in alphabetical order and Print Users removing duplication");
        System.out.println("7. Print just users with valid data ");
        System.out.println("8. Exit");
    }

    private static void partOne(UserPrinter userPrinter) {
        System.out.println("Q1 part 6) Sort Users in alphabetical" +
                " order and Print Users removing duplication");
        userPrinter.sortAndPrintUsers();
    }

    private static void partTow(UserPrinter userPrinter) throws IOException {
        System.out.println("Q1 part2) With Customer Reference Number as input;" +
                " Print Name, Mobile and Email, the solution is");
        userPrinter.printUserByCustomerReference(104582);
    }

    private static void partThree(UserPrinter userPrinter) {
        System.out.println("Q1 part3) Print Users with valid Email ID");
        userPrinter.printUsersValidEmail();
    }

    private static void partFour(UserPrinter userPrinter) {
        System.out.println("Q1 part 4) Print Users in alphabetical order");
        userPrinter.printInAlphabetOrder();
    }

    private static void partFive(UserPrinter userPrinter) {
        System.out.println("Q1 part 5) Print duplicate Users");
        userPrinter.printDuplicateUsers();
    }

    private static void partSix(UserPrinter userPrinter) {
        System.out.println("Q1 part 6) Sort Users in alphabetical" +
                " order and Print Users removing duplication");
        userPrinter.printWithoutDuplicateUsers();
    }

    private static void partSeven(UserPrinter userPrinter) {
        System.out.println("Q! part 7 extra) Print just users with valid data ");
        userPrinter.printJustValidUsers();
    }
}
