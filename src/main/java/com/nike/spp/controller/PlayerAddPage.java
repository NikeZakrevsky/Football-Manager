package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Team;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Nike on 27.05.2016.
 */
public class PlayerAddPage extends ActionSupport {

    @Autowired
    DAO dao;

    List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String execute() throws Exception {
        teams = dao.getTeams();
        return SUCCESS;
    }
}