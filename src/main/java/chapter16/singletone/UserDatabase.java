package chapter16.singletone;

public interface UserDatabase {
    User readUser(String userName);
    void writeUser(User user);
}
