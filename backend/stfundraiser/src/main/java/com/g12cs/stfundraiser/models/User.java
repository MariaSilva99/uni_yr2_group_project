package com.g12cs.stfundraiser.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "users" )
@EntityListeners( AuditingEntityListener.class )


public class User  {

    public User(){

    }


    // User constructor
    public User ( String username, String password, String firstName, String lastname, String email,boolean active ){
        this.username = username ;
        this.password = password ;
        this.firstName = firstName ;
        this.lastName = lastname ;
        this.email = email;
        this.active = active ;
    }



     //Variables/columns


     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)

     private int id;
     private String username;
     private String password;

     private String firstName;
     private String lastName;

     private String email;
     private boolean active;
     private String role;


    //getters/setters for above columns

    public void setUsername(String username){
         this.username=username;
    }
    public String getUsername(){
         return username;
    }

    public void setPassword(String password){
         this.password = password;
    }
    public String getPassword(){
         return password;
    }

    public void setRole(String role){
         this.role = role;
    }
    public String getRole(){
         return role;
    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }


}
