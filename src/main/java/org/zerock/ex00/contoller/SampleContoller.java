package org.zerock.ex00.contoller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleContoller {

    @GetMapping("/basic")
    public void basic(){
        log.info("basic-------------");
    }

    @GetMapping("/ex01")
    public void ex01(
        @RequestParam("name") String name,
        @RequestParam(value="age", required = false, defaultValue = "10") int age
        ){
        log.info("ex1===============================");
        log.info(name);
        log.info(age);
    }

    @GetMapping("/ex04")
    public void ex04(Model model){
        model.addAttribute("list", new String[]{"AAA","BBB","CCC"});
    }

    @GetMapping("/ex05")
    public String ex05(RedirectAttributes rttr){
        rttr.addAttribute("v1", "ABC");
        rttr.addAttribute("v2", "XYZ");

        rttr.addFlashAttribute("core", "ABCDE");

        return "redirect:/sample/basic";
    }
}


