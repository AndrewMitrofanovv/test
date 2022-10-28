package com.spring.example.web.service;

import com.spring.example.web.DAO.UserDAOImpl;
import org.springframework.transaction.annotation.Transactional;
import com.spring.example.web.DAO.UserDAO;
import com.spring.example.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();



    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public User findUser(Integer id) {
        return userDAO.findUser(id);
    }
}
