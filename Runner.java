/**
 * 
 * Runner for creatinga new pool, also can edit bouts
 * @Andrew Jin
 * @5/26/16
 */
import java.util.*;
public class Runner{
   public static void main(String[] args)
    {   boolean contin=true;
        String s;
        int ctr=0;
        char c;
        int n;
        int nof;
        Bout b;
        Classification a1;
        Scanner sc = new Scanner(System.in);
        System.out.print( "Number of Fencers: ");
        nof=sc.nextInt();
        while(nof<4||nof>8){
            System.out.print( "Error: Please Enter Valid Value for Number of Fencers: ");
            nof=sc.nextInt();}
        Classification [] classs=new Classification[nof];
        String [] fnames=new String[nof];
        String [] lnames=new String[nof];
        String [] clubs=new String[nof];
        while (ctr<nof){
            System.out.print( "First name of Fencer #"+ (ctr+1)+": " );
            fnames[ctr]=sc.next();
            System.out.println();
            System.out.print( "Last name of Fencer #"+ (ctr+1)+": "  );
            lnames[ctr]=sc.next();
            System.out.println();
            System.out.print( "Club of Fencer #"+ (ctr+1)+": "  );
            clubs[ctr]=sc.next();
            System.out.println();
            System.out.print( "Classification of Fencer #"+ (ctr+1)+" (enter U with 2016): "  );
            s=sc.next();
            System.out.println();
              while(s.length()!=5||s.charAt(0)<'A'||(s.charAt(0)>'E'&&s.charAt(0)!='U')){
                            System.out.print( "Error: Please Enter Valid Classification that Fencer: ");
                                s=sc.next();}
            a1=new Classification(s.charAt(0),Integer.parseInt(s.substring(1,5)));
            classs[ctr]=a1;
            System.out.println("\n \n \n Next Fencer:");
            ctr++;
        }
       ArrayList<Fencer> f=new ArrayList<Fencer>();
       Fencer a;
        for (int x=0; x<ctr; x++){
        a=new Fencer(lnames[x],fnames[x],classs[x],clubs[x],"");
        f.add(a);}
  
        Pool p=new Pool(f);
        RndR r=new RndR(p);
        System.out.println(p+"\n \n \n"+r);
        int s1,s2,id;
           System.out.print( "Set Scores? 1= Yes  2=No"  );
        int so=sc.nextInt();
        while(so==1){
            System.out.print( "Enter Bout ID:"  );
            id=sc.nextInt();
            while (id>r.getNumBouts()||id<0){
              System.out.print( "Re-enter Bout ID:"  );
              id=sc.nextInt();}
             b=r.getBout(id);
             System.out.println(b);
            System.out.print( "Enter Score 1: ");
            s1=sc.nextInt();
            System.out.print( "Enter Score 2: ");
            s2=sc.nextInt();
            while(!b.setScore(s1,s2)){
                  System.out.print( "Re-enter Score 1: ");
                  s1=sc.nextInt();
                  System.out.print( "Re-enter Score 2: ");
                  s2=sc.nextInt();}
            System.out.println(b);
                System.out.print( "Continue? 1= Yes  2=No "  );
        so=sc.nextInt();
                }      
        System.out.println(r+"\n \n \n "+p.toStrRec());
    }}