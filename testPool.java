/**
 * Class to test whether or not a pool can be run effectively with program
 * 
 * @Andrew Jin
 * @5/26/16
 */
import java.util.*;
public class testPool{
   public static void main(String[] args)
    {
        Classification a1=new Classification('C',2016);
        Classification b1=new Classification('A',2016);
        Classification c1=new Classification('D',2015);
        Classification d1=new Classification('U',2016);
        Classification e1=new Classification('D',2014);
        Classification f1=new Classification('E',2015);
        Classification g1=new Classification('A', 2013);
        Classification h1=new Classification('B',2014);
        
        Fencer a=new Fencer("Smith", "John",a1, "Peter Westbrook","");
        Fencer b=new Fencer("Shmo", "Joe", b1, "Golden Gate","");
        Fencer c=new Fencer("Smith", "Jean",c1, "LAIFC","");
        Fencer d=new Fencer("Shann", "Jean",d1, "LAIFC","");
        Fencer e=new Fencer("Smith", "Leslie",e1, "LAIFC","");
        Fencer f=new Fencer("Davis", "David", f1,"Peter Westbrook","");
        Fencer g=new Fencer("Devito", "Danny", g1,"Peter Westbrook","");
        Fencer h=new Fencer("Johnson", "Smith",h1,"LAIFC","");

        ArrayList<Fencer> x=new ArrayList<Fencer>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        x.add(f);
        x.add(g);
        x.add(h);
        
        Pool p=new Pool(x);
        System.out.println(p);
        
        
        System.out.println("# Fencers for LAIFC:"+ p.f4c("LAIFC").size());
        System.out.println(p.f4c("LAIFC"));
        System.out.println(p.nonconflict());
        System.out.println("# Fencers for Golden Gate:" +p.f4c("Golden Gate").size());
    }}