package com.nike.spp.dao;

import com.nike.spp.dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 24.05.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/inventory-servlet.xml" })
public class DAOImplTest {

    @Autowired
    private DAO dao;
    private Player player;
    private Stadium stadium;
    private User user;
    private Team team;
    private Match match;
    private int id = 0;
    private String login = "Log123";
    private String name = "Name";

    @Before
    public void setUp() throws Exception {


        user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setPassword("ksjdhf");

        team = new Team();
        team.setId(id);
        team.setName(name);

        player = new Player();
        player.setId(id);
        player.setName(name);
        player.setHight(12);
        player.setNumber(1);
        player.setWeight(40);

        stadium = new Stadium();
        stadium.setCapacity(5);
        stadium.setName("ty");
        stadium.setTown("321");
        stadium.setId(0);

        match = new Match();
        match.setId(id);
        match.setScoreSecond(0);
        match.setScoreFirst(0);
        match.setStadiumName("kjdsf");
        match.setTeam1Name("w");
        match.setTeam2Name("q");
        match.setStadium(stadium);





    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getMatches() throws Exception {
        assertNotNull(dao.getMatches());
    }


    @Test
    public void getTeams() throws Exception {
        assertNotNull(dao.getTeams());
    }

    @Test
    public void getStadiums() throws Exception {
        assertNotNull(dao.getStadiums());
    }

    @Test
    public void setCurrentUser() throws Exception {
        System.out.println(user);
        dao.setCurrentUser(user);
    }

    @Test
    public void getCurrentTeamsList() throws Exception {
        assertNotNull(dao.getCurrentTeamsList());
    }

    @Test
    public void getUserList() throws Exception {
        assertNotNull(dao.getUserList());
    }

    @Test
    public void getUserByName() throws Exception {
        dao.getUserByName(name);
    }

    @Test
    public void addUser() throws Exception {
        dao.addUser(user);
    }



}