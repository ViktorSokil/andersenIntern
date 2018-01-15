package com.sokil.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Util {

    public static Long getRoleId(String role, Connection connection) throws SQLException {
        PreparedStatement selectStatment = connection.prepareStatement(
                "SELECT role_id FROM roles " +
                        "WHERE role = ?");
        selectStatment.setString(1, role);
        ResultSet resultSet = selectStatment.executeQuery();
        if (resultSet.next()){
            return  resultSet.getLong(1);
        }
        resultSet.close();
        return null;
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

