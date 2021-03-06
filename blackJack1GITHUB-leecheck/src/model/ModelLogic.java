/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import java.util.ArrayList;

import utils.MyFileLogWriter;

/**
 *
 * @author siwar
 */
public class ModelLogic implements Serializable  {
    
    /**
	 * 
	 */
	
	//***************************************** Variables *********************************************
	/**Singleton instance of this class, loaded on the first execution of ModelLogic.getInstance()*/
	private static ModelLogic instance;
	/**Boolean flag for class instance existence (singleton)*/
	private static boolean exists = false;
	/**SysData reference pointer*/
	private static SysData sData; 
	/**Serilizing the ModelLogic class*/
	private static final long serialVersionUID = 1L;
	/** the current game */
	private game currentGame;
	/** indication of winning */
	private int flag = 0;

	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor, for singleton support. 
	 */
	private ModelLogic() {
		MyFileLogWriter.initializeMyFileWriter();
                currentGame = new game();
	}
	//***************************************** Methods ***********************************************
	/**
	 * The method creates this class's instance & provides access to it, by returning a reference (singleton).
	 * @return reference to this class's only instance, or null if reference was already returned (singleton).
	 * @throws GeneralException 
	 */
	public static ModelLogic getInstance() {
		if(! exists){
			sData = SysData.getInstance(); // creating the sDatat instance
			
			if(sData != null){ 
				sData.buildCards(); // activating the biulding cards function
				SysData.executeInput(); // creating the input file
				exists = true; // accessing this func may be done only once
				instance  = new ModelLogic(); // creating the model logic instance
				return instance; // returning model logic instance
			}
		}return null;
	}
        
        
	
	//***************************************** CRUD Methods ******************************************
    
        public ArrayList<Card> getCards(){
            return sData.getCards(); // returning the deck ready for dealing
        }
        
       //siwar
        public game startGame(){
        game g = new game(1); // creating game 1
		g.setDeck(sData.getCards()); // setting the deck to the one returning from getCards() func
		g.startGame();
                System.err.print(g.toString());
                this.currentGame = g;
        return g; // returning the game which created
	}

        
        public String hitFunc(){

            //SIWAR	
       		String card = this.currentGame.hitFunc();
               this.flag= this.currentGame.getFlag();
               return card;
       				
       	}

               /*StandFunc compares the amount of cards between the dealer and the player and returns the array of cards */
               public ArrayList<String> standFunc(){
                //siwar
                   
                
               	ArrayList<String> setOfCardsToDealer = this.currentGame.standFunc();
               	this.flag = this.currentGame.getFlag();
               	
               	return setOfCardsToDealer;
               }
               
               public ArrayList<String> PlayerHand(){
                 
               	return this.currentGame.PlayerHand();
               }
               
               public ArrayList<String> DealerHand(){
                  
               	return this.currentGame.DealerHand();
               }
               
        
        
        
        
	
	public int getFlag(){
		return this.flag;
                
	}
	
    public int getPlayerHand()
    {
        Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
        return round.getPlayerAmount();       
    }
    
     public int getDealerHand()
    {
        Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
        return round.getDelaerAmount();       
    }
     
       public int getDealerHandAfterStand()
    {
        Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
        return round.getDelaerAmountAfterStand();       
    }
     
     public int checkWinOnStart()
     {
        return this.currentGame.getwinOnStart();
     }
     
     
     /**
		 * @return the sData
		 */
		public SysData getsData() {
			return sData;
		}
       
        
	//********************************** Layer's closure procedure methods ****************************
    
    /*
     * Calls the method from SDATA which prints the output from executing the file
     */   
	public void executeSysExit()
	{
		sData.executeOutput();
	}

        
    
    
}
