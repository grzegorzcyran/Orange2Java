package sda.orange.grcy.hibernateDemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private SessionFactory factory;

    public SessionFactory getFactory() {

        if (factory == null) {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Car.class)
                    .buildSessionFactory();
        }

        return factory;
    }
}
