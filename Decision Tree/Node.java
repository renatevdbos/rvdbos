class Node{
	private String name;
	private String question;
	private Node ja = null;
	private Node nee = null;

	public Node (String n, String q){
		this.name = n;
		this.question = q;
	}	
	
	public String getName(){
		return this.name;
	}
	
	public String getQuestion(){
		return this.question;
	}
	
	public void setJa(Node node){
		this.ja = node;
	}
	
	public Node getJa(){
		return this.ja;
	}
	
	public void setNee(Node node){
		this.nee = node;
	}
	
	public Node getNee(){
		return this.nee;
	}
}