package io.zbc.uu.book.config;

import io.zbc.uu.book.dao.IGoodsInfoDao;
import io.zbc.uu.book.dao.IUserDao;
import io.zbc.uu.book.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class InitializeConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IGoodsInfoDao goodsInfoDao;

    @Autowired
    private IUserDao userDao;

    @Value("${price-list.auth.user-name:admin}")
    private String userName;

    @Value("${price-list.auth.password:admin}")
    private String password;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createTables();
        initDefaultAuth();
    }

    private void createTables() {
        goodsInfoDao.createGoodsInfoTable();
        userDao.createUserTable();
    }

    @Transactional
    public void initDefaultAuth() {
        User user = buildDefaultUser();
        User existUser = userDao.selectUserByName(userName);
        if (existUser != null) {
            user.setUserId(existUser.getUserId());
        } else {
            userDao.insertUser(user);
        }
    }

    private User buildDefaultUser() {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return user;
    }

}
