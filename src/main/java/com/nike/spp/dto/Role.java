package com.nike.spp.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", catalog = "mydb")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer role_id;
	private String name;
	private String rights;
	private Set<User> users = new HashSet<User>(0);

	public Role() {
	}

	public Role(String name, String rights) {
		this.name = name;
		this.rights = rights;
	}

	public Role(String name, String rights, Set<User> users) {
		this.name = name;
		this.rights = rights;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	public Integer getRole_id() {
		return role_id;
	}

	@Column(name = "name", unique = true, nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "rights", unique = true, nullable = false, length = 10)
	public String getRights() {
		return this.rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}