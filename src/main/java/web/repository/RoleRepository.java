package web.repository;

import web.models.Role;
import web.models.User;

import java.util.HashSet;
import java.util.List;

public interface RoleRepository {

    List <Role> getAllRoles();
    Role getRoleByName(String name);
    HashSet<Role> getSetOfRoles(String[] roleNames);

}
