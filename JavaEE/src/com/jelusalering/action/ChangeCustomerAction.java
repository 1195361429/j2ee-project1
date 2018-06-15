package com.jelusalering.action;

import Database.CustomerEntity;
import com.jelusalering.dao.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChangeCustomerAction extends ActionSupport {
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

    private String ccode;
    private String newSPMC;
    private String newSPBH;
    private String text;
    private String description;
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
        if(privilege==1||privilege==2){
        List<CustomerEntity> list ;
        CustomerDAO customerDAO =new CustomerDAO();
        list=customerDAO.selectCustomer(ccode);
        CustomerEntity customerEntity =list.get(0);
        newSPMC=customerEntity.getCname();
        newSPBH=customerEntity.getClinkphone();
        text=customerEntity.getCaddress();
        description=customerEntity.getCdescription();
        return SUCCESS;}
        else if(privilege==3) {
            return ERROR;
        }
        else {
            return  LOGIN;
        }

  }
}
