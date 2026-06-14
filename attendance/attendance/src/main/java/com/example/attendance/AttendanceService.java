package com.example.attendance;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository repository;
    //コンストラクタ設定
    public AttendanceService(AttendanceRepository Repository) {
        this.repository = Repository;
    }
    //出勤を記録する
    public void punchIn() {
        //PunchType.AttendanceにLocalDateTime.now()の値でlogに代入する
        Attendance log = new Attendance(Attendance.PunchType.ATTENDANCE, LocalDateTime.now());
        //DBを保存
        repository.save(log);
    }
    //退勤を記録する
    public void punchOut() {
        Attendance log = new Attendance(Attendance.PunchType.LEAVE, LocalDateTime.now());
        //DB保存
        repository.save(log);
    }
    //すべての打刻ログを取得する(画面表示用)
    public List<Attendance>getAllLogs() {
        return repository.findAllByOrderByPunchTimeDesc();
    }
}
