import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner; 

//Moran Arzi 200244945
//Almog Fadida 315544437

public class main {
	
	public static void main(String[] args) {
		
		File array = new File("C:\\Users\\Almog Fadida\\Desktop\\array.txt");
		
		Scanner sc = new Scanner(System.in);			
		int arraySize , index;
		
		char firstNode , lastNode;
		
		System.out.println("Please enter array size (lower than 26)");
		arraySize = sc.nextInt();
		System.out.println("Please enter first node");
		firstNode = sc.next().charAt(0);
		System.out.println("Please enter last node");
		lastNode = sc.next().charAt(0);
		
		int[][] costArray = new int[arraySize][arraySize];
		
		
		try 
		{
			Scanner myReader = new Scanner(array);
			String data = "";
			
			while (myReader.hasNextLine()) {
			        data = myReader.nextLine();
			}
			
			myReader.close();
			
			//System.out.println(data);
	        
			String[] splited = data.split("\\s+");
	        index = 0;
	        		
	        for(int i = 0; i < arraySize; i++) {
	        	
	        	for(int j = 0; j < arraySize; j++) {
	        		
	        		costArray[i][j] = Integer.parseInt(splited[index]) ;
	        		index ++;
	        		
	        	}
	        }
	        
	        searchWithoutKnowledgeAlgoritm search = new searchWithoutKnowledgeAlgoritm(costArray);
	        
	        System.out.println("bfs Algorithm Search:");
	        System.out.println(search.bfsAlgorithmSearch(costArray, firstNode - 'a', lastNode - 'a'));
	        
	        System.out.println("ucs Algorithm Search:");
	        System.out.println(search.ucsAlgorithmSearch(costArray, firstNode - 'a', lastNode - 'a'));
	        
	        System.out.println("dfs Algorithm Search:");
	        System.out.println(search.dfsAlgorithmSearch(costArray, firstNode - 'a', lastNode - 'a'));
	        
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
			
	}

}
