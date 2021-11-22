package com.example.cdshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	

}
