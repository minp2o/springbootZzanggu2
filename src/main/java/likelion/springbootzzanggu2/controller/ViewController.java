package likelion.springbootzzanggu2.controller;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    @GetMapping("story")
    public String story(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "story";
    }
}




