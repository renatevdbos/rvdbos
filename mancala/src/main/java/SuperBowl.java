public abstract class SuperBowl {
	private int stone = 0;
	private Players players;
	private final boolean propertyPlayerOne;
	private SuperBowl nbSuperBowl;

	public SuperBowl () {
		this.players = new Players();
		this.propertyPlayerOne = true;
	}
	
	public SuperBowl(Players p, boolean one){
		this.players = p;
		this.propertyPlayerOne = one;
	}
	
	protected boolean isPropertyPlayerOne() {
		return this.propertyPlayerOne;
	}
	
	protected SuperBowl getNbSuperBowl() {
		return this.nbSuperBowl;
	}
	
	protected void setNbSuperBowl(SuperBowl nbSuperBowl) {
		this.nbSuperBowl = nbSuperBowl;
	}
	
	protected void setNbSuperBowlBowl(Players players, int n, boolean propertyPlayerOne, SuperBowl firstBowl) {
		this.nbSuperBowl = new Bowl(players, n, propertyPlayerOne, firstBowl);
	}
	
	protected void setNbSuperBowlKahala(Players players, int n, boolean propertyPlayerOne, SuperBowl firstBowl) {
		this.nbSuperBowl = new Kahala(players, n, propertyPlayerOne, firstBowl);
	}
	
	protected Players getPlayers() {
		return this.players;
	}
	
	protected int getStone() {
		return this.stone;
	}
	
	protected void setStone(int amount) {
		if (amount >= 0) {
			this.stone = amount;
		}
	}
	
	protected void plusStone() {
		this.stone +=1;
	}
	
	protected boolean owningPlayersTurnCanPlay(){
		return nbSuperBowl.owningPlayersTurnCanPlay();
	}
	
	public boolean BowlIsEmpty() {
		if (this.getStone() == 0) {
			return nbSuperBowl.BowlIsEmpty();
		} else {
			return false;
		}
	}

	protected SuperBowl getSuperBowlNr(int position) {
		position--;
		if (position != 0 ) {
			return this.nbSuperBowl.getSuperBowlNr(position);
		}else {
			return this;
		}
	}
	
	public int  getStoneAtPosition(int position) {
		return getSuperBowlNr(position).getStone();
	}
	
	protected void passStone(int passingStone) {
		passingStone -= 1;
		if (passingStone!=0) {
			this.plusStone();
			this.nbSuperBowl.passStone(passingStone);
		}
	}	
	
	public void passStoneToKahala(int passStone) {
		nbSuperBowl.passStoneToKahala(passStone);
	}
	
	public boolean draw() {
		return getNbSuperBowl().draw();
	}
	
	protected int otherKahala() {
		return getNbSuperBowl().otherKahala();
	}
	
	public boolean playerOneWins() {
		return getNbSuperBowl().playerOneWins();
	}
	
	protected int [] gameState(int [] lastgamestate) {
		int [] gamestate = new int[lastgamestate.length + 1];
		for (int i = 0; i<lastgamestate.length; i++) {
			gamestate[i] = lastgamestate[i];
		}
		gamestate [gamestate.length-1] = this.getStone();
		return gamestate;
	}
}
