package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@Setter
@Getter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "password")
    @JsonIgnore
    private String password;

    public User() {

    }
    public User(String user_name,String password){
        this.user_name=user_name;
        this.password=password;
    }

    public long id() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public User setUser_name(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public String user_name() {
        return user_name;
    }

    public String password() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}








