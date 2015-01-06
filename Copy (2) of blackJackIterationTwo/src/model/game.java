package model;

import java.io.Serializable;
import java.util.ArrayList;

import utils.MyFileLogWriter;

public class game implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8461086951674612269L;
	//***************************************** Variables ******************************************
	/**KEY field, Game's serialNumber*/
	private int serialNumber;
	/**array list of rounds of game*/
	private ArrayList<Round> rounds;
	/**deck of the game*/
	private ArrayList <Card> Deck;
	/**counter of rounds*/
	private int counterOfRounds=0;
	/**player involved*/
	private Player player;
	/**total score of game*/
	private int scoreForGame;
	/**size of current round*/
    public int sizeOfCurrentRound=0;
    
    public int winOnStart=0;
    private boolean newRecord = false;
    
    
    /** indication of winning */
	private int flag = 0;
        /** total amount of player's cards */
    private int amountOfPlayerCards = 0;
        /** total amount of dealer's cards */
    private int amountOfDealerCards = 0;
    
    private boolean status;
    private int numOfWinnings = 0;
    private int numOfLoses = 0;
	
  //***************************************** Constructors ******************************************
  	/**
  	 * Full C'tor
  	 */
	protected game(int serialNumber, Player player, ArrayList<Card> deck) {
		super();
                MyFileLogWriter.initializeMyFileWriter();
		this.serialNumber = serialNumber;
		this.rounds = new ArrayList<>();
		this.counterOfRounds =0 ;
		this.player = player;
		this.scoreForGame = 0;
		this.Deck = deck;
	}
        protected game(){
            
        }
	public game(int serialNumber) {
			super();
	         MyFileLogWriter.initializeMyFileWriter();
			this.serialNumber = serialNumber;
			this.rounds = new ArrayList<>();
			this.counterOfRounds =0 ;
			this.player = new Player();
			this.scoreForGame = 0;
			this.Deck = new ArrayList<>();
		}
	protected game(int serialNumber, ArrayList<Round> rounds,
			int counterOfRounds, Player player, int scoreForGame) {
                        
		super();
        MyFileLogWriter.initializeMyFileWriter();
		this.serialNumber = serialNumber;
		this.rounds = rounds;
		this.counterOfRounds = counterOfRounds;
		this.player = player;
		this.scoreForGame = scoreForGame;
	}
  
	
  /**
		 * @return the sizeOfCurrentRound
		 */
		protected int getSizeOfCurrentRound() {
			return sizeOfCurrentRound;
		}
		/**
		 * @param sizeOfCurrentRound the sizeOfCurrentRound to set
		 */
		protected void setSizeOfCurrentRound(int sizeOfCurrentRound) {
			this.sizeOfCurrentRound = sizeOfCurrentRound;
		}
		/**
		 * @return the winOnStart
		 */
		protected int getWinOnStart() {
			return winOnStart;
		}
		/**
		 * @param winOnStart the winOnStart to set
		 */
		protected void setWinOnStart(int winOnStart) {
			this.winOnStart = winOnStart;
		}
		/**
		 * @return the flag
		 */
		protected int getFlag() {
			return flag;
		}
                
                protected boolean getNewRecord() {
			return newRecord;
		}
                  protected void setNewRecord(boolean s)
	 {
		 this.newRecord=s;
	 }
		/**
		 * @param flag the flag to set
		 */
		protected void setFlag(int flag) {
			this.flag = flag;
		}
		/**
		 * @return the amountOfPlayerCards
		 */
		protected int getAmountOfPlayerCards() {
			return amountOfPlayerCards;
		}
		/**
		 * @param amountOfPlayerCards the amountOfPlayerCards to set
		 */
		protected void setAmountOfPlayerCards(int amountOfPlayerCards) {
			this.amountOfPlayerCards = amountOfPlayerCards;
		}
		/**
		 * @return the amountOfDealerCards
		 */
		protected int getAmountOfDealerCards() {
			return amountOfDealerCards;
		}
		/**
		 * @param amountOfDealerCards the amountOfDealerCards to set
		 */
		protected void setAmountOfDealerCards(int amountOfDealerCards) {
			this.amountOfDealerCards = amountOfDealerCards;
		}
	
	 protected void setStatus(boolean s)
	 {
		 this.status=s;
	 }
         
	 
	 protected boolean getStatus()
	 {
		 return this.status;
	 }
	
	
	//***************************************** GETTERS AND SETTERS******************************************
	/**
	 * @return the deck
	 */
	public ArrayList<Card> getDeck() {
		return Deck;
	}


	/**
	 * @param deck the deck to set
	 */
	public void setDeck(ArrayList<Card> deck) {
		Deck = deck;
	}


	
	


	/**
	 * @return the serialNumber
	 */
	protected int getSerialNumber() {
		return serialNumber;
	}


	/**
	 * @param serialNumber the serialNumber to set
	 */
	protected void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}


	/**
	 * @return the rounds
	 */
	public ArrayList<Round> getRounds() {
		return rounds;
	}


	/**
	 * @param rounds the rounds to set
	 */
	protected void setRounds(ArrayList<Round> rounds) {
		this.rounds = rounds;
	}


	/**
	 * @return the counterOfRounds
	 */
	protected int getCounterOfRounds() {
		return counterOfRounds;
	}


	/**
	 * @param counterOfRounds the counterOfRounds to set
	 */
	protected void setCounterOfRounds(int counterOfRounds) {
		this.counterOfRounds = counterOfRounds;
	}


	/**
	 * @return the player
	 */
	protected Player getPlayer() {
		return player;
	}


	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}


	/**
	 * @return the scoreForGame
	 */
	protected int getScoreForGame() {
		return scoreForGame;
	}


	/**
	 * @param scoreForGame the scoreForGame to set
	 */
	protected void setScoreForGame(int scoreForGame) {
		this.scoreForGame = scoreForGame;
	}
	
    public int getwinOnStart() {
	return winOnStart;
}
    
      protected void setwinOnStart(int winOnStart ) {
	this.winOnStart =winOnStart;
}
  
      /**
  	 * @param the function starts the game
  	 */
    protected game startGame(){

  	this.OpenRound(); // openning a new round
  	this.Deal(); // activating DEAL FUNCTION
     return this; // returning the game which created
      }
    /**
  	 * @param the function opens a new round and calls the shuffle function
  	 */
	public void OpenRound(){
        this.winOnStart = 0;
		Round r = new Round(); ///// you must enter dealer hand and player hand
		this.Deck=r.shuffle(this.Deck);	         
		this.rounds.add(r);
                	
	}
	
	 /**
  	 * @param the function gives both the dealer and the player two cards
  	 */
	public void Deal(){
		//saving all cards for the first iteration
		Card c1 = this.Deck.remove(0); 
		Card c2 = this.Deck.remove(0);
		Card c3= this.Deck.remove(0);
		Card c4 =this.Deck.remove(0);
		
		Hand playerTemp = new Hand(TypeOfHand.User);
		Hand dealer = new Hand(TypeOfHand.Dealer);
		this.Deck.add(c1);
		this.Deck.add(c2);
		this.Deck.add(c3);
		this.Deck.add(c4);
		//adding them to each player and dealer's hand
		playerTemp.addCard(c1);
		playerTemp.addCard(c2);
		dealer.addCard(c3);
		dealer.addCard(c4);
                if (playerTemp.getAmountOfCards()==21)
                {
                 setwinOnStart(1);
                }
		//setting the size of current round
		this.sizeOfCurrentRound = rounds.size()-1;
		//setting the dealer's and players hand
		rounds.get(sizeOfCurrentRound).setDealerHand(dealer);
		rounds.get(sizeOfCurrentRound).setPlayerHand(playerTemp);
                       
                
        // for the tests in the first itiration
        System.out.println("Test for the results after shuffling the deck -> two cards for player and two for the dealer: ");
        System.out.println();
		System.out.println("Dealer:"+rounds.get(sizeOfCurrentRound).getDealerHand().toString());
		System.out.println("Player:"+rounds.get(sizeOfCurrentRound).getPlayerHand().toString());
        System.out.println();
		
	}
	
	 /**
  	 * @param the hit function - give player another card
  	 */
	public String hitFunc(){
	Card card;
	Round round = this.getRounds().get(this.sizeOfCurrentRound);
	card = round.hit();
	this.amountOfPlayerCards = round.getPlayerHand().getAmountOfCards();
            
        if (round.isCheck()){
            if (this.amountOfPlayerCards == 21){
		this.flag = 1;
               // return;
                
                }
                else{
                    if (this.amountOfPlayerCards > 21){
                        this.flag = -1;
                    }
                    else
                        this.flag=0;
                }
            }
            else{
            
                if (this.amountOfPlayerCards > 21){
                        this.flag = -1;
                    }
                else if (this.amountOfPlayerCards<21){
                    this.flag =0;
                            
                }else if (this.amountOfDealerCards==21){
                    this.flag=1;
                }
                
                
            }
            return card.getImage();
	}
	
	 /**
  	 * @param the function let the dealer to play and stop the game for player
  	 */
	public ArrayList<String> standFunc(){    
           ArrayList<String> arr = new ArrayList<>();
           ArrayList<Card> dealerCards = new ArrayList<>();
           Round round = this.getRounds().get(this.sizeOfCurrentRound);
           //call for stand() function in Round class
           dealerCards = round.stand();
           
           // supplying the string array
           for (Card c : dealerCards){
              arr.add(c.getImage());
           }
           // get the amount of dealer cards in order to check it and compare it to the player's amount of cards
           this.amountOfPlayerCards = round.getPlayerHand().getAmountOfCards();
           this.amountOfDealerCards = round.getDealerHand().getAmountOfCards();
           //if the dealer's amount of cards is more than 21: the dealer loses
           if (this.amountOfDealerCards  > 21){
               this.flag = 1;
           }
          
           //if the dealer's amount of cards is equal to 21: the dealer wins
           else  if (this.amountOfDealerCards == 21)
               this.flag = -1;
           //if the dealers amount of cards is more than or equal to the player's amount of cards: the dealer wins
           else if (this.amountOfDealerCards >= this.amountOfPlayerCards)
               this.flag = -1;
           else if (this.amountOfDealerCards < this.amountOfPlayerCards)
               this.flag = 1;
           else
               this.flag = 1;
           return arr;
       }
	
	 /**
  	 * @param the function get array of player hand
  	 */
	public ArrayList<String> PlayerHand(){
        Round round = this.getRounds().get(this.sizeOfCurrentRound);
        ArrayList<String> arr = new ArrayList<>();
        for (Card c : round.getPlayerHand().getCards() ){
            arr.add(c.getImage());
        }
        return arr ;
    }
    
	 /**
  	 * @param the function get array of dealer hand
  	 */
    public ArrayList<String> DealerHand(){
        Round round = this.getRounds().get(this.sizeOfCurrentRound);
        ArrayList<String> arr = new ArrayList<>();
        for (Card c : round.getDealerHand().getCards() ){
            arr.add(c.getImage());
        }
        return arr;
    }
    
    
    
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "game [serialNumber=" + serialNumber + ", rounds=" + rounds
				+ ", Deck=" + Deck + ", counterOfRounds=" + counterOfRounds
				+ ", player=" + player + ", scoreForGame=" + scoreForGame
				+ ", sizeOfCurrentRound=" + sizeOfCurrentRound + "]";
	}
	
	/**
  	 * @param the function check if the player has new record. if so-return true.else false.
  	 */
     public boolean checkHighScore(int score)
     {
         if (this.player.updateHighScore(score)){
             return true;
         }
    	  return false;
     }
     /**
   	 * @param this function calculaters total score.
   	 */
	public int calculateScoreForGame(){
	
		int size =this.rounds.size()-1;
		int score =this.rounds.get(size).calculateScoreForRound();
		if (this.getStatus())
		{
		 scoreForGame+=score;
         boolean t =checkHighScore(scoreForGame);	 
         this.setNewRecord(t);
		 this.numOfWinnings++;
		
		}
		else
		{
			if (scoreForGame==0)
			{
                this.numOfLoses++;
				return scoreForGame;
			}
			else if (scoreForGame-score<0)
			{
				scoreForGame=0;
			}
			else 
			{
				scoreForGame-=score; 
			}
			this.numOfLoses++;
						
		}
		System.err.println("Highest score************"+this.player.getMaxScore());
		return scoreForGame;	
	}
	/**
	 * @return the numOfWinnings
	 */
	protected int getNumOfWinnings() {
		return numOfWinnings;
	}
	/**
	 * @param numOfWinnings the numOfWinnings to set
	 */
	protected void setNumOfWinnings(int numOfWinnings) {
		this.numOfWinnings = numOfWinnings;
	}
	/**
	 * @return the numOfLoses
	 */
	protected int getNumOfLoses() {
		return numOfLoses;
	}
	/**
	 * @param numOfLoses the numOfLoses to set
	 */
	protected void setNumOfLoses(int numOfLoses) {
		this.numOfLoses = numOfLoses;
	}
	
	
	
}
