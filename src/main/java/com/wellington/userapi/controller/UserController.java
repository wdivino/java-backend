package com.wellington.userapi.controller;

import com.wellington.userapi.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    private static List<UserDTO> usuarios = new ArrayList<>();

    @PostConstruct
    public void initiateList() {
        UserDTO usuario1 = new UserDTO("Eduardo", "123", "Rua a", "eduardo@email.com", "1234-3454", new Date());
        UserDTO usuario2 = new UserDTO("Luiz", "456", "Rua b", "luiz@email.com", "1234-3454", new Date());
        UserDTO usuario3 = new UserDTO("Bruna", "789", "Rua c", "bruna@email.com", "1234-3454", new Date());

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
    }

    @GetMapping("/")
    public String getMensagem() {
        return "Spring boot is working!";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf) {
        return usuarios.stream().filter(user -> user.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    @PostMapping("/users")
    public UserDTO inserir(@RequestBody UserDTO newUser) {
        newUser.criadoEm(new Date());
        usuarios.add(newUser);
        return newUser;
    }

    @DeleteMapping("/users/{cpf}")
    public boolean remover(@PathVariable String cpf) {
        UserDTO userDTO = usuarios.stream().filter(user -> user.getCpf().equals(cpf)).findFirst().orElse(null);
        return usuarios.remove(userDTO);
    }
}
