package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import web.models.Role;
import web.repository.RoleRepository;
import javax.transaction.Transactional;
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
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }

    @Override
    public List<Role> allRoles() {
        return roleRepository.allRoles();
    }

    @Override
    public Role getDefaultRole() {
        return roleRepository.getDefaultRole();
    }
}
