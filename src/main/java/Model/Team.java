package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "classroom", name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategie folosita pentru generarea ID-ului
    @Column (name = "teamID")
    private int teamID;

    @Column (name = "team_name")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Module> module;

    @OneToMany(mappedBy = "team")
    private List<Person> person;

    public Team () {}

    public Team (String name) {
        this.name = name;
    }

    public int getTeamID () {
        return teamID;
    }

    public void setTeamID (int teamID) {
        this.teamID = teamID;
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
