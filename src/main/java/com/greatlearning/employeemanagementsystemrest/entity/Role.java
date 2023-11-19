package com.greatlearning.employeemanagementsystemrest.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString(exclude="users")
@EqualsAndHashCode(of ="id")
public class Role {
	
	@Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;
    
    @ManyToMany
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(name="role_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private Set<User> users;
	
	public Set<User> getUsers(){
		if(this.users == null) {
			this.users = new HashSet<>();
		}
		return this.users;
	}
    
    public Role() {}
    
    public Role(String name) {
    	this.name = name;
    }
}