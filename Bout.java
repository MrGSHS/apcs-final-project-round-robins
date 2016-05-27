/**
 * Creates a bout with two fencers in it. Also contains a bout ID and can be adjusted later to add scores, notes and wins;  
 * 
 * @Andrew Jin
 * @5/26/16
 */
public class Bout
{
    // instance variables 
    Fencer r;//first called fencer, right strip
    Fencer l;// second called fencer, left strip
    int [] x;
    int win;
    String note;
    int id;
    public Bout(Fencer right, Fencer left, int p)
    {
      r=right;
      l=left;
      x=new int [2];
      win=0;
      id=p;
    }
//     public void rUp()
//     {
//        if(x[0]<5)
//         x[0]++;
//        
//     }
//     public void rDown()
//     {
//       if(x[0]>=0)      
//        x[0]--;
//     }
//      public void lUp()
//     {
//        if(x[1]<5)
//         x[1]++;
//     }
//     public void lDown()
//     {
//       if(x[1]>=0)      
//        x[1]--;
//     }

// determines the win and changes the records of the given fencer
    public void win()
    {
        if(x[1]>x[2]){
        l.addWin();
        r.addLoss();
        win=-1;}
        else if (x[2]>x[1]){
        r.addWin();
        l.addLoss();
        win=1;}
        else{
        win=0;}
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
        if (win==0)
            return ""+r+" vs. " +l+" BoutID= "+id;
        else 
            return ""+r+ " vs. "+l+"\t Score:"+x[0]+ "-" + x[1];}   
    
    public int getID(){
        return id;}
        
    // sets the final score of the bout with first called fencer on the left of the pool sheet, labeled as r
    public Boolean setScore(int a, int b){
        if (a>5||b>5)
            return false;
        x[0]=a;
        x[1]=b;
        win();
        return true;
        
    }
}
