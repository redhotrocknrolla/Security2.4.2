package web.Service;

import web.models.User;
import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(long id);
    void createUser(User user);
    void updateUser(long id, User updatedUser);
    void deleteUser(long id);
}
