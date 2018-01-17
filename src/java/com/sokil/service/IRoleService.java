package com.sokil.service;

import com.sokil.dto.UserDTO;

import java.sql.SQLException;

public interface IRoleService {
    void saveRole(UserDTO user) throws SQLException;
}
