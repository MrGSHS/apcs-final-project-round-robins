import java.util.*;

public class Classification implements Comparable<Classification>
{
    // instance variables 
    private char c;
    private int n;
    // creates the classification
    public Classification(char rating, int year)
    {
        c=rating;
        n=year;
    }
    //returns letter rating
    public char getRating()
    {
        return c;
    }
    //returns year recieved
    public int getYear()
    {
        return n;
    }
    //compares one rating to another rating
    public int compareTo(Classification x)
    {   if(c<x.getRating())
            return 1;
        else if (c>x.getRating())
            return -1;
        else if (c==x.getRating()){
            if(n>x.getYear())
                return 1;
            else if (n<x.getYear())
                return -1;
        }
        return 0;
    }
    //pritns Classification
    public String toString(){
        return ""+c+n; 
}
}