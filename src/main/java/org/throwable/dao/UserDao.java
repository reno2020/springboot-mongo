package org.throwable.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.throwable.entity.User;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/16 15:57
 */
@Repository
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void createCollection(Class<?> clazz) {
        CollectionOptions collectionOptions = new CollectionOptions(100, 100, true);
        mongoTemplate.createCollection(clazz, collectionOptions);
    }

    public void save(User user) {
        mongoTemplate.insert(user);
    }

    public User findById(Long id) {
        return mongoTemplate.findById(id, User.class);
    }
}
