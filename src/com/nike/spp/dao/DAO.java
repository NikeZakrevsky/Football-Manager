package com.nike.spp.dao;

import java.util.List;
import java.util.Set;

import com.nike.spp.dto.Player;
import com.nike.spp.dto.Team;
import com.nike.spp.dto.User;

public interface DAO {

	public void addUser(User user);

	public User getUserByName(String name);
	
	public void addTeam(Team team);

	public List<User> getUserList();
	
	public void setCurrentUser(User user);
	
	public List<Team> getTeams();
	
	public void savePlayer(Player player);
}
