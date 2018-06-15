package com.jelusalering.dao;

import Database.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDAO {
    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

    public List selectAll() {
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();

        List list = null;
        Query query = session.createQuery("from CustomerEntity ");
        list = query.list();
        ts.commit();
        session.close();
        return list;
    }

    public void addCustomer(CustomerEntity customerEntity){
         Session session =sessionFactory.openSession();
         Transaction ts =session.beginTransaction();
         session.save(customerEntity);
         ts.commit();
         session.close();
    }
    public void  deleteCustomer(CustomerEntity customerEntity){
         Session session=sessionFactory.openSession();
         Transaction ts =session.beginTransaction();
         session.delete(customerEntity);
         ts.commit();
         session.close();
    }
    public  void  updateCustmoer(CustomerEntity userEntity){
        Session session =sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        Query query=session.createQuery("update CustomerEntity u set u.cname='"+userEntity.getCname()+"',u.clinkphone='"+userEntity.getClinkphone()+"',u.caddress='"+userEntity.getCaddress()+"',u.cdescription='"+userEntity.getCdescription()+"' where u.ccode='"+userEntity.getCcode()+"'");
        query.executeUpdate();
        ts.commit();
        session.close();
    }
    public List selectCustomer(String ccode){
        Session session =sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        Query query =session.createQuery("from CustomerEntity ue where ue.ccode='"+ccode+"'");
        List list=query.list();
        return  list;
    }
    public  List selectByName(String name){
        Session session=sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        Query query =session.createQuery("from CustomerEntity ue where  ue.cname like:name");
        query.setString("name","%"+name+"%");
        List list =query.list();
        return  list;

    }

}