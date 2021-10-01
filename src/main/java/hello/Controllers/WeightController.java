package hello.Controllers;

import hello.Get_data;
import hello.Services.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeightController {
    @Autowired
    private WeightService weightService;

    @GetMapping("/weight")
    public String greetingForm(Model model) {
        model.addAttribute("get_data", new Get_data());
        return "Weight";
    }

    @PostMapping("/weight")
    public  String greetingSubmit(@ModelAttribute Get_data get_data, Model model) {
        get_data.setSecond_value(weightService);
        model.addAttribute("get_data", get_data);
        return "Weight";
    }
}
