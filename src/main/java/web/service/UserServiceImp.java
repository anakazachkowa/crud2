package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserDao userDao;


    public UserServiceImp (UserDao userDao) {

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
    @Transactional
    public User getUserById(Long id) {

        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }
}

