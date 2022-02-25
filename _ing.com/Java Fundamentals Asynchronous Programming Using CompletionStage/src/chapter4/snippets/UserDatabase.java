package chapter4.snippets;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    public static List<User> readUsers(List<Long> IDs) {
        // Make database call here...
        User isabella = new User(IDs.get(0),"Isabella");
        User kim = new User(IDs.get(1), "Kim");
        User miel = new User(IDs.get(2),"Miel");

        List<User> users = new ArrayList<>();
        users.add(isabella);
        users.add(kim);
        users.add(miel);

        return users;
    }

}
