package com.example.Cursor_HW6.services;

import com.example.Cursor_HW6.models.User;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private final EntityManagerFactory emf;

    @Autowired
    public UserServiceImplementation(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void createUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteUserById(Long id) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
                System.out.println("Користувача з id " + Long.toString(id) + " видалено");
            } else {
                System.out.println("Помилка! Не вдалося видалити користувача із заданим Id");
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception ex) {
            System.out.println("Помилка! Не вдалося видалити користувача із заданим Id");
        }
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("FROM User", User.class);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public User getUserById(Long id) {
        EntityManager em = emf.createEntityManager();
        User userFounded = em.find(User.class, id);
        em.close();
        return userFounded;
    }

    @Override
    public User getUserByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        em.close();
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            User updatedUser = em.merge(user);
            transaction.commit();
            System.out.println("User updated: " + updatedUser);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
