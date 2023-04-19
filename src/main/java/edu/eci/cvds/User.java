package edu.eci.cvds;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "USER")
    private String id;
    @Column(name = "PASSWORD")
    private String password;
    
    public User(String newUser, String newPassword){
        this.id = newUser;
        this.password = newPassword;
    }

    public User () {}

    public void setUser(String newUser) {
        this.id = newUser;
    }

    public String getUser(){
        return id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String toString() {
        return "ConfigutationB{" +
                "propiedad='" + id + '\'' +
                ", valor='" + password + '\'' +
                '}';
    }    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(id, that.id) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password);
    }

}
