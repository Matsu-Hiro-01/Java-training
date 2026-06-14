package com.example.attendance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    //最新の打刻が一番上にくるように並び替え
    List<Attendance>findAllByOrderByPunchTimeDesc();
}
