package model;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Comparator;


@Data
@Builder
@ToString
public class User {

    private long id;
    private String name;
    private String mobile;
    private String email;
    private int customerReference;

    public static Comparator<User> customerReferenceComparator = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            return (user2.getCustomerReference() < user1.getCustomerReference() ? -1 :
                    (user2.getCustomerReference() == user1.getCustomerReference() ? 0 : 1));
        }
    };

    public static Comparator<User> nameComparator = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            return (int) (user1.getName().compareTo(user2.getName()));
        }
    };

}
