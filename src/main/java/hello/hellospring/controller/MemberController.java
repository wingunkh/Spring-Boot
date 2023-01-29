package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //스프링 빈으로 자동 등록
public class MemberController {
    private final MemberService memberService;

    @Autowired //객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //http://localhost:8080/members/new
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //http://localhost:8080/members/new
    //주어진 URI 표현식과 일치하는 POST 방식의 HTTP 요청을 처리한다.
    //templates/members/createMemberForm.html 파일의 POST 방식의 HTTP 요청을 처리하며 <input> 태그의 name 속성의 값이 form 객체의 name 속성의 값에 매핑된다.
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}