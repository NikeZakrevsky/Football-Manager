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
@Table(name = "tournament", catalog = "mydb")
public class Tournament implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int tournament_id;
	private String name;
	private Integer prize;
	private Set<Match> matches = new HashSet<Match>(0);

	public Tournament() {
	}

	public Tournament(int tournament_id) {
		this.tournament_id = tournament_id;
	}

	public Tournament(int id, String name, Integer prize, Set<Match> matches) {
		this.tournament_id = id;
		this.name = name;
		this.prize = prize;
		this.matches = matches;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tournament_id", unique = true, nullable = false)
	public int getId() {
		return this.tournament_id;
	}

	public void setId(int id) {
		this.tournament_id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "prize")
	public Integer getPrize() {
		return this.prize;
	}

	public void setPrize(Integer prize) {
		this.prize = prize;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament")
	public Set<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

}
