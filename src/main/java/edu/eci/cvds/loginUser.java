package edu.eci.cvds;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "loginUser")
@ApplicationScoped
public class loginUser {

    private String user;
    private String password;

    public loginUser() {
        restart();
    }

    public String getUser() {
        return user;
    }

    public String getPassword(){
        return password;
    }

    public void setUser(String newUser) {
        this.user = newUser;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    public void restart() {
        user = null;
        password = null;
    }
}
