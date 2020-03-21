package it.polito.tdp.alien;

import java.net.URL;

import java.security.InvalidParameterException;
import java.util.*;

import it.polito.tdp.alien.model.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary alienDictionary = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtTranslation;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {
    	txtInsert.clear();
    	txtTranslation.clear();
    	alienDictionary.getDizionario().clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {

    	String textInserito = txtInsert.getText().toLowerCase();
    	String array [] = textInserito.split(" ");
    	String alienWord = null;
    	Set<String> translation = new TreeSet<>();
    	
    	for(String s : array)
    		if(s.compareTo("")!=0) {
    			if(alienWord==null)
    				alienWord = s;
    			else
    				translation.add(s);
    		}
    	
    	if(translation.size()>0) {
    		try {
    			alienDictionary.addWord(alienWord, translation);
    			txtTranslation.setText("PAROLA AGGIORNATA CORRETTAMENTE");
    			
    		} catch (InvalidParameterException ipe) {
    			txtTranslation.setText("LA PAROLA ALIENA DEVE CONTENERE SOLO LETTERE");
    		} catch (IllegalStateException ise) {
    			txtTranslation.setText("PRESENTI TRADUZIONI NON SONO VALIDE");
    		}
    		
    		txtInsert.clear();
    		
    	} else if(translation.size()==0) {
    		String translationS = alienDictionary.translateWord(alienWord);
    		if(translationS==null) 
    			translationS = "PAROLA NON PRESENTE NEL DIZIONARIO";
    		txtTranslation.setText(translationS);
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txrInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTranslation != null : "fx:id=\"txtTranslation\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
