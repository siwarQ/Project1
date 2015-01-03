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
        private int deckCounter;
        
        //private static ArrayList<Player> players;

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
    
        public ArrayList<Card> getCards(){
            return sData.getCards(); // returning the deck ready for dealing
        }
        
        public void setStatus(boolean s)
        {
        this.currentGame.setStatus(s);	
        }
        
        
        
      public Player checkLogIn(String name, String passWord){
          
          Player player = new Player(name,passWord);
          SysData.executeInput();
          for (Player p: sData.getPlayers() ){
              if (p.getUserName().equals(player.getUserName()) && p.getPassWord().equals(player.getPassWord())){
                  this.player=p;
                  return p;
              }
              
              
          }
         // this.player = sData.checkLogIn(name, passWord);
        return  null;
      }
      
      
        public boolean addNewUser( String userName, String pass, String firstName, String lastName)
         {
             // public boolean addNewUser( String userName, String pass, String firstName, String lastName)
         
             Player p = new Player(userName, pass, firstName, lastName);
           //  sData.getPlayers().add(p);
             if ( sData.getPlayers().add(p)){
                 sData.executeOutput();
                 return true;
             }
             else
                 return false;
         //return sData.addNewUser(userName, pass, firstName, lastName);
         }
        
        public game startGame(){
 
            this.deckCounter = 0;
            ArrayList<Card> temp = sData.getCards();
        game g = new game(1, this.player, temp); // creating game 1
		g.startGame();
                this.currentGame = g;
        return g; // returning the game which created
	}
        
        
        public void nextRound(){
            this.currentGame.setNewRecord(false);
            ArrayList<Card> temp = sData.getCards();
        	this.currentGame.setDeck(temp); // setting the first deck for a new round
        	this.currentGame.startGame();
            this.currentGame.setCounterOfRounds(this.currentGame.getCounterOfRounds()+1);

        }
        
        public int calculateScoreForGame(){
           return currentGame.calculateScoreForGame();
           // return currentGame.getScoreForGame();
            
        }
        
        public boolean checkNewRecord(){
            return currentGame.getNewRecord();
        }
        
        public int getWinningsCounter(){
        	if (this.currentGame !=null){
        		return this.currentGame.getNumOfWinnings();
        	}
        	
        	return 0;
        }
        
        public int getLostsCounter(){
        	if (this.currentGame !=null){
        		return this.currentGame.getNumOfLoses();
        	}
        	
        	return 0;
        }
                    

        
        public String hitFunc(){

            //SIWAR	
       		String card = this.currentGame.hitFunc();
               this.flag= this.currentGame.getFlag();
              // this.currentGame.calculateScoreForGame();
               return card;
       				
       	}
        
        
        /*StandFunc compares the amount of cards between the dealer and the player and returns the array of cards */
        public ArrayList<String> standFunc(){
        //siwar
        	ArrayList<String> setOfCardsToDealer = this.currentGame.standFunc();
            this.flag = this.currentGame.getFlag();
            //this.currentGame.calculateScoreForGame();
            return setOfCardsToDealer;
        }
               
               public ArrayList<String> PlayerHand(){
                 
               	return this.currentGame.PlayerHand();
               }
               
               public ArrayList<String> DealerHand(){
                  
               	return this.currentGame.DealerHand();
               }
               
               /**
	 * @return the currentGame
	 */
	protected game getCurrentGame() {
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
    
    /*
     * Calls the method from SDATA which prints the output from executing the file
     */   
	public void executeSysExit()
	{
		sData.executeOutput();
	}

        
    
    
}
