package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Match;
import com.nike.spp.dto.Team;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Nike on 27.05.2016.
 */
public class MatchListPage extends ActionSupport{
    @Autowired
    DAO dao;

    List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("djh");
        matches = dao.getMatches();
        System.out.println(matches);
        return SUCCESS;
    }
}
