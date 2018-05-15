package roads;

import java.util.LinkedList;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
String check1="no";
    @RequestMapping("/connected")
    public String greeting(@RequestParam Map<String, String> customQuery) {
    	

        LinkedList<String> visited = new LinkedList();
       
        String origin = customQuery.get("origin");      
        String dest = customQuery.get("destination");
        CityRoutes graph = new CityRoutes(origin,dest);
            
        check1 = graph.checkbothends(visited, graph, origin, dest);
        if(check1==null)
        	check1 = "no";
        
        System.out.println(check1);
        return check1;
    }
    
   
    
}