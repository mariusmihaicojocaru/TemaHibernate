package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "classroom", name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;

    @Column
    private Date date;

    @Column
    private boolean isPresent;

    @ManyToOne
    @JoinColumn(name = "moduleId", foreignKey = @ForeignKey(name = "fk_attendance_module"))
    private Module module;

    @ManyToOne
    @JoinColumn(name = "attendanceId",foreignKey = @ForeignKey(name = "fk_attendance_student"), insertable = false, updatable = false)
    private Attendance attendance;

    public Attendance(){}

    public Attendance(Date date, boolean isPresent){
        this.date = date;
        this.isPresent = isPresent;
    }

    public Attendance (Date date, boolean isPresent, Module module, Attendance attendance) {
        this.date = date;
        this.isPresent = isPresent;
        this.module = module;
        this.attendance = attendance;
    }

    public Date getDate () {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
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
                "name='" + date + '\'' +
                ", isPresent=" + isPresent +
                '}';
    }
}
