package com.wellington.userapi.service;

import com.wellington.userapi.dto.UserDTO;
import com.wellington.userapi.entity.User;
import com.wellington.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> obterTodos() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::converter)
                .collect(Collectors.toList());
    }

    public UserDTO obterPorId(long id) {
        Optional<User> possivelUsuarioEncontrado = userRepository.findById(id);
        if (possivelUsuarioEncontrado.isPresent()) {
            return UserDTO.converter(possivelUsuarioEncontrado.get());
        }
        return null;
    }

    public UserDTO salvar(UserDTO novoUsuario) {
        novoUsuario.criadoEm(LocalDateTime.now());
        User usuarioCadastrado = userRepository.save(User.converter(novoUsuario));
        return UserDTO.converter(usuarioCadastrado);
    }

    public boolean excluirPorId(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserDTO obterPorCpf(String cpf) {
        Optional<User> possivelUsuarioEncontrado = userRepository.findByCpf(cpf);
        if (possivelUsuarioEncontrado.isPresent()) {
            return UserDTO.converter(possivelUsuarioEncontrado.get());
        }
        return null;
    }

    public List<UserDTO> consultarPorNome(String name) {
        return userRepository.queryByNomeLike(name)
                .stream()
                .map(UserDTO::converter)
                .collect(Collectors.toList());
    }
}
