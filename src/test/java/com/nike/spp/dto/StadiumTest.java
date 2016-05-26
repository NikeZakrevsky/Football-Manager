package com.nike.spp.dto;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by User on 24.05.2016.
 */
public class StadiumTest {
    @Test
    public void getId() throws Exception {
        Stadium olimp = new Stadium();
        int id=199,Id;
        olimp.setId(id);
        Id=olimp.getId();
        assertEquals(199,Id);
    }

    @Test
    public void getName() throws Exception {
        Stadium stadium = new Stadium();
        String name="olimp",newName;
        stadium.setName(name);
        newName=stadium.getName();
        assertEquals(newName,"olimp");
    }

    @Test
    public void getCapacity() throws Exception {
        Stadium nouCamp = new Stadium();
        int capacity=1000,capacityTaken;
        nouCamp.setCapacity(capacity);
        capacityTaken=nouCamp.getCapacity();
        assertEquals(1000,capacityTaken);
    }

    @Test
    public void getMatches() throws Exception {
        Set<Match> matches = new HashSet<Match>(0);
        Stadium stadium = new Stadium();
        stadium.setMatches(matches);
        assertEquals(matches, stadium.getMatches());
    }

    @Test
    public void getTown() throws Exception {
        Stadium stadium = new Stadium();
        String town="Barcelona",setTown;
        stadium.setTown(town);
        setTown=stadium.getTown();
        assertEquals(setTown,"Barcelona");
    }

    @Test
    public void setId() throws Exception {
        Stadium nouCamp = new Stadium();
        int id=91,Id;
        nouCamp.setId(id);
        Id=nouCamp.getId();
        assertEquals(91,Id);
    }

    @Test
    public void setName() throws Exception {
        Stadium stadium = new Stadium();
        String name="campNou",newName;
        stadium.setName(name);
        newName=stadium.getName();
        assertEquals(newName,"campNou");
    }

    @Test
    public void setCapacity() throws Exception {
        Stadium olimp = new Stadium();
        int capacity=2000,capacityTaken;
        olimp.setCapacity(capacity);
        capacityTaken=olimp.getCapacity();
        assertEquals(2000,capacityTaken);
    }

    @Test
    public void setTown() throws Exception {
        Stadium stadium = new Stadium();
        String town="Shchuchin",setTown;
        stadium.setTown(town);
        setTown=stadium.getTown();
        assertEquals(setTown,"Shchuchin");
    }

    @Test
    public void setMatches() throws Exception {
        Set<Match> matches = new HashSet<Match>(0);
        Stadium stadium = new Stadium();
        stadium.setMatches(matches);
        assertTrue(matches == stadium.getMatches());
    }
	
   @Test
    public void testEquals() throws Exception {
        Stadium stadium = new Stadium();
        stadium.setName("Olimp");
		stadium.setCapacity(10000);
        Stadium stadium2 = new Stadium();
        stadium2.setName("Olimp");
		stadium2.setCapacity(10000);
        System.out.println(stadium.equals(stadium2));
        assertTrue(stadium.getName().equals(stadium2.getName()));
    }

}