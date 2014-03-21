
/**
 * Write a description of class Indexer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Indexer
{   
    Trie t = new Trie();
   
   
    public void insert(String title, WebPage link){

        String words[] = title.split(" ");
        for(String s:words){
            if(s.equals("Link")){
                break;
            }
            if(!s.equals("vs")){
                t.insert(s, link);
            }
        }
    
    }
    
    public Trie getTrie(){
        return t;
    }
    
    
   
}
