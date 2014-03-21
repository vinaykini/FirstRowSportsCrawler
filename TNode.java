import java.util.*;

public class TNode{
    char letter;
    TNode links[];
    boolean isEnd;
    HashSet<WebPage> pages = new HashSet<>();
    
    public TNode(char letter){
        this.letter = letter;
        this.links = new TNode[256];
        this.isEnd = false;
    }
    
    public void setPage(WebPage page){
        pages.add(page);
    }
    
    public HashSet<WebPage> getPage(){
        return pages;
    }

    public String toString(){
        return (new String(letter+""));
    }
}