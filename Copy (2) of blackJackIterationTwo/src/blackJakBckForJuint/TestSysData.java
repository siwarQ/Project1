package blackJakBckForJuint;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Card;
import model.ModelLogic;
import model.Round;


import org.junit.Test;

public class TestSysData {

	private static ModelLogic m =ModelLogic.getInstance();
	
	
	
	@Test
	public void testShuffleCards() { // cheking shuffle
		ArrayList<Card> cardBeforeShuffle = m.getsData().getCards();
		Round r = new Round(); ///// you must enter dealer hand and player hand
		assertNotEquals(cardBeforeShuffle.toString() , r.shuffle(cardBeforeShuffle).toString());
	}

}
