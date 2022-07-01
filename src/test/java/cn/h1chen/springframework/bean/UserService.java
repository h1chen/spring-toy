package cn.h1chen.springframework.bean;

/**
 * @author h1chen
 */
public class UserService {
    private String name;
    private UserDao userDao;
    private String userId;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(userId));
    }

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
