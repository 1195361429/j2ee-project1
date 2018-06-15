package com.jelusalering.action;

import Database.UserEntity;
import com.jelusalering.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DelUsersAction extends ActionSupport {
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;

    private  String account;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
        }
        if (privilege == 1) {


        UserEntity userEntity=new UserEntity();
        userEntity.setUaccount(account);
        userEntity.setUstate("as");
        userEntity.setUrole("as");
        userEntity.setUpwd("sd");
        userEntity.setUname("894");
        UserDAO userDAO =new UserDAO();
        userDAO.deleteSalelist(userEntity);
        return SUCCESS;}
        else if (privilege==2||privilege==3){
            return ERROR;

        }else {
            return  LOGIN; }
    }
}
