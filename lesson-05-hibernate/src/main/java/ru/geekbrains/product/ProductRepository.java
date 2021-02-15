package ru.geekbrains.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class ProductRepository {
    private final EntityManagerFactory emFactory;

    public ProductRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public List<Product> findAll() {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        em.createNamedQuery("allUsers", Product.class).getResultList();

        em.getTransaction().commit();
        em.close();

    }

    public Product findById(long id) {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        em.find(Product.class, id);

        em.getTransaction().commit();
        em.close();
    }

    public void insert(Product product) {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        em.persist(product);

        em.getTransaction().commit();
        em.close();
    }

    public void update(Product product) {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        em.merge(product);

        em.getTransaction().commit();
        em.close();
    }

    public void delete(long id) {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Product product = em.find(Product.class, id);
        if(product != null){
            em.remove(product);
        }

        em.getTransaction().commit();
        em.close();
    }
}
