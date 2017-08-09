package com.chaocharliehuang.grouplanguages.controllers;

import java.util.ArrayList;

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
		ArrayList<Language> languages = languageService.getLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/new")
	public String createLanguage(
			@Valid @ModelAttribute("language") Language language,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			ArrayList<Language> languages = languageService.getLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		} else {
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/{index}")
	public String showLanguage(Model model, @PathVariable("index") int index) {
		Language language = languageService.findLanguageByIndex(index);
		model.addAttribute("language", language);
		return "language.jsp";
	}
	
	@GetMapping("/delete/{index}")
	public String deleteLanguage(@PathVariable("index") int index) {
		languageService.deleteLanguage(index);
		return "redirect:/languages";
	}
	
	@GetMapping("/edit/{index}")
	public String editLanguage(@PathVariable("index") int index, Model model) {
		Language language = languageService.findLanguageByIndex(index);
		if (language != null) {
			model.addAttribute("language", language);
			return "edit.jsp";
		} else {
			return "redirect:/languages";
		}
	}
	
	@PostMapping("/edit/{index}")
	public String updateLanguage(
			@PathVariable("index") int index,
			@Valid @ModelAttribute("language") Language language,
			BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(index, language);
			return "redirect:/languages";
		}
	}
}
