import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   private int gridSize;
   private WeightedQuickUnionUF uf; 
   private int[] grid; //grid[0] and grid[N*N+1] are dummy
   private int dummyTop = 0;
   private int dummyBottom; 
   public Percolation(int N)               // create N-by-N grid, with all sites blocked
   {

       gridSize = N;
       grid = new int[gridSize+2]; 
       
       dummyBottom = N*N+1;
       // Set Dummy Nodes to Open
       grid[0] = grid[N*N+1] = 1;
       
       
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
       return (i>0 && j > 0 && i < gridSize && j < gridSize);
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
       grid[i,j] = 1;
       if(j == 0) 
       {
           uf.union(getDummyTop(), convertCoordinates(i,j));
       }
       if(j = gridSize)
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
       return grid[convertCoordinates(i,j)];
   }
   public boolean isFull(int i, int j)     // is site (row i, column j) full?
   {
       return getDummyTop() == uf.find(convertCoordinates(i,j));
   }
   public boolean percolates()             // does the system percolate?
   {
       return uf.connected(getDummyTop(), getDummyBottom());
   }
   public static void main(String[] args)  // test client (optional)
   {
       Percolation perc = new Percolation(10);
       System.out.println(perc.convertCoordinates(0,0) == 0);
       System.out.println(perc.convertCoordinates(5,0) == 5);
       System.out.println(perc.convertCoordinates(0,1) == 10);
       perc.open(5,5);
       perc.isOpen(5,5);
       perc.isOpen(5,4);
       perc.open(0,0);
    }
}
