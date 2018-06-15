package com.jelusalering.action;

import Database.CustomerEntity;
import com.jelusalering.dao.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdateCustomer extends ActionSupport{
    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

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
    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;

    private String ccode;
   private String newSPMC;
   private String newSPBH;
   private  String  text;
   private String description;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
        }
        if(privilege==1||privilege==2){
        CustomerEntity customerEntity =new CustomerEntity();
        customerEntity.setClinkphone(newSPBH);
        customerEntity.setCaddress(text);
        customerEntity.setCcode(ccode);
        customerEntity.setCdescription(description);
        customerEntity.setCname(newSPMC);
        CustomerDAO customerDAO =new CustomerDAO();
        customerDAO.updateCustmoer(customerEntity);
        return SUCCESS;}
        else if(privilege==3){
            return ERROR;
        }else {
            return LOGIN;
        }

    }
}
