package com.nike.spp.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player", catalog = "mydb")
public class Player implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer player_id;
	private Team team;
	private String name;
	private int number;
	private int weight;
	private int hight;
	private Date birthDate;
	private String nationality;

	

	public Player() {
	}
	
	public Player(Team team, String name, int number, int weight, int hight, Date birthDate, String nationality) {
		this.team = team;
		this.name = name;
		this.number = number;
		this.weight = weight;
		this.hight = hight;
		this.birthDate = birthDate;
		this.nationality = nationality;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id", unique = true, nullable = false)
	public Integer getId() {
		return this.player_id;
	}

	public void setId(Integer player_id) {
		this.player_id = player_id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false)
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "number")
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Column(name = "weight")
	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Column(name = "hight")
	public int getHight() {
		return this.hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}

	@Column(name = "birthDate")
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "nationality")
	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
