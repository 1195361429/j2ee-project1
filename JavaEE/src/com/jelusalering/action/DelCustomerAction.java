package com.jelusalering.action;

import Database.CustomerEntity;
import Database.UserEntity;
import com.jelusalering.dao.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DelCustomerAction extends ActionSupport {
    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;

    private  String ccode;
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
        }
        if(privilege==1||privilege==2){
        CustomerEntity userEntity =new CustomerEntity();
        userEntity.setCcode(ccode);
        userEntity.setCstate("as");
        userEntity.setCname("as");
        userEntity.setCdescription("sd");
        userEntity.setCaddress("894");
        userEntity.setClinkphone("afasa");
        CustomerDAO userDAO =new CustomerDAO();
        userDAO.deleteCustomer(userEntity);
        return SUCCESS;}
        else if(privilege==3){
            return ERROR;
        }else {
            return LOGIN;
        }
    }
}
