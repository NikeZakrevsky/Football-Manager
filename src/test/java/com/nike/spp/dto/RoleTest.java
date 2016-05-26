package com.nike.spp.dto;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by User on 24.05.2016.
 */
public class RoleTest {
    @Test
    public void getRole_id() throws Exception {
        Role role = new Role();
        int id=1,Id;
        role.setRole_id(id);
        Id=role.getRole_id();
        assertEquals(1,Id);
    }

    @Test
    public void getName() throws Exception {
        Role role = new Role();
        String name="admin",nName;
        role.setName(name);
        nName = role.getName();
        assertEquals("admin",nName);
    }
    @Test
    public void getRights() throws Exception {
        Role role = new Role();
        String rights="Common",newRights;
        role.setName(rights);
        newRights = role.getName();
        assertEquals("Common", newRights);
    }

    @Test
    public void getUsers() throws Exception {
        Role role = new Role();
        Set<User> users = new HashSet<User>(0);
        role.setUsers(users);
        assertEquals(users, role.getUsers());

    }

    @Test
    public void setRole_id() throws Exception {
        Role role = new Role();
        int role_id=2,Id;
        role.setRole_id(role_id);
        Id=role.getRole_id();
        assertEquals(2,Id);
    }

	
    @Test
    public void setName() throws Exception {
        Role role = new Role();
        String name="user",newName;
        role.setName(name);
        newName = role.getName();
        assertTrue("user" == newName);
    }

    @Test
    public void setRights() throws Exception {
        Role role = new Role();
        String rights="God",nRights;
        role.setName(rights);
        nRights = role.getName();
        assertTrue("God" == nRights);
    }

    @Test
    public void setUsers() throws Exception {
        Role role = new Role();
        Set<User> users = new HashSet<User>(0);
        role.setUsers(users);
        assertTrue(users == role.getUsers());
    }
	
   @Test
    public void testEquals() throws Exception {
        Role role = new Role();
        role.setName("admin");
		role.setRights("God");
        Role role2 = new Role();
        role2.setRights("God");
        role2.setName("admin");
        assertTrue(role.getName().equals(role2.getName()));
    }

}