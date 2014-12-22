package model;

import java.util.ArrayList;

import utils.MyFileLogWriter;

public class game {
	
	//***************************************** Variables ******************************************
	/**KEY field, Game's serialNumber*/
	private int serialNumber;
	/**array list of rounds of game*/
	private ArrayList<Round> rounds;
	/**deck of the game*/
	private ArrayList <Card> Deck;
	/**counter of rounds*/
	private int counterOfRounds;
	/**player involved*/
	private Player player;
	/**total score of game*/
	private int scoreForGame;
	/**size of current round*/
    public int sizeOfCurrentRound=0;
    
    public int winOnStart=0;
	
    
  
	
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
      //siwar
     // this function starts the game
    protected game startGame(){

  		this.OpenRound(); // openning a new round
  		this.Deal(); // activating DEAL FUNCTION
        return this; // returning the game which created
      }
	
	// this function opens a new round and calls the shuffle function 
	public void OpenRound(){
		Round r = new Round(); ///// you must enter dealer hand and player hand
		this.Deck=r.shuffle(this.Deck);	
		this.rounds.add(r);
		
	}
	
	
	// This function gives both the dealer and the player two cards
	public void Deal(){
		//saving all cards for the first iteration
		Card c1 = this.Deck.remove(0); 
		Card c2 = this.Deck.remove(0);
		Card c3= this.Deck.remove(0);
		Card c4 =this.Deck.remove(0);
		//adding them to each player and dealer's hand
		Hand playerTemp = new Hand(0, TypeOfHand.User);
		Hand dealer = new Hand(1, TypeOfHand.Dealer);
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
	// this function calculaters total score for this game
	public int calculateScoreForGame(){
		int totalScore = 0;
		for (Round r : this.rounds) {
			totalScore += r.getTotalScore();			
		}
		return totalScore;
		
	
	}
	
	
}
