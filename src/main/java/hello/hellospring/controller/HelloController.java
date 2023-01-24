package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") //http://localhost:8080/hello
    public String method(Model model){
        model.addAttribute("data", "hello!!!"); //키와 값
        return "hello"; //컨트롤러에서 리턴 값으로 문자열을 반환하면 viewResolver가 화면을 찾아서 처리한다.
    }

    @GetMapping("hello-mvc") //http://localhost:8080/hello-mvc?name=
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-templates";
    }

    @GetMapping("hello-string") //http://localhost:8080/hello-string?name=
    @ResponseBody //Http Request의 Body부에 View 페이지가 아닌 반환값을 그대로 반환한다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //반환값이 문자열일 경우 문자열을 그대로 반환하지만,
    }

    @GetMapping("hello-api") //http://localhost:8080/hello-api?name=
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello; //반환값이 객체일 경우 viewResolver 대신에 HttpMessageConverter가 동작하여 JSON 방식으로 변환하여 반환한다.
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}