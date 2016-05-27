/**
 * Creates a round robin pool with the needed number of bouts, making sure fencers get breaks and there is a time period between each
 * 
 * @Andrew Jin
 * @5/26/16
 */
import java.util.*;
public class RndR
{
    // instance variables - replace the example below with your own
    private Bout [] bts;
    private Pool in;
    private int type;
    //designated pool bout orders;
    private final int[][] p4 ={{1,4},{2,3},{1,3},{2,4},{3,4},{1,2}};//0
    private final int[][] p5 = {{1,2},{3,4},{5,1},{2,3},{5,4},{1,3},{2,5},{4,1},{3,5},{4,2}};//1
    private final int[][] p6= {{1,2},{4,5},{2,3},{5,6},{3,1},{6,4},{2,5},{1,4},{5,3},{1,6},{4,2},{3,6},{5,1},{3,4},{6,2}};//2
    private final int[][] p6t2= {{1,4},{2,5},{3,6},{5,1},{4,2},{3,1},{6,2},{5,3},{6,4},{1,2},{3,4},{5,6},{2,3},{1,6},{4,5}};//3
    private final int[][] p6t3= {{1,2},{4,5},{2,3},{5,6},{3,1},{6,4},{2,6},{1,4},{5,3},{1,6},{4,2},{3,6},{5,1},{3,4},{6,2}};//4
    private final int[][] p6t4= {{3,1},{4,2},{1,4},{2,3},{4,6},{1,2},{3,4},{1,6},{2,5},{3,6},{4,5},{6,2},{5,1},{6,4},{5,3}};//5
    private final int[][] p7={{1,4},{2,5},{3,6},{7,1},{5,4},{2,3},{6,7},{5,1},{4,3},{6,2},{5,7},{3,1},{4,8},{7,2},{3,5},{1,6},{2,4},{7,3},{6,5},{1,2},{4,7}};//6
    private final int[][] p7t2={{1,3},{2,5},{3,6},{7,1},{5,4},{2,3},{6,7},{5,1},{4,3},{6,2},{5,7},{3,1},{4,6},{7,2},{3,5},{1,6},{2,4},{7,3},{6,3},{1,2},{4,7}};//7
    private final int[][] p7t3={{1,2},{4,5},{6,7},{3,1},{4,7},{2,3},{5,1},{6,2},{3,4},{7,5},{1,6},{4,2},{7,3},{5,6},{1,4},{2,7},{5,3},{6,4},{7,1},{2,5},{3,6}};//8
    private final int[][] p7t4c1={{1,2},{6,7},{5,4},{7,1},{6,2},{4,3},{5,7},{1,6},{2,4},{5,1},{7,3},{6,5},{7,2},{3,6},{1,4},{3,5},{4,7},{2,3},{4,6},{3,1},{2,5}};//9
    private final int[][] p8={{2,3},{1,5},{7,4},{6,8},{1,2},{3,4},{5,6},{8,7},{4,1},{5,2},{8,3},{6,7},{4,2},{8,1},{7,5},{3,6},{2,8},{5,4},{6,1},{3,7},{4,8},{2,6},{3,5},{1,7},{4,6},{8,5},{7,2},{1,3}};//10
    private final int[][] p8t3={{2,3},{7,4},{6,8},{1,2},{7,5},{4,6},{1,3},{8,5},{4,2},{1,7},{3,6},{2,8},{5,4},{6,1},{3,7},{4,8},{2,6},{3,5},{4,1},{8,7},{5,6},{3,4},{8,1},{5,2},{6,7},{8,3},{1,5},{7,2}};//11
    private final int[][] p8t3c2={{1,2},{4,5},{3,1},{6,4},{7,8},{2,3},{5,6},{1,4},{2,7},{5,8},{3,6},{7,1},{8,4},{2,5},{7,3},{8,6},{5,1},{3,4},{8,2},{6,7},{5,3},{1,8},{4,7},{6,2},{3,8},{7,5},{1,6},{4,2}};//12
    private final int[][] p8t4t3={{5,6},{1,2},{3,4},{7,5},{3,1},{4,2},{6,7},{5,8},{1,4},{8,6},{2,3},{7,8},{5,1},{6,4},{2,7},{3,8},{1,6},{2,5},{8,4},{7,3},{6,2},{1,8},{5,3},{4,7},{8,2},{3,6},{7,1},{4,5}};//13
    private final int[][] p8t4={{2,3},{1,5},{7,4},{6,8},{1,2},{3,5},{8,7},{4,6},{1,3},{5,2},{4,8},{6,7},{3,4},{8,5},{6,1},{3,7},{2,8},{5,4},{1,7},{3,6},{4,2},{8,1},{7,5},{2,6},{8,3},{4,1},{7,2},{5,6}};//14
    private final int[][] p8t4c2={{5,8},{6,7},{1,4},{2,3},{7,5},{8,6},{3,1},{4,2},{7,8},{5,6},{3,4},{1,2},{3,8},{6,4},{7,1},{2,5},{3,6},{1,8},{4,5},{2,7},{1,6},{5,3},{8,2},{4,7},{5,1},{6,2},{7,3},{8,4}};//15
    //
    public RndR(Pool p)
    {
        in=p;
        type=setType();
        bts=creator(type);
    }
    //returns the type of bout needed for this pool based on conflicts;
    public int setType(){
        int max=0;
        int size=in.getSize();
        int nsts=0;
        boolean has2=false;
        boolean has3=false;
        if(in.hasConflicts()){
        nsts=in.getCons().size();
        ArrayList<Integer> j= in.getConflicts();
            for(int x:j){
                if(x==2)
                has2=true;
                if(x==3)
                has3=true;
                if(x>max)
                max=x;
            }
        }
        if(size==4)
            return 0;
        else if(size==5)
            return 1;
        else if(size==6){
            if(!in.hasConflicts()||max==5)
               return 2;
            else if(max==2)
                if(nsts==2)
                    return 103;
                else if(nsts==3)
                    return 203;   
                else
                    return 3;
            else if(max==3){
                if(nsts==2&&has2){
                    return 104;}
               
                else if(nsts==2){
                    return 204;}                    
                else{
                    return 4;
                }}
            else if(max==4){
                    return 5;
                }}
        else if(size==7){
            if (!in.hasConflicts()||max==6)
                return 6; 
            else if (max==2)
                if (nsts==2){
                    return 107;}
                else if (nsts==3){
                    return 207;}
                else 
                    return 7;
            else if (max==3)
                if(nsts==2)
                    return 108;
                else if(nsts==3&&has2)
                    return 208;
                else 
                    return 8;
            else if (max==4)
                return 9;
            else  return 6;}
        else if(size==8){
            
            if(max==3){
               if ( nsts==1)
               return 11;
               else if(nsts==2&&!has2)
               return 12;
            else if(max==4&&has3)
                return 13;
            else if(max==4&&nsts==2)
                return 15;
            else 
            return 10;}
            
        }
               return -1;
            }
    //Based on the type of bout, returns the bout order array;
        public int[][] ordering(int n){
        if(n==0)
        return p4;
        if(n==1)
        return p5;
        if(n==2)
        return p6;
        if(n==3)
        return p6t2;
        if(n==4)
        return p6t3;
        if(n==5)
        return p6t4;
        if(n==6)
        return p7;
        if(n==7)
        return p7t2;
        if(n==8)
        return p7t3;
        if(n==9)
        return p7t4c1;
        if(n==10)
        return p8;
        if(n==11)
        return p8t3;
        if(n==12)
        return p8t3c2;
        if(n==13)
        return p8t4t3;
        if(n==14)
        return p8t4;
        if(n==15)
        return p8t4c2;
        int[][] x={{0}};
        return x;
    }
    //creates the round robin bout array
    private Bout [] creator(int type){
            int x=setType();
            int y=type/100;
            int[][] order=ordering(x%100);
            Fencer[] inOrder=new Fencer[in.getSize()];
            ArrayList <Fencer> a=new ArrayList<Fencer>(); 
            if(!in.hasConflicts())
                inOrder=in.getFencers();
            else{
                ArrayList<String> l=in.getCons();
               
               for(String s: l){
                        for(Fencer k: in.f4c(s))
                         a.add(k);
                }
                for(Fencer s:in.nonconflict()){
                       a.add(s);}
                for(int z=0;z<inOrder.length;z++){
                    inOrder[z]=a.get(z);
                }}
                int size=in.getSize()*(in.getSize()-1)/2;
                Bout [] b=new Bout [size];
                int ctr=0;
                for(int r=0;r<b.length;r++){
                  Bout d=new Bout(inOrder[order[r][0]-1],inOrder[order[r][1]-1],ctr);
                  b[ctr]=d;
                  ctr++;}
             return b;
                }
    //returns type of pool
        public int getType(){
            return type;}
    //prints        
      public String toString(){
          String x="";
          int ctr=1;
          for(Bout b:bts){
            x+=ctr+". "+b+"\n";
            ctr++;
        }
     return x;} 
        public Bout getBout(int n){
            return bts[n];
                
        }
    public int getNumBouts(){
            return bts.length;
                
        }}