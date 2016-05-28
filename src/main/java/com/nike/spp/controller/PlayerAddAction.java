package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Player;
import com.nike.spp.dto.Team;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nike on 27.05.2016.
 */
public class PlayerAddAction extends ActionSupport {

    @Autowired
    DAO dao;

    String team;
    Player player;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(player.getName());
        System.out.println(team);
        player.setTeamName(team);
        dao.savePlayer(player);
        return SUCCESS;
    }

    private boolean isEmptyString ( String value )
    {
        return value == null || "".equals ( value.trim () );
    }


    public void validate(){
        if (isEmptyString(player.getName()))
        {
            addFieldError("player.name","Name field is empty");
        }
        Pattern namePattern = Pattern.compile("^[A-Za-z ]{2,30}$");
        Matcher m = namePattern.matcher(player.getName());
        if (!m.matches())
        {
            addFieldError("team.name","The name is invalid");
        }
        boolean q = false;
        for ( Team teamOfList : dao.getTeams()) {
            if(this.team.equals(teamOfList.getName()))
            {
                q = true;
            }
        }
        if (!q)  addActionError ( "Данные не верны" );
    }
}