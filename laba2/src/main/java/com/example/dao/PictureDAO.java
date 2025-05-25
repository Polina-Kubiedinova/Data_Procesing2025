package com.example.dao;

import com.example.model.Picture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
public class PictureDAO {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public void saveStudent (Picture picture){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(picture);
            session.getTransaction().commit();
        }
    }
    public List<Picture> getAllPictures(){
        try (Session session = sessionFactory.openSession()){
            return session.createQuery(s: "from project_db", Picture.class).list();
        }
    }
    public Picture getPictureById(Long id){
        try (Session session = sessionFactory.openSession())
        {
            return session.createQuery("from project_db", Picture.class).list();
        }
    }


}
