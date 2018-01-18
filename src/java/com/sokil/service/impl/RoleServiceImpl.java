package com.sokil.service.impl;


import com.sokil.dao.IRoleDAO;
import com.sokil.entity.Role;
import com.sokil.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDAO roleDao;

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }
}
