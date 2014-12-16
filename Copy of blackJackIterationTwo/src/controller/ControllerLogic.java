/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import model.Card;

import model.ModelLogic;
import model.game;
import utils.Constants;
import view.ViewLogic;

/**
 *
 * @author siwar qaddur
 * @author lee weiner 
 * @author tal tenzer
 * @author aseel ibrahim
 */
public class ControllerLogic implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//***************************************** Variables *********************************************
	/**Singleton instance of this class, loaded on the first execution of ControllerLogic.getInstance()*/
	private static ControllerLogic instance;
	/**Boolean flag for class instance existence (singleton)*/
	private static boolean exists = false;
	/**ViewLogic reference pointer*/
	private static ViewLogic view; //assuming we've only one.
	/**ModelLogic reference pointer*/
	private static ModelLogic model; //assuming we've only one.
	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor, for singleton support. 
	 */
	private ControllerLogic() {
            new Constants();
		
	}
	//***************************************** Methods ***********************************************
	/**
	 * The method creates this class's instance & provides access to it, by returning a reference (singleton).
	 * @return reference to this class's only instance, or null if reference was already returned (singleton).
	 */
        
	protected static ControllerLogic getInstance() {
		try {
                    
			if(! exists){
				exists = true; // exists cant be done again
				model = ModelLogic.getInstance(); // creating the instance of model logic
                instance = new ControllerLogic(); // creating the instance of controller logic
				view = ViewLogic.getInstance(instance); // creating the instance of view logic and sending him his controller 
				view.executeLoginView(); // calling the activating functions which needed for the start window in user interface		
				return instance; // returning the instance of controller logic
			}
		} catch (IOException e) {
			System.err.println("Error: cannot initialize ModelLogic, please contact you administrator!"); 
			e.printStackTrace(); 
		}return null;
        }	
	
	
	
	//***************************************** CRUD Methods ******************************************
               
		// returning all cards from ModelLogic 
        public ArrayList<Card> getCards(){
            return model.getCards();
        }
                
        /* 
         * This function starts the game by supplying the openning of the game and deal button
         * This function calls the function in modelLogic which builds the deck of cards
         * After building the cards the fuction return the result of model function "startGame()" which calls the deal function from class game
        */
         public game getNextGame(){
             model.buildCards(); // activating the biulding cards function
            return model.startGame(); // activating start game function
        }
         
        public String hit(){
            //System.err.println("say whatr");
            return model.hitFunc();
        } 
        
        public int checkWin()
        {
                return model.getFlag();
         }

     	//********************************** Layer's closure procedure methods ****************************
        
         /*
          * Calls the method from model which prints the output from executing the file
          */
 		public void executeSysExit()  { 
             model.executeSysExit(); 		
 		}
         
        
}
