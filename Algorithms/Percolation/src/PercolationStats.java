package Percolation.src;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats
{  
    public static int[] results;
    
    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T) {   
        int i = 0;
        int[] results = new int[T];
        double[] stddevArray = new double[T];
        double[] loArray = new double[T];
        double[] hiArray = new double[T];
        while(i < T){
            Percolation perc = new Percolation(N);
            int counter = 0;
            while (!perc.percolates()){
                int x = (int)(Math.random() * N);
                int y = (int)(Math.random() * N);
                if(!perc.isOpen(x, y)){
                    perc.open(x, y);
                    counter++;
                }
            }
            results[i] = counter;
//            stddevArray[i] = perc.stddev();
//            loArray[i] = perc.confidenceLo();
//            hiArray[i] = perc.confidenceHi();
            i++;
        }
      //  double resultsMean = mean(results);
    }
    public int getResults(){
        return results[0];
    }
//     // sample mean of percolation threshold
//    public double mean()  {
//        return 0;
//    }
//    
//    // sample standard deviation of percolation threshold
//    public double stddev(){
//        return 0;
//    }
//   // low  endpoint of 95% confidence interval
//    public double confidenceLo(){
//        return 0;
//        
//    }
//       
//        // high endpoint of 95% confidence interval
//
//    public double confidenceHi(){
//        return 0;
//        
//    
   public static void main(String[] args)  // test client (optional)
   {
       PercolationStats percs = new PercolationStats(10, 20);
       System.out.println(percs.getResults());
       
    } 
}
