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
import java.util.ArrayList;
import model.Player;

import model.game;


/**
 *
 * @author siwar
 */


public class ViewLogic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9038452627289746649L;
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
    
    public void executeSysExit()
        {
            controller.executeSysExit();
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
         public boolean addNewUser( String userName, String pass, String firstName, String lastName)
         {
             return controller.addNewUser(userName, pass, firstName, lastName);
         }
         
        public game restartGame(game myGame)
       {
          return controller.restartGame(myGame);
       }
         public Player checkLogIn(String userName, String passWord){
             return controller.checkLogIn(userName, passWord);             
         }
         
         public void setStatus(boolean s)
         {
        	 controller.setStatus(s);
         }
         public int checkWinOnStart()
         {
            return controller.checkWinOnStart();
         }
         
         public boolean checkNewRecord(){
            return controller.checkNewRecord();
        }
         
         public void nextRound(){
              controller.nextRound();
         }
         
         public int calculateScoreForGame(){
             return controller.calculateScoreForGame();
         }
         
         public void setCurrentGame(game currentGame) {
		controller.setCurrentGame(currentGame);
	}
         
          /*
            * Hit function        
         * This function hits the player with a card
         * If the player wins or looses he gets a message 
         * If the player is legal to get the next card this function returns the string of the card's image source
         * @return String Image
         */
         public String hitButton(){
             String s=  this.controller.hit();
             if (s!=null){
             return s;  
             }
             else {
                 return "this is null";                 
             }
         }
         
         public ArrayList<String> standButton(){
             ArrayList<String> arr = this.controller.stand();
             return arr;
             
         }
          public ArrayList<String> getPlayerSHand(){
             return controller.getPlayersHand();
         }
          public ArrayList<String> getDealerSHand(){
             return controller.getDealerSHand();
         }
         
         public int checkWin()
         {
            return controller.checkWin();
         }
         public int getPlayerHand()
        {
         return controller.getPlayerHand();
        }
         
         public game getCurrentGame(){
            return controller.getCurrentGame();
       }
         
         
        
         public int getDealerHand()
        {
         return controller.getDealerHand();
        }
         
         
         
           public int getDealerHandAgterStand()
        {
         return controller.getDealerHandAfterStand();
        }
           
           
           public int getNumberOfWinnings(){
        	   return controller.getNumberOfWinnings();
           }
           
           public int getNumberOfLosts(){
        	   return controller.getNumberOfLosts();
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
