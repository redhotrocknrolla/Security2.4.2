package web.repository;

import web.models.User;
import java.util.List;

public interface UserRepository {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id,User updateUser);
    void delete(int id);
}
