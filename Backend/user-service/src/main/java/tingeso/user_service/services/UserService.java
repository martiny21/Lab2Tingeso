package tingeso.user_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingeso.user_service.repositories.UserRepository;
import tingeso.user_service.Entities.UserEntity;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserEntity registerUser(UserEntity user) {
        // Check if the user already exists
        if (userRepository.findByRut(user.getRut()) != null) {
            throw new RuntimeException("El RUT ya está registrado");
        }
        return userRepository.save(user);
    }

    public UserEntity getUserByRut(String rut) {
        return userRepository.findByRut(rut);
    }

    public String getUserRut(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));
        return user.getRut();
    }
}
