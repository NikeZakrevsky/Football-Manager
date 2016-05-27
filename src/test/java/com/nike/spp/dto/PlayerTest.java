package com.nike.spp.dto;
import org.junit.Test;
import org.springframework.core.NestedCheckedException;

import static org.junit.Assert.*;

/**
 * Created by User on 24.05.2016.
 */
public class PlayerTest {
    @Test
    public void getId() throws Exception {
        Player ronaldo=new Player();
        int id=9,Id;
        ronaldo.setId(id);
        Id=ronaldo.getId();
        assertEquals(9,Id);
    }


    @Test
    public void getTeam() throws Exception {
        Player player=new Player();
        Team team = new Team();
        team.setName("Spartak");
        player.setTeam(team);
        assertTrue(player.getTeam().getName() == "Spartak");
    }

    @Test
    public void getName() throws Exception {
        Player ronaldo=new Player();
        String name="lima",newName;
        ronaldo.setName(name);
        newName = ronaldo.getName();
        assertEquals("lima",newName);
    }

    @Test
    public void getNumber() throws Exception {
        Player best=new Player();
        int number=7,newNumber;
        best.setNumber(number);
        newNumber=best.getNumber();
        assertEquals(7, newNumber);
    }

    @Test
    public void getWeight() throws Exception {
        Player best=new Player();
        int weight=73,newWeight;
        best.setWeight(weight);
        newWeight=best.getWeight();
        assertEquals(73, newWeight);
    }


    @Test
    public void getHight() throws Exception {
        Player zidane=new Player();
        int hight=180,newHight;
        zidane.setHight(hight);
        newHight=zidane.getHight();
        assertEquals(180, newHight);
    }

    @Test
    public void setId() throws Exception {
        Player best=new Player();
        int id=7,Id;
        best.setId(id);
        Id=best.getId();
        assertEquals(7,Id);
    }

    @Test
    public void setTeam() throws Exception {
        Player player=new Player();
        Team team = new Team();
        team.setName("Neman");
        player.setTeam(team);
        assertEquals(player.getTeam().getName(),"Neman");
    }

    @Test
    public void setName() throws Exception {
        Player zico=new Player();
        String name="Arthur",newName;
        zico.setName(name);
        newName = zico.getName();
        assertEquals("Arthur",newName);
    }

    @Test
    public void setNumber() throws Exception {
        Player player=new Player();
        int number=21,newNumber;
        player.setNumber(number);
        newNumber=player.getNumber();
        assertEquals(21, newNumber);
    }

    @Test
    public void setWeight() throws Exception {
        Player zidane=new Player();
        int weight=65,newWeight;
        zidane.setWeight(weight);
        newWeight=zidane.getWeight();
        assertEquals(65, newWeight);
    }


    @Test
    public void setHight() throws Exception {
        Player ronaldo=new Player();
        int hight=175,newHight;
        ronaldo.setHight(hight);
        newHight=ronaldo.getHight();
        assertEquals(175, newHight);
    }

	@Test
    public void testEquals() throws Exception {
        Player player= new Player();
        player.setName("Dima");
        player.setHight(183);
        Player player2= new Player();
        player2.setName("Dima");
        player2.setHight(183);
        assertTrue(player.getName().equals(player2.getName()));
    }
}
