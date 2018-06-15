package com.jelusalering.action;

import Database.GoodsEntity;
import com.jelusalering.dao.GoodsDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddGoodAction extends ActionSupport{
    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    private int privilege;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInprice() {
        return inprice;
    }

    public void setInprice(String inprice) {
        this.inprice = inprice;
    }

    public String getOutprice() {
        return outprice;
    }

    public void setOutprice(String outprice) {
        this.outprice = outprice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrand() {
        return grand;
    }

    public void setGrand(String grand) {
        this.grand = grand;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private  String  name;
    private  String  code;
    private  String inprice;
    private  String outprice;
    private  String  type;
    private  String  grand;
    private  String  unit;
    private  String description;
    private  int  number;




    @Override
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("privilege")!=null){
            privilege=(Integer)session.getAttribute("privilege");
        }
        if (privilege == 1 || privilege == 3) {
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setGcode(code);
            goodsEntity.setGname(name);
            goodsEntity.setGdescription(description);
            goodsEntity.setGgrand(grand);
            goodsEntity.setGstoreNum(number);
            goodsEntity.setGtype(type);
            goodsEntity.setGunit(unit);
            goodsEntity.setGinprice(inprice);
            goodsEntity.setGoutprice(outprice);

            GoodsDAO goodsDAO = new GoodsDAO();
            goodsDAO.addCustomer(goodsEntity);
            return SUCCESS;
        } else if(privilege==2){
            return ERROR;
        }else {
            return LOGIN;
        }
    }

}

