package com.nike.spp.dto;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by User on 24.05.2016.
 */
public class TournamentTest {
    @Test
    public void getId() throws Exception {
        Tournament tournament = new Tournament();
        int id=99,Id;
        tournament.setId(id);
        Id = tournament.getId();
        assertEquals(99,Id);
    }

    @Test
    public void getName() throws Exception {
        Tournament tournament = new Tournament();
        String name = "Champions League";
        tournament.setName(name);
        assertTrue(tournament.getName() == name);
    }

    @Test
    public void getPrize() throws Exception {
        Tournament tournament = new Tournament();
        int prize = 9900,mainPrize;
        tournament.setPrize(prize);
        mainPrize = tournament.getPrize();
        assertEquals(9900, mainPrize);
    }

    @Test
    public void getMatches() throws Exception {
        Set<Match> matches = new HashSet<Match>(0);
        Tournament tournament = new Tournament();
        tournament.setMatches(matches);
        assertEquals(tournament.getMatches(), matches);
    }

    @Test
    public void setId() throws Exception {
        Tournament tournament = new Tournament();
        int id = 120;
        tournament.setId(id);
        assertTrue(120 == tournament.getId());
    }

    @Test
    public void setName() throws Exception {
        Tournament tournament = new Tournament();
        String name = "FA Cup";
        tournament.setName(name);
        assertTrue(tournament.getName().equals("FA Cup"));
    }

    @Test
    public void setPrize() throws Exception {
        Tournament tournament = new Tournament();
        int prize = 1000,mainPrize;
        tournament.setPrize(prize);
        assertTrue(1000 == tournament.getPrize());
    }

    @Test
    public void setMatches() throws Exception {
        Set<Match> matches = new HashSet<Match>(0);
        Tournament tournament = new Tournament();
        tournament.setMatches(matches);
        assertTrue(tournament.getMatches() == matches);
    }
	
	@Test
    public void testEquals() throws Exception {
        Tournament tournament = new Tournament();
        tournament.setName("UEFA League");
		tournament.setPrize(1000);
        Tournament tournament2 = new Tournament();
        tournament2.setName("UEFA League");
		tournament2.setPrize(1000);
        assertTrue(tournament.getName().equals(tournament2.getName()));
    }

}