package com.sokil.service.impl;


import com.sokil.dao.IRoleDAO;
import com.sokil.service.IRoleService;
import com.sokil.utils.Util;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Set;

public class RoleServiceImpl implements IRoleService {
    private IRoleDAO roleDao;

    public RoleServiceImpl(IRoleDAO roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void saveRole(HttpServletRequest request) throws SQLException {
        String userRoles = request.getParameter("role");
        Set<String> roles = Util.parseRoles(userRoles);
        for (String role: roles){
            roleDao.saveRole(role);
        }
    }
}
