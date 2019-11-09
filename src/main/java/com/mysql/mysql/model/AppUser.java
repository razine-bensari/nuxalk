package com.mysql.mysql.model;

import java.sql.Date;
import java.util.Set;
import com.mysql.mysql.model.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="user")
public class AppUser {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(unique=true)
    private String username;

    @NotNull
    private String password;

    private Date dateOfBirth;
    
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "assigned_roles", 
        joinColumns = @JoinColumn(name = "userID"), 
        inverseJoinColumns = @JoinColumn(name = "roleID")
    )
    Set<Role> userRoles;

    public AppUser() {
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "Username: " + this.username + " Password: " + this.password;
    }
}