package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "classroom", name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategie folosita pentru generarea ID-ului
    @Column
    private int teamId;

    @Column
    private String name;

    @OneToMany(mappedBy = "moduleId")
    private List<Module> module;

    @OneToMany(mappedBy = "personId")
    private List<Person> person;

    public Team () {}

    public Team (String name) {
        this.name = name;
    }

    public int getTeamID () {
        return teamId;
    }

    public void setTeamID (int teamID) {
        this.teamId = teamID;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getTeamId () {
        return teamId;
    }

    public void setTeamId (int teamId) {
        this.teamId = teamId;
    }

    public List<Module> getModule () {
        return module;
    }

    public void setModule (List<Module> module) {
        this.module = module;
    }

    public List<Person> getPerson () {
        return person;
    }

    public void setPerson (List<Person> person) {
        this.person = person;
    }

    @Override
    public String toString () {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }
}
