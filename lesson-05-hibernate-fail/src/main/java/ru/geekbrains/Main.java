package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.persist.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration() // для работы с базой
                .configure("hibernate.cfg.xml") // передаем имя файла с конфигурацими
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager(); // создаем em для работы с таблицей

        // Insert
        em.getTransaction().begin(); // открвыем транзакцию для работы с БД
        User user1 = new User("user1", "password1", "email1@mail.ru"); // создаем экземпляр пользователя
        em.persist(user1); // добавляем пользователя в таблицу БД
        em.getTransaction().commit(); // комитим изменения в БД
        em.close(); // прекращаем работу em

    }
}
