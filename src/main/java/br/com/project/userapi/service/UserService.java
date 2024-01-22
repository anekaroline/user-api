package br.com.project.userapi.service;

import br.com.project.userapi.domain.models.User;
import br.com.project.userapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Page<User> findAllPage(Pageable page){
        return userRepository.findAll(page);
    }

    public User save(User user){
        return userRepository.save(user);
    }


    public void delete(Long id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User findByCpf(String cpf, UUID key){
        User user = userRepository.findByCpfAndKey(cpf, key);
        if (user != null) {
            return user;
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    public List<User> queryByNameLike(String name){
        return userRepository.queryByNameLike(name);
    }

    public User update(Long id, User user){
        User userExisting = findById(id);
        BeanUtils.copyProperties(userExisting,user);
        return userRepository.save(userExisting);
    }

}
