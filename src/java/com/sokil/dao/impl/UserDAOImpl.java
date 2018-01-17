package com.sokil.dao.impl;


import com.sokil.dao.IUserDAO;
import com.sokil.entity.User;
import com.sokil.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository("userDAO")
public class UserDAOImpl implements IUserDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_USER = "INSERT INTO users (user_name, user_password) VALUES (?, ?)";
    private static final String INSERT_USERS_ROLES = "INSERT INTO users_roles (user_id, role_id) VALUES (?, ?)";
    private static final String UPDATE_USERS = "UPDATE users SET user_password = ? WHERE user_id = ?";
    private static final String SELECT_USER = "SELECT Users.user_id, users.user_name, roles.role\n" +
                                                "FROM users, roles, users_roles\n" +
                                                "WHERE users.user_id = users_roles.user_id AND \n" +
                                                "roles.role_id = users_roles.role_id\n" +
                                                "ORDER BY user_id;";
    private static final String SELECT_USER_ID = "SELECT user_id FROM users WHERE user_name = ";

    public void saveUser(User user) throws SQLException{
        Long userId = getUserId(user);
        if (userId == null) {
            jdbcTemplate.update(INSERT_USER,
                    user.getUserName(),
                    user.getUserPassword());
        }else {
            jdbcTemplate.update(UPDATE_USERS,
                    user.getUserPassword(),
                    userId);
        }

        userId = getUserId(user);
        for (String role: user.getRoles()){
            Long roleId = Util.getRoleId(role, jdbcTemplate);
            if (!isPareExist(userId, roleId)){
                jdbcTemplate.update(INSERT_USERS_ROLES,
                        userId,
                        roleId);
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Map<Long, User> map = new HashMap<>();

        List<User> list = jdbcTemplate.query(SELECT_USER, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserId(rs.getLong("user_id"));
                user.setUserName(rs.getString("user_name"));
                Set<String> roles = new HashSet<>();
                roles.add(rs.getString("role"));
                user.setRoles(roles);
                return user;
            }
        });

        for (User user: list){
            if (!map.containsKey(user.getUserId())){
                map.put(user.getUserId(), user);
            }else {
                User userInMap = map.get(user.getUserId());
                Set<String> roles = userInMap.getRoles();
                roles.addAll(user.getRoles());
                user.setRoles(roles);
                map.put(user.getUserId(), user);
            }
        }
        list.addAll(map.values());
        return list;
    }

    private Long getUserId(User user) throws SQLException {
        return jdbcTemplate.query(
                SELECT_USER_ID+"'"+user.getUserName()+"'", new ResultSetExtractor<Long>() {

                    @Override
                    public Long extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        if (resultSet.next()) {
                            return resultSet.getLong("user_id");
                        }
                        return null;
                    }
                });
    }

    private boolean isPareExist(Long userId, Long roleId) throws SQLException {
        return jdbcTemplate.query(
                "SELECT * FROM users_roles WHERE user_id = '"+userId+"' AND role_id = '"+roleId+"'"
                , new ResultSetExtractor<Boolean>(){

                    @Override
                    public Boolean extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        if(resultSet.next()){
                            return true;
                        }
                        return false;
                    }
                });
    }
}
