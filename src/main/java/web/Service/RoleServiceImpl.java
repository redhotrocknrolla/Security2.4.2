package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.models.Role;
import web.repository.RoleRepository;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {


    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        return roleRepository.getSetOfRoles(roleNames);
    }




}
