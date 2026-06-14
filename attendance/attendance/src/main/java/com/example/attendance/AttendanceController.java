package com.example.attendance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    //AttendanceServiceを使うためにフィールでに設定してコンストラクタを作成
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    // メイン画面（打刻ボタンとログ一覧を表示）
    public String showMainPage(Model model) {
        //DBからログを取得してThymeLeafに渡す
        model.addAttribute("logs", attendanceService.getAllLogs());
        return "attendance_main";
    }

    //出勤ボタンが押されたときの処理
    @PostMapping("/punch-in")
    public String PunchIn() {
        attendanceService.punchIn();
        return "redirect:/attendance";
    }

    //退勤ボタンが押されたときの処理
    @PostMapping("/punch-out")
    public String PunchOut() {
        attendanceService.punchOut();
        return "redirect:/attendance";
    }
}
