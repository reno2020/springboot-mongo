package org.throwable.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.throwable.Application;
import org.throwable.entity.User;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/16 16:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testCreateCollection()throws Exception{
        userDao.createCollection(User.class);
    }

    @Test
    public void testSaveUser() throws Exception {
        User u = new User();
        u.setId(2L);
        u.setAge(24);
        u.setBirth(new Date());
        u.setName("zjc2");
        u.setEmail("@163.com");
        userDao.save(u);
    }

    @Test
    public void testFindById()throws Exception{
        User u  = userDao.findById(1L);
        Assert.assertEquals(u.getName(),"zjc");
    }
}