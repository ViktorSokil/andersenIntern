package com.sokil.utils;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Util {

    public static Long getRoleId(String role, JdbcTemplate jdbcTemplate) throws SQLException {
        String SELECT_ROLE_ID = "SELECT role_id FROM roles WHERE role = '" + role+"'";
        return jdbcTemplate.query(
                SELECT_ROLE_ID, new ResultSetExtractor<Long>() {

                    @Override
                    public Long extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        if (resultSet.next()) {
                            return resultSet.getLong("role_id");
                        }
                        return null;
                    }
                });
    }

    public static Set<String> parseRoles(String userRoles) {
        Set<String> roles = new HashSet<>();
        String[] words = userRoles.split(" ");
        for (String word: words){
            if(!word.equals(" ") && !word.equals("")){
                roles.add(word);
            }
        }
        return roles;
    }
}

