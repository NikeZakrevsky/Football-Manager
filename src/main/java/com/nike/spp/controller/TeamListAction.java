package com.nike.spp.controller;
import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Team;
import com.nike.spp.dto.User;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TeamListAction extends ActionSupport{

    @Autowired
    private DAO itemMasterDao;

    List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String execute() throws Exception {
        teams = itemMasterDao.getTeams();
        return SUCCESS;

    }
}