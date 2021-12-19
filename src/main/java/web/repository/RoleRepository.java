package web.repository;

import web.models.Role;
import web.models.User;

import java.util.List;

public interface RoleRepository {

    Role getRoleByName(String name);
    Role getRoleById(Long id);
    List<Role> allRoles();
    Role getDefaultRole();
}
