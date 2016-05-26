package com.nike.spp.dto;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by User on 24.05.2016.
 */
public class TeamTest {
    @Test
    public void getId() throws Exception {
        Team team=new Team();
        int id=132,newId;
        team.setId(id);
        newId=team.getId();
        assertEquals(132,newId);
    }

    @Test
    public void getUser() throws Exception {
        User user = new User();
        user.setId(123);
        Team team = new Team();
        team.setUser(user);
        assertEquals(team.getUser(), user);
    }

    @Test
    public void getName() throws Exception {
        Team team=new Team();
        String name = "Bate";
        team.setName(name);
        assertTrue(team.getName() == name);
    }

    @Test
    public void getCoach() throws Exception {
        Team team=new Team();
        String name = "Van Gaal";
        team.setCoach(name);
        assertEquals(team.getCoach(), "Van Gaal");
    }

    @Test
    public void getPlayers() throws Exception {
        Set<Player> players = new HashSet<Player>(0);
        Team team = new Team();
        team.setPlayers(players);
        assertEquals(team.getMatch(), players);
    }

    @Test
    public void getMatch() throws Exception {
        Set<Match> match = new HashSet<Match>(0);
        Team team = new Team();
        team.setMatch(match);
        assertEquals(team.getMatch(), match);
    }

    @Test
    public void setId() throws Exception {
        Team team=new Team();
        int id=222,newId;
        team.setId(id);
        newId = team.getId();
        assertTrue(222 == newId);
    }

    @Test
    public void setUser() throws Exception {
        User user = new User();
        user.setLogin("Lurk123");
        Team team = new Team();
        team.setUser(user);
        assertTrue(team.getUser().getLogin() == "Lurk123");
    }

    @Test
    public void setName() throws Exception {
        Team team=new Team();
        String name = "Loko";
        team.setName(name);
        assertEquals(team.getName(), "Loko");
    }

    @Test
    public void setCoach() throws Exception {
        Team team=new Team();
        String coach = "Fergie";
        team.setCoach(coach);
        assertTrue(team.getCoach().equals("Fergie"));
    }

    @Test
    public void setPlayers() throws Exception {
        Set<Player> players = new HashSet<Player>(0);
        Team team = new Team();
        team.setPlayers(players);
        assertTrue(team != null);
    }

    @Test
    public void setMatch() throws Exception {
        Set<Match> match = new HashSet<Match>(0);
        Team team = new Team();
        team.setMatch(match);
        assertTrue(team != null);
    }
	
	
   @Test
    public void testEquals() throws Exception {
        Team team = new Team();
        team.setName("Real");
		team.setCoach("Zidane");
        Team team2 = new Team();
        team2.setName("Real");
		team2.setCoach("Zidane");
        assertTrue(team.getName().equals(team2.getName()));
    }

}