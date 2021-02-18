package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.customer.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Customer customer = new Customer("customer1");
        em.persist(customer);

        em.getTransaction().commit();

        em.close();
    }
}
