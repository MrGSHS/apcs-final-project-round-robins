
/**
 * Fencer Object: First/Last Name, Rating, Club, and Notes
 * 
 * @Andrew Jin
 * @5/26/16
 */
public class Fencer implements Comparable<Fencer>
{
    // instance variables - replace the example below with your own
    private Classification rating; 
    private String lastName;
    private String firstName;
    private String club;
    private String notes;
    //creates a fencer
    public Fencer( String lnm,String fnm,Classification c, String clb, String nts)
    {
        rating=c;
        lastName=lnm;
        firstName=fnm;
        club=clb;
        notes=nts;
    }
    //returns the fencer's classifcation
    public Classification getClassification()
    {
        return rating;
    }
    //returns full name of fencer;
    public String getName()
    {
        return lastName+", "+firstName;
    }
    //returns club of fencer;
    public String getClub()
    {
        return club;
    }
    //returns notes on fencer;
    public String getNotes()
    {
        return notes;
    }
    //compares one fencer to another based on rating
    public int compareTo(Fencer a){
        if(rating.compareTo(a.getClassification())>0)
         return 1;
        if(rating.compareTo(a.getClassification())<0)
         return -1;
         return 0;
    }
    public String toString(){
        return lastName+", "+firstName+" "+rating+" (" + club +")";
   
}
 public String s(){
        return lastName+", "+firstName+" "+rating+" (" + club +")";
   
}
}
