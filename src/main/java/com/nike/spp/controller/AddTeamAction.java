package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Team;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Nike on 26.05.2016.
 */
public class AddTeamAction extends ActionSupport {

    @Autowired
    private DAO itemMasterDao;

    Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String execute() throws Exception {
        System.out.println(team.getName() + " " + team.getCoach());
        itemMasterDao.addTeam(team);
        return SUCCESS;

    }
}
