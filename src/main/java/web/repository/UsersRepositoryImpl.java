package web.repository;


import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class UsersRepositoryImpl implements UserRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public UsersRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("from User",
                User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        TypedQuery<User> q = entityManager.createQuery(
                "select user from User user where user.id = :id", User.class
        );
        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void updateUser(long id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));

    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.name = :userName", User.class)
                .setParameter("userName", name)
                .setMaxResults(1)
                .getSingleResult();
    }
}

