package Percolation.src;
import java.lang.*;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
   private static int gridSize;
   private static int gridCount;
   private WeightedQuickUnionUF uf; 
   private static int[] grid; //grid[0] and grid[N*N+1] are dummy
   private int dummyTop = 0;
   private static int dummyBottom; 
   public Percolation(int N)               // create N-by-N grid, with all sites blocked
   {
       if(N <= 0)
       {
           throw new java.lang.IllegalArgumentException();
       }
       
       gridSize = N;
       gridCount = N*N;
       grid = new int[gridSize*gridSize + 2]; 
       
       dummyBottom = (N*N) + 1;
       // Set Dummy Nodes to Open
       grid[dummyTop] = grid[dummyBottom] = 1;
       
       
       uf = new WeightedQuickUnionUF(gridSize*gridSize + 2);
       //System.out.println(uf.count());
   }    
   
   private int convertCoordinates(int i, int j)
   {
      return (i-1) + (j-1)*gridSize + 1; 
   }
   
   private boolean isValid(int i, int j)
   {
       //If i or j is less than 0 or bigger than the gridsize it is invalid
       return (i>0 && j > 0 && i <= gridSize && j <= gridSize);
   }
   
   private int getDummyTop()
   {
     return dummyTop;   
   }
   
   private int getDummyBottom()
   {
       return dummyBottom;   
   }
   
   public void open(int i, int j)          // open site (row i, column j) if it is not open already
   {
       if(!isValid(i,j))
       {
           throw new java.lang.IndexOutOfBoundsException();
       }
       grid[convertCoordinates(i, j)] = 1;
       if(j == 1) 
       {
           uf.union(getDummyTop(), convertCoordinates(i,j));
       }
       if(j == gridSize)
       {
           uf.union(convertCoordinates(i,j), getDummyBottom());
       }
      
       if(isValid(i-1,j) && isOpen(i-1, j))
       {
           uf.union(convertCoordinates(i,j), convertCoordinates(i-1,j));
       }
       if(isValid(i,j-1) && isOpen(i, j-1))
       {
           uf.union(convertCoordinates(i,j), convertCoordinates(i,j-1));
       }
       if(isValid(i+1,j) && isOpen(i+1, j))
       {
           uf.union(convertCoordinates(i,j), convertCoordinates(i+1,j));
       }
       if(isValid(i, j+1) && isOpen(i, j+1))
       {
           uf.union(convertCoordinates(i,j), convertCoordinates(i,j+1));
       }
       
       
   }

   public boolean isOpen(int i, int j)     // is site (row i, column j) open?
   {
       if(!isValid(i,j))
       {
           throw new java.lang.IndexOutOfBoundsException();
       }
       return grid[convertCoordinates(i,j)] == 1;
   }
   public boolean isFull(int i, int j)     // is site (row i, column j) full?
   {
       if(!isValid(i,j))
       {
           throw new java.lang.IndexOutOfBoundsException();
       }
       return getDummyTop() == uf.find(convertCoordinates(i,j));
   }
   public boolean percolates()             // does the system percolate?
   {
       return uf.connected(getDummyTop(), getDummyBottom());
   }
   public static void main(String[] args)  // test client (optional)
   {      
       Percolation perc_one = new Percolation(1);
       System.out.println(perc_one.percolates() == false);
       System.out.println(perc_one.isOpen(1,1) == false);
       perc_one.open(1,1);
       
       System.out.println(perc_one.percolates() == true);
       System.out.println(perc_one.isOpen(1,1) == true);
       Percolation perc_two = new Percolation(5);
       perc_two.open(2,1);
       System.out.println(perc_two.percolates() == false);
       perc_two.open(2,2);
       System.out.println(perc_two.percolates() == false);
       perc_two.open(2,3);
       System.out.println(perc_two.percolates() == false);
       perc_two.open(2,4);
       System.out.println(perc_two.percolates() == false);
       perc_two.open(2,5);
       System.out.println(perc_two.percolates() == true);
      
       System.out.println(perc_two.isFull(2,1) == true);
       System.out.println(perc_two.isFull(2,2) == true);
       System.out.println(perc_two.isFull(2,3) == true);
       System.out.println(perc_two.isFull(2,4) == true);
       System.out.println(perc_two.isFull(2,5) == true);
    }
}
