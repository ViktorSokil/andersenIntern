package com.sokil.dao.impl;


import com.sokil.dao.IRoleDAO;
import com.sokil.utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDAOImpl implements IRoleDAO{
    private PreparedStatement saveStatement;
    private Connection connection;

    public RoleDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;

        saveStatement = connection.prepareStatement("INSERT INTO roles (role) VALUES (?)");
    }

    public void saveRole(String role) throws SQLException {
        Long roleId = Util.getRoleId(role, connection);
        if (roleId == null){
            saveStatement.setString(1, role);
            saveStatement.executeUpdate();
        }
    }


}
