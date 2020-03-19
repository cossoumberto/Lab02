package it.polito.tdp.alien.model;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	private List <Word> dizionario = new LinkedList<> ();
	
	public List<Word> getDizionario() {
		return dizionario;
	}

	public void addWord(String alienWord, String translation) {
		Word word = null;
		
		if(alienWord.matches("[a-zA-Z]*")==false || translation.matches("[a-zA-Z]*")==false) {
			throw new InvalidParameterException();
		}
		
		if(this.equals(alienWord)==false) {
				word = new Word(alienWord, translation);
				dizionario.add(word);
		} else {
			for(Word w : dizionario)
				if(w.getAlienWord().compareTo(alienWord)==0)
					w.setTranslation(translation);
		}
	}
	
	public String translateWord(String alienWord) {
		for(Word w : dizionario) 
			if(w.getAlienWord().compareTo(alienWord)==0)
					return w.getTranslation();
		return null;
	}
	
	public boolean equals(String alienWord) {
		for(Word w : dizionario)
			if(w.getAlienWord().compareTo(alienWord)==0)
				return true;
		return false;
	}
}
