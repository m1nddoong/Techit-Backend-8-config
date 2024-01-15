package com.example.article;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// 개발 환경(profile = dev 일때)에서만 사용하고 싶은 Controller
// Profile Annotation
// 특정 Profile 에서만 Bean으로 등록하고 싶을 때
@Profile("dev")
public class MonitorController {
    @GetMapping("/monitor")
    @ResponseBody
    public String test() {
        return "monitor";
    }
}
