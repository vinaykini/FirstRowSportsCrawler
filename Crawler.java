import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
/**
* @author Vinay Kini
* Java web crawler to crawl a given web site and read data.
*/
public class Crawler {
 
    public static void main(String[] args)  {
        HashSet<WebPage> hSet = new HashSet<>();
        Indexer index = new Indexer();
        Search s = new Search();
        try {
            System.out.println("Seed site(s) are :: ");
            System.out.println("http://gofirstrowus.eu/sport/football.html");
            System.out.println("http://gofirstrowus.eu/sport/motosport.html");
            System.out.println("http://gofirstrowus.eu/sport/basketball.html");
            System.out.println("http://gofirstrowus.eu/sport/tennis.html");
            
            String seeds[] = {"http://gofirstrowus.eu/sport/football.html","http://gofirstrowus.eu/sport/motosport.html",
                                "http://gofirstrowus.eu/sport/basketball.html","http://gofirstrowus.eu/sport/tennis.html"};
            
            FirstRowParser fr = new FirstRowParser();
            for(String strSeeds:seeds){
                parsePages(fr,strSeeds);
            }
        //hSet = fr.getSet();
        /*
        myUrl = new URL("http://gofirstrowus.eu/sport/basketball.html");
        br = new BufferedReader(new InputStreamReader(myUrl.openStream()));
        strTemp = "";
         
        while((strTemp = br.readLine())!=null){
               if(linkPresent(strTemp)){
                   fr.parse(strTemp);
                  // hm.put(fr.getTitle(), fr.getURL());
               }   
               
        }*/
        hSet = fr.getSet();
       
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        for(WebPage a:hSet){
            String title = a.getTitle();
            String link = a.getLink();
            System.out.println(title);
            System.out.println(link);
            index.insert(title, a);
            System.out.println();
            System.out.println("==================================================================================");
            
        }
        
        s.setTrie(index.getTrie());
        s.search();
        
    }
    
    public static void parsePages(FirstRowParser fr,String seed) {
        try{
        URL myUrl = new URL(seed);
        //URL myUrl = new URL("http://cisegrads.blogspot.in/");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(myUrl.openStream()));
        String strTemp = "";
           
        while((strTemp = br.readLine())!=null){
              if(linkPresent(strTemp)){
                  fr.parse(strTemp);
              }   
        }
    }catch(Exception e){e.printStackTrace();}
    }
    //Method that only sends lines with links on them
   public static boolean linkPresent(String link){
        if(link.length()>7){
       if(link.substring(3,7).equals("href")){
            return true;
        }
    }
        return false;
    }
}