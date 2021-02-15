package ru.geekbrains.persist;

import javax.persistence.*;

@Entity // Чтобы hibernate понямал, что эти сущности нужно хранить в базе
@Table(name = "users") // Называем таблицу
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоматическое создание значений (значение генерит таблица)
    private Long id;

    @Column(length = 128, unique = true, nullable = false)
    // указываем для полей, которые хотим хранить в таблице (не обязательно)
    // указываем длину, уникальность, не может быть пустой.
    private String username;

    @Column(length = 512, nullable = false)
    private String password;

    @Transient // Для полей, которые  не хотим хранить в таблице
    private String matchingPassword;

    @Column
    public String email;

    public User() {
    } // Для создания таблицы, должен быть конструктор и get'еры и set'еры для всех полей класса.

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
