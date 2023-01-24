package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello") //http://localhost:8080/hello
    public String method(Model model){
        model.addAttribute("data", "hello!!!"); //키와 값
        return "hello"; //컨트롤러에서 리턴 값으로 문자열을 반환하면 뷰 리졸버가 화면을 찾아서 처리한다.
    }

    @GetMapping("hello-mvc") //http://localhost:8080/hello-mvc?name=
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-templates";
    }
}