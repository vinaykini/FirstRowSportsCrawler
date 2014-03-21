
/**
 * Basic Web page class. Stores information on a particular web page including its title and url
 * 
 * @author Vinay Kini
 * @Version 1.0
 */
public class WebPage
{
    private String url;         //Declared private so cant be changed from outside
    private String title;       
    public String getLink(){
        return url;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setPage(String Url,String Title){
        this.url = Url;
        this.title = Title;
    }
    
    public void setPage(String Url){
        this.url = Url;
        this.title = null;
    }
}
