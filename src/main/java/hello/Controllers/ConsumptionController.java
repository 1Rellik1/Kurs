package hello.Controllers;

import hello.Get_data;
import hello.Services.ConsumptionService;
import hello.Services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ConsumptionController {
        @Autowired
        private ConsumptionService consumptionService;

        @GetMapping("/consumption")
        public String greetingForm(Model model) {
            model.addAttribute("get_data", new Get_data());
            return "Consumption";
        }

        @PostMapping("/consumption")
        public  String greetingSubmit(@ModelAttribute Get_data get_data, Model model) {
            get_data.setSecond_value(consumptionService);
            model.addAttribute("get_data", get_data);
            return "Consumption";
        }
}
