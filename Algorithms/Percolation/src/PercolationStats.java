package Percolation.src;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats
{  
    double[] results;
    double[] meanArray;
    double[] stddevArray;
    double[] loArray;
    double[] hiArray;
    
    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T) {   
        int i = 0;
        double[] meanArray = new double[T];
        double[] stddevArray = new double[T];
        double[] loArray = new double[T];
        double[] hiArray = new double[T];
        while(i < T){
            Percolation perc = new Percolation(N);
            int counter = 1;
            while (!perc.percolates()){
                int x = randOpener(gridSize);
                int y = randOpener(gridSize);
                if(!perc.isOpen(x, y)){
                    perc.open(x, y);
                    counter++;
                }
            }
            meanArray[i] = perc.mean();
            stddevArray[i] = perc.stddev();
            loArray[i] = perc.confidenceLo();
            hiArray[i] = perc.confidenceHi();
            i++;
            
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

    } 
}
