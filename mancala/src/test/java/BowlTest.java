import static org.junit.Assert.*;

import org.junit.Test;

public class BowlTest {

	@Test
	public void testStones() {
		SuperBowl firstBowl = new Bowl();
		assertEquals(4, firstBowl.getStoneAtPosition(1));
	}
	
	@Test
	public void testStonesNbBowl() {
		SuperBowl firstBowl = new Bowl();
		assertEquals(4, firstBowl.getStoneAtPosition(2));
	}
	
	@Test
	public void testStonesKahala() {
		SuperBowl firstBowl = new Bowl();
		assertEquals(0, firstBowl.getStoneAtPosition(7));
	}
	
	@Test
	public void testNbBowl() {
		SuperBowl firstBowl = new Bowl();
		assertNotNull(firstBowl.getNbSuperBowl());
	}
	
	@Test
	public void testPropertyPlayer() {
		SuperBowl firstBowl = new Bowl();
		assertTrue(firstBowl.isPropertyPlayerOne());
	}

	@Test
	public void testOwningPlayer() {
		SuperBowl firstBowl = new Bowl();
		assertTrue(firstBowl.getPlayers().yourTurn(true));
	}
	
	@Test
	public void TurnOppositePlayer() {	
		SuperBowl firstBowl = new Bowl();
		assertFalse(firstBowl.getPlayers().yourTurn(false));
	}
	
	@Test
	public void testPickUpStone() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).pickUpStone();
		assertEquals(0, firstBowl.getStoneAtPosition(1));
	}
	
	@Test
	public void testPickUpStonePassing() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).pickUpStone();
		assertEquals(5, firstBowl.getNbSuperBowl().getStone());
	}
	
	@Test
	public void testMakeRound() {
		SuperBowl firstBowl = new Bowl();
		assertEquals(firstBowl, firstBowl.getSuperBowlNr(14).getNbSuperBowl());		
	}
	
	@Test
	public void testGiveStoneToKahala() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).giveStoneToKahala();
		assertEquals(0, firstBowl.getStoneAtPosition(1));
	}
	
	@Test
	public void testPassStoneToKahala() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).giveStoneToKahala();
		assertEquals(4, firstBowl.getStoneAtPosition(2));		
	}
	
	@Test
	public void testPassStoneToKahalaNbBowl() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).giveStoneToKahala();
		assertEquals(4, firstBowl.getStoneAtPosition(2));		
	}

	@Test
	public void testGetStoneOppositeBowlToKahalaTestNbBowl() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).getStoneOppositeBowlToKahala();
		assertEquals(4, ((Bowl)firstBowl).getStoneAtPosition(2));		
	}
	
	@Test
	public void testGetStoneOppositeBowlToKahalaTestLeeg() {
		Bowl firstBowl = new Bowl();
		((Bowl)firstBowl.getSuperBowlNr(6)).getStoneOppositeBowlToKahala();
		assertEquals(0, firstBowl.getStoneAtPosition(8));		
	}
	
	@Test
	public void testSamePlayerTurn() {
		SuperBowl firstBowl = new Bowl();
		firstBowl.passStone(1);
		assertFalse(firstBowl.getPlayers().yourTurn(true));
	}
	
	@Test
	public void testGetSuperBowlNr() {
		SuperBowl firstBowl = new Bowl();
		assertEquals(0, firstBowl.getStoneAtPosition(7));
	}
	
	@Test 
	public void testBowlIsEmptyNotEmpty() {
		SuperBowl firstBowl = new Bowl();
		assertFalse(firstBowl.BowlIsEmpty());
	}
	
	@Test 
	public void testBowlIsEmptyEmpty() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).pickUpStoneAtPosition(6);
		assertTrue(((Bowl)firstBowl.getSuperBowlNr(6)).BowlIsEmpty());
	}
	
	@Test
	public void owningPlayersTurnCanPlay() {
		SuperBowl firstBowl = new Bowl();
		assertFalse(firstBowl.owningPlayersTurnCanPlay());
	}
	
	@Test
	public void owningPlayersTurnCanPlayOtherPlayer() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).pickUpStone();
		assertFalse(firstBowl.owningPlayersTurnCanPlay());
	}
	
	@Test
	public void testPassStoneBowlIsEmpty() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).pickUpStoneAtPosition(1);
		((Bowl)firstBowl).getSuperBowlNr(10);
		assertEquals(0, firstBowl.getStoneAtPosition(1));
	}
	
	@Test
	public void testPassStoneBowlIsEmptyStonesInKahala() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).pickUpStoneAtPosition(1);
		((Bowl)firstBowl).pickUpStoneAtPosition(11);
		assertEquals(1, firstBowl.getStoneAtPosition(14));
	}
	
	@Test
	public void testLastPassingStone() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).pickUpStoneAtPosition(5);
		((Bowl)firstBowl).pickUpStoneAtPosition(8);
		((Bowl)firstBowl).pickUpStoneAtPosition(1);
		assertEquals(8, firstBowl.getStoneAtPosition(7));
		assertEquals(0, firstBowl.getStoneAtPosition(5));
	}
	
	@Test
	public void testDraw() {
		SuperBowl firstBowl = new Bowl();
		assertTrue(firstBowl.draw());
	}
	
	@Test
	public void testWinner() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).pickUpStoneAtPosition(6);
		assertTrue(firstBowl.playerOneWins());
	}
	
	@Test
	public void testWinnerPlayerTwo() {
		SuperBowl firstBowl = new Bowl();
		((Bowl)firstBowl).pickUpStoneAtPosition(6);
		((Bowl)firstBowl).pickUpStoneAtPosition(8);
		assertTrue(firstBowl.playerOneWins());
	}
	
	@Test 
	public void testGameState(){
		SuperBowl firstBowl = new Bowl();
		int [] gamestate = {4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};
		assertArrayEquals(gamestate, ((Bowl)firstBowl).gameState());
	}
}
