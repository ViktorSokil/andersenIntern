package com.sokil.dao;

import java.sql.SQLException;


public interface IRoleDAO {
    void saveRole(String role) throws SQLException;
}
