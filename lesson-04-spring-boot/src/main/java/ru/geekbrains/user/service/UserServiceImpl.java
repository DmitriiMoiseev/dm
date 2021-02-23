package ru.geekbrains.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.user.persist.User;
import ru.geekbrains.user.persist.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public List<UserRepr> findAll() {
        return userRepository.findAll().stream()
                .map(UserRepr :: new)
                .collect(Collectors.toList());

    }

    @Override
    public List<UserRepr> findWithFilter(String usernameFilter) {
        return userRepository.findUserByUsernameLike(usernameFilter).stream()
                .map(UserRepr :: new)
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public Optional<UserRepr> findById(long id) { // Optional - контейнер для значения, которое может быть, а может не быть.
        return userRepository.findById(id)
                .map(UserRepr :: new);
    }

    @Transactional
    @Override
    public void save(UserRepr userRepr) {
        userRepository.save(new User(userRepr));
    }

    @Transactional
    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
