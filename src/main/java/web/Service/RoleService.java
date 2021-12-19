package web.Service;

import web.models.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);
    Role getRoleById(Long id);
    List<Role> allRoles();
    Role getDefaultRole();
}
