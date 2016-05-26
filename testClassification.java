import java.util.*;
public class testClassification
{
   public static void main(String[] args)
    {
        Classification a=new Classification('C',2016);
        Classification b=new Classification('A',2016);
        Classification c=new Classification('D',2015);
        Classification d=new Classification('U',2016);
        Classification e=new Classification('D',2014);
        Classification f=new Classification('E',2015);
        ArrayList<Classification> x=new ArrayList<Classification>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        x.add(f);
        for(Classification z:x)
            System.out.println(z);
        Collections.sort(x);
        System.out.println("\n \n \n");
        for(Classification z:x)
            System.out.println(z);
}}