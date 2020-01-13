import java.util.*;

class Decisiontree{
	public static void main (String [] args) {
		
		Node root = ReadfileToNodes.omzetten();
		Node runner = root;

		while (runner.getJa() != null){
			System.out.println(runner.getQuestion());
			Scanner in = new Scanner (System.in);
			String antwoord = in.nextLine();
			if (antwoord.equals("ja")){
				runner = runner.getJa();
			} else if (antwoord.equals("nee")){
				runner = runner.getNee();
			} else{
				System.out.println("Je moet ja of nee antwoorden.");
			}
		}
		System.out.println("De boomnaam die je zoekt is: " + runner.getQuestion());

	} 
}