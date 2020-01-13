import static org.junit.Assert.*;

import org.junit.Test;

public class KahalaTest {
	
	@Test
	public void testPropertyPlayerNbKahalaPlayerTwo() {
		SuperBowl firstBowl = new Bowl();
		assertFalse(firstBowl.getSuperBowlNr(14).isPropertyPlayerOne());
	}
	
	@Test
	public void testPropertyPlayerNbBowlOfKahala() {
		SuperBowl firstBowl = new Bowl();
		assertFalse(firstBowl.getSuperBowlNr(8).isPropertyPlayerOne());
	}
	
	@Test
	public void testPropertyPlayerNbKahala() {
		SuperBowl firstBowl = new Bowl();
		assertTrue(firstBowl.getSuperBowlNr(7).isPropertyPlayerOne());
	}

	@Test
	public void testStonesInKahala() {
		SuperBowl firstBowl = new Bowl();
		firstBowl.getSuperBowlNr(6).passStone(2);
		assertEquals(1, firstBowl.getSuperBowlNr(7).getStone());
	}
	
	@Test
	public void testSamePlayerTurnEndingOnKahala() {
		SuperBowl firstBowl = new Bowl();
		firstBowl.passStone(7);
		assertTrue(firstBowl.getSuperBowlNr(8).getPlayers().yourTurn(true));
	}
	
	@Test
	public void testAllStonesToKahala() {
		SuperBowl firstBowl = new Bowl();
		firstBowl.getPlayers().setTurn();
		firstBowl.getSuperBowlNr(14).BowlIsEmpty();
		assertEquals(24, firstBowl.getSuperBowlNr(7).getStone());
	}
	
	@Test
	public void testPassStoneSkipKahala() {
		SuperBowl firstBowl = new Bowl();
		firstBowl.passStone(14);
		assertEquals(0, firstBowl.getSuperBowlNr(14).getStone());
	}
	
}
