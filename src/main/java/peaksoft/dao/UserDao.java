package peaksoft.dao;

import peaksoft.model.User;

import java.util.List;


public interface UserDao {

    //saveOrUpdate
    void saveOrUpdate(User user);

    //delete by id
    void deleteById(int id);

    //get by id
    User getById(int id);

    //delete all
    void deleteAll();

    //get all users
    List<User> getAllUsers();
}
