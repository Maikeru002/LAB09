package com.game.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.*;

@Component
public class UsersBean  implements Serializable {
    private final UsersRepository usuarioRepository;
    @Autowired
    UserService usuarioService;
    private String user;
    private String password;
    private List<User> users;
    public UsersBean(UsersRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public String getUser() {
        return user;
    }
    public List<User> getUsers(){
        users = usuarioService.getAllUsers();
        return users;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
        Users usuario = usuarioRepository.findById(user);
        if (usuario == null || !usuario.getPassword().equals(password)) {
            FacesContext.getCurrentInstance().addMessage("@all", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos incorrectos", null));
            return null;
        } else {
            return "welcome.xhtml";
        }
    }

    @Bean
    public CommandLineRunner currentUser() throws Exception{
        return args -> {
            usuarioService.addUser(new Users("Miguel", "123654"));
            usuarioService.addUser(new Users("Camilo", "Mayan"));
            usuarioService.addUser(new Users("Mario", "Marioycmm4+"));
            usuarioService.getAllUsers().forEach(System.out::println);
        };
    }
}
