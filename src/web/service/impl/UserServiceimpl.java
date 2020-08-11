package web.service.impl;

import web.dao.UserDao;
import web.dao.impl.UserDaoimpl;
import web.domain.User;
import web.service.UserService;

import java.util.List;
//获得所有用户数据的类
//这里实现业务逻辑
public class UserServiceimpl implements UserService {

    private UserDao dao = new UserDaoimpl();
    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
    @Override
    public User login(User user) {
        User userByUsernameAndPassword = dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        return userByUsernameAndPassword;
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }
}