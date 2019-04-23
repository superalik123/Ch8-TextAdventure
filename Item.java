
/**
 * Item class that holds item description and weight.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemDescription;
    private int itemWeight;
    private String itemInspect;
    
    public Item(){
        
     //initialize instance variables
     itemInspect = "";
     itemDescription = "";
     itemWeight = 0;
    }
    /**
     * Constructor for objects of class Item
     */
    public Item(String description, String inspect, int weight)
    {
        // initialise instance variables
        itemDescription = description;
        itemWeight = weight;
        itemInspect = inspect;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getItemShortDescription()
    {
       String itemString = "";
       itemString += this.itemDescription;
       
       return itemString;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getItemDescription()
    {
       String itemString = "";
       itemString += this.itemDescription +"\n";
       itemString += this.itemInspect +"\n";
       
       return itemString;
    }
}
