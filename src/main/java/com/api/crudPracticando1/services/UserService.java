package com.api.crudPracticando1.services;

import com.api.crudPracticando1.models.UserModel;
import com.api.crudPracticando1.repositories.IUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    //obtener todos los usuarios
    public ArrayList<UserModel> getUser(){
        return (ArrayList<UserModel>) userRepository.findAll();

    }

    //guardar usuarios
    public UserModel saveUser(UserModel userModel){
        return userRepository.save(userModel);
    }

    //obtener el usuario que queramos a travez de un id
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    //modificacion
    public UserModel updateByid(UserModel request, Long id){
        UserModel user = userRepository.findById(id).get();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        userRepository.save(user);

        return user;
    }


    //borrar usuario
    public Boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

}
