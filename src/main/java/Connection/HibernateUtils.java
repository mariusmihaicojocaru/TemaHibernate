package Connection;

import Model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {
    public static SessionFactory sessionFactory; //obiectul care deschide conexiuni

    //la baza de date pentru executarea de operatiuni de scriere/citire

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration ();
                Properties settings = new Properties ();

                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/classroom?serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Root123456");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "validate"); //sau "create-drop"
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Attendance.class);
                configuration.addAnnotatedClass(Classroom.class);
                configuration.addAnnotatedClass(Module.class);
                configuration.addAnnotatedClass(Team.class);
                configuration.addAnnotatedClass(Topic.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder ()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static void shutdown(){
        getSessionFactory().close();
    }
}
