import static org.junit.Assert.*;

import org.junit.Test;

public class PlayersTest {

	@Test
	public void test() {
		Players testPlayer = new Players();
		assertTrue(testPlayer.yourTurn(true));
		assertFalse(testPlayer.yourTurn(false));
		testPlayer.setTurn();
		assertTrue(testPlayer.yourTurn(false));
		assertFalse(testPlayer.yourTurn(true));
	}

}
