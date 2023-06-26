package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {

        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {

        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {

        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void editUser(User user) {

        userDao.editUser(user);
    }

    @Override
    public User getUserById(Long id) {

        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }
}

