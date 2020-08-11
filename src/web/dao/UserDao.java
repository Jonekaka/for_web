package web.dao;

import web.domain.User;

import java.util.List;

//操作用户的dao封装接口
public interface UserDao {
    public List<User> findAll();
/**
*@Description: 登录方法接口
*@Param:
*@Return:
*/
    public User findUserByUsernameAndPassword(String username, String password);
/**
*@Description: 添加用户dao接口
*@Param:
*@Return:
*/
    void addUser(User user);
}
