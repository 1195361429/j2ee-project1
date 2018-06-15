package com.jelusalering.action;

import Database.GoodsEntity;
import com.jelusalering.dao.GoodsDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SelectGoods extends ActionSupport {
    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public List<GoodsEntity> getList() {
        return list;
    }

    public void setList(List<GoodsEntity> list) {
        this.list = list;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;

    private String good;
    private  List<GoodsEntity> list;
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
            if(privilege==1||privilege==3){
                if(good==null){
                    return ERROR;
                }
                else if(good.isEmpty()){
                    return  ERROR;
                }else {

                    GoodsDAO customerDAO =new GoodsDAO();
                    list = customerDAO.selectByName(good);
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
