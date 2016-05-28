package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Team;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private boolean isEmptyString ( String value )
    {
        return value == null || "".equals ( value.trim () );
    }

    public void validate(){
        Pattern namePattern = Pattern.compile("^[A-Za-z0-9_-]{2,30}$");
        Matcher m = namePattern.matcher(team.getName());
        if (isEmptyString(team.getName()))
        {
            addFieldError("team.name","The name is empty");
        }
        if (!m.matches())
        {
            addFieldError("team.name","The name is invalid");
        }
        if (isEmptyString(team.getCoach()))
        {
            addFieldError("team.coach","Coach's name is empty");
        }
        Pattern coachPattern = Pattern.compile("^[A-Za-z ]{5,30}$");
        m = coachPattern.matcher(team.getCoach());
        if (!m.matches())
        {
            addFieldError("team.coach","Name of the coach is invalid");
        }
    }
}