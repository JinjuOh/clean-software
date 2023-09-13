package chapter16.singletone;

public class UserDatabaseSource implements UserDatabase {
    private static UserDatabase theInstance = new UserDatabaseSource();

    public static UserDatabase instance() {
        return theInstance;
    }

    @Override
    public User readUser(String userName) {
        return null;
    }

    @Override
    public void writeUser(User user) {

    }
}
