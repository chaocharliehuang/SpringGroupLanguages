package com.chaocharliehuang.grouplanguages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chaocharliehuang.grouplanguages.models.Language;
import com.chaocharliehuang.grouplanguages.services.LanguageService;

@Controller()
@RequestMapping("/languages")
public class GroupLanguages {
	
	private final LanguageService languageService;
	
	public GroupLanguages(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("")
	public String index(@ModelAttribute("language") Language language, Model model) {
		model.addAttribute("languages", languageService.getLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/new")
	public String createLanguage(
			@Valid @ModelAttribute("language") Language language,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("languages", languageService.getLanguages());
			return "index.jsp";
		} else {
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/{id}")
	public String showLanguage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("language", languageService.findLanguageById(id));
		return "language.jsp";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	@GetMapping("/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguageById(id);
		if (language != null) {
			model.addAttribute("language", language);
			return "edit.jsp";
		} else {
			return "redirect:/languages";
		}
	}
	
	@PostMapping("/edit/{id}")
	public String updateLanguage(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("language") Language language,
			BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
}
