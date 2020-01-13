public class Kahala extends SuperBowl {

	public Kahala(Players players, int n, boolean propertyPlayerOne, SuperBowl firstBowl){
		super(players, propertyPlayerOne);
		n++;
		propertyPlayerOne = false;
		if (this.isPropertyPlayerOne()) {
			this.setNbSuperBowlBowl(players, n, propertyPlayerOne, firstBowl);
		}else {
			this.setNbSuperBowl(firstBowl);
		}
	}
	
	public boolean BowlIsEmpty() {
		this.allStonesToKahala();
		return true;
	}	
	
	protected SuperBowl getSuperBowlNr(int position) {
		if (position<0) {
			position *= -1; 
			position ++; 
			return super.getSuperBowlNr(position);
		}else {
			return super.getSuperBowlNr(position);
		}
	}
	
	protected void passStone(int passingStone) {
		if (this.getPlayers().yourTurn(isPropertyPlayerOne())){
			super.passStone(passingStone);
		}
	}

	@Override
	public void passStoneToKahala(int passStone) {
		if (this.getPlayers().yourTurn(isPropertyPlayerOne())) {
			passStone += getStone();
			this.setStone(passStone);
		} else {
			this.getNbSuperBowl().passStoneToKahala(passStone);
		}
	}
	
	private void allStonesToKahala() {
		getPlayers().setTurn(); //otherwise the stones will end up in the wrong Kahala.
		for(int i=0; i<=6; i++) {
			((Bowl)this.getNbSuperBowl().getSuperBowlNr(i)).giveStoneToKahala();
		}
	}
	
	public boolean draw() {
		int otherKahalaStone = getNbSuperBowl().otherKahala();
		if (otherKahalaStone == this.getStone()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean playerOneWins() {
		int otherKahalaStone = getNbSuperBowl().otherKahala();
		if (otherKahalaStone < this.getStone() ^ this.isPropertyPlayerOne()) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	protected int otherKahala() {
		return this.getStone();
	}

	@Override
	protected int [] gameState(int [] lastgamestate) {
		int [] gamestate = super.gameState(lastgamestate);
		if (this.isPropertyPlayerOne()) {
			int [] newgamestate = this.getNbSuperBowl().gameState(gamestate);
			return newgamestate;
		}else {
			return gamestate;
		}
	}
}

