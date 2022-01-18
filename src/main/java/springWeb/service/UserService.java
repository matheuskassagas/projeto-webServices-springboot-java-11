package springWeb.service;

import springWeb.DTO.response.UserResponse;
import springWeb.repositoryJPA.User;
import springWeb.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springWeb.repositoryJPA.UserRepositoryJPA;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    public List<UserResponse> findAll(){
        return userRepositoryJPA.findAll().stream().map(user -> new UserResponse().toReponse(user)).collect(Collectors.toList());
    }

    public UserResponse findById(Integer id) throws Exception{
        Optional<User> user = userRepositoryJPA.findById(id);

        if(user.isPresent()){
            return new UserResponse().toReponse(user.get());
        }else{
            throw new DomainException("Id: " + id + " not found in database");
        }
    }
}
