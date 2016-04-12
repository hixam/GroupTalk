package edu.upc.eetac.dsa.GroupTalk.dao;

import edu.upc.eetac.dsa.GroupTalk.entity.User;

import java.sql.SQLException;

/**
 * Created by hixam on 16/10/15.
 */
public interface UserDAO {
    public User createUser(String loginid, String password) throws SQLException, UserAlreadyExistsException; //crea en la base de datos un usuario con rol registered

    //public User updateProfile(String id, String email, String fullname) throws SQLException;

    public User getUserById(String id) throws SQLException;

    public User getUserByLoginid(String loginid) throws SQLException;

    public boolean deleteUser(String id) throws SQLException;

    public boolean checkPassword(String id, String password) throws SQLException;

}
