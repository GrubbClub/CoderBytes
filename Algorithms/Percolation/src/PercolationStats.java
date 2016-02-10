package Percolation.src;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats
{  
   public static void main(String[] args)  // test client (optional)
   {
       System.out.println("Fuck You");
       Percolation perc_one = new Percolation(1);
       System.out.println(perc_one.percolates() == false);
       System.out.println(perc_one.isOpen(0,0) == false);
       perc_one.open(0,0);
       System.out.println(perc_one.percolates() == true);
       System.out.println(perc_one.isOpen(0,0) == true);
       Percolation perc_two = new Percolation(5);
       perc_two.open(2,0);
       System.out.println(perc_two.percolates() == false);
       perc_two.open(2,1);
       System.out.println(perc_two.percolates() == false);
       perc_two.open(2,2);
       System.out.println(perc_two.percolates() == false);
       perc_two.open(2,3);
       System.out.println(perc_two.percolates() == false);
       perc_two.open(2,4);
       System.out.println(perc_two.percolates() == true);
   
       System.out.println(perc_two.isFull(2,0) == true);
       System.out.println(perc_two.isFull(2,1) == true);
       System.out.println(perc_two.isFull(2,2) == true);
       System.out.println(perc_two.isFull(2,3) == true);
       System.out.println(perc_two.isFull(2,4) == true);
    } 
}
