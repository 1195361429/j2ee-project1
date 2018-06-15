package com.jelusalering.dao;

import Database.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
public class UserDAO {
    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();



    public List selectAll() {
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        List<UserEntity> list = null;
        Query query = session.createQuery("from UserEntity ");
        list = query.list();
        ts.commit();
        session.close();
        return list;
    }
    public void addSalelist(UserEntity userEntity){
        Session session =sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        session.save(userEntity);
        ts.commit();
        session.close();
    }
   public void  deleteSalelist(UserEntity userEntity){
        Session session=sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        session.delete(userEntity);
        ts.commit();
        session.close();
    }
   /* public  void  deleteSalelist(String account){
        Session session=sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        UserEntity userEntity ;
        Query query= session.createQuery("from  UserEntity where uaccount="+account);
        userEntity=(UserEntity)((query.list()).get(0));
  //      session.delete(userEntity);
        ts.commit();
        session.close();
    }*/
    public  void  updateSalelist(UserEntity userEntity){
        Session session =sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        Query query=session.createQuery("update UserEntity u set u.uname='"+userEntity.getUname()+"',u.urole='"+userEntity.getUrole()+"',u.ustate='"+userEntity.getUstate()+"' where  u.uaccount='"+userEntity.getUaccount()+"'");
        query.executeUpdate();
        ts.commit();
        session.close();
    }
    public List selectSalelist(String account){
        Session session =sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        Query query =session.createQuery("from UserEntity ue where ue.uaccount='"+account+"'");
        List list=query.list();
        return  list;
    }
    public List selectByName(String name){
        Session session=sessionFactory.openSession();
        Transaction ts =session.beginTransaction();
        Query query =session.createQuery("from UserEntity ue where  ue.uaccount ='"+name+"'");
        List list =query.list();
        return  list;
    }
}
