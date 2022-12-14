package com.wellington.userapi.controller;

import com.wellington.userapi.dto.UserDTO;
import com.wellington.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getMensagem() {
        return "Spring boot is working!";
    }

    @GetMapping
    public List<UserDTO> obterTodos() {
        return userService.obterTodos();
    }

    @GetMapping("{id}")
    public UserDTO obterPorId(@PathVariable long id) {
        return userService.obterPorId(id);
    }

    @GetMapping("{cpf}")
    public UserDTO obterPorCpf(@PathVariable String cpf) {
        return userService.obterPorCpf(cpf);
    }

    @PostMapping
    public UserDTO inserir(@RequestBody UserDTO novoUsuario) {
        return userService.salvar(novoUsuario);
    }

    @DeleteMapping("{id}")
    public boolean excluirPorId(@PathVariable long id) {
        return userService.excluirPorId(id);
    }

    @GetMapping("search")
    public List<UserDTO> buscarPorNome(@RequestParam(name = "nome") String nome) {
        return userService.consultarPorNome(nome);
    }
}
