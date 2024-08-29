package br.com.javamysql.service;

import br.com.javamysql.dto.UserDTO;
import br.com.javamysql.entity.User;
import br.com.javamysql.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) throws ChangeSetPersister.NotFoundException {
        if (userRepository.existsById(userId)) {
            Optional<User> optionalUser = userRepository.findById(userId);
            return optionalUser.get();
        } else {
            throw  new ChangeSetPersister.NotFoundException();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setGender(user.getGender());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private UserDTO convertToDTO(User user) {
        // logic to convert User to UserDTO
        return null;
    }

    private User convertToEntity(UserDTO userDTO) {
        // logic to convert UserDTO to User
        return null;
    }
}
