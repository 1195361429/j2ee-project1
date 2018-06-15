package com.jelusalering.action;

import Database.UserEntity;
import com.jelusalering.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdateUsers extends ActionSupport {
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    private String userID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    private  String userName;
    private  String roles;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private  String state;
    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;
    @Override
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
        }
        if (privilege == 1) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUaccount(userID);
            userEntity.setUname(userName);
            userEntity.setUrole(roles);
            userEntity.setUstate(state);
            userEntity.setUpwd("lkdasl");
            UserDAO userDAO = new UserDAO();
            userDAO.updateSalelist(userEntity);
            return SUCCESS;
        } else if (privilege == 2||privilege==3) {
            return ERROR;

        } else {
            return LOGIN;
        }
    }

}
