package com.sokil.dao.impl;


import com.sokil.dao.IRoleDAO;
import com.sokil.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("roleDAO")
@Transactional
public class RoleDAOImpl implements IRoleDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public void saveRole(Role role) {
        currentSession().saveOrUpdate(role);
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}
