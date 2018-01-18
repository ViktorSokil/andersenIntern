package com.sokil.dao.impl;


import com.sokil.dao.IUserDAO;
import com.sokil.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements IUserDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user) {
        currentSession().saveOrUpdate(user);
    }

    public List<User> getAllUsers() {
        CriteriaBuilder criteriaBuilder = currentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        CriteriaQuery<User> all = criteriaQuery.select(root);
        TypedQuery<User> allQuery = currentSession().createQuery(all);
        return allQuery.getResultList();
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    private CriteriaBuilder getCriteriaBuilder(){
        return currentSession().getCriteriaBuilder();
    }
}
