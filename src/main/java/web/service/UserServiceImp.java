package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    @Autowired
    private UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers(int count) {
        return this.userDao.getUsers(count);
    }

    @Transactional
    @Override
    public void delete(long id) {
        this.userDao.delete(id);
    }
}
