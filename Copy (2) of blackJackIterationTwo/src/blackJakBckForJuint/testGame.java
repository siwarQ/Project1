package blackJakBckForJuint;



import static org.junit.Assert.*;
import java.util.ArrayList;
import model.Card;
import model.Color;

import model.Letter;

import model.Suit;

import model.game;

import org.junit.Test;

public class testGame {
  

	
/* test when player gets 21 on start*/
	@Test
	public void testCheckWinOnStart1() {
		Card c1 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c2 = new Card(11, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Card c3 = new Card(2, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c4 = new Card(3, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		ArrayList<Card> arr = new ArrayList<Card>();
		arr.add(c1);
		arr.add(c2);
		arr.add(c3);
		arr.add(c4);
		game g =new game(1);
		g.OpenRound();
		g.setDeck(arr);
		System.out.println(g.getDeck().toString());
		
		g.Deal();
		//int temp= g.ge
	    assertEquals(1, g.getwinOnStart(),0);
	}
	
	/* test when player not 21 on start - doesnt win on start*/
	@Test
	public void testCheckWinOnStart2() {
		Card c1 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c2 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.Q, "1BC.png");
		Card c3 = new Card(2, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c4 = new Card(3, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		ArrayList<Card> arr = new ArrayList<Card>();
		arr.add(c1);
		arr.add(c2);
		arr.add(c3);
		arr.add(c4);
		game g =new game(1);
		g.OpenRound();
		g.setDeck(arr);
		g.Deal();
		
	    assertNotEquals(1, g.getwinOnStart(),0);
	}
	
	

	

}
