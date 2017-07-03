package gr.uoa.di.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseUtils {
    public static Session getSession() {
        Configuration cfg = new Configuration();
        cfg.configure("persistence.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        return factory.openSession();
    }
}