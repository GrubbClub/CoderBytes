package Percolation.src;
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
      return i + j*gridSize + 1; 
   }
   
   private boolean isValid(int i, int j)
   {
       //If i or j is less than 0 or bigger than the gridsize it is invalid
       return (i>=0 && j >= 0 && i < gridSize && j < gridSize);
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
       grid[convertCoordinates(i, j)] = 1;
       if(j == 0) 
       {
           uf.union(getDummyTop(), convertCoordinates(i,j));
       }
       if(j == gridSize - 1)
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
           System.out.println("Connecting " + convertCoordinates(i,j) + " and "
                                  + convertCoordinates(i,j-1));
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
       return grid[convertCoordinates(i,j)] == 1;
   }
   public boolean isFull(int i, int j)     // is site (row i, column j) full?
   {
       return getDummyTop() == uf.find(convertCoordinates(i,j));
   }
   public boolean percolates()             // does the system percolate?
   {
       return uf.connected(getDummyTop(), getDummyBottom());
   }
   public static int randOpener(int n){
        int result = (int)(Math.random() * n);
        return result;
    }
   public static void main(String[] args)  // test client (optional)
   {
       //Percolation perc = new Percolation(10);
       //System.out.println(perc.convertCoordinates(0,0) == 1);
       //System.out.println(perc.convertCoordinates(5,0) == 6);
       //System.out.println(perc.convertCoordinates(0,1) == 11);
       //perc.open(5,5);
       //System.out.println(perc.isOpen(5,5) == true);
       //System.out.println(perc.isOpen(5,4) == false);
       //perc.open(0,0);
       
//       int counter = 1;
//       Percolation mcperc = new Percolation(200);
//       while (!mcperc.percolates()){
//           int x = randOpener(gridSize);
//           int y = randOpener(gridSize);
//           if(!mcperc.isOpen(x, y)){
//               mcperc.open(x, y);
//               counter++;
//           }
       
   
       //}
//       System.out.println("System percolates after " + counter + " out of " + gridCount + " sites have been opened for a threshold of: "
//                              + (((double) counter)) / ((double) gridCount));
       
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
       System.out.println(grid[0]);
       for (int i = 1; i < grid.length - 1; i++) {
           System.out.print(grid[i]);
           if (i % 5 == 0)
               System.out.println();
       }
       System.out.println(grid[dummyBottom]);
       System.out.println(perc_two.isFull(2,0) == true);
       System.out.println(perc_two.isFull(2,1) == true);
       System.out.println(perc_two.isFull(2,2) == true);
       System.out.println(perc_two.isFull(2,3) == true);
       System.out.println(perc_two.isFull(2,4) == true);
    }
}
