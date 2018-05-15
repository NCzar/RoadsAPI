package roads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CityRoutes 
{
	private Map<String, LinkedHashSet<String>> map = new HashMap();
	
	 
    
    public void addEdge(String node1, String node2)
    {
        LinkedHashSet<String> adjacent = map.get(node1);
        if (adjacent == null)
        {
            adjacent = new LinkedHashSet();
            map.put(node1, adjacent);
        }
      
        
        adjacent.add(node2);
    }
 
    public void addTwoWayVertex(String node1, String node2)
    {
        addEdge(node1, node2);
        addEdge(node2, node1);
    }
 
    public boolean isConnected(String node1, String node2)
    {
        Set adjacent = map.get(node1);
        if (adjacent == null)
        {
            return false;
        }
        return adjacent.contains(node2);
    }
 
    public LinkedList<String> adjacentNodes(String last)
    {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null)
        {
            return new LinkedList();
        }
        return new LinkedList<String>(adjacent);
    }
 
    private static boolean flag;
    public static String check;
 
  
    
    public static void readFile(String filename,CityRoutes graph) throws IOException
    {
      
        File file = new File(filename); // For example, foo.txt
       
        try {
        	 BufferedReader br = new BufferedReader(new FileReader(file));
        	
        	  String st;
        	  while ((st = br.readLine()) != null) {
        		  String[] str = st.split(", ");
        		  
        		  str[0] = getOnlyStrings(str[0]);
        		  str[1] = getOnlyStrings(str[1]);
        		
        		  graph.addEdge(str[0], str[1]);
        	  }
        		   
        	    
        	  }
         catch (IOException e) {
            e.printStackTrace();
        } 
        
      
        
    }
    
    public static String getOnlyStrings(String s) {
        Pattern pattern = Pattern.compile("[^a-z A-Z]");
        Matcher matcher = pattern.matcher(s);
        String number = matcher.replaceAll("");
        return number;
     }
   
    
    public CityRoutes() {
    	
    }
    
  
    
    public CityRoutes(String origin,String dest) {
    	 CityRoutes graph = new CityRoutes();

    		String path =  new File("").getAbsolutePath();
        	path += "\\src\\main\\resources\\file\\city.txt";
        	
        	try {
				readFile(path,graph);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
         check = "no";
        
         LinkedList<String> visited = new LinkedList();
         
         System.out.println(checkbothends(visited,graph,origin,dest));

    }
    
    public static String checkbothends(LinkedList<String> visited,CityRoutes graph,String ORIG,String DEST) {
    	visited.add(ORIG);
        new CityRoutes().breadthFirst(graph, visited,DEST);
        visited.clear();
        visited.add(DEST);
        new CityRoutes().breadthFirst(graph, visited,ORIG);
    	return check;
    }
 
    private void breadthFirst(CityRoutes graph,
            LinkedList<String> visited,String DEST)
    {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
 
        for (String node : nodes)
        {
            if (visited.contains(node))
            {
                continue;
            }
            if (node.equals(DEST))
            {
                visited.add(node);

                flag = true;
                check = "yes";
                visited.removeLast();
                break;
            }
        }
 
        for (String node : nodes)
        {
            if (visited.contains(node) || node.equals(DEST))
            {
                continue;
            }
            visited.addLast(node);
            breadthFirst(graph, visited,DEST);
            visited.removeLast();
        }
        if (flag == false)
        {
        	      
            flag = true;
        }
 
    }

	
 
   
}