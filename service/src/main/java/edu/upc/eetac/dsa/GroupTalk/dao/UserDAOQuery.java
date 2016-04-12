package edu.upc.eetac.dsa.GroupTalk.dao;

/**
 * Created by hixam on 16/10/15.
 */
public class UserDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";//genera el identificador de usuario
    public final static String CREATE_USER = "insert into users (id, loginid, password) values (UNHEX(?), ?, UNHEX(MD5(?)));";
    public final static String ASSIGN_ROLE_REGISTERED = "insert into user_roles (userid, role) values (UNHEX(?), 'registered')";
    public final static String ASSIGN_ROLE_ADMIN = "insert into user_roles (userid, role) values (UNHEX(?), 'admin')";
    //public final static String GET_ROLE_ADMIN="select role as role from user_roles where userid=unhex(?)";
    public final static String GET_USER_BY_ID = "select hex(u.id) as id, u.loginid from users u where id=unhex(?)";
    public final static String GET_USER_BY_USERNAME = "select hex(u.id) as id, u.loginid from users u where u.loginid=?";
    public final static String DELETE_USER = "delete from users where id=unhex(?)";
    public final static String GET_PASSWORD =  "select hex(password) as password from users where id=unhex(?)";
}

//UNHEX Convierte de hexadecimal a binario. HEX viceversa
//MD5 calcula la función de hash sobre el argumento pasado como parametro