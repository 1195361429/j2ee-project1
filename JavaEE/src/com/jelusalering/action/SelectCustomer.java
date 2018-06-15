package com.jelusalering.action;

import Database.CustomerEntity;
import com.jelusalering.dao.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SelectCustomer extends ActionSupport {
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    private String customer;

    public List<CustomerEntity> getList() {
        return list;
    }

    public void setList(List<CustomerEntity> list) {
        this.list = list;
    }

    private List<CustomerEntity> list;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;
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
            if(privilege==1||privilege==2){
                if(customer==null){
                    return ERROR;
                }
                else if(customer.isEmpty()){
                    return  ERROR;
                }else {

                    CustomerDAO customerDAO =new CustomerDAO();
                    list=  customerDAO.selectByName(customer);
                    number=list.size();
                    return  SUCCESS;
                }
            }else {
                return INPUT;
            }
        }else {
            return LOGIN;
        }
    }
}
