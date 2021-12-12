package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@ComponentScan("config")
public class UsersDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UsersDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    public List<User> index() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }
    @Transactional
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Transactional
    public void update(int id, User updatedUser) {
        User userToBeUpdated =  entityManager.getReference(User.class,id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setId(updatedUser.getId());
    }

    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
