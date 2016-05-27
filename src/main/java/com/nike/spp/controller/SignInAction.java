package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.User;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nike on 26.05.2016.
 */
public class SignInAction extends ActionSupport {

    @Autowired
    private DAO itemMasterDao;

    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() throws Exception {
        System.out.println(user.getLogin());
        itemMasterDao.addUser(user);
        return SUCCESS;

    }
}
