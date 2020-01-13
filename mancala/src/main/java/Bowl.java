public class Bowl extends SuperBowl {

	public Bowl(){
		super();
		this.setStone(4);
		this.setNbSuperBowlBowl(getPlayers(), 2, isPropertyPlayerOne(), this);
	}
	
	public Bowl(Players players, int n, boolean propertyPlayerOne, SuperBowl firstBowl){
		super(players, propertyPlayerOne);
		n++;
		this.setStone(4);
		if (n==7||n==14) {			
			this.setNbSuperBowlKahala(players, n, propertyPlayerOne, firstBowl);
		}else{
			this.setNbSuperBowlBowl(players, n, propertyPlayerOne, firstBowl);
		}
	}


	protected boolean owningPlayersTurnCanPlay(){
		if (this.getPlayers().yourTurn(isPropertyPlayerOne())) {
			return this.BowlIsEmpty();
		}else {
			return getNbSuperBowl().owningPlayersTurnCanPlay();
		}
	}
	
	protected void pickUpStoneAtPosition(int position) {
		((Bowl)this.getSuperBowlNr(position)).pickUpStone();
	}
	
	protected void pickUpStone() {
		if (this.getPlayers().yourTurn(isPropertyPlayerOne()) && 0 != getStone()) {
			int passingStone = getStone();
			this.setStone(0);	
			this.getNbSuperBowl().passStone(passingStone);
		}
	}
	
	protected void passStone(int passingStone) {
		if (passingStone==1) {
			this.lastPassingStone();
		}else {
			super.passStone(passingStone);
		}
	}

	private void lastPassingStone(){
		if (getStone()==0 && getPlayers().yourTurn(isPropertyPlayerOne())) {
			this.setStone(1);
			this.getStoneOppositeBowlToKahala();
			this.giveStoneToKahala();
		}else {
			this.plusStone();
		}
		getPlayers().setTurn();
	}
	
	protected void getStoneOppositeBowlToKahala() {
		((Bowl)this.getSuperBowlNr(0)).giveStoneToKahala();
	}
	
	public void giveStoneToKahala() {
		this.passStoneToKahala(getStone());
		this.setStone(0);
	}	
	
	protected int [] gameState() {
		int [] gamestate = {this.getStone()};
		int [] newgamestate = this.getNbSuperBowl().gameState(gamestate);
		return newgamestate;
	}
	
	protected int [] gameState(int [] lastgamestate) {
		int [] gamestate = super.gameState(lastgamestate);
		int [] newgamestate = this.getNbSuperBowl().gameState(gamestate);
		return newgamestate;
	}
}