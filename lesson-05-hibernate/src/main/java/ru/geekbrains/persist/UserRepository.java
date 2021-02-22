package ru.geekbrains.persist;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserRepository {

    private final EntityManagerFactory emFactory;

    public UserRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public List<User> findAll() {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        em.createNamedQuery("allUsers", User.class).getResultList();

        em.getTransaction().commit();
        em.close();

    }

    public User findById(long id) {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        em.find(User.class, id);

        em.getTransaction().commit();
        em.close();
    }

    public void insert(User user) {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();
        em.close();
    }

    public void update(User user) {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        em.merge(user);

        em.getTransaction().commit();
        em.close();
    }

    public void delete(long id) {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class, id);
        if(user != null){
            em.remove(user);
        }

        em.getTransaction().commit();
        em.close();
    }

}
