package com.example.cdshop.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cdshop.domain.Cd;
import com.example.cdshop.domain.CdRepository;
import com.example.cdshop.domain.GenreRepository;

@Controller
public class CdController {
	
	@Autowired
	private CdRepository cdrepository;
	
	@Autowired
	private GenreRepository genrerepository;
	
	@RequestMapping(value= {"/cdlist", "/"})
	public String cdList(Model model) {
		model.addAttribute("cds", cdrepository.findAll());
		return "cdlist";
	}
	
	@RequestMapping(value= "/addcd")
	public String addcd(Model model) {
		model.addAttribute("cd", new Cd());
		model.addAttribute("genres", genrerepository.findAll());
		return "addcd";
	}
	
	@RequestMapping(value= "/modify/{id}", method= RequestMethod.GET)
	public String modifyCd(@PathVariable("id") Long cdId, Model model) {
		System.out.println("Modifying...");
		Optional<Cd> cd = cdrepository.findById(cdId);
		model.addAttribute("cd", cd);
		model.addAttribute("genres", genrerepository.findAll());
		return "modifycd";
	}
	
	@RequestMapping(value= "/save", method =  RequestMethod.POST)
	public String save (Cd cd) {
		cdrepository.save(cd);
		return "redirect:cdlist";
	}
	
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteCd(@PathVariable("id") Long id, Model model) {
		cdrepository.deleteById(id);
		return "redirect:../cdlist";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/cdrest")
	public @ResponseBody List <Cd> cdlistREST() {
		return (List <Cd>) cdrepository.findAll();
	}
	
	@GetMapping("/cdrestid/{id}")
	public @ResponseBody Optional<Cd> findCdREST(@PathVariable("id") Long id) {
		return cdrepository.findById(id);
	}
	
	

}
