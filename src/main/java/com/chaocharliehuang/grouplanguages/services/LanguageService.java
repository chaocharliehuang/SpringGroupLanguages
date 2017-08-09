package com.chaocharliehuang.grouplanguages.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.chaocharliehuang.grouplanguages.models.Language;

@Service
public class LanguageService {
	
	private ArrayList<Language> languages = new ArrayList<Language>(Arrays.asList(
		new Language("Java", "James Gosling", "1.8"),
		new Language("Python", "Guido van Rossum", "3.6"),
		new Language("Javascript", "Brendon Eich", "1.9.5.23.247.2")
		));
	
	public ArrayList<Language> getLanguages() {
		return languages;
	}
	
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	public Language findLanguageByIndex(int index) {
		if (index < languages.size()) {
			return languages.get(index);
		} else {
			return null;
		}
	}
	
	public void deleteLanguage(int index) {
		if (index < languages.size()) {
			languages.remove(index);
		}
	}
	
	public void updateLanguage(int index, Language language) {
		if (index < languages.size()) {
			languages.set(index, language);
		}
	}
}
