package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;


@Component
public class UsersDaoImpl implements UserDao{
    private static int USERS_COUNT;
    private List <User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USERS_COUNT, "Tom"));
        users.add(new User(++USERS_COUNT, "Bob"));
        users.add(new User(++USERS_COUNT, "Mike"));
        users.add(new User(++USERS_COUNT, "Katy"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).
                findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }
    public void update(int id,User updateUser) {
        User userToBeUpdate = show(id);
        userToBeUpdate.setName(updateUser.getName());
    }
    public void delete(int id) {
        users.removeIf(u -> u.getId() == id );
    }
}
