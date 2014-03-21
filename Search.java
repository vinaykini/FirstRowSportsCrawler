
/**
 * Write a description of class Search here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class Search
{
    Trie t;
    
    public void setTrie(Trie t){
        this.t = t;
    }
    
    public void search(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String term = "";
        String search = "";
        HashSet<WebPage> result = null;
        do{
            System.out.println("1. Search");
            System.out.println("2. Autocomplete");
            System.out.println("3. List");
            System.out.println("4. Exit");
            try{
            term = br.readLine();
            switch(term){
                case "1" :
                    System.out.print("Search :: ");
                    search = br.readLine();
                    result = t.find(search);
                    System.out.println();
                    if(result!=null){
                        Iterator<WebPage> it = result.iterator();
                        WebPage no = null;
                        while(it.hasNext()){
                            no = it.next();
                            System.out.println(no.getTitle());
                            System.out.println("http://gofirstrowus.eu"+no.getLink());
                        }
                        String answer = "";
                        int number = 0;
                        do{
                            System.out.println("Do you want to play any of the links? Link Number or no?");
                            answer = br.readLine();
                            
                            switch(answer){
                                case ("no"):
                                    answer = "no";
                                    break;
                                case ("No"):
                                    answer = "no";
                                    break;
                                default:
                                    number = Integer.parseInt(answer);
                                    Process p;
                                    try{
                                        it = result.iterator();
                                        while(number!=0 && it.hasNext()){
                                            no = it.next();
                                            number--;
                                        }
                                        System.out.println("Starting "+no.getLink());
                                        p = Runtime.getRuntime().exec(("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe -url http://gofirstrowus.eu"+no.getLink()));
                                        System.exit(0);
                                       // p = Runtime.getRuntime().exec("firefox.exe -"+no.getLink());
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                    break;
                            }
                        }while(!answer.equals("no"));
                    }else{
                        System.out.println("No results found!");
                    }
                    
                    break;
                case "2":
                    System.out.print("Enter term to autocomplete: ");
                    search = br.readLine();
                    System.out.println("\nAutocompleting "+search);
                    t.autoComplete(search);
                    break;
                case "3":
                    System.out.println("List");
                    t.List();
                    break;        
                case "4":
                    System.out.println("Exit");
                    System.exit(0);
                    break;   
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        }while(true);
    }
}
