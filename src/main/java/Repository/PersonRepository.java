package Repository;

import Connection.HibernateUtils;
import Model.Person;
import com.mysql.cj.xdevapi.Result;
import org.hibernate.Session;


import javax.persistence.criteria.CriteriaQuery;

import java.util.List;

public class PersonRepository {

    public List<Person> getAllStudents(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaQuery<Person> query = session.getCriteriaBuilder().createQuery(Person.class); // aici definim criteria query-ul;
        List<Person> personsInDatabase = session.createQuery(query.select(query.from(Person.class))).list(); // aici extragem din db studentii
        for(Person person : personsInDatabase){
            System.out.println (person.toString());
        }
        session.close();
        return personsInDatabase;
    }
}
