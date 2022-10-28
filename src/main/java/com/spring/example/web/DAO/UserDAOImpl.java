package com.spring.example.web.DAO;

import com.spring.example.web.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;


@Transactional
public class UserDAOImpl implements UserDAO {

//    @PersistenceContext(unitName = "pun")
//    private EntityManager entityManager;




    @PersistenceContext(unitName = "pun")
    EntityManager entityManager;


    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void delete(Integer id) {
        User user = findUser(id);
        if (user == null) {
            System.err.println("Пользователь не найден");
        }
        entityManager.remove(user);
        entityManager.flush();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User findUser(Integer id) {
        return entityManager.find(User.class, id);
    }
}
