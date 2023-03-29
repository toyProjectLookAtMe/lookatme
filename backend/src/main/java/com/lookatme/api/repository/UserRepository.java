package com.lookatme.api.repository;

import com.lookatme.api.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findOne(int userIndex){
        return em.find(User.class, userIndex);
    }

    public List<User> findAll(){
        return em.createQuery("select u from User u")
                .getResultList();
    }

    public List<User> findByEmail(String userEmail){
      return em.createQuery("select u from User u where u.userEmail = :userEmail ", User.class)
              .setParameter("userEmail", userEmail)
              .getResultList();
    };
}
