package com.jelusalering.action;


import Database.UserEntity;
import com.jelusalering.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class ShowUsersAction  extends ActionSupport {





   private  List<UserEntity> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name ;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    private  String num;

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
        if(privilege==1) {
            UserDAO userDAO = new UserDAO();
            list = userDAO.selectAll();
            return SUCCESS;
        }else if(privilege==2||privilege==3){
            return ERROR;
       }else {
            return  LOGIN;
        }

    }

    public List<UserEntity> getList() {
        return list;
    }

    public void setList(List<UserEntity> list) {
        this.list = list;
    }
}

