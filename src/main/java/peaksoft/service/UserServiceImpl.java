package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import peaksoft.dao.UserDao;
import peaksoft.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    //define dependency
    private UserDao userDao;

    //inject dependency
    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImplSF") UserDao userDao) {
        this.userDao = userDao;
    }

    //CRUD METHODS
    @Override
    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
