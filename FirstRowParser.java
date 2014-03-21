
/**
 * Write a description of class FirstRowParser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class FirstRowParser
{
    WebPage page;
    String title;
    HashSet<WebPage> hSet = new HashSet<>();
   
    public void parse(String line){
              
        String cutTitle[] = line.split("title=\'");
        String cut[] = cutTitle[1].split("\'");
        title =cut[0];
        
        
        //System.out.println(line);
        page = new WebPage();
        page.setPage(cut[2], cut[0]);
        if(!hSet.contains(page)){
            hSet.add(page);
        }
        
    }
    
    public HashSet<WebPage> getSet(){
        return hSet;
    }
}
