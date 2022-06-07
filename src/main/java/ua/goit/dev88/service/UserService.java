package ua.goit.dev88.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ua.goit.dev88.converter.ConvertProducer;
import ua.goit.dev88.converter.ConvertUser;
import ua.goit.dev88.model.dao.Producer;
import ua.goit.dev88.model.dao.User;
import ua.goit.dev88.model.dto.ProducerDto;
import ua.goit.dev88.model.dto.UserDto;
import ua.goit.dev88.repository.ProducerRepository;
import ua.goit.dev88.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {

        return userRepository.findAll();
    }



    public List<UserDto> getAllDto() {
        ConvertUser convertUser=new ConvertUser();
        return getAll()
                .stream()
                .map(entity -> convertUser.from(entity))
                .collect(Collectors.toList());
    }
    public User getByEmail(String email){

       return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Email:" + email));
    }
    public User createOrUpdate(User user) {
        return userRepository.save(user);

    }
    public void deleteById(UUID id) {

        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("deleteById . No such index in database");
            throw new NoSuchElementException("No such index in database");
        }
    }
    public Optional<User> findById(UUID id) {

        return userRepository.findById(id);
    }
}
