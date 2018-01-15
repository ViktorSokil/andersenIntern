package com.sokil.service;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface IRoleService {
    void saveRole(HttpServletRequest request) throws SQLException;
}
