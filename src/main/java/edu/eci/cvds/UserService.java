package edu.eci.cvds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository  userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUser(String user){
        return userRepository.findById(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    } 

    public User updateGuess(User user){
        if(userRepository.existsById(user.getUser())){
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long user){
        userRepository.deleteById(user);
    }

}
