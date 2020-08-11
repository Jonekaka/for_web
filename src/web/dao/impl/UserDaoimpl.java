package web.dao.impl;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.dao.UserDao;
import web.domain.User;
import web.util.JDBCUtils;
import java.util.List;

public class UserDaoimpl implements UserDao{
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//@Test
    public List<User> findAll() {
//    public void findAll() {

//        使用dao查询
        String sql="select * from user";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
//        System.out.println(userList+"doa执行结果");
        return userList;
    }
    @Override
    /**
    *@Description: 登录验证
    *@Param: [username, password]
    *@Return: web.domain.User
    */
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
//            没有查询到返回空
            return null;
        }
    }

    @Override
    /**
    *@Description: 添加用户操作数据库方法
    *@Param: [user]
    *@Return: void
    */
    public void addUser(User user) {
//        id,用户名，密码省略
        String sql="insert into user value(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }
}
