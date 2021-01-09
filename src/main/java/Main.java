import Connection.HibernateUtils;
import Model.Person;
import Repository.PersonRepository;
import org.hibernate.Session;


import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import static Connection.HibernateUtils.sessionFactory;

public class Main {
    public static void main (String[] args) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        if(session != null){
            System.out.println ("Connection good");
        }else{
            System.out.println ("WTH !!!");
        }

        PersonRepository personRepository = new PersonRepository();

        System.out.println ("TRAINERS:");
        personRepository.getAllTrainers ();

        System.out.println ("_______________________________");
        System.out.println ("STUDENTS:");
        personRepository.getAllStudents ();




//        for(Person person : personList){
//            System.out.println (person.toString());
//        }

//        Person person1 = new Person("Grigore", "Varlam", "grigorevarlam@yahoo.ro",
//                new Date (80, 7, 13), true);
//        Person person2 = new Person("Miaw", "Miawson", "miawmiawson@yahoo.ro",
//                new Date (83, 12, 25), true);
//        Person person3 = new Person("Dog", "Dogson", "dogdogson@yahoo.ro",
//                new Date (85, 1, 1), true);
//        Person person4 = new Person("Balan", "Emanuela", "balanemanuela@yahoo.ro",
//                new Date (95, 4, 5), false);
//        Person person5 = new Person("Balazs", "Calin", "balazscalin@yahoo.ro",
//                new Date (80, 4, 3), false);
//        Person person6 = new Person("Cojocaru", "Marius", "cojocarumarius@yahoo.ro",
//                new Date (92, 4, 4), false);
//        Person person7 = new Person("Tus", "Andreea", "tusandreea@yahoo.ro",
//                new Date (94, 2, 11), false);
//        Person person8 = new Person("Cer", "cel", "cercel@yahoo.ro",
//                new Date (83, 2, 17), false);
//        Person person9 = new Person("Handi", "Cap", "handicap@yahoo.ro",
//                new Date (88, 8, 2), false);
//        Person person10 = new Person("Gigi", "Becali", "gigibecali@yahoo.ro",
//                new Date (58, 2, 8), false);
//        Person person11 = new Person("Cancioc", "Constructor", "canciocconstructor@yahoo.ro",
//                new Date (83, 9, 11), false);
//        Person person12 = new Person("Alb", "Negru", "albnegru@yahoo.ro",
//                new Date (89, 3, 22), false);
//        Person person13 = new Person("Mic", "Mare", "micmare@yahoo.ro",
//                new Date (98, 07, 27), false);
//        Person person14 = new Person("Apa", "Ulei", "apaulei@yahoo.ro",
//                new Date (84, 07, 2), false);
//        Person person15 = new Person("Sarma", "Carne", "sarmacarne@yahoo.ro",
//                new Date (101, 6, 16), false);



    }

}
