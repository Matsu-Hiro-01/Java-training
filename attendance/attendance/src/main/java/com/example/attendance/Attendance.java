package com.example.attendance;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendance_logs")
public class Attendance {
    //打刻タイプを定義するEnum
    public enum PunchType {
        ATTENDANCE, //出勤
        LEAVE; //退勤
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "punch_Type", nullable = false)
    private PunchType punchType;

    @Column(name = "Punch_Time", nullable = false)
    private LocalDateTime punchTime;

    public Attendance() {}

    public Attendance(PunchType punchType, LocalDateTime punchTime) {
        this.punchType = punchType;
        this.punchTime = punchTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PunchType getPunchType() {
        return punchType;
    }

    public void setPunchType(PunchType punchType) {
        this.punchType = punchType;
    }

    public LocalDateTime getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(LocalDateTime punchTime) {
        this.punchTime = punchTime;
    }
}
