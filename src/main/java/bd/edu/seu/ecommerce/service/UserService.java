package bd.edu.seu.ecommerce.service;

import bd.edu.seu.ecommerce.model.User;
import bd.edu.seu.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        System.out.println("It reached the service");
        userRepository.save(user);
    }
}
