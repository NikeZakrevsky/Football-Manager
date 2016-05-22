package com.nike.spp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "match", catalog = "mydb")
public class Match implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer match_id;
	private Team team;
	private Stadium stadium;
	private Integer scoreFirst;
	private Integer scoreSecond;
	private Team team1;
	private String team1Name;
	private String team2Name;
	private String stadiumName;

	public Match() {
	}

	public Match(Integer match_id, Team team) {
		this.match_id = match_id;
		this.team = team;
	}

	public Match(Integer match_id, Integer scoreFirst, Integer scoreSecond, Team team, Team team1) {
		this.match_id = match_id;
		this.team = team;
		this.scoreFirst = scoreFirst;
		this.scoreSecond = scoreSecond;
		this.team1 = team1;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "match_id", unique = true, nullable = false)
	public Integer getId() {
		return this.match_id;
	}

	public void setId(Integer match_id) {
		this.match_id = match_id;
	}

	@Column(name = "scoreFirst")
	public Integer getScoreFirst() {
		return this.scoreFirst;
	}

	public void setScoreFirst(Integer scoreFirst) {
		this.scoreFirst = scoreFirst;
	}

	@Column(name = "scoreSecond")
	public Integer getScoreSecond() {
		return this.scoreSecond;
	}

	public void setScoreSecond(Integer scoreSecond) {
		this.scoreSecond = scoreSecond;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false)
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id1", nullable = false)
	public Team getTeam1() {
		return this.team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stadium_id", nullable = false)
	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	@Column(name = "team1Name")
	public String getTeam1Name() {
		return team1Name;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}
	
	@Column(name = "team2Name")
	public String getTeam2Name() {
		return team2Name;
	}

	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}

	@Column(name = "stadiumName")
	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
}
