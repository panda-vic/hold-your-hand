package org.academiadecodigo.hackaton.persistence.dao.jpa;

import org.academiadecodigo.hackaton.persistence.dao.UserDao;
import org.academiadecodigo.hackaton.persistence.model.User;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link UserDao} implementation
 */
@Repository
public class JpaUserDao extends GenericJpaDao<User> implements UserDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaUserDao() {
        super(User.class);
    }
}
