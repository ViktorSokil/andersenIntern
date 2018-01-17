package com.sokil.service.impl;


import com.sokil.dao.IRoleDAO;
import com.sokil.dto.UserDTO;
import com.sokil.service.IRoleService;
import com.sokil.utils.Util;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Set;

@AllArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private IRoleDAO roleDao;

    @Override
    public void saveRole(UserDTO userDTO) throws SQLException {
        String userRoles = userDTO.getRoles();
        Set<String> roles = Util.parseRoles(userRoles);
        for (String role: roles){
            roleDao.saveRole(role);
        }
    }
}
