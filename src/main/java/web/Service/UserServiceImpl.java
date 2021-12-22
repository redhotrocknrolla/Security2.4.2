package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Transient;
import org.springframework.stereotype.Service;
import web.repository.UserRepository;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);

    }

    @Override
    public void updateUser(long id, User updatedUser) {
        userRepository.updateUser(id,updatedUser);

    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);

    }
}
