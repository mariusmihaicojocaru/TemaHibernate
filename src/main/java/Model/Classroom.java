package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "classroom", name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroomId;

    @Column
    private String name;

    @Column
    private String address;

    @OneToMany(mappedBy = "classroom")
    private List<Module> module;

    public Classroom(){}

    public Classroom(String name, String address){
        this.name = name;
        this.address = address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    @Override
    public String toString () {
        return "Classroom{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
