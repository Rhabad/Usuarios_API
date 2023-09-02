package com.api.crudPracticando1.controllers;

import com.api.crudPracticando1.models.UserModel;
import com.api.crudPracticando1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    //aqui definiremos las peticiones http y las rutas.

    @Autowired
    private UserService userService;



    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUser();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }


    @GetMapping(path = "/{id}") //abrir llaves significa que sera lo que le digamos.
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id){
        return  this.userService.updateByid(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id ){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "Usuario: "+id+" Eliminado";
        } else {
            return "Error al eliminar el usuario con id: "+id;
        }
    }

}
