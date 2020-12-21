package Model;

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

    @OneToMany(mappedBy = "module")
    private List<Module> module;

    @OneToMany(mappedBy = "person")
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

    @Override
    public String toString () {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }
}
