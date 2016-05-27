package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Player;
import com.nike.spp.dto.Team;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

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
}
