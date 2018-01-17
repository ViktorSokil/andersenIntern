package com.sokil.dao.impl;


import com.sokil.dao.IRoleDAO;
import com.sokil.utils.Util;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@AllArgsConstructor
public class RoleDAOImpl implements IRoleDAO{
    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_ROLES = "INSERT INTO roles (role) VALUES (?)";

    public void saveRole(String role) throws SQLException {
        Long roleId = Util.getRoleId(role, jdbcTemplate);
        if (roleId == null){
            jdbcTemplate.update(INSERT_ROLES, role);
        }
    }
}
