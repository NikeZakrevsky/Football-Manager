package com.nike.spp.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.nike.spp.dto.Match;
import com.nike.spp.dto.Player;
import com.nike.spp.dto.Role;
import com.nike.spp.dto.Stadium;
import com.nike.spp.dto.Team;
import com.nike.spp.dto.User;

@Transactional
public class DAOImpl implements DAO {

	private SessionFactory sessionFactory;
	User currentUser;

	public DAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Match> getMatches() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Match> matches = (List<Match>) session.createQuery("FROM Match").list();
		session.getTransaction().commit();
		return matches;
	}

	@Override
	public void removeStadium(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Stadium stadium = (Stadium)session.load(Stadium.class,new Integer(id));
		if(stadium != null)
			session.delete(stadium);
		session.getTransaction().commit();
	}

	public void savePlayer(Player player) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Set<Team> list = (Set<Team>) currentUser.getTeams();
		for (Team teamName1 : list) {
			System.out.println(teamName1.getName() + " " + player.getTeamName());
			if (teamName1.getName().equals(player.getTeamName())) {
				player.setTeam(teamName1);
				teamName1.getPlayers().add(player);
				System.out.println("yes");
			}
		}
		session.save(player);
		session.getTransaction().commit();
	}

	public List<Team> getTeams() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Team> teamsList = (List<Team>) session.createQuery("FROM Team").list();
		session.getTransaction().commit();
		return teamsList;
	}

	public List<Stadium> getStadiums() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Stadium> stadiumList = (List<Stadium>) session.createQuery("FROM Stadium").list();
		session.getTransaction().commit();
		return stadiumList;
	}

	public void setCurrentUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		currentUser = (User) session.get(User.class, user.getId());
		System.out.println("Current: " + currentUser);
	}

	public Set<Team> getCurrentTeamsList() {
		return currentUser.getTeams();
	}

	public List<User> getUserList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<User> usersList = (List<User>) session.createQuery("from User").list();
		session.getTransaction().commit();
		return usersList;
	}

	public User getUserByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<User> usersList = (List<User>) session.createQuery("from User").list();
		session.getTransaction().commit();
		for (User user : usersList) {
			if (user.getLogin().equals(name)) {
				System.out.println(user);
				return user;
			}
		}
		return null;
	}

	public void addTeam(Team team) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		team.setUser(currentUser);
		currentUser.getTeams().add(team);
		session.save(team);
		session.getTransaction().commit();
	}

	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Role> usersList = (List<Role>) session.createQuery("from Role").list();
		for (Role role2 : usersList) {
			if (role2.getName().equals("user")) {
				currentUser = user;
				role2.getUsers().add(user);
				user.setRole(role2);
				session.save(user);
				session.getTransaction().commit();
			}
		}
	}

	public void addMatch(Match match) {
		List<Team> teams = getTeams();
		List<Stadium> stadiums = getStadiums();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		for (Team team : teams) {
			if (match.getTeam1Name().equals(team.getName()))
				match.setTeam(team);
			if (match.getTeam2Name().equals(team.getName()))
				match.setTeam1(team);
		}

		for (Stadium stadium1 : stadiums) {
			if (match.getStadiumName().equals(stadium1.getName()))
				match.setStadium(stadium1);
		}
		session.save(match);
		session.getTransaction().commit();
	}

	public User getCurrentUser() {
		return currentUser;
	}

	@Override
	public String getRole(User userItem) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		System.out.println("Role: " + userItem.getRole().getRole_id());
		Role role = (Role)session.load(Role.class,new Integer(userItem.getRole().getRole_id()));
		System.out.println(role);
		session.getTransaction().commit();
		return role.getName();
	}

	@Override
	public void addStadium(Stadium stadium) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(stadium);
		session.getTransaction().commit();
	}
}