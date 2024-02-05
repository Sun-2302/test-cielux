package com.poja.cielux.service.event;

import com.poja.cielux.repository.UserRepository;
import com.poja.cielux.repository.model.User;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Object findById(UUID id){
        return userRepository.findById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void deleteById(UUID id){
        userRepository.deleteById(id);
    }

    public User update(UUID id, String name)throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        user.setName(name);
        return userRepository.save(user);
    }
}
