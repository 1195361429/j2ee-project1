package com.jelusalering.dao;

import Database.GoodsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class GoodsDAO {
    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();



    public List selectAll() {
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();

        List list = null;
        Query query = session.createQuery("from GoodsEntity ");
        list = query.list();
        ts.commit();
        session.close();
        return list;
    }

    public void addCustomer(GoodsEntity goodsEntity){
        Session session =sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        session.save(goodsEntity);
        ts.commit();
        session.close();
    }
    public void  deleteCustomer(GoodsEntity goodsEntity){
        Session session=sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        session.delete(goodsEntity);
        ts.commit();
        session.close();
    }
    public  void  updateCustomer(GoodsEntity goodsEntity){
        Session session =sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        Query query=session.createQuery("update GoodsEntity u set u.gname='"+goodsEntity.getGname()+"',u.gtype='"+goodsEntity.getGtype()+"',u.ggrand='"+goodsEntity.getGgrand()+"',u.gunit='"+goodsEntity.getGunit()+"',u.ginprice='"+goodsEntity.getGinprice()+"',u.goutprice='"+goodsEntity.getGoutprice()+"',u.gdescription='"+goodsEntity.getGdescription()+"' where u.gcode='"+goodsEntity.getGcode()+"'");
        query.executeUpdate();
        ts.commit();
        session.close();
    }
    public List selectGoods(String gcode){
        Session session =sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        Query query =session.createQuery("from GoodsEntity ue where ue.gcode='"+gcode+"'");
        List list=query.list();
        return  list;
    }
    public List selectByName(String name){
        Session session=sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        Query query =session.createQuery("from GoodsEntity ue where  ue.gname like:name");
        query.setString("name","%"+name+"%");
        List list =query.list();
        return  list;
    }

}
