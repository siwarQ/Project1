package blackJakBckForJuint;

import static org.junit.Assert.*;
import model.ModelLogic;



import org.junit.Test;

public class testModelLogic {
	private static ModelLogic m =ModelLogic.getInstance();


	@Test
	public void testGetCards() { // checking that sData deck is not null
		assertNotNull(m.getCards());
	}
	@Test
	public void testStartGame() {
		
		
		m.getCards();
		assertNotNull(m.startGame());
	}

	@Test
	public void testBuildCards() {

		assertNotNull(m.getCards());
		
	}


	@Test
	public void testHitStandFunc() { 
		assertNotNull(m.hitFunc());
		assertNotNull(m.standFunc());
	}

	
	
	@Test
	public void testPlayersHand() {
		
		assertNotNull(m.getPlayerHand());
	}
	
	
	@Test
	public void testDealersHand() {
		
		assertNotNull(m.getDealerHand());
	}
	
	

}
