package com.sokil.dao.impl;


import com.sokil.dao.IUserDAO;
import com.sokil.entity.User;
import com.sokil.utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDAOImpl implements IUserDAO{
    private PreparedStatement saveStatement;
    private PreparedStatement updateStatment;
    private PreparedStatement selectStatment;
    private PreparedStatement saveBindingStatement;
    private PreparedStatement selectUserIdStatement;
    private PreparedStatement isPareExistStatement;

    private Connection connection;

    public UserDAOImpl(Connection connection) throws SQLException{
        this.connection = connection;

        saveStatement = connection.prepareStatement(
                "INSERT INTO users (user_name, user_password) VALUES (?, ?)");

        saveBindingStatement = connection.prepareStatement("INSERT INTO users_roles (user_id, role_id) VALUES (?, ?)");

        updateStatment = connection.prepareStatement("UPDATE users SET user_password = ?"+
                " WHERE user_id = ?");

        selectStatment = connection.prepareStatement(
                "SELECT Users.user_id, users.user_name, roles.role\n" +
                        "FROM users, roles, users_roles\n" +
                        "WHERE users.user_id = users_roles.user_id AND \n" +
                        "roles.role_id = users_roles.role_id\n" +
                        "ORDER BY user_id;"
        );

        selectUserIdStatement = connection.prepareStatement(
                "SELECT user_id FROM users WHERE user_name = ?");


        isPareExistStatement = connection.prepareStatement("SELECT * FROM users_roles " +
                "WHERE user_id = ? AND role_id = ?");
    }

    public void saveUser(User user) throws SQLException{
        Long userId = getUserId(user);
        if (userId == null) {
            saveStatement.setString(1, user.getUserName());
            saveStatement.setString(2, user.getUserPassword());
            saveStatement.execute();
        }else {
            updateStatment.setString(1, user.getUserPassword());
            updateStatment.setLong(2, userId);
            updateStatment.executeUpdate();
        }

        userId = getUserId(user);
        for (String role: user.getRoles()){
            Long roleId = Util.getRoleId(role, connection);
            if (!isPareExist(userId, roleId)){
                saveBindingStatement.setLong(1, userId);
                saveBindingStatement.setLong(2, roleId);
                saveBindingStatement.executeUpdate();
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> list = new ArrayList<>();
        Map<Long, User> map = new HashMap<>();

        ResultSet rs = selectStatment.executeQuery();
        while(rs.next()){
            Long id  = rs.getLong("user_id");
            String name = rs.getString("user_name");
            String role = rs.getString("role");
            Set<String> roles = new HashSet<>();
            User user = new User();
            if (!map.containsKey(id)){
                user.setUserId(id);
                user.setUserName(name);
                roles.add(role);
                user.setRoles(roles);
                map.put(id, user);
            }else {
                user = map.get(id);
                roles = user.getRoles();
                roles.add(role);
                user.setRoles(roles);
                map.put(id, user);
            }
        }
        list.addAll(map.values());
        rs.close();
        return list;
    }

    private Long getUserId(User user) throws SQLException {
        selectUserIdStatement.setString(1, user.getUserName());
        ResultSet resultSet = selectUserIdStatement.executeQuery();
        if (resultSet.next()){
            return  resultSet.getLong(1);
        }
        resultSet.close();
        return null;
    }

    private boolean isPareExist(Long userId, Long roleId) throws SQLException {
        isPareExistStatement.setLong(1, userId);
        isPareExistStatement.setLong(2, roleId);
        ResultSet resultSet = isPareExistStatement.executeQuery();
        if (resultSet.next()){
            return true;
        }
        return false;
    }
}
