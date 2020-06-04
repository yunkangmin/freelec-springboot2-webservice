package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
//예전에는 @ResponseBody를 각 메서드마다 선언했던 것을 한 번에 사용할 수
//있게 해준다고 생각하면 된다.
@RestController
public class HelloController {

    //HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
    //예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용
    //되었다. 이제 이 프로젝트는 /hello로 요청이 오면 문자열 hello를 반환
    //하는 기능을 가지게 되었다.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    //@RequestParam
    //외부에서 API로 넘긴 파라미터를 가져오는 어노테이션이다.
    //여기서는 외부에서 name(@RequestParam("name"))이란 이름으로 넘긴 파라미터를
    //메소드 파라미터 name(String name)에 저장하게 된다.
    public HelloResponseDto helloDto(@RequestParam("name") String name
            , @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
