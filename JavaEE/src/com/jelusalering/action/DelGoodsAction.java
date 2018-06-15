package com.jelusalering.action;

import Database.GoodsEntity;
import com.jelusalering.dao.GoodsDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DelGoodsAction  extends ActionSupport{
    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }
    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;
    private  String gcode;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
        }
        if (privilege==1||privilege==3){
        GoodsEntity goodsEntity =new GoodsEntity();
        goodsEntity.setGcode(gcode);
        goodsEntity.setGstoreNum(1);
        goodsEntity.setGdescription("sa");
        goodsEntity.setGoutprice("sd");
        goodsEntity.setGtype("s");
        goodsEntity.setGinprice("sada");
        goodsEntity.setGunit("asd");
        goodsEntity.setGgrand("sad");
        goodsEntity.setGname("sdad");
        GoodsDAO goodsDAO =new GoodsDAO();
        goodsDAO.deleteCustomer(goodsEntity);
        return  SUCCESS;}
        else if(privilege==2){
            return ERROR;
        }else {
            return LOGIN;
        }
    }
}
