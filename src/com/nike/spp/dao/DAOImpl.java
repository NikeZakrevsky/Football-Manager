package com.nike.spp.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.nike.spp.dto.Match;
import com.nike.spp.dto.Player;
import com.nike.spp.dto.Role;
import com.nike.spp.dto.Stadium;
import com.nike.spp.dto.Team;
import com.nike.spp.dto.Tournament;
import com.nike.spp.dto.User;

@Transactional
public class DAOImpl implements DAO {

	private SessionFactory sessionFactory;

	public DAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUserByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<User> usersList = (List<User>) session.createQuery("from User").list();
		session.getTransaction().commit();
		for (User user : usersList) {
			if (user.getLogin().equals(name))
				return user;
		}
		return null;
	}

	
	
	public void add() {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Role role = new Role("Nikita", "admin");
		session.save(role);

		User user = new User(role, "login", "password");
		role.getUsers().add(user);
		session.save(user);

		Team team = new Team();
		team.setUser(user);
		team.setName("team_name");
		team.setCoach("coach");
		user.getTeams().add(team);

		Team team1 = new Team();
		team1.setUser(user);
		team1.setName("team_name1");
		team1.setCoach("coach1");
		user.getTeams().add(team1);

		session.save(team);
		session.save(team1);

		Player player = new Player();
		player.setBirthDate(new Date());
		player.setWeight(90);
		player.setHight(195);
		player.setName("player_name");
		player.setNationality("nationality");
		player.setNumber(20);
		player.setTeam(team);

		Player player1 = new Player();
		player1.setBirthDate(new Date());
		player1.setWeight(95);
		player1.setHight(100);
		player1.setName("player_name2");
		player1.setNationality("nationality2");
		player1.setNumber(25);
		player1.setTeam(team1);
		team.getPlayers().add(player);
		session.save(player);
		session.save(player1);

		Tournament tournament = new Tournament();
		tournament.setName("tournament_name");
		tournament.setPrize(20);
		session.save(tournament);

		Stadium stadium = new Stadium();
		stadium.setCapacity(25);
		stadium.setName("stadium_name");
		session.save(stadium);

		Match match = new Match();
		match.setScoreFirst(10);
		match.setScoreSecond(11);
		match.setTeam(team);
		match.setTeam1(team1);
		match.setStadium(stadium);
		match.setTournament(tournament);
		tournament.getMatches().add(match);
		stadium.getMatches().add(match);
		session.save(match);

		match.setTournament(tournament);

		session.getTransaction().commit();
		System.out.println("Done");
	}

	/*
	 * public void update(ItemMaster item) {
	 * 
	 * Session session = sessionFactory.getCurrentSession(); try {
	 * System.out.println("IN Update"); session.beginTransaction();
	 * session.saveOrUpdate(item); } catch (HibernateException e) {
	 * e.printStackTrace(); session.getTransaction().rollback(); }
	 * session.getTransaction().commit(); }
	 * 
	 * public ItemMaster getItem(Long id) { Session session =
	 * sessionFactory.getCurrentSession(); ItemMaster item = null; try {
	 * System.out.println("IN GetIteam"); session.beginTransaction(); item =
	 * (ItemMaster) session.get(ItemMaster.class, id); } catch
	 * (HibernateException e) { e.printStackTrace();
	 * session.getTransaction().rollback(); } session.getTransaction().commit();
	 * return item; }
	 * 
	 * public void delete(Long id) { Session session =
	 * sessionFactory.getCurrentSession(); session.beginTransaction();
	 * ItemMaster item = (ItemMaster) session.get(ItemMaster.class, id); if
	 * (null != item) { session.delete(item); }
	 * session.getTransaction().commit(); // return item; }
	 * 
	 * public List<ItemMaster> list() {
	 * 
	 * Session session = sessionFactory.getCurrentSession();
	 * session.beginTransaction(); List<ItemMaster> items = null; try {
	 * System.out.println("IN LIST"); items = (List<ItemMaster>)
	 * session.createQuery("from ItemMaster").list();
	 * 
	 * } catch (HibernateException e) { e.printStackTrace();
	 * session.getTransaction().rollback(); } session.getTransaction().commit();
	 * return items; }
	 */

}
