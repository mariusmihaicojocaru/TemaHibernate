package Model;

import javax.persistence.*;

@Entity
@Table(schema = "classroom", name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;

    @Column(name = "attendance_date")
    private String name;

    @Column(name = "is_present")
    private boolean isPresent;

    @ManyToOne
    @JoinColumn(name = "moduleId", foreignKey = @ForeignKey(name = "fk_attendance_module"))
    private Module module;

    @ManyToOne
    @JoinColumn(name = "personId", foreignKey = @ForeignKey(name = "fk_attendance_student"))
    private Attendance attendance;

    public Attendance(){}

    public Attendance(String name, boolean isPresent){
        this.name = name;
        this.isPresent = isPresent;
    }

    public Attendance (String name, boolean isPresent, Module module, Attendance attendance) {
        this.name = name;
        this.isPresent = isPresent;
        this.module = module;
        this.attendance = attendance;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public boolean isPresent () {
        return isPresent;
    }

    public void setPresent (boolean present) {
        isPresent = present;
    }

    public int getAttendanceId () { return attendanceId; }

    public void setAttendanceId (int attendanceId) { this.attendanceId = attendanceId; }

    public Module getModule () { return module; }

    public void setModule (Module module) { this.module = module; }

    public Attendance getAttendance () { return attendance; }

    public void setAttendance (Attendance attendance) { this.attendance = attendance; }

    @Override
    public String toString () {
        return "Attendance{" +
                "name='" + name + '\'' +
                ", isPresent=" + isPresent +
                '}';
    }
}
