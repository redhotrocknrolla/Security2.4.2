package web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.Role;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    private final  String defaultRoleName = "ROLE_USER";
    private final  String adminRoleName = "ROLE_ADMIN";

    private EntityManager entityManager;

    @Autowired
    public RoleRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String name) {

        return entityManager.createQuery("SELECT r FROM Role r WHERE r.role = :roleName", Role.class)
                .setParameter("roleName", name)
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleNames) {
            roleSet.add(getRoleByName(role));
        }
        return (HashSet)roleSet ;
    }
    @Override
    public Role getAdminRole() {
        return getRoleByName(adminRoleName);
    }

    @Override
    public void setAdminRoleDefault() {
        Role adminRole = new Role();
        adminRole.setRole("ROLE_ADMIN");
        entityManager.persist(adminRole);

    }
    @Override
    public void setUserRoleDefault() {
        Role userRole = new Role();
        userRole.setRole("ROLE_USER");
        entityManager.persist(userRole);

    }
}
