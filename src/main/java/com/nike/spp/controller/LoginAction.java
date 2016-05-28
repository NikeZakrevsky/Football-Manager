package com.nike.spp.controller;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by Nike on 26.05.2016.
 */
public class LoginAction extends ActionSupport implements SessionAware {

    @Autowired
    private DAO itemMasterDao;

    String login;
    String password;

    private SessionMap<String,Object> session;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String logout() throws Exception {
        session.invalidate();
        return Action.SUCCESS;
    }

    @Override
    public String execute() throws Exception{
        System.out.println("login");
        System.out.println(login);
        if (login.isEmpty()) {
            addActionError("Username can't be blanked");
            return Action.LOGIN;
        } else {
            List<User> userList = itemMasterDao.getUserList();
            for (User user : userList) {
                System.out.println(user.getLogin());
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    session.put("id", user.getId());
                    session.put("login", user.getLogin());
                    session.put("role", user.getRole().getName());
                    return Action.SUCCESS;
                }
            }
        }
        return Action.LOGIN;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = (SessionMap) map;
    }
}
