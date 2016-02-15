package Percolation.src;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats
{  
    private static double[] results;
    private static int popSize; 
    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T) {   
        results = new double[T];
        popSize = T;
        for(int i = 0; i < T; i++)
        {
            Percolation perc = new Percolation(N);
            int counter = 0;
            while (!perc.percolates()){
                int x = (int)(Math.random() * N + 1);
                int y = (int)(Math.random() * N + 1);
                if(!perc.isOpen(x, y)){
                    perc.open(x, y);
                    counter++;
                }
            }
            results[i] = counter/(N*N*1.0);
        }
    }
  
  //    sample mean of percolation threshold
    public double mean()  {
        return StdStats.mean(results);
    }
    
    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddevp(results);
    }
   // low  endpoint of 95% confidence interval
    public double confidenceLo(){
        return StdStats.mean(results) - ((1.96 * StdStats.stddevp(results)) / Math.sqrt(popSize));
    }
       
        // high endpoint of 95% confidence interval

    public double confidenceHi(){
        return StdStats.mean(results) + ((1.96 * StdStats.stddevp(results)) / Math.sqrt(popSize));
    }
    
   public static void main(String[] args)  // test client (optional)
   {
       PercolationStats percs = new PercolationStats(200, 100);
       System.out.println ("mean                    = " + percs.mean());
       System.out.println ("stddev                  = " + percs.stddev());
       System.out.println ("95% confidence interval = " + percs.confidenceLo() + ", " + percs.confidenceHi());
       
       
       
    } 
}
