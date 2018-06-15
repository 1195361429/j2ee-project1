package com.jelusalering.action;

import Database.UserEntity;
import com.jelusalering.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChangeUsersAction extends ActionSupport {
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String account;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    private  String userID;
    private  String userName;
    private  String roles;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private  String state;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;

    private  String num;
    @Override
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
        }
        if (privilege == 1) {
            List<UserEntity> list;
            UserDAO userDAO = new UserDAO();
            list = userDAO.selectSalelist(account);
            UserEntity userEntity = (UserEntity) (list.get(0));
            userID = userEntity.getUaccount();
            userName = userEntity.getUname();
            roles = userEntity.getUrole();
            state = userEntity.getUstate();
            return SUCCESS;
        }else if(privilege==2||privilege==3) {
            return ERROR;

        }else {
             return LOGIN;
        }

    }
}
