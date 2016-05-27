package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Match;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatchAddAction extends ActionSupport{
    @Autowired
    DAO dao;

    Match match;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(match.getStadiumName());
        System.out.println(match.getTeam1Name());
        System.out.println(match.getTeam2Name());
        dao.addMatch(match);
        System.out.println(match);
        return SUCCESS;
    }
}
