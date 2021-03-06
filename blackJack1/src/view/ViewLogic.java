/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.Serializable;

import controller.ControllerLogic;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import model.game;


/**
 *
 * @author siwar
 */


public class ViewLogic implements Serializable {
	//***************************************** Variables *********************************************
	/**Singleton instance of this class, loaded on the first execution of ViewLogic.getInstance()*/
	private static ViewLogic instance;
	/**Boolean flag for class instance existence (singleton)*/
	private static boolean  exists = false;
	/**ControllerLogic reference pointer*/
    private ControllerLogic controller; 
    /** MainFrameDESK reference pointer*/
    private MainFrameDESK mf;
    /**Serilizing ViewLogic class*/
	private static final long serialVersionUID = 1L;

	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor, for singleton support. 
	 */
	private ViewLogic(ControllerLogic cl)
    {
        controller = cl; // connecting the right controller
    }
    
	//***************************************** Methods ***********************************************
	/**
	 * The method creates this class's instance & provides access to it, by returning a reference (singleton).
	 * @return reference to this class's only instance, or null if reference was already returned (singleton).
	 */
    public static ViewLogic getInstance(ControllerLogic cl) {
			if(! exists){
				exists = true; // accessing to this function may be done only once
				instance = new ViewLogic(cl); // creating the instance of view logic
				return instance; // returning the instance of view logic
			}
		return null;
	}
        
  //***************************************** CRUD Methods ******************************************
     
        /*
         * Starting the game function        
         * This function starts the game by calling the getNextGame() function in controllerLogic
         * The function is activated by clicking the deal button in userInterface
         * by clicking the button this function deals two cards to the player and two cards to the dealer
         */
         public game loadStringCard(){
             
             return controller.getNextGame(); // activating the start game functions in model which activates the deal function
             
         }
         
       //********************************** Layer's closure procedure methods ****************************
         
         /*
          * activating the MAIN start window of the game
          */
         public void executeLoginView() throws FileNotFoundException
         {
              mf= new MainFrameDESK(instance);
              mf.setVisible(true);
              // printing all output checks
              PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
              System.setOut(out);
         }
         
         
        
}
