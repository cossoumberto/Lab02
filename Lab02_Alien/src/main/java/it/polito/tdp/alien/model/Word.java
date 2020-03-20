package it.polito.tdp.alien.model;

import java.util.*;

public class Word {
	
	private String alienWord;
	private Collection<String> translation;
	
	/** Costruttore parola aliena - traduzione
	 * @param alienWord parola aliena
	 * @param translation traduzione 
	 */
	public Word(String alienWord, Collection<String> translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		
		String tempT = "";
		
		for(String s : translation)
			tempT += s + "\n";
		
		return tempT;
	}

	public void addTranslation(Collection<String> translation) {
		this.translation.addAll(translation);
	}

}
