package it.polito.tdp.alien.model;

import java.util.List;

public class Word {
	
	private String alienWord;
	private String translation;
	
	/** Costruttore parola aliena - traduzione
	 * @param alienWord parola aliena
	 * @param translation traduzione 
	 */
	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

}
