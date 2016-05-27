/**
 * Creates a pool with the needed number of bouts, has methods to get the fencers and the ability to get different conflicts and related stuff
 *  
 * @Andrew Jin
 * @5/26/16
 */
import java.util.*;
public class Pool
{
    // instance variables - replace the example below with your own
    private Fencer [] pools;
    private ArrayList<Integer> conflicts;

    
    //constructs the Pool given an ArrayList of Fencers.
public Pool ( ArrayList<Fencer> y){
        Fencer [] poo=new Fencer[y.size()];
        
        for(int a=0;a<y.size();a++){
           poo[a]=y.get(a);
        }
        pools=poo;
      conflicts=new ArrayList<Integer>();
      ArrayList<String> clubslist= new ArrayList<String>();
    ArrayList<String> clubslist2= new ArrayList<String>();
    String l=pools[0].getClub();
    int ctr=0;
    for(int x=0; x<pools.length;x++){
        l=pools[x].getClub();
        if(!clubslist.contains(l)){
            clubslist.add(l);
        }
    }
    for(String s:clubslist){
     for(Fencer x:pools){
         if(s.equals(x.getClub())){
             ctr++;
            }}
        if(ctr>1)
            clubslist2.add(s);
        ctr=0;}
     ctr=0;
    for(String n:clubslist2){
        for(int x=0; x<pools.length;x++){
        l=pools[x].getClub();
        if(l==n){
         ctr++;
        }}
       conflicts.add(ctr);
       ctr=0;
        }
}
    //fills in the ArrayList<Integer> with the number of people and the number of conflicts in each 

       //returns the ArrayList Conflicts.
public ArrayList<Integer> getConflicts(){
    return conflicts;
    }
    //returns true if there are conflicts, otherwise returns false.
public boolean hasConflicts(){
    return conflicts.size()>0;}
    //returns a list of clubs which are causing conflicts within the pool
public ArrayList<String> getCons(){
    ArrayList<String> clubslist= new ArrayList<String>();
    ArrayList<String> clubslist2= new ArrayList<String>();
    String l=pools[0].getClub();
    int ctr=0;
    for(int x=0; x<pools.length;x++){
        l=pools[x].getClub();
        if(!clubslist.contains(l)){
            clubslist.add(l);
        }
    }
    for(String s:clubslist){
     for(Fencer x:pools){
         if(s.equals(x.getClub())){
             ctr++;
            }}
        if(ctr>1)
            clubslist2.add(s);
        ctr=0;}
    ArrayList<String> clublist=new ArrayList<String>();
     ArrayList<Integer> copy=new ArrayList<Integer>();
    copy.addAll(conflicts);
    int max=0;
    int index=0;
        while(copy.size()>1){
    for(int x=0; x<copy.size(); x++){
       if(max<copy.get(x)){
       max=copy.get(x);
       index=x;}
    }
    clublist.add( clubslist2.remove(index));
    copy.remove(index);
    }
    clublist.add(clubslist2.get(0));
    return clublist;
}

//returns a sorted array of clubs with most conflicts caused to least conflicts caused

    // returns an arraylist of fencers from a given club.
public ArrayList<Fencer> f4c(String s){
    ArrayList<Fencer> a=new ArrayList<Fencer>();
    String l="";
      for(int x=0; x<pools.length;x++){
        l=pools[x].getClub();
        if(s.equals(l)){
            a.add(pools[x]);
        }
    }
    return a;
}
    //returns all fencers not involved in conflicts
public ArrayList<Fencer> nonconflict(){
    ArrayList<Fencer> a=new ArrayList<Fencer>();
    ArrayList<String> b=getCons();
    for(Fencer x: pools){
        a.add(x);}
    for(int x=0; x<pools.length;x++){
    for(String c:b){
        if(pools[x].getClub()==c)
            a.remove(pools[x]);}}
        return a;}
   //returns the size of the pool
    public int getSize(){
        return pools.length;
    }
   //returns an array of all the fencers in a pool;
    public Fencer [] getFencers(){
        return pools;
}
public String toString(){
    String x="";
    int ctr=1;
    ArrayList<String> clubslist;
    for(Fencer f: pools){
    x+=""+ctr+". "+f.toString()+"\n";
    ctr++;}
    if(hasConflicts()){
    x+="Conflicts: "+conflicts.size()+ " ( " ;
     clubslist= getCons();
        for(String c:clubslist){
            x+=c+"\t";
    }
    x+=" )";
}
return x;}

public String toStrRec(){
    String x="";
    int ctr=1;
    ArrayList<String> clubslist;
    for(Fencer f: pools){
    x+=""+ctr+". "+f.toString()+ " "+f.recorder() +"\n";
    ctr++;}
    if(hasConflicts()){
    x+="Conflicts: "+conflicts.size()+ " ( " ;
     clubslist= getCons();
        for(String c:clubslist){
            x+=c+"\t";
    }
    x+=" )";
}
return x;}
}