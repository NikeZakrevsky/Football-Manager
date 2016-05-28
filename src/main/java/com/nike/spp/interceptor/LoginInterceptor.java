package com.nike.spp.interceptor;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class LoginInterceptor extends AbstractInterceptor {

    @Autowired
    DAO dao;
    private List<String> allowedRoles = new ArrayList<String>();
    private List<String> disallowedRoles = new ArrayList<String>();

    public void setDisallowedRoles(String roles) {
        this.disallowedRoles = stringToList(roles);
    }

    public void setAllowedRoles(String roles) {
        this.allowedRoles = stringToList(roles);
    }

    public boolean isAllowed(HttpServletRequest request) {
        System.out.println(allowedRoles);
        HttpSession session = request.getSession();
        String userRole = (String) session.getAttribute("role");
        if(session.getAttribute("login") != null) {
            String username = (String) session.getAttribute("login");
            List<User> users = dao.getUserList();
            for(User user : users) {
                if(user.getLogin().equals(username))
                    for(String role : allowedRoles) {
                        System.out.println("Role : " + role);
                        if (userRole.equals(role)) {
                            for (String disRole : disallowedRoles)
                                if (userRole.equals(disRole))
                                    return false;
                            return true;
                        }
                    }
            }
        }
        return false;
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println(allowedRoles);
        System.out.println("inside auth interceptor");
        HttpServletRequest request = ServletActionContext.getRequest();
        if(!isAllowed(request))
            return Action.LOGIN;
        else
            return invocation.invoke();
    }

    public List<String> stringToList(String val) {
        if (val != null) {
            String[] list = val.split("[ ]*,[ ]*");
            return Arrays.asList(list);
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}