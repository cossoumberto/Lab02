package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;

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
    }

    @FXML
    void doTranslate(ActionEvent event) {

    	String textInserito = txtInsert.getText().toLowerCase();
    	String array [] = textInserito.split(" ");
    	String alienWord = null;
    	String translation = null;
    	
    	for(String s : array)
    		if(s.compareTo("")!=0) {
    			if(alienWord==null)
    				alienWord = s;
    			else
    				translation = s;
    		}
    	
    	if(translation!=null) {
    		try {
    			alienDictionary.addWord(alienWord, translation);
    			txtTranslation.setText("PAROLA AGGIORNATA CORRETTAMENTE");
    			
    		} catch (InvalidParameterException e) {
    			txtTranslation.setText("LE PAROLE DEVE CONTENERE SOLO LETTERE");
    		}
    		txtInsert.clear();
    	}
    	
    	if(translation==null) {
    		translation = alienDictionary.translateWord(alienWord);
    		if(translation==null) 
    			translation = "PAROLA NON PRESENTE NEL DIZIONARIO";
    		txtTranslation.setText(translation);
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
