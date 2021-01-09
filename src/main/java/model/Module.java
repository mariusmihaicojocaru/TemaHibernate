package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "classroom", name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moduleId;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @OneToMany(mappedBy = "attendance")
    private List<Attendance> attendance;

    @ManyToOne
    @JoinColumn(name = "classroomId", foreignKey = @ForeignKey(name = "fk_module_classroom"))
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "topicId", foreignKey = @ForeignKey(name = "fk_module_topic"))
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "trainerId", foreignKey = @ForeignKey(name = "fk_module_student"))
    private Person person;

    @ManyToOne
    @JoinColumn(name = "teamId", foreignKey = @ForeignKey(name = "fk_module_team"))
    private Team team;

    public Module () {}

    public Module (Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Module (Date startDate, Date endDate, Classroom classroom, Topic topic, Person person, Team team) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.classroom = classroom;
        this.topic = topic;
        this.person = person;
        this.team = team;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public int getModuleId () { return moduleId; }

    public void setModuleId (int moduleId) { this.moduleId = moduleId; }

    public Classroom getClassroom () { return classroom; }

    public void setClassroom (Classroom classroom) { this.classroom = classroom; }

    public Topic getTopic () { return topic; }

    public void setTopic (Topic topic) { this.topic = topic; }

    public Person getPerson () { return person; }

    public void setPerson (Person person) { this.person = person; }

    public Team getTeam () { return team; }

    public void setTeam (Team team) { this.team = team; }

    @Override
    public String toString () {
        return "Module{" +
                "Start Date = " + startDate +
                ", End Date = " + endDate +
                '}';
    }
}
