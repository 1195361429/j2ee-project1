package com.jelusalering.action;

import Database.CustomerEntity;
import com.jelusalering.dao.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCustomer extends ActionSupport {
    String newSPMC;
    String newSPBH;
    String text;
    String description;

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;
    public String getNewSPMC() {
        return newSPMC;
    }

    public void setNewSPMC(String newSPMC) {
        this.newSPMC = newSPMC;
    }

    public String getNewSPBH() {
        return newSPBH;
    }

    public void setNewSPBH(String newSPBH) {
        this.newSPBH = newSPBH;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
        }
        if(privilege==1||privilege==2){

        Cookie[] cookies =request.getCookies();

        String dateStr = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
       dateStr= dateStr.substring(9);
        CustomerEntity customerEntity =new CustomerEntity();
        customerEntity.setCaddress(text);
        customerEntity.setCdescription(description);
        customerEntity.setClinkphone(newSPBH);
        customerEntity.setCname(newSPMC);
        customerEntity.setCstate("正常");
        customerEntity.setCcode(dateStr);
        CustomerDAO customerDAO=new CustomerDAO();
        customerDAO.addCustomer(customerEntity);
        return  SUCCESS;}
        else if(privilege==3){
            return ERROR;
        }
        else {
            return  LOGIN;
        }
    }
}
