package it.polito.tdp.alien.model;

import java.security.InvalidParameterException;

import java.util.*;

public class AlienDictionary {
	
	private List <Word> dizionario = new LinkedList<> ();
	
	public List<Word> getDizionario() {
		return dizionario;
	}

	public void addWord(String alienWord, Set<String> translation) {
		Word word = null;
		Set<String> elementiDaEliminare = new HashSet<>();
		
		if(alienWord.matches("[a-zA-Z]*")==false) {
			throw new InvalidParameterException();
		}
	
		for(String s : translation)
			if(s.matches("[a-zA-Z]*")==false)
				elementiDaEliminare.add(s);

		if(elementiDaEliminare.size()>0)
			translation.removeAll(elementiDaEliminare);
		
		if(translation.size()>0) {
			if(this.equals(alienWord)==false){
					word = new Word(alienWord, translation);
					dizionario.add(word);
			} else {
				for(Word w : dizionario)
					if(w.getAlienWord().compareTo(alienWord)==0)
						w.addTranslation(translation);
			}
		}
		
		if(elementiDaEliminare.size()>0)
			throw new IllegalStateException();
	
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
