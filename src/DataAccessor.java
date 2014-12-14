import java.util.ArrayList;

/**
 * Created by Nastassia on 14.12.2014.
 */
public class DataAccessor
{
    ArrayList<User> users;

    public DataAccessor()
    {
        users = new ArrayList<User>();

        User user1 = new User("Mike", "qwerty", Position.CLERK);
        users.add(user1);
        User user2 = new User("Paul", "qwerty123", Position.SELLER);
        users.add(user2);
        User user3 = new User("John", "qwerty123456", Position.MANAGER);
        users.add(user3);
    }

    public boolean checkUser(User user)
    {
        if (users.contains(user))
        {
            user.setPosition(users.get(users.indexOf(user)).getPosition());
            return  true;
        }
        else
        {
            return  false;
        }
    }

}
