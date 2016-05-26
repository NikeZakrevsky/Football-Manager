package com.nike.spp.dto;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 24.05.2016.
 */
public class MatchTest {
    @Test
    public void getId() throws Exception {
        Match match = new Match();
        int id = 231, newId;
        match.setId(id);
        newId = match.getId();
        assertEquals(231, newId);
    }

    @Test
    public void getScoreFirst() throws Exception {
        Match match = new Match();
        int score = 0, firstScore;
        match.setScoreFirst(score);
        firstScore = match.getScoreFirst();
        assertTrue(firstScore == match.getScoreFirst());
    }

    @Test
    public void getScoreSecond() throws Exception {
        Match match = new Match();
        int score = 2, secondScore;
        match.setScoreSecond(score);
        secondScore = match.getScoreSecond();
        assertTrue(secondScore == match.getScoreSecond());
    }

    @Test
    public void getTeam() throws Exception {
        Match match = new Match();
        Team team = new Team();
        team.setId(123);
        match.setTeam(team);
        assertTrue(match.getTeam().getId() == 123);
    }

    @Test
    public void getTeam1() throws Exception {
        Match match = new Match();
        Team team = new Team();
        String coach = "Maurinho";
        team.setCoach(coach);
        match.setTeam1(team);
        assertTrue(match.getTeam1().getCoach() == coach);
    }

    @Test
    public void getStadium() throws Exception {
        Match match = new Match();
        Stadium stadium = new Stadium();
        stadium.setTown("Mozyr");
        match.setStadium(stadium);
        String stad = match.getStadium().getTown();
        assertEquals(stad, match.getStadium().getTown());
    }

    @Test
    public void getTeam1Name() throws Exception {
        Match match = new Match();
        String name = "Real";
        match.setTeam1Name(name);
        String nameTeam1 = match.getTeam1Name();
        assertEquals(nameTeam1, name);
    }

    @Test
    public void getTeam2Name() throws Exception {
        Match match = new Match();
        String name = "Spartak";
        match.setTeam2Name(name);
        assertEquals(match.getTeam2Name(), "Spartak");
    }

    @Test
    public void getStadiumName() throws Exception {
        Match match = new Match();
        String name = "Old Trafford";
        match.setStadiumName(name);
        assertEquals(match.getStadiumName(), name);
    }

    @Test
    public void setId() throws Exception {
        Match match = new Match();
        int id = 423, newId;
        match.setId(id);
        newId = match.getId();
        assertTrue(423 == newId);
    }

    @Test
    public void setScoreFirst() throws Exception {
        Match match = new Match();
        int score = 4, firstScore;
        match.setId(score);
        firstScore = match.getId();
        assertEquals(firstScore, 4);
    }

    @Test
    public void setScoreSecond() throws Exception {
        Match match = new Match();
        int score = 3, secondScore;
        match.setId(score);
        secondScore = match.getId();
        assertEquals(secondScore, 3);
    }

    @Test
    public void setTeam() throws Exception {
        Match match = new Match();
        Team team = new Team();
        team.setName("PSG");
        match.setTeam(team);
        String name = match.getTeam().getName();
        assertEquals(name, "PSG");
    }

    @Test
    public void setTeam1() throws Exception {
        Match match = new Match();
        Team team = new Team();
        team.setId(2);
        match.setTeam1(team);
        int id = match.getTeam1().getId();
        assertEquals(id, 2);
    }

    @Test
    public void setStadium() throws Exception {
        Match match = new Match();
        Stadium stadium = new Stadium();
        stadium.setName("San Siro");
        match.setStadium(stadium);
        assertEquals(stadium, match.getStadium());
    }

    @Test
    public void setTeam1Name() throws Exception {
        Match match = new Match();
        String name = "Lokomotiv";
        match.setTeam1Name(name);
        assertTrue(match.getTeam1Name() == name);
    }

    @Test
    public void setStadiumName() throws Exception {
        Match match = new Match();
        String name = "Alianz Arena";
        match.setStadiumName(name);
        assertTrue(match.getStadiumName().equals(name));
    }

    @Test
    public void setTeam2Name() throws Exception {
        Match match = new Match();
        String name = "Roma";
        match.setTeam2Name(name);
        assertTrue(match.getTeam2Name() == name);
    }

    @Test
    public void testEquals() throws Exception {
        Match match= new Match();
        match.setTeam1Name("Lokomotiv");
		match.setTeam2Name("Zenit");
        Match match2= new Match();
        match2.setTeam1Name("Lokomotiv");
        match2.setTeam2Name("Zenit");
        assertTrue(match.getTeam1Name().equals(match2.getTeam1Name()));
    }

}