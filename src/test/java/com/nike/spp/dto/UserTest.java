package com.nike.spp.dto;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void getId() throws Exception {
        User user=new User();
        int id=99,Id;
        user.setId(id);
        Id=user.getId();
        assertEquals(99,Id);
    }

    @Test
    public void getTeams() throws Exception {
        User user = new User();
        Set<Team> teams = new HashSet<Team>(0);
        user.setTeams(teams);
        assertEquals(user.getTeams(), teams);
    }

    @Test
    public void getRole() throws Exception {
        User user=new User();
        Role role = new Role();
        role.setName("Admin");
        user.setRole(role);
        assertEquals(user.getRole().getName(), "Admin");
    }

    @Test
    public void getLogin() throws Exception {
        User user = new User();
        String login="Johny",setLogin;
        user.setLogin(login);
        setLogin=user.getLogin();
        assertEquals(setLogin,"Johny");
    }

    @Test
    public void getPassword() throws Exception {
        User user = new User();
        String password="1234qwer",setPassword;
        user.setPassword(password);
        setPassword=user.getPassword();
        assertEquals(setPassword,"1234qwer");
    }

    @Test
    public void setId() throws Exception {
        User user=new User();
        int id=23,Id;
        user.setId(id);
        Id=user.getId();
        assertEquals(23,Id);
    }

    @Test
    public void setRole() throws Exception {
        User user=new User();
        Role role = new Role();
        role.setRole_id(12);
        user.setRole(role);
        assertTrue(user.getRole().getRole_id() == 12);
    }

    @Test
    public void setLogin() throws Exception {
        User user = new User();
        String login="Nikita",setLogin;
        user.setLogin(login);
        setLogin=user.getLogin();
        assertEquals(setLogin,"Nikita");
    }

    @Test
    public void setPassword() throws Exception {
        User user = new User();
        String password="zxc123",setPassword;
        user.setPassword(password);
        setPassword=user.getPassword();
        assertEquals(setPassword,"zxc123");
    }

    @Test
    public void setTeams() throws Exception {
        User user = new User();
        Set<Team> teams = new HashSet<Team>(0);
        user.setTeams(teams);
        assertTrue(user.getTeams() == teams);
    }
	
    @Test
    public void testEquals() throws Exception {
        User user = new User();
        user.setLogin("Ilya");
        user.setPassword("123qwe");
        User user2 = new User();
        user2.setLogin("Ilya");
        user2.setPassword("123qwe");
        assertTrue(user.getLogin().equals(user2.getLogin()));
    }

























    @Test
    public void xvbnm() {

    }

    @Test
    public void m() {

    }
    @Test
    public void t() {

    }

    @Test
    public void b() {

    }

    @Test
    public void c() {

    }

}