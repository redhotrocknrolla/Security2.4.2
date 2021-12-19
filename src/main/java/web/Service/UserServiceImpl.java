package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.repository.UserRepository;
import web.models.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> index() {
        return userRepository.index();
    }

    @Override
    public User show(int id) {
        return userRepository.show(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(int id,User updateUser) {
        userRepository.update(id,updateUser);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }
}
