package web.service;

import web.domain.User;

import java.util.List;

//用户管理的用户接口
public interface UserService {
//    查询所有用户信息
/**
*@Description
*@Param
*@Return
*/
    public List<User> findAll();
//    登录方法
/**
*@Description
*@Param
*@Return
*/
User login(User user);
/**
*@Description: 添加用户数据
*@Param:
*@Return:
*/
void addUser(User user);
}
