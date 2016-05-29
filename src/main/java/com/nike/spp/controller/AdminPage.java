package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Player;
import com.nike.spp.dto.Stadium;
import com.nike.spp.dto.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AdminPage extends ActionSupport  {

    @Autowired
    private DAO dao;
    private List<User> users;
    private List<Stadium> stadiums;
    private List<Player> players;
    private Stadium stadium;
    private User user;
    private String role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String deleteStadium() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        dao.removeStadium(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    public String editStadium() {
        users = dao.getUserList();
        players = dao.getPlayers();
        stadiums = dao.getStadiums();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        stadium = dao.getStadiumByID(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    public String editUser() {
        users = dao.getUserList();
        players = dao.getPlayers();
        stadiums = dao.getStadiums();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        user = dao.getUserByID(Integer.parseInt(request.getParameter("id")));
        role = dao.getRole(user);
        return Action.SUCCESS;
    }

    public String deletePlayer() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        System.out.println(request.getParameter("id"));
        Stadium stadium = dao.getStadiumByID(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    public String deleteUser() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        User user = dao.getUserByID(Integer.parseInt(request.getParameter("id")));
        if (user.getRole().getName().equals("admin")) {
            int adminNumber = 0;
            for(User userListElement : dao.getUserList()) {
                if (userListElement.getRole().getName().equals("admin"))
                    adminNumber++;
            }
            if (adminNumber == 1) return Action.SUCCESS;
        }
        dao.removeUser(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    public String addStadium() {
        dao.addStadium(stadium);
        return Action.SUCCESS;
    }

    public String addUser() {
        dao.addUser(user,role);
        return Action.SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        users = dao.getUserList();
        players = dao.getPlayers();
        stadiums = dao.getStadiums();
        return Action.SUCCESS;
    }
}