package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CalcController {
    public record CalcResponse(double result){}

    @PostMapping("/calc")
    public CalcResponse Calcurate(@RequestBody Calc request) {
        double sum = switch(request.operator()) {
            case "+" -> request.number1() + request.number2();
            case "-" -> request.number1() - request.number2();
            case "*" -> request.number1() * request.number2();
            case "/" -> {
                if (request.number2() == 0) {
                    throw new IllegalArgumentException("0で割ることはできません");
                }
                yield request.number1() / request.number2();
            }
            default -> throw new IllegalArgumentException("無効な演算子です");
        };
        return new CalcResponse(sum);
    }
}
