package reivosar.intarfaces.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import reivosar.intarfaces.model.web.DemoForm;

@Controller
@RequestMapping(value = "demo")
public class DemoController
{
	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("form", new DemoForm());
		return "demo/index";
	}
}
