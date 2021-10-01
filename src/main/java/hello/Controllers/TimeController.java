package hello.Controllers;

import hello.Get_data;
import hello.Services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TimeController {
	@Autowired
	private TimeService timeService;

	@GetMapping("/time")
	public String greetingForm(Model model) {
		model.addAttribute("get_data", new Get_data());
		return "Time";
	}

	@PostMapping("/time")
	public  String greetingSubmit(@ModelAttribute Get_data get_data, Model model) {
		get_data.setSecond_value(timeService);
		model.addAttribute("get_data", get_data);
		return "Time";
	}

}
