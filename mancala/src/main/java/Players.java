public class Players {
	private boolean turnPlayerOne = true;
	
	protected boolean yourTurn(boolean playerOne) {
		if (this.turnPlayerOne ^ playerOne) {
			return false;
		}else {
			return true;
		}
	}
	
	protected void setTurn() {
		this.turnPlayerOne = !turnPlayerOne;
	}
}	
