package blackJakBckForJuint;

import static org.junit.Assert.*;
import model.Round;

import org.junit.Test;

public class TestRound {

	/**
	 * This class tests two situation for one function
	 * In this iteration we decided not to accomplish more than one round for a game and so there's no calling for calculateScoreForRound()
	 * But we decided to check it anyway. 
	 */
	@Test
	public void testCalculateScoreForRoundForDoubleNum() {
		Round r = new Round(2, 25);
		int check = 25*2;
		int scoreForRound = r.calculateScoreForRound();
		
		assertEquals(check, scoreForRound);
		
	}
	
	@Test
	public void testCalculateScoreForRoundForNonDoubleNum() {
		Round r = new Round(3, 25);
		int check = 25*3;
		int scoreForRound = r.calculateScoreForRound();
		
		assertEquals(check, scoreForRound);
		
	}

}
