package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "classroom", name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;

    @Column(name = "topic_name")
    private String name;

    @OneToMany(mappedBy = "topic")
    private List<Module> module;

    public Topic () {}

    public Topic(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString () {
        return "Topic{" +
                "name='" + name + '\'' +
                '}';
    }
}
