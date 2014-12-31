/**
 * 
 */
package blackJakBckForJuint;

import static org.junit.Assert.*;



import model.Card;
import model.Color;
import model.Hand;
import model.Letter;
import model.Suit;
import model.TypeOfHand;

import org.junit.Test;

/**
 * @author Siwar
 *
 */
public class testHand {

	/**
	 * Test method for {@link model.Hand#addCard(model.Card)}.
	 */
	@Test
	//check the first time player gets ass- excpected value 11
	public void testAddCardWithAse() {
		Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Card c2 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c3 = new Card(3, Color.BLACK, Suit.CLOVER, (3+"BC.png"));
		Hand h1  = new Hand (TypeOfHand.User);
		h1.addCard(c1);
		h1.addCard(c2);
		h1.addCard(c3);
		assertEquals(11, c1.getValue(),0);
	}
	
	@Test
	//check player gets ass when the sum is bigger then 21 with 11 - excpected value 1
	public void testAddCardWishAse() {
		Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Card c2 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c3 = new Card(3, Color.BLACK, Suit.CLOVER, (3+"BC.png"));
		Hand h1  = new Hand (TypeOfHand.User);
		h1.addCard(c2);
		h1.addCard(c3);
		h1.addCard(c1);
		assertEquals(1, c1.getValue(),0);
	}
	
	
	@Test
	//check if the player passed the allowed amount of the play which is 21, - excpected value false
	public void testAddCard3() {
		Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Card c2 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c3 = new Card(3, Color.BLACK, Suit.CLOVER, (3+"BC.png"));
		Card c4 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Hand h1  = new Hand (TypeOfHand.User);
		h1.addCard(c2);
		h1.addCard(c3);
		h1.addCard(c1);
		// the amount of cards are more than 21 and in the next card it should not be entered
		//if you enter another card it would give you false
		assertTrue("true", h1.addCard(c4));
	}
	
	@Test
	//check if the player passed the allowed amount of the play which is 21, - excpected value false
	public void testAddCard5() {
		Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Card c2 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c3 = new Card(3, Color.BLACK, Suit.CLOVER, (3+"BC.png"));
		Card c4 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c5 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.K, "11BC.png");
		Hand h1  = new Hand (TypeOfHand.User);
		h1.addCard(c2);
		h1.addCard(c3);
		h1.addCard(c1);
		h1.addCard(c4);
		// the amount of cards are more than 21 the card should not be added and it will return false
		assertFalse("false", h1.addCard(c5));
	}
	
	@Test
	//check if the dealer passed the allowed amount of the play which is 17, - excpected value false
	public void testAddCard4() {
		Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Card c2 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c3 = new Card(3, Color.BLACK, Suit.CLOVER, (3+"BC.png"));
		Card c4 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.K, "11BC.png");
		Hand h1  = new Hand (TypeOfHand.Dealer);
		h1.addCard(c2);
		h1.addCard(c3);
		h1.addCard(c1);
		
		// the amount of cards are more than 17 so in the next card would not be enterd
		assertTrue("true", h1.addCard(c4));
	}
	
	@Test
	//check if the dealer passed the allowed amount of the play which is 17, - excpected value false
	public void testAddCard6() {
		Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Card c2 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png");
		Card c3 = new Card(3, Color.BLACK, Suit.CLOVER, (3+"BC.png"));
		Card c4 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.K, "11BC.png");
		Card c5 = new Card(10, Color.BLACK, Suit.CLOVER, Letter.Q, "11BC.png"); // if we add also this than it would be faild
		Hand h1  = new Hand (TypeOfHand.Dealer);
		h1.addCard(c2);
		h1.addCard(c3);
		h1.addCard(c1);
		h1.addCard(c4);
		// the amount of cards are more than 17 so in the next card would not be enterd
		assertFalse("false", h1.addCard(c5));
	}
	
	@Test
	//Testing the function isLegal for the dealer, expected value true - legal to add
	public void testLegalAmount1() {
		//Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Hand h1  = new Hand (TypeOfHand.Dealer);
		assertTrue("true", h1.isLegal(16));
	}
	
	
	
	@Test
	//Testing the function isLegal for the dealer, expected value false - not legal to add
	public void testLegalAmount3() {
		//Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Hand h1  = new Hand (TypeOfHand.Dealer);
		assertFalse("false", h1.isLegal(18));
	}
	
	@Test
	//Testing the function isLegal for the player, expected value true - legal to add
	public void testLegalAmount2() {
		//Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Hand h2  = new Hand (TypeOfHand.User);
		//h2.isLegal(2);
		assertTrue("true", h2.isLegal(20));
	}
	
	@Test
	//Testing the function isLegal for the player, expected value false - not legal to add
	public void testLegalAmount4() {
		//Card c1 = new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png");
		Hand h2  = new Hand (TypeOfHand.User);
		//h2.isLegal(2);
		assertFalse("false", h2.isLegal(22));
	}
	

	


}
