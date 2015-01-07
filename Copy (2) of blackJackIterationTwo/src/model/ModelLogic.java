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
	private static final long serialVersionUID = -2421267785539300695L;
	//***************************************** Variables *********************************************
	/**Singleton instance of this class, loaded on the first execution of ModelLogic.getInstance()*/
	private static ModelLogic instance;
	/**Boolean flag for class instance existence (singleton)*/
	private static boolean exists = false;
	/**SysData reference pointer*/
	private static SysData sData ; 
	/**Serilizing the ModelLogic class*/
	/** the current game */
	private game currentGame;
	/** indication of winning */
	private int flag = 0;
	
	private Player player;

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
                                
				//sData.executeInput();
				exists = true; // accessing this func may be done only once
				instance  = new ModelLogic(); // creating the model logic instance
                                
                               // SysData.executeInput(); // creating the input file
				return instance; // returning model logic instance
			}
		}return null;
	}
        
        
	
	//***************************************** CRUD Methods ******************************************
	/**
	 * 
	 * @param get the array of cards
	 */
        public ArrayList<Card> getCards(){
            return sData.getCards(); // returning the deck ready for dealing
        }
        
        
        /**
    	 * 
    	 * @param set status for game- if the player won - true,else false.
    	 */
        public void setStatus(boolean s)
        {
        this.currentGame.setStatus(s);	
        }
        
        
        /**
    	 * 
    	 * @param get name and password of player and check if the player exists. if so return the player.
    	 */ 
      public Player checkLogIn(String name, String passWord){
          
          Player player = new Player(name,passWord);
          SysData.executeInput();
          for (Player p: sData.getPlayers() ){
              if (p.getUserName().equals(player.getUserName()) && p.getPassWord().equals(player.getPassWord())){
                  this.player=p;
                  return p;
              }
              
              
          }
        return  null;
      }
      
      /**
  	 * 
  	 * @param add new user to the players of the game. return true if the player was added succesfully.
  	 */
        public boolean addNewUser( String userName, String pass, String firstName, String lastName)
         {
             Player p = new Player(userName, pass, firstName, lastName);
             if ( sData.getPlayers().add(p)){
                 sData.executeOutput();
                 return true;
             }
             else
                 return false;
         }
        
        /**
    	 * 
    	 * @param start the game. creates a game object.
    	 * @return the game that was created. 
    	 */
        public game startGame(){
            
         ArrayList<Card> temp = sData.getCards();
        game g = new game(this.player, temp); // creating game 1
		g.startGame();
                this.currentGame = g;
                System.err.println("the gammmmmmmmmmmmmeeeeeee"+g.toString());
        return g; // returning the game which created
	}
        
        
        public game newGame(){
            ArrayList<Card> temp = sData.getCards();
            this.currentGame.setRounds(new ArrayList<Round>());
            this.currentGame.setCounterOfRounds(0);
            this.currentGame= currentGame.startGame();
            return currentGame;
        }
        
        /**
    	 * 
    	 * @param set the next round settings
    	 */ 
        public void nextRound(){
            this.currentGame.setNewRecord(false);
            ArrayList<Card> temp = sData.getCards();
        	this.currentGame.setDeck(temp); // setting the first deck for a new round
        	this.currentGame.startGame();
            this.currentGame.setCounterOfRounds(this.currentGame.getCounterOfRounds()+1);

        }
        
        /**
    	 * 
    	 * @param return the total score for game
    	 */
        public int calculateScoreForGame(){
           return currentGame.calculateScoreForGame();           
        }
        
        /**
    	 * 
    	 * @param get the record for the player
    	 */
        public boolean checkNewRecord(){
            return currentGame.getNewRecord();
        }
        
        /**
    	 * 
    	 * @param get te number of winning of player in the game.
    	 */
        public int getWinningsCounter(){
        	if (this.currentGame !=null){
        		return this.currentGame.getNumOfWinnings();
        	}
        	
        	return 0;
        }
        
        /**
    	 * 
    	 * @param get te number of loses of player in the game.
    	 */
        public int getLostsCounter(){
        	if (this.currentGame !=null){
        		return this.currentGame.getNumOfLoses();
        	}
        	
        	return 0;
        }
                    

        /**
       	 * 
       	 * @param calls the hit function in the currunt game.
       	 * @ return the card that was deliverd by the hit function.
       	 */        
        public String hitFunc(){
       		String card = this.currentGame.hitFunc();
               this.flag= this.currentGame.getFlag();
               return card;
       				
       	}
        
        /**
       	 * 
       	 * @param StandFunc compares the amount of cards between the dealer and the player. returns the array of cards
       	 * @ return the array of cards.
       	 */ 
        public ArrayList<String> standFunc(){
        	ArrayList<String> setOfCardsToDealer = this.currentGame.standFunc();
            this.flag = this.currentGame.getFlag();
            return setOfCardsToDealer;
        }
        
        /**
       	 * 
       	 * @ return the array of card in player hand.
       	 */        
          public ArrayList<String> PlayerHand(){
                      	return this.currentGame.PlayerHand();
           }
          
          /**
         	 * @ return the array of card in delear hand.
         	 */ 
            public ArrayList<String> DealerHand(){
                  	return this.currentGame.DealerHand();
               }
               
               /**
	 * @return the currentGame
	 */
	public game getCurrentGame() {
		return currentGame;
	}
	/**
	 * @param currentGame the currentGame to set
	 */
	public void setCurrentGame(game currentGame) {
		this.currentGame = currentGame;
	}
      
	
	public int getFlag(){
		return this.flag;
                
	}
	/**
	 * @return the player sum of cards for round.
	 */
    public int getPlayerHand()
    {
        Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
        return round.getPlayerAmount();       
    }
    /**
	 * @return the dealer sum of cards for round.
	 */
     public int getDealerHand()
    {
        Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
        return round.getDelaerAmount();       
    }
     
     /**
 	 * @return the delear sum of cards for round after the stand button was clicked.
 	 */
       public int getDealerHandAfterStand()
    {
        Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
        return round.getDelaerAmountAfterStand();       
    }
     
     /**
   	 * @param the function return 1 if the player won on the first deal of cards. 
   	 */  
     public int checkWinOnStart()
     {
         //this.currentGame.calculateScoreForGame();
        return this.currentGame.getwinOnStart();
     }
     
     
     /**
		 * @return the sData
		 */
		public SysData getsData() {
			return sData;
		}
       
        
	//********************************** Layer's closure procedure methods ****************************
    
    /**
	* @param Calls the method from SDATA which prints the output from executing the file
	 */
	public void executeSysExit()
	{
		sData.executeOutput();
	}

        
    
    
}
