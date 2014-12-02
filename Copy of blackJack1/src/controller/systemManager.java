package controller;



import java.util.ArrayList;

import model.Card;
import model.Color;
import model.Letter;
import model.Player;
import model.Suit;
import model.game;



public class systemManager {
	
	public ArrayList<Player> player;
	public int highestScore;
	
	public static ArrayList<Card> cards = new ArrayList<Card>();
	
	
	public void newGame(){
		
	}
	
	public static void main(String[] args) {
		
		
		buildCards();
		/*for (Card c: cards){
			System.out.println(c.toString());
		}
		
		System.out.println(cards.size());*/
		
		startGame();
		
		
		
	}
	
	
	public static void startGame(){
		game g = new game(1);
		g.setDeck(cards);
		g.OpenRound();
		g.Deal();
	}
	
	public static void buildCards(){
		ArrayList<Card> cardsWithCloverNumbers = new ArrayList<Card>(); //black ones
		ArrayList<Card> cardsWithLeafNumbers = new ArrayList<Card>(); // black ones
		ArrayList<Card> cardsWithHearts = new ArrayList<Card>(); //red ones
		ArrayList<Card> cardsWithDiamonds = new ArrayList<Card>(); //red ones
		
		cardsWithCloverNumbers.add(new Card(1, Color.BLACK, Suit.CLOVER, Letter.A));
		cardsWithLeafNumbers.add(new Card(1, Color.BLACK, Suit.LEAF, Letter.A));
		cardsWithHearts.add(new Card(1, Color.RED, Suit.HEART, Letter.A));
		cardsWithDiamonds.add(new Card(1, Color.RED, Suit.DIAMOND, Letter.A));
		
		for (int i=1; i< 10; i++){
			cardsWithCloverNumbers.add(new Card(i, Color.BLACK, Suit.CLOVER));
			cardsWithLeafNumbers.add(new Card(i, Color.BLACK, Suit.LEAF));
			cardsWithHearts.add(new Card(i, Color.RED, Suit.HEART));
			cardsWithDiamonds.add(new Card(i, Color.RED, Suit.DIAMOND));
			
		}
		
		// clover pictures
		cardsWithCloverNumbers.add(new Card(10, Color.BLACK, Suit.CLOVER, Letter.J));
		cardsWithCloverNumbers.add(new Card(10, Color.BLACK, Suit.CLOVER, Letter.K));
		cardsWithCloverNumbers.add(new Card(10, Color.BLACK, Suit.CLOVER, Letter.Q));
		
		
		// Leaf pictures
		cardsWithLeafNumbers.add(new Card(10, Color.BLACK, Suit.LEAF, Letter.J));
		cardsWithLeafNumbers.add(new Card(10, Color.BLACK, Suit.LEAF, Letter.K));
		cardsWithLeafNumbers.add(new Card(10, Color.BLACK, Suit.LEAF, Letter.Q));
		
		
		// hEART pictures
		cardsWithHearts.add(new Card(10, Color.RED, Suit.HEART, Letter.J));
		cardsWithHearts.add(new Card(10, Color.RED, Suit.HEART, Letter.K));
		cardsWithHearts.add(new Card(10, Color.RED, Suit.HEART, Letter.Q));
		
		
		// DIAMOND pictures
		cardsWithDiamonds.add(new Card(10, Color.RED, Suit.DIAMOND, Letter.J));
		cardsWithDiamonds.add(new Card(10, Color.RED, Suit.DIAMOND, Letter.K));
		cardsWithDiamonds.add(new Card(10, Color.RED, Suit.DIAMOND, Letter.Q));
		//cardsWithDiamonds.add(new Card(1, Color.RED, Suit.DIAMOND, Letter.A));
		
		
			
		cards.addAll(cardsWithCloverNumbers);
		//System.out.println(cardsWithCloverNumbers.size());
		cards.addAll(cardsWithLeafNumbers);
		cards.addAll(cardsWithHearts);
		cards.addAll(cardsWithDiamonds);
		
		
		
		
	}

	
	
}
