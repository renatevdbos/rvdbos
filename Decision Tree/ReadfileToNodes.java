import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class ReadfileToNodes{
	
	public static Node omzetten() {
		
		ArrayList<Node> arraynodes = new ArrayList<Node>();
		ArrayList<Edge> arrayedge = new ArrayList<Edge>();
		
		//file uitlezen, splitsen in nodes en edges en deze in lijsten zetten.
		try {
			List<String> uitgelezen = Files.readAllLines(Paths.get("decision-tree-data.txt"));
			for (int i = 0; i<uitgelezen.size(); i++){
				String zin = uitgelezen.get(i);
				String [] split_zin_comma = zin.split(",");
				if (split_zin_comma.length == 2){
					String zondercomma = split_zin_comma[1].substring(1, split_zin_comma[1].length());
					Node tijdelijk = new Node(split_zin_comma[0], zondercomma);
					arraynodes.add(tijdelijk);
				}else if(split_zin_comma.length == 3){
					String zondercomma1 = split_zin_comma[1].substring(1, split_zin_comma[1].length());
					String zondercomma2 = split_zin_comma[2].substring(1, split_zin_comma[2].length());
					Edge tijdelijk = new Edge(split_zin_comma[0], zondercomma1, zondercomma2);
					arrayedge.add(tijdelijk);
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		
		//nodes aan elkaar koppelen om een boom te maken m. b. v. edges.
		int nextnode = 0;
		for (nextnode = 0; nextnode<arraynodes.size();nextnode++){
			for (int i = 0; i<arrayedge.size(); i++){
				if (arraynodes.get(nextnode).getName().equals(arrayedge.get(i).getNodevoor())){
					if (arrayedge.get(i).getAntwoord().equals("Ja")){
						for (int j = 0; j<arraynodes.size(); j++){
							if (arrayedge.get(i).getNodena().equals(arraynodes.get(j).getName())){
								arraynodes.get(nextnode).setJa(arraynodes.get(j));
							}
						}
					}else if (arrayedge.get(i).getAntwoord().equals("Nee")){
						for (int j = 0; j<arraynodes.size(); j++){
							if (arrayedge.get(i).getNodena().equals(arraynodes.get(j).getName())){
								arraynodes.get(nextnode).setNee(arraynodes.get(j));
							}
						}
					}
				}
			}
		}	
		
		
		//begin node opzoeken
		for (int i = 0; i<arraynodes.size(); i++){
			if (arraynodes.get(i).getName().equals("N1")){
				nextnode = i;
			}
		}
		
		Node root = arraynodes.get(nextnode);
		return root;
	}
}	