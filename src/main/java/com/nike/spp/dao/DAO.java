package com.nike.spp.dao;

import java.util.List;
import java.util.Set;

import com.nike.spp.dto.Match;
import com.nike.spp.dto.Player;
import com.nike.spp.dto.Stadium;
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

	public Set<Team> getCurrentTeamsList();

	public void addMatch(Match match);

	public List<Stadium> getStadiums();
	
	public List<Match> getMatches();

	public void removeStadium(int id);

	public User getCurrentUser();

	public String getRole(User userItem);

	public void addStadium(Stadium stadium);

	public void removeUser(int id);

	public List<Player> getPlayers();

	public void removePlayer(int id);

	public User getUserByID(int id);

	public Stadium getStadiumByID(int id);

	public void addUser(User user, String role);
}
