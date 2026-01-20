import java.util.*;

public class BackendService
{
    static HashMap<Integer,User> users=new HashMap<>();

    public static void addUser(User u)
    {
        users.put(u.id,u);
    }

    public static User getUser(int id)
    {
        return users.get(id);
    }

    public static void deleteUser(int id)
    {
        users.remove(id);
    }

    public static Collection<User> getAllUsers()
    {
        return users.values();
    }

}