package repository;

import connection.HibernateUtils;
import model.Person;
import org.hibernate.Session;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

public class PersonRepository {

    public List<Person> getAllStudents(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = session.getCriteriaBuilder().createQuery(Person.class); // aici definim criteria query-ul;
        Root<Person> personTable = criteriaQuery.from(Person.class);

        List<Person> studentsInDatabase = session.createQuery(criteriaQuery.select(personTable).where(criteriaBuilder.equal(personTable.get("isTrainer"), false))).list();

        if(studentsInDatabase.size() > 0){
            for(Person student : studentsInDatabase){
                System.out.println (student.toString());
            }
            return studentsInDatabase;
        }

        session.close();

        return null;
    }

    public List<Person> getAllTrainers(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = session.getCriteriaBuilder().createQuery(Person.class); // aici definim criteria query-ul;
        Root<Person> personTable = criteriaQuery.from(Person.class);

        List<Person> trainersInDatabase = session.createQuery(criteriaQuery.select(personTable).where(criteriaBuilder.equal(personTable.get("isTrainer"), true))).list();

        if(trainersInDatabase.size() > 0){
            for(Person student : trainersInDatabase){
                System.out.println (student.toString());
            }
            return trainersInDatabase;
        }

        session.close();

        return null;
    }
}
