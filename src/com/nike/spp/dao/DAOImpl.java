package com.nike.spp.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.nike.spp.dto.Player;
import com.nike.spp.dto.Role;
import com.nike.spp.dto.Team;
import com.nike.spp.dto.User;

@Transactional
public class DAOImpl implements DAO {

	private SessionFactory sessionFactory;
	User currentUser;

	public DAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void savePlayer(Player player) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Set<Team> list = (Set<Team>) currentUser.getTeams();
		for (Team teamName1 : list) {
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

	public void setCurrentUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		currentUser = (User) session.get(User.class, user.getId());
		System.out.println("Current: " + currentUser);
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
}
