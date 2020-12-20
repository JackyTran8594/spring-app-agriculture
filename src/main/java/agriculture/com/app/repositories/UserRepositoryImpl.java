package agriculture.com.app.repositories;

import java.util.Optional;

import javax.persistence.PersistenceContext;

import com.querydsl.core.support.QueryBase;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import agriculture.com.app.model.QUser;
import agriculture.com.app.model.User;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final JPAQuery<User> query = new JPAQuery<>(entityManager);
    private final QUser user = QUser.user;

    @Override
    public User findbyEmail(String email, String password) {
        // TODO Auto-generated method stub
        // final JPAQuery<User> query = new JPAQuery<>(entityManager);
        User userByEmail = query.from(user).where(user.email.eq(email), user.password.eq(password)).fetchOne();
        
        return userByEmail;
    }

    @Override
    public User findbyUserName(String userName, String password) {
        // TODO Auto-generated method stub
        User userByUserName = query.from(user).where(user.userName.eq(userName), user.password.eq(password)).fetchOne();
        return userByUserName;
    }

    @Override
    public Optional<User> findOne(Predicate predicate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<User> findAll(Predicate predicate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<User> findAll(Predicate predicate, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<User> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<User> findAll(OrderSpecifier<?>... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<User> findAll(Predicate predicate, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count(Predicate predicate) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean exists(Predicate predicate) {
        // TODO Auto-generated method stub
        return false;
    }

}
