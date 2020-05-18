package co.johncortes.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.johncortes.demo.interfaceService.IPersonService;
import co.johncortes.demo.model.Person;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
	
	@Autowired
	private IPersonService service;
	
	@GetMapping("/list")
	public String listar(Model model) {
		List<Person> persons = service.list();
		model.addAttribute("persons",persons);
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("person", new Person());
		return "form";
	}

	@PostMapping("/save")
	public String save(@Valid Person p, Model model) {
		service.save(p);
		return "redirect:/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<Person> person = service.listById(id);
		model.addAttribute("person", person);
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);;
		return "redirect:/list";
	}
}
