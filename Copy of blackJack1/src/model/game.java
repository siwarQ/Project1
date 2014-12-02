package model;

import java.util.ArrayList;

public class game {
	
	private int serialNumber;
	private ArrayList<Round> rounds;
	private ArrayList <Card> Deck;
	private int counterOfRounds;
	private Player player;
	private int scoreForGame;
	
	
	/**
	 * @return the deck
	 */
	protected ArrayList<Card> getDeck() {
		return Deck;
	}


	/**
	 * @param deck the deck to set
	 */
	public void setDeck(ArrayList<Card> deck) {
		Deck = deck;
	}


	public game(int serialNumber) {
		super();
		this.serialNumber = serialNumber;
		this.rounds = new ArrayList<Round>();
		this.counterOfRounds =0 ;
		this.player = new Player();
		this.scoreForGame = 0;
		this.Deck = new ArrayList<Card>();
	}
	
	
	protected game(int serialNumber, Player player, ArrayList<Card> deck) {
		super();
		this.serialNumber = serialNumber;
		this.rounds = new ArrayList<Round>();
		this.counterOfRounds =0 ;
		this.player = player;
		this.scoreForGame = 0;
		this.Deck = deck;
	}
	protected game(int serialNumber, ArrayList<Round> rounds,
			int counterOfRounds, Player player, int scoreForGame) {
		super();
		this.serialNumber = serialNumber;
		this.rounds = rounds;
		this.counterOfRounds = counterOfRounds;
		this.player = player;
		this.scoreForGame = scoreForGame;
	}
	
	public void OpenRound(){
		Round r = new Round(); ///// you must enter dealer hand and player hand
		
		this.Deck=r.shuffle(this.Deck);	
		this.rounds.add(r);
		
		
		
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
	protected ArrayList<Round> getRounds() {
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
	protected void setPlayer(Player player) {
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
	
	
	// This function gives both the dealer and the player two cards
	public void Deal(){
		
		Card c1 = this.Deck.remove(0);
		Card c2 = this.Deck.remove(0);
		Card c3= this.Deck.remove(0);
		Card c4 =this.Deck.remove(0);
		
		Hand player = new Hand(0, TypeOfHand.User);
		Hand dealer = new Hand(1, TypeOfHand.Dealer);
		player.addCard(c1);
		player.addCard(c2);
		dealer.addCard(c3);
		dealer.addCard(c4);
		int size = rounds.size()-1;
		rounds.get(size).setDealerHand(dealer);
		rounds.get(size).setPlayerHand(player);
		System.out.println("Dealer:"+rounds.get(size).getDealerHand().toString());
		System.out.println("Player:"+rounds.get(size).getPlayerHand().toString());
		
	}
	
	
	
	
	
	
	
	
	public int calculateScoreForGame(){//
		int totalScore = 0;
		for (Round r : this.rounds) {
			totalScore += r.getTotalScore();			
		}
		return totalScore;
		
	
	}
	
	
}
