package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Match;
import com.nike.spp.dto.Stadium;
import com.nike.spp.dto.Team;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Nike on 27.05.2016.
 */
public class MatchAddPage extends ActionSupport {
    @Autowired
    DAO dao;

    List<Team> teams;
    List<Stadium> stadiums;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("djh");
        teams = dao.getTeams();
        stadiums = dao.getStadiums();
        return SUCCESS;
    }
}
