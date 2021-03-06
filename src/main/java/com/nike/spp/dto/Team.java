package com.nike.spp.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "team", catalog = "mydb")
public class Team implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer team_id;
	private User user;
	private String name;
	private String coach;
	private Set<Player> players = new HashSet<Player>(0);
	private Set<Match> match = new HashSet<Match>(0);

	public Team() {
	}

	public Team(User user, String name, String coach) {
		this.user = user;
		this.name = name;
		this.coach = coach;
	}

	public Team(User user, String name, String coach, Set<Player> players) {
		super();
		this.user = user;
		this.name = name;
		this.coach = coach;
		this.players = players;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id", unique = true, nullable = false)
	public Integer getId() {
		return team_id;
	}

	public void setId(Integer team_id) {
		this.team_id = team_id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "coach")
	public String getCoach() {
		return this.coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team", cascade = CascadeType.ALL)
	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team", cascade = CascadeType.ALL)
	public Set<Match> getMatch() {
		return match;
	}

	public void setMatch(Set<Match> match) {
		this.match = match;
	}
	
	

}
