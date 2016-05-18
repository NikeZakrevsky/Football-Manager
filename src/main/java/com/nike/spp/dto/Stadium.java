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
@Table(name = "stadium", catalog = "mydb")
public class Stadium implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int stadium_id;
	private String name;
	private int capacity;
	private Set<Match> matches = new HashSet<Match>(0);

	public Stadium() {
	}

	public Stadium(int stadium_id, String name, int capacity) {
		this.stadium_id = stadium_id;
		this.name = name;
		this.capacity = capacity;
	}

	public Stadium(int stadium_id, String name, int capacity, Set<Match> matches) {
		this.stadium_id = stadium_id;
		this.name = name;
		this.capacity = capacity;
		this.matches = matches;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stadium_id", unique = true, nullable = false)
	public int getId() {
		return this.stadium_id;
	}

	public void setId(int stadium_id) {
		this.stadium_id = stadium_id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "capacity")
	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "stadium")
	public Set<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

}
