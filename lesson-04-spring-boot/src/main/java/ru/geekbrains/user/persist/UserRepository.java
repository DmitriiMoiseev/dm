package ru.geekbrains.user.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// Стало

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByUsernameLike(String username);
}

//    @Query("select u from User u where u.username like :username")
//    List<User> someQuery(@Param("username") String username);

// Строчки выше достаточно, чтобы сделать тоже самое, что написано ниже, но автоматически.

// Было
//@Repository
//public class UserRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    public List<User> findAll() {
//        return em.createQuery("from User", User.class)
//                .getResultList();
//    }
//
//    public User findById(long id) {
//        return em.find(User.class, id);
//    }
//
//    public void insert(User user) {
//        em.persist(user);
//    }
//
//    public void update(User user) {
//        em.merge(user);
//    }
//
//    public void delete(long id) {
//        User u = findById(id);
//        if(u != null) {
//            em.remove(u);
//        }
//    }
//}
