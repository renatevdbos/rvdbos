class Edge{
	private String antwoord;
	private String nodevoor;
	private String nodena;
	
	public Edge(String voor, String na, String ant){
		this.nodevoor = voor;
		this.nodena = na;
		this.antwoord = ant;
	}
	
	public String getAntwoord(){
		return this.antwoord;
	}
	
	public String getNodevoor(){
		return this.nodevoor;
	}
	
	public String getNodena(){
		return this.nodena;
	}
	
}