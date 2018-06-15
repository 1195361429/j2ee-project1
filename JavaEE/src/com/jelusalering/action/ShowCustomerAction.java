package com.jelusalering.action;

import Database.CustomerEntity;
import com.jelusalering.dao.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowCustomerAction extends ActionSupport {
    public List<CustomerEntity> getList() {
        return list;
    }

    public void setList(List<CustomerEntity> list) {
        this.list = list;
    }

    private List<CustomerEntity> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    private  String name;
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
        if (privilege == 1 || privilege == 2) {
            CustomerDAO customerDAO = new CustomerDAO();
            list = customerDAO.selectAll();
            name = list.get(0).getCcode();
            num = Integer.toString(list.size());

            return SUCCESS;
        } else if (privilege == 3) {
            return ERROR;
        } else {
            return LOGIN;
        }
    }
}
