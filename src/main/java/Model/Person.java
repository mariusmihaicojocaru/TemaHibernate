package Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(schema = "classroom", name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategie folosita pentru generarea ID-ului
    @Column (name = "personID")
    private int personId;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Column (name = "date_of_birth")
    private Date dateOfBirth;

    @Column (name = "is_trainer")
    private boolean isTrainer;

    @Column (name = "team_id")
    private int teamId;

    @OneToMany(mappedBy = "person")
    private List<Module> module;

    @OneToMany(mappedBy = "attendance")
    private List<Attendance> attendance;

    @ManyToOne
    @JoinColumn(name = "teamId", foreignKey = @ForeignKey(name = "fk_student_team"))
    private Team team;

    public Person(){}

    public Person (String firstName, String lastName, String email, Date dateOfBirth, boolean isTrainer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.isTrainer = isTrainer;
    }

    public Person (String firstName, String lastName, String email, Date dateOfBirth, boolean isTrainer, int teamId, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.isTrainer = isTrainer;
        this.teamId = teamId;
        this.team = team;
    }

    public int getPersonId () {
        return personId;
    }

    public void setPersonId (int personId) {
        this.personId = personId;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public Date getDateOfBirth () {
        return dateOfBirth;
    }

    public void setDateOfBirth (Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isTrainer () {
        return isTrainer;
    }

    public void setTrainer (boolean trainer) {
        isTrainer = trainer;
    }

    public int getTeamId () {
        return teamId;
    }

    public void setTeamId (int teamId) {
        this.teamId = teamId;
    }

    public Team getTeam () { return team; }

    public void setTeam (Team team) { this.team = team; }



    @Override
    public String toString () {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", isTrainer=" + isTrainer +
                ", teamId=" + teamId +
                '}';
    }
}

