package com.jelusalering.action;

import Database.GoodsEntity;
import com.jelusalering.dao.GoodsDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowGoodsAction extends ActionSupport {

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;
    public List<GoodsEntity> getList() {
        return list;
    }

    public void setList(List<GoodsEntity> list) {
        this.list = list;
    }

    private List<GoodsEntity> list;
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
        }
        if(privilege==1||privilege==3){
        GoodsDAO goodsDAO =new GoodsDAO();
        list=goodsDAO.selectAll();
           return SUCCESS;}
           else if(privilege==2){
            return ERROR;
        }else {
               return LOGIN;
        }
    }
}
