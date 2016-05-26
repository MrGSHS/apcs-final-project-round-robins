
public class Bout
{
    // instance variables - replace the example below with your own
    Fencer r;
    Fencer l;
    int [] x;
    int win;
    String note;
    int id;
    public Bout(Fencer right, Fencer left, int p)
    {
      r=right;
      l=left;
      int []x=new int [2];
      win=0;
      id=p;
    }
    public void rUp()
    {
       if(x[0]<5)
        x[0]++;
       
    }
    public void rDown()
    {
      if(x[0]>=0)      
       x[0]--;
    }
     public void lUp()
    {
       if(x[1]<5)
        x[1]++;
    }
    public void lDown()
    {
      if(x[1]>=0)      
       x[1]--;
    }
    public void win()
    {
        if(x[1]==5)
        win=-1;
        else if (x[0]==5)
        win=1;
        win=0;
    }
    public String getNote()
    {
        return note;
    }
     public void addNote(String x)
    {
        note+=x;
    }
    public void setNote(String x)
    {
        note=x;
    }
    public String toString(){
     return ""+r+" vs. " +l+" BoutID= "+id;}   
    
    public int getID(){
        return id;}
}
