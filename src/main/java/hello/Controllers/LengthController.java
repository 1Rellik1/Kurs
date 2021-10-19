package hello.Controllers;

import hello.Entities.Length;
import hello.Get_data;
import hello.Services.LengthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LengthController {
    @Autowired
    private LengthService lengthService;

    @GetMapping("/length")
    public String greetingForm(Model model) {
        model.addAttribute("get_data", new Get_data());
        return "Length";
    }

    @PostMapping("/length")
    public  String greetingSubmit(@ModelAttribute Get_data get_data, Model model) {
        get_data.setSecond_value(lengthService);
        model.addAttribute("get_data", get_data);
        return "Length";
    }
}
