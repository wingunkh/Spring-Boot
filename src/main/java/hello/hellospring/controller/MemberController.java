package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //스프링 빈으로 자동 등록
public class MemberController {
    private final MemberService memberService;

    @Autowired //객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
