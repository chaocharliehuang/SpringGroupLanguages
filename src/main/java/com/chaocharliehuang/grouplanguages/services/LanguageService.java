package com.chaocharliehuang.grouplanguages.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chaocharliehuang.grouplanguages.models.Language;
import com.chaocharliehuang.grouplanguages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public ArrayList<Language> getLanguages() {
		return (ArrayList<Language>) languageRepository.findAll();
	}
	
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public Language findLanguageById(Long id) {
		return languageRepository.findOne(id);
	}
	
	public void deleteLanguage(Long id) {
		if (languageRepository.exists(id)) {
			languageRepository.delete(id);
		}
	}
	
	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}
}
