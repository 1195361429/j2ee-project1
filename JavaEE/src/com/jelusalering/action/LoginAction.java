package com.jelusalering.action;

import Database.UserEntity;
import com.jelusalering.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.deploy.net.HttpResponse;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginAction  extends ActionSupport{
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    private String username;
    private String password;
    private String warning;


    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;

    @Override
    public String execute() throws Exception {
        UserEntity userEntity ;
        UserDAO userDAO= new UserDAO();
        List<UserEntity> list=userDAO.selectByName(username);
        if (list.size()==0){
            warning="该用户不存在";
            return  ERROR;
        }else if(list.get(0).getUpwd().equals(password)){
        HttpServletResponse response= ServletActionContext.getResponse();
            HttpServletRequest request=ServletActionContext.getRequest();
         HttpSession session= request.getSession();
            Cookie cookie =new Cookie("account",username);
            if(list.get(0).getUstate().equals("正常")) {
                if (list.get(0).getUrole().equals("超级管理员")){
                    privilege=1;
                    session.setAttribute("privilege",1);
                }else if(list.get(0).getUrole().equals("库存管理员")){
                    privilege=3;
                    session.setAttribute("privilege",3);
                }else
                {
                    privilege=2;
                    session.setAttribute("privilege",2);
                }
                response.addCookie(cookie);
                return SUCCESS;
            }else{
                warning="账户已被冻结";
                return  ERROR;
            }
        }else {
            warning="密码错误";
            return  ERROR;
        }


    }
}
