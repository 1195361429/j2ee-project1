package com.jelusalering.action;

import Database.UserEntity;
import com.jelusalering.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddUsersAction  extends ActionSupport {

    String userID;
    String passwd1;
    String userName;
    String roles;

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPasswd1() {
        return passwd1;
    }

    public void setPasswd1(String passWD1) {
        this.passwd1 = passWD1;
    }

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
            userEntity.setUpwd(passwd1);
            userEntity.setUname(userName);
            userEntity.setUrole(roles);
            userEntity.setUstate("正常");
            UserDAO userDAO = new UserDAO();
            userDAO.addSalelist(userEntity);
            return SUCCESS;
        } else if(privilege==2||privilege==3) {
            return ERROR;
        }else {
            return LOGIN;
        }
    }
}